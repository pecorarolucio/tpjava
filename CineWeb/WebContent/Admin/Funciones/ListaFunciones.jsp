<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Funcion"%>
<%@page import="entities.Pelicula"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<%
	LinkedList<Funcion> Listfuncion = (LinkedList<Funcion>) request.getAttribute("funciones");
	Pelicula p = (Pelicula) request.getAttribute("pelicula");
	%>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand">Gestion de Funciones </a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Funciones</h3>
			<hr>
			<div class="container text-left">
				<form action="GetSala" method="get" >
	            			<input type="hidden" name="idPelicula" value="<%=p.getIdPelicula() %>" >
	            			<button type="submit" class="btn btn-success">Agregar Funcion</button>
	            </form>
				<button class="btn btn-dark" onclick="volver()">Volver</button>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>fecha</th>
						<th>HoraInicio</th>
						<th>HoraFin</th>
                  		<th>IDSala</th>
                  		<th>IDPelicula</th> <!-- LO AGREGO PARA VERIFICAR QUE LA PELI SEA LA CORECTA, LUEGO LO ELIMINAMOS -->
					</tr>
				</thead>
				<tbody>
						<%for (Funcion f: Listfuncion ) { %>
            		<tr>
            		<td><%=f.getFechaFuncion()%></td>
            		<td><%=f.getHoraInicio()%></td> 
            		<td><%=f.getHoraFin()%></td>
            		<td><%=f.getSala().getIdSala()%></td>  
            		<td><%=f.getPelicula().getIdPelicula()%></td>        	
            		<td>
            			<form action="SaveFuncion" method="get" >
	            			<input type="hidden" name="Fecha" value="<%= f.getFechaFuncion() %>" >
	            			<input type="hidden" name="HoraInicio" value="<%=f.getHoraInicio() %>" >
	            			<input type="hidden" name="IDSala" value="<%=f.getSala().getIdSala()%>" >
	            			<input type="hidden" name="idPelicula" value="<%=p.getIdPelicula() %>" >
	            			<button type="submit" class="btn btn-dark">Editar</button>
	            		</form>
	            		<form action="EliminarFuncion" method="post" >
	            			<input type="hidden" name="Fecha" value="<%= f.getFechaFuncion() %>" >
	            			<input type="hidden" name="HoraInicio" value="<%= f.getHoraInicio() %>" >
	            			<input type="hidden" name="IDSala" value="<%= f.getSala().getIdSala()%>" >
	            			<button type="submit" class="btn btn-dark">Eliminar Funcion</button>
	            		</form>
            		</td>	
					</tr>
						<%} %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>