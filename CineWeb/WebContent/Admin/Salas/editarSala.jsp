<%@page import="entities.Sala"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar pelicula</title>
</head>
<%Sala s = (Sala) request.getAttribute("sala"); %>
<html>
<head>
    <title>Editar Sala</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Editar Sala</h1>
        <form action="EditarSala" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="capacidad">Capacidad:</label>
                <input type="text" class="form-control" id="capacidad" name="capacidad" value="<%= s.getCapacidadMaxima() %>"
                    required>
            </div>
            
            <input type="hidden" name="idSala" value="<%= s.getIdSala() %>">
            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
            <a href="#" onclick="volver()" class="btn btn-secondary ml-2">Volver</a>
        </form>
    </div>
</body>
    <script>
        function volver() {
            window.location.href = 'MenuSala';
        }
    </script>
 </html> 