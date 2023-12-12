<%@page import="entities.Categoria"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar pelicula</title>
</head>
<body>
<%LinkedList<Categoria> categorias = (LinkedList<Categoria>) request.getAttribute("categorias"); %>
<h2>Agregar Película</h2>

    <form action="AgregarPelicula" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
        <br>

        <label for="portada">URL de la Portada:</label>
        <input type="text" id="portada" name="portada" required>
        <br>

        <label for="idCategoria">Categoría:</label>
        <select id="idCategoria" name="idCategoria" required>
            <!-- Iterar sobre las categorías recuperadas y generar las opciones -->
            <% for (Categoria categoria: categorias) { %>
                <option value="<%=categoria.getIdCategoria()%>"><%=categoria.getNombreCategoria() %></option>
            <% } %>
        </select>
        <br>

        <input type="submit" value="Agregar Película">
    </form>
</body>
</html>