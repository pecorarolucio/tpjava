<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Pelicula" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Listado de Películas</title>
</head>
<body>

<%-- Forma completa que verifica que lo que llega no es null y es una instcia de Linkedlist --%>
<%--<% 
    Object peliculasObject = request.getAttribute("peliculas");
    if (peliculasObject != null && peliculasObject instanceof LinkedList<?>) {
        @SuppressWarnings("unchecked")
        LinkedList<Pelicula> peliculas = (LinkedList<Pelicula>) peliculasObject;
        System.out.println("Cantidad de películas: " + peliculas.size());
        for (Pelicula pelicula : peliculas) { %>
            <h1><%= pelicula.getNombrePelicula() %></h1>
<%      }
    } else { %>
        <p>No hay películas disponibles.</p>
<% } %> --%>



<% LinkedList<Pelicula> peliculas = (LinkedList<Pelicula>) request.getAttribute("peliculas");
	if ( !peliculas.isEmpty() && peliculas.size() > 0) {
	for (Pelicula pel : peliculas) {%>
		<h1><%= pel.getNombrePelicula() %></h1>
	<% }}
	else { %>
		<p>No hay peliculas disponibles </p>
	<% } %>

</body>
</html>
