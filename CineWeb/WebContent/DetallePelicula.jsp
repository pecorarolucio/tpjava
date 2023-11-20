<%@page import="entities.Persona"%>
<%@page import="entities.Pelicula"%>
<%@page import="entities.Reseña" %>
<%@page import="java.util.LinkedList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles pelicula</title>
</head>
<body>
	<%
		Pelicula pel = (Pelicula) request.getAttribute("pelicula");
		LinkedList<Reseña> reseñas = (LinkedList<Reseña>) request.getAttribute("reseñas");
		if (pel != null){
	%>
	<h1>Detalles pelicula</h1>
	<p>Titulo: <%= pel.getNombrePelicula() %></p>
	<p>Categoria: <%= pel.getCategoria().getNombreCategoria()%></p>
	
	<h2>Reseñas:</h2>
	<ul>
	<% for (Reseña reseña : reseñas) {
		Persona Autor = reseña.getAutor(); %>
	<li><p><%= Autor.getNombre() %></p>
		<p><%= reseña.getFecha() %></p>
		<p><%= reseña.getDescripcion() %></p>
	</li>
		<% } %>
	</ul>
	<%
	} else {
	%>
	<p>No se encontro la pelicula especificada</p>
	<% } %>

</body>
</html>