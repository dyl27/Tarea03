# FormularioDBSpring3MVC

CRUD de créditos con Spring MVC, JSP y Tomcat 9, conectado a MySQL.

## Autores

- **Dylan**: modelo, controlador y base de datos.
- **Moisés**: vista.

## Requisitos

- Java 8 (JavaSE-1.8)
- Eclipse / Spring Tools for Eclipse
- Apache Tomcat 9.0
- MySQL (con cliente de consola `mysql`)
- El driver JDBC ya viene en `WebContent/WEB-INF/lib`

## 1. Importar el proyecto

En Eclipse: **File → Import → General → Existing Projects into Workspace**, selecciona la carpeta del proyecto y termina.

Verifica en **Project → Properties → Java Build Path** que el JRE sea 1.8 y que Tomcat 9 aparezca como *Server Runtime*. Si no, agrégalo en **Window → Preferences → Server → Runtime Environments**.

## 2. Crear la base de datos

Crea la base de datos vacía:

```
mysql -u TU_USUARIO -p -e "CREATE DATABASE financiera_huanca;"
```

Carga el dump con la estructura y los datos de prueba:

```
mysql -u TU_USUARIO -p financiera_huanca < DOM_Base_datos/dump.sql
```

## 3. Configurar la conexión

Abre `src/servicio.properties` y ajusta los datos de conexión a tu MySQL:

- URL de la base de datos: `jdbc:mysql://localhost:3306/financiera_huanca`
- Usuario de MySQL
- Contraseña de MySQL

Las credenciales originales no están en el repositorio. Pídeselas a Dylan por mensaje privado, o usa las de tu propio MySQL.

**No subas este archivo con tus credenciales.** Para que Git ignore tus cambios locales:

```
git update-index --assume-unchanged src/servicio.properties
```

## 4. Ejecutar

1. Clic derecho en el proyecto → **Run As → Run on Server** → Tomcat 9.
2. Abre en el navegador:

```
http://localhost:8080/FormularioDBSpring3MVC/credito/listar.htm
```

Si tu Tomcat usa otro puerto o el proyecto otro *context path*, ajusta la URL.

## Estructura

- `src/control`: controladores (`CreditoController`, etc.)
- `src/dominio`: clases de dominio (`Credito`, `Cliente`, `Moneda`)
- `src/servicio`: servicios y acceso a datos
- `WebContent/WEB-INF/jsp`: vistas JSP
- `DOM_Base_datos`: dump de la base de datos

## Notas para el frontend

- **No cambies los atributos `name` ni `path` de los inputs** en `creditoForm.jsp`. Spring los usa para llenar el objeto `Credito`.
- Los campos de fecha viajan como `yyyy-MM-dd`. Si cambias el formato, hay que ajustar el `@InitBinder` de `CreditoController`.
- Las rutas terminan en `.htm` (`/credito/listar.htm`, `/credito/nuevo.htm`, `/credito/editar/{id}.htm`).

## Ramas

- `main`: versión estable.
- `frontend`: cambios de vistas (JSP/CSS/JS). Se une a `main` con Pull Request.
