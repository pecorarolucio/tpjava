<%@page import="entities.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%Persona p = (Persona) request.getSession().getAttribute("usuario"); %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar mi perfil</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Editar mi perfil</h1>

        <form action="Profile" method="post" class="bg-white p-4 rounded shadow-sm">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="<%=p.getNombre() %>" required>
            </div>

            <div class="form-group">
                <label for="apellido">Apellido:</label>
                <input type="text" class="form-control" id="apellido" name="apellido" value="<%=p.getApellido() %>" required>
            </div>

            <div class="form-group">
                <label for="mail">Mail:</label>
                <input type="text" class="form-control" id="mail" name="mail" value="<%=p.getMail() %>" required>
            </div>

            <button type="submit" class="btn btn-primary">Guardar</button>
            <a href="#" onclick="volver()" class="btn btn-secondary">Volver</a>
        </form>
    </div>
<script>
	function volver(){
		window.location.href= 'Profile';
	}
</script>
</body>
</html>
