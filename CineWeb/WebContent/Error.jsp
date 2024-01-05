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
    <p>Ha ocurrido un error: </p>
    <p>${requestScope.error}</p>
    <% if (p != null && p.getTipo().equalsIgnoreCase("Admin")){%>
    <p>${requestScope.causa}</p>
    <% } %>
    
    <a href="Index.jsp">Volver a index</a>
</body>
</html>