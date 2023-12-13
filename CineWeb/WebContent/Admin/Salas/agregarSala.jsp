
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Sala</title>
</head>
<body>
<h2>Agregar Sala</h2>

    <form action="AgregarSala" method="post">
        <label for="nombre">Capacidad:</label>
        <input type="text" id="capacidad" name="capacidad" required>
        <br>

        <input type="submit" value="Agregar Sala">
    </form>
</body>
</html>