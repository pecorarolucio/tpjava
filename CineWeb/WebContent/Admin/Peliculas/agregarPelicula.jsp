<%@page import="entities.Categoria"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%LinkedList<Categoria> categorias = (LinkedList<Categoria>) request.getAttribute("categorias"); %>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Película</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <h2>Agregar Película</h2>

        <form action="AgregarPelicula" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>

            <div class="form-group">
                <label for="portada">Portada:</label>
                <input type="file" class="form-control-file" id="portada" name="portada" accept="image/*">
            </div>

            <div class="form-group">
                <label for="idCategoria">Categoría:</label>
                <select class="form-control" id="idCategoria" name="idCategoria" required>
                    <!-- Iterar sobre las categorías recuperadas y generar las opciones -->
                    <% for (Categoria categoria: categorias) { %>
                        <option value="<%=categoria.getIdCategoria()%>"><%=categoria.getNombreCategoria() %></option>
                    <% } %>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Agregar Película</button>
            
            <a href="#" onclick="volver()" class="btn btn-secondary ml-2">Volver</a>
            
        </form>
    </div>
    
    <script>
        function volver() {
            window.location.href = 'MenuPelicula';
        }
    </script>
</body>
</html>
