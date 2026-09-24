<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Monedas</title>
</head>
<body>
    <h2>Listado de Monedas</h2>

    <a href="${pageContext.request.contextPath}/moneda/nuevo.htm">Nueva Moneda</a>

    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Símbolo</th>
            <th>Acciones</th>
        </tr>
        <c:forEach var="moneda" items="${monedas}">
            <tr>
                <td>${moneda.idMoneda}</td>
                <td>${moneda.nombre}</td>
                <td>${moneda.simbolo}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/moneda/editar/${moneda.idMoneda}.htm">Editar</a>
                    |
                    <a href="${pageContext.request.contextPath}/moneda/eliminar/${moneda.idMoneda}.htm">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>