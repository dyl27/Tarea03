<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario de Moneda</title>
</head>
<body>
    <h2>
        <c:choose>
            <c:when test="${moneda.idMoneda != null}">Editar Moneda</c:when>
            <c:otherwise>Nueva Moneda</c:otherwise>
        </c:choose>
    </h2>

    <form:form modelAttribute="moneda" action="${pageContext.request.contextPath}/moneda/guardar.htm" method="post">
        <form:hidden path="idMoneda" />

        <p>
            <label>Nombre:</label>
            <form:input path="nombre" />
        </p>
        <p>
            <label>Símbolo:</label>
            <form:input path="simbolo" />
        </p>

        <input type="submit" value="Guardar" />
    </form:form>

    <a href="${pageContext.request.contextPath}/moneda/listar.htm">Volver al listado</a>
</body>
</html>