<%@page import="java.util.LinkedList"%>
<%@page import="entities.Reseña"%>
<%@page import="entities.Pelicula" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			<input type="hidden" name="idReseña" value="<%=reseña.getCodigo()%>" >
			<input type="hidden" name="idPelicula" value="<%=reseña.getPelicula().getIdPelicula()%>" >
			<input type="submit" value="Borrar Reseña">
			</form>
		</li>
		<% } 
		} %>
		</ul>
		
</body>
</html>