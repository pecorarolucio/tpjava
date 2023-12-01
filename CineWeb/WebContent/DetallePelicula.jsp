<%@page import="entities.Persona"%>
<%@page import="entities.Pelicula"%>
<%@page import="entities.Reseña" %>
<%@page import="java.util.LinkedList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%HttpSession se = request.getSession();
Persona p = (Persona) se.getAttribute("usuario"); %>
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
	<p>Categoria: <%=pel.getCategoria().getNombreCategoria() %></p> <%--pel.getCategoria().getNombreCategoria() --%>
	
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
	<% if(p == null){%>
	<a href="login.html" class="btn btn-primary">Inicie sesion para comprar la entrada</a>
	<%}else{%>
	<%String url = "ListaFunciones?IdPelicula=" + pel.getIdPelicula();%>
	<a href="<%=url%>" class="btn btn-primary">Comprar entrada</a>
	<%} %>
	<%
	} else {
	%>
	<p>No se encontro la pelicula especificada</p>
	<% } %>
	

</body>
</html>