<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario de Registro</title>
</head>
<body>
    <h2>Registro de Usuario</h2>
    <form action="SignIn" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br>
        
        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido" required><br>
        
        <label for="correo">Correo Electrónico:</label>
        <input type="email" id="mail" name="correo" required><br>
        
        <label for="password">Contraseña:</label>
        <input type="password" id="contrasenia" name="password" required><br>
        
        <input type="submit" value="Registrarse">
    </form>
</body>
</html>