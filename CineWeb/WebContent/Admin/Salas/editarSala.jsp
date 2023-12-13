<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entities.Sala"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar sala</title>
</head>
<body>
	<% Sala sala = (Sala) request.getAttribute("sala"); %>
    <h1>Editar Sala</h1>
    <form action="EditarSala" method="post">
        <label>Capacidad:</label>
        <input type="text" name="capacidad" value=<%= sala.getCapacidadMaxima() %>>
        <br>
        <input type="hidden" name="idSala" value=<%= sala.getIdSala()%>>
        
        <input type="submit" value="Guardar Cambios">
        
        <button type="button" onclick="volver()">Volver</button>
    </form>
    
	<script>
function volver() {
    history.back();
}
</script>