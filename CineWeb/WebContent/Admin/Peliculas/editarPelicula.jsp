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
<body>
    <h1>Editar Película</h1>
    <form action="EditarPelicula" method="post" enctype="multipart/form-data">
        <label>Nombre:</label>
        <input type="text" name="nombre" value="<%=editPel.getNombrePelicula()%>">
        <br>
        <label for="portada">Portada:</label>
        <input type="file" name="portada" id="portada" value="../../<%=editPel.getPortada()%>" accept="image/*">
        <label for="idCategoria">Categoría:</label>
        <select id="idCategoria" name="idCategoria" required>
            <% for (Categoria categoria: categorias) { %>
                <option value="<%=categoria.getIdCategoria()%>"><%=categoria.getNombreCategoria() %></option>
            <% } %>
        </select>
        <br>
        <input type="hidden" name="idPelicula" value="${editPel.idPelicula}">
        <input type="submit" value="Guardar Cambios">
        <button type="button" onclick="volver()">Volver</button>
    </form>
    
    <script>
        function volver() {
            window.location.href = 'MenuPelicula';
        }
    </script>
    