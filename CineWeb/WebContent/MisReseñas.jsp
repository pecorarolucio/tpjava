<%@page import="java.util.LinkedList"%>
<%@page import="entities.Rese�a"%>
<%@page import="entities.Pelicula" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis Rese�as</title>
</head>
<body>
	<% LinkedList<Rese�a> rese�as = (LinkedList<Rese�a>) request.getAttribute("rese�as"); %>
	<h1>Mis rese�as</h1>
	<%if (rese�as.isEmpty()){ %>
	<p><strong>No has realizado ninguna rese�a</strong></p>
	<% } else { %>
		<ul>
		<%for (Rese�a rese�a: rese�as){ %>
	
		<li><p><%= rese�a.getPelicula().getNombrePelicula() %></p>
			<p><%= rese�a.getFecha() %></p>
			<p><%= rese�a.getDescripcion() %></p>
			<form method="post" action="BorrarRese�a">
			<input type="hidden" name="idRese�a" value="<%rese�a.getCodigo(); %>" >
			<input type="submit" value="Borrar Rese�a">
			</form>
		</li>
		<% } 
		} %>
		</ul>
		
</body>
</html>