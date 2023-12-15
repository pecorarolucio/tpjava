<%@page import="java.util.LinkedList"%>
<%@page import="entities.Reseña"%>
<%@page import="entities.Pelicula" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mis Reseñas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="d-flex justify-content-start align-items-center mb-3">
        <a href="#" onclick="volver()" class="btn btn-secondary btn-sm me-3">Volver</a>
        <h1 class="mb-0">Mis Reseñas</h1>
    </div>

    <% LinkedList<Reseña> reseñas = (LinkedList<Reseña>) request.getAttribute("reseñas"); %>
    <% if (reseñas.isEmpty()){ %>
        <p class="text-center"><strong>No has realizado ninguna reseña</strong></p>
    <% } else { %>
        <ul class="list-group">
            <% for (Reseña reseña: reseñas){ %>
                <li class="list-group-item">
                    <p><strong>Película:</strong> <%= reseña.getPelicula().getNombrePelicula() %></p>
                    <p><strong>Fecha:</strong> <%= reseña.getFecha() %></p>
                    <p><strong>Descripción:</strong> <%= reseña.getDescripcion() %></p>
                    <form action="BorrarReseña" method="post">
                        <input type="hidden" name="codigo" value="<%= reseña.getCodigo() %>" >
                        <input type="hidden" name="idPelicula" value="<%= reseña.getPelicula().getIdPelicula() %>">
                        <button type="submit" class="btn btn-danger">Borrar Reseña</button>
                    </form>
                </li>
            <% } %>
        </ul>
    <% } %>
</div>

</body>

<script>
	function volver(){
		window.location.href='Index.jsp'
	}
</script>
</html>
