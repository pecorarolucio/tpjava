<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Película</title>
</head>
<body>
    <h1>Editar Película</h1>
    <form action="EditarPelicula" method="post">
        <label>Nombre:</label>
        <input type="text" name="nombre" value="${editPel.nombrePelicula}">
        <br>
        <label>URL de la portada:</label>
        <input type="text" name="portada" value="${editPel.portada}">
        <br>
        <input type="hidden" name="idPelicula" value="${editPel.idPelicula}">
        <input type="submit" value="Guardar Cambios">
    </form>
</body>
</html>