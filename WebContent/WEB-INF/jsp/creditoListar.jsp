<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Créditos</title>
</head>
<body>
    <h2>Listado de Créditos</h2>

    <a href="${pageContext.request.contextPath}/credito/nuevo.htm">Nuevo Crédito</a>

    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Fecha</th>
            <th>Monto</th>
            <th>Periodo (meses)</th>
            <th>Cuota</th>
            <th>TEA</th>
            <th>Fecha vencimiento</th>
            <th>Acciones</th>
        </tr>
        <c:forEach var="credito" items="${creditos}">
            <tr>
                <td>${credito.idCredito}</td>
                <td><fmt:formatDate value="${credito.fecha}" pattern="dd/MM/yyyy" /></td>
                <td>${credito.monto}</td>
                <td>${credito.periodoMeses}</td>
                <td>${credito.cuota}</td>
                <td>${credito.tea}%</td>
                <td><fmt:formatDate value="${credito.fechaVencimiento}" pattern="dd/MM/yyyy" /></td>
                <td>
                    <a href="${pageContext.request.contextPath}/credito/editar/${credito.idCredito}.htm">Editar</a>
                    |
                    <a href="${pageContext.request.contextPath}/credito/eliminar/${credito.idCredito}.htm">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>