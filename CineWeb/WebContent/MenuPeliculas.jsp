<%@page import="java.util.LinkedList"%>
<%@page import="entities.Pelicula"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Peliculas</title>
</head>
<body>
<%
	LinkedList<Pelicula> peliculas = (LinkedList<Pelicula>) request.getAttribute("peliculas");
	
	%>
<h1>Peliculas</h1>
	<table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                  	<th>Categoria</th>
                  	<th>Portada</th>
                  	<th>Acciones</th>
               </tr>
            </thead>
            <tbody>
            	<%for (Pelicula pelicula: peliculas ) { %>
            	<tr>
            		<td><%=pelicula.getIdPelicula()%></td>
            		<td><%=pelicula.getNombrePelicula() %></td>
            		<td><%=pelicula.getCategoria().getNombreCategoria() %></td>
            		<td><%=pelicula.getPortada() %></td>
            		<td>
            			<form action="BorrarPelicula" method="post">
	            			<input type="hidden" name="idPelicula" value="<%=pelicula.getIdPelicula() %>" >
	            			<button type="submit">Borrar</button>
            			</form>
            			
            			<form action="EditarPelicula" method="get" >
	            			<input type="hidden" name="idPelicula" value="<%=pelicula.getIdPelicula() %>" >
	            			<button type="submit">Editar</button>
            			</form>
            		</td>
            	</tr>
            	<% } %>
            </tbody>
	</table>
</body>
</html>