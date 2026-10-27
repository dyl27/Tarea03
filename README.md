# Financiera Huanca — Tarea 3 (TDI)

Aplicación web con **Spring MVC + MySQL** que muestra el formulario de solicitud de crédito junto con una **tabla de pagos de tarjeta de crédito**. Las columnas Fecha, Mes, Tarjeta, Transacción y Gastos vienen de la base de datos y son de solo lectura; la columna **Pagos** es editable y se guarda en la BD al presionar **Aceptar**. Después se muestra otra vista con los créditos capturados y los pagos.

Continuación de la Tarea 2, basada en el ejemplo de clase `MultiRowSpring3MVC`.

---

## Tecnologías

| Componente | Versión |
|---|---|
| IDE | Spring Tools for Eclipse (STS) 5.4 — sirve cualquier Eclipse para Java EE |
| Servidor | Apache Tomcat **9.0.x** (no usar Tomcat 10+, este proyecto usa `javax.servlet`) |
| Java | JDK 8 o superior (el proyecto compila como Java SE 1.8) |
| Spring | 3.0.0.M3 (jars incluidos en `WebContent/WEB-INF/lib`) |
| Base de datos | MySQL 8.0 |
| Driver | mysql-connector-java 8.0.18 (incluido) |
| Vistas | JSP + JSTL 1.2 + Spring form tags |

No usa Maven ni Gradle: todas las librerías ya vienen en `WEB-INF/lib`.

---

## Cómo correrlo

### 1. Clonar

```bash
git clone <URL_DEL_REPO>
```

### 2. Base de datos

Crea la base y carga el dump:

```bash
mysql -u root -p -e "CREATE DATABASE financiera_huanca;"
mysql -u root -p financiera_huanca < DOM_Base_datos/dump.sql
```

Verifica que existan las tablas `cliente`, `moneda`, `credito` y `pago_tarjeta`:

```bash
mysql -u root -p financiera_huanca -e "SHOW TABLES; SELECT COUNT(*) FROM pago_tarjeta;"
```

### 3. Configurar la conexión

Edita `src/servicio.properties` con **tu** usuario y contraseña de MySQL:

```properties
urlBD=jdbc:mysql://127.0.0.1:3306/financiera_huanca?serverTimezone=America/Mexico_City&useSSL=false&allowPublicKeyRetrieval=true
user=root
password=TU_PASSWORD
```

> No subas tu contraseña al repo. Si lo modificas, no hagas commit de este archivo.

### 4. Importar en STS / Eclipse

1. **File → Import → General → Existing Projects into Workspace**.
2. *Select root directory* → la carpeta del repo → **Finish** (sin palomear "Copy projects into workspace").
3. Si sale *"Target runtime not defined"*: clic derecho al proyecto → **Properties → Targeted Runtimes** → palomea tu Tomcat 9 → **Apply**.
   - Si no tienes Tomcat dado de alta: **Window → Preferences → Server → Runtime Environments → Add → Apache Tomcat v9.0** → apunta a la carpeta de tu Tomcat.

### 5. Correr

1. **Project → Clean**.
2. Clic derecho al proyecto → **Run As → Run on Server** → Tomcat 9 → **Finish**.
3. En la consola debe aparecer `Server startup in [...] milliseconds` sin excepciones.

### 6. Abrir en el navegador

El *context root* es `ValidacionFormularioSpring3MVC`:

| Página | URL |
|---|---|
| Formulario + tabla de pagos | http://localhost:8080/ValidacionFormularioSpring3MVC/credito/nuevo.htm |
| Resultado (créditos + pagos) | http://localhost:8080/ValidacionFormularioSpring3MVC/credito/listar.htm |
| Clientes | http://localhost:8080/ValidacionFormularioSpring3MVC/cliente/listar.htm |
| Monedas | http://localhost:8080/ValidacionFormularioSpring3MVC/moneda/listar.htm |

---

## Estructura

```
src/
├── control/        Controladores Spring (CreditoController, ClienteController, MonedaController…)
├── dominio/        Beans: Credito, PagoTarjeta, Cliente, Moneda…
├── servicio/       Interfaces e implementaciones de servicio
├── baseDeDatos/    Acceso a MySQL con JDBC (…JDBCTemplate)
├── servicio.properties   Conexión a la BD
└── Spring-Datasource.xml
WebContent/
└── WEB-INF/
    ├── jsp/        Vistas (aquí trabaja el frontend)
    ├── lib/        Jars
    ├── dispatcher-servlet.xml   Beans de servicio y component-scan
    └── web.xml
DOM_Base_datos/
└── dump.sql        Script de la base de datos
```

Flujo de la Tarea 3:

```
GET  /credito/nuevo.htm   → carga pagos de BD → creditoForm.jsp
POST /credito/guardar.htm → guarda crédito + UPDATE de la columna pagos
                          → redirect a /credito/listar.htm → creditoListar.jsp
```

---

## Guía para el frontend

Las vistas que importan para la Tarea 3 son:

- `WebContent/WEB-INF/jsp/creditoForm.jsp` — formulario + tabla editable
- `WebContent/WEB-INF/jsp/creditoListar.jsp` — vista de resultado

Se puede cambiar libremente el HTML, la estructura visual y los estilos, **pero estas cosas no se deben tocar** porque Spring las usa para leer los datos:

1. **Los `path` de los `form:` tags** (`idCliente`, `idMoneda`, `monto`, `periodoMeses`, `cuota`, `tea`, `idCredito`).
2. **Los `name` de los inputs de fecha**: `fecha` y `fechaVencimiento` (deben seguir siendo `type="date"`, formato `yyyy-MM-dd`).
3. **Los `name` de la tabla de pagos**, con su índice:
   ```jsp
   <input type="hidden" name="pagos[${s.index}].idPago" value="${p.idPago}" />
   <input name="pagos[${s.index}].pagos" value="${p.pagos}" />
   ```
   El `hidden` con `idPago` es obligatorio, sin él no se sabe qué fila actualizar.
4. **El `action` y `method="post"` del `form:form`** y que la tabla de pagos quede **dentro** del form.
5. **Las variables del modelo**: `${credito}`, `${credito.pagos}`, `${clientes}`, `${monedas}`, `${creditos}`, `${pagos}`.

### CSS / JS / imágenes

Ponerlos en `WebContent/css`, `WebContent/js`, `WebContent/img` (crear las carpetas) y referenciarlos con el context path para que no se rompan las rutas:

```jsp
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
<script src="${pageContext.request.contextPath}/js/app.js"></script>
```

Los cambios en JSP y CSS se ven con solo recargar el navegador; no hace falta reiniciar Tomcat.

### Validaciones del lado del cliente (opcional)

Los tipos en Java son: `periodoMeses` entero; `monto`, `cuota`, `tea` y `pagos` decimales (`tea` máximo 999.99). Si se mete texto o un decimal en un entero, Spring regresa error 500, así que ayuda poner `type="number"` con `step` adecuado.

---

## Problemas comunes

| Error | Causa | Solución |
|---|---|---|
| `Communications link failure` | MySQL no escucha en el puerto 3306 | Revisar que no exista `skip-networking` en `/etc/mysql/` y reiniciar MySQL |
| `Access denied for user 'root'` | Contraseña incorrecta | Corregir `src/servicio.properties` |
| Fechas un día antes | Zona horaria | Usar `serverTimezone=America/Mexico_City` en `urlBD` |
| `NumberFormatException` al guardar | Valor no numérico o decimal en `periodoMeses` | Capturar un entero |
| 404 | URL con context root incorrecto | Usar `/ValidacionFormularioSpring3MVC/...` |
