<%@page import="java.util.LinkedList"%>
<%@page import="entities.Sala"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Salas</title>
</head>
<body>
<%
	LinkedList<Sala> salas = (LinkedList<Sala>) request.getAttribute("salas");
	
	%>
<h1>Salas</h1>
	<table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Capacidad</th>                  	
                  	<th>Acciones</th>
               </tr>
            </thead>
            <tbody>
            	<%for (Sala sal: salas ) { %>
            	<tr>
            		<td><%=sal.getIdSala()%></td>
            		<td><%=sal.getCapacidadMaxima() %></td>            	
            		<td>
            			<form action="BorrarSala" method="post">
	            			<input type="hidden" name="idPelicula" value="<%=sal.getIdSala() %>" >
	            			<button type="submit">Borrar</button>
            			</form>
            			
            			<form action="EditarSala" method="get" >
	            			<input type="hidden" name="idPelicula" value="<%=sal.getIdSala() %>" >
	            			<button type="submit">Editar</button>
            			</form>
            		</td>
            	</tr>
            	<% } %>
            </tbody>
	</table>
</body>
</html>
