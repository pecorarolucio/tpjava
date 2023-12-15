
<%@page import="entities.Categoria"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar pelicula</title>
</head>
<%Categoria c = (Categoria) request.getAttribute("categoria"); %>
<html>
<head>
    <title>Editar Categoria</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Editar Categoria</h1>
        <form action="EditarCategoria" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="<%= c.getNombreCategoria() %>"
                    required>
            </div>
            
            <input type="hidden" name="idCategoria" value="<%= c.getIdCategoria() %>">
            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
            <a href="#" onclick="volver()" class="btn btn-secondary ml-2">Volver</a>
        </form>
    </div>
</body>
    <script>
        function volver() {
            window.location.href = 'MenuCategoria';
        }
    </script>
 </html> 