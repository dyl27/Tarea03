<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <input type="submit" value="Aceptar" />
    </form:form>

    <a href="${pageContext.request.contextPath}/credito/listar.htm">Volver al listado</a>
</body>
</html>