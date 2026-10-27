<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario de Crédito</title>
</head>
<body>
    <h2>
        <c:choose>
            <c:when test="${credito.idCredito != null}">Editar Crédito</c:when>
            <c:otherwise>Nuevo Crédito</c:otherwise>
        </c:choose>
    </h2>

    <form:form modelAttribute="credito" action="${pageContext.request.contextPath}/credito/guardar.htm" method="post">
        <form:hidden path="idCredito" />

        <p>
            <label>Cliente:</label>
            <form:select path="idCliente">
                <form:option value="" label="-- Selecciona --" />
                <c:forEach var="cliente" items="${clientes}">
                    <form:option value="${cliente.idCliente}">${cliente.nombres} ${cliente.apellidos}</form:option>
                </c:forEach>
            </form:select>
        </p>

        <p>
            <label>Fecha:</label>
            <input type="date" name="fecha" id="fecha" value="${credito.fecha}" />
        </p>

        <p>
            <label>Moneda:</label>
            <c:forEach var="moneda" items="${monedas}">
                <form:radiobutton path="idMoneda" value="${moneda.idMoneda}" label="${moneda.nombre} (${moneda.simbolo})" />
            </c:forEach>
        </p>

        <p>
            <label>Monto:</label>
            <form:input path="monto" />
        </p>

        <p>
            <label>Periodo (meses):</label>
            <form:input path="periodoMeses" />
        </p>

        <p>
            <label>Cuota:</label>
            <form:input path="cuota" />
        </p>

        <p>
            <label>TEA (%):</label>
            <form:input path="tea" />
        </p>

        <p>
            <label>Fecha vencimiento:</label>
            <input type="date" name="fechaVencimiento" id="fechaVencimiento" value="${credito.fechaVencimiento}" />
        </p>

        <h3>Gastos con tarjeta de crédito</h3>
        <table border="1" cellpadding="5">
            <tr>
                <th>FECHA</th><th>MES</th><th>TARJETA</th><th>TRANSACCIÓN</th><th>GASTOS</th><th>PAGOS</th>
            </tr>
            <c:forEach items="${credito.pagos}" var="p" varStatus="s">
                <tr>
                    <td><fmt:formatDate value="${p.fecha}" pattern="dd/MM/yyyy" /></td>
                    <td>${p.mes}</td>
                    <td>${p.tarjeta}</td>
                    <td>${p.transaccion}</td>
                    <td>${p.gastos}</td>
                    <td>
                        <input type="hidden" name="pagos[${s.index}].idPago" value="${p.idPago}" />
                        <input name="pagos[${s.index}].pagos" value="${p.pagos}" />
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br/>

        <input type="submit" value="Aceptar" />
    </form:form>

    <a href="${pageContext.request.contextPath}/credito/listar.htm">Volver al listado</a>
</body>
</html>
