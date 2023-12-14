<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Categoria</title>
</head>
<body>
<h2>Agregar Categoria</h2>

    <form action="AgregarCategoria" method="post">
        <label for="nombre">Nombre</label>
        <input type="text" id="nombre" name="nombre" required>
        <br>
		 <br>
        <input type="submit" value="Agregar Categoria">
    </form>
</body>
</html>