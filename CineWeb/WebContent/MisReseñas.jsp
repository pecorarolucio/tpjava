<%@page import="java.util.LinkedList"%>
<%@page import="entities.Reseña"%>
<%@page import="entities.Pelicula" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis Reseñas</title>
</head>
<body>
	<% LinkedList<Reseña> reseñas = (LinkedList<Reseña>) request.getAttribute("reseñas"); %>
	<h1>Mis reseñas</h1>
	<%if (reseñas.isEmpty()){ %>
	<p><strong>No has realizado ninguna reseña</strong></p>
	<% } else { %>
		<ul>
		<%for (Reseña reseña: reseñas){ %>
	
		<li><p><%= reseña.getPelicula().getNombrePelicula() %></p>
			<p><%= reseña.getFecha() %></p>
			<p><%= reseña.getDescripcion() %></p>
			<form method="post" action="BorrarReseña">
			<input type="hidden" name="idReseña" value="<%reseña.getCodigo(); %>" >
			<input type="submit" value="Borrar Reseña">
			</form>
		</li>
		<% } 
		} %>
		</ul>
		
</body>
</html>