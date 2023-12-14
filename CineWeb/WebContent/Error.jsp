<%@page isErrorPage="true" import="java.io.*" %>
<%@page import="entities.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Error</title>
</head>
<body>
<%Persona p = (Persona)session.getAttribute("usuario"); %>
    <h2>Error</h2>
    <p>${requestScope.error}</p>
    <% if (p != null && "Admin".equals(p.getTipo())){%>
    <p>${requestScope.causa}</p>
    <% } %>
</body>
</html>