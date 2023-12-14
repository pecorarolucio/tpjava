<%@page import="entities.Pelicula"%>
<%@page import="entities.Categoria"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar pelicula</title>
</head>
<%Pelicula editPel = (Pelicula) request.getAttribute("editPel");
	LinkedList<Categoria> categorias = (LinkedList<Categoria>) request.getAttribute("categorias"); %>
<html>
<head>
    <title>Editar Película</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Editar Película</h1>
        <form action="EditarPelicula" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="<%= editPel.getNombrePelicula() %>"
                    required>
            </div>
            <div class="form-group">
                <label for="portada">Portada:</label>
                <input type="file" class="form-control-file" id="portada" name="portada" accept="image/*">
            </div>
            <div class="form-group">
                <label for="idCategoria">Categoría:</label>
                <select class="form-control" id="idCategoria" name="idCategoria" required>
                    <% for (Categoria categoria: categorias) { %>
                        <option value="<%=categoria.getIdCategoria()%>"><%=categoria.getNombreCategoria() %></option>
                    <% } %>
                </select>
            </div>
            <input type="hidden" name="idPelicula" value="${editPel.idPelicula}">
            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
            <a href="#" onclick="volver()" class="btn btn-secondary ml-2">Volver</a>
        </form>
    </div>
</body>
    <script>
        function volver() {
            window.location.href = 'MenuPelicula';
        }
    </script>
 </html>
    