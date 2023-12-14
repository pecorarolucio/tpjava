<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Categoria"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar categoria</title>
</head>
<body>
	<% Categoria c = (Categoria) request.getAttribute("categoria"); %>
    <h1>Editar Categoria</h1>
    <form action="EditarCategoria" method="post">
        <label>Nombre:</label>
        <input type="text" name="nombre" value=<%= c.getNombreCategoria() %>>
        <br>
        <input type="hidden" name="idCategoria" value=<%= c.getIdCategoria()%>>
        
        <input type="submit" value="Guardar Cambios">
        
        <button type="button" onclick="volver()">Volver</button>
    </form>
    
	<script>
function volver() {
    history.back();
}
</script>