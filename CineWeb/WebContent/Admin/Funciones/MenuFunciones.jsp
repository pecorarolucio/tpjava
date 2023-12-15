<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.LinkedList"%>
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
	LinkedList<Pelicula> pelis = (LinkedList<Pelicula>) request.getAttribute("peliculas");
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
			<h3 class="text-center">Lista de Peliculas para elegir funciones</h3>
			<hr>
			<div class="container text-left">
				<button class="btn btn-dark" onclick="volver()">Volver</button>
			</div>
			<br>
			<table class="table table-bordered">
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
						<%for (Pelicula p: pelis ) { %>
            		<tr>
            		<td><%=p.getIdPelicula()%></td>
            		<td><%=p.getNombrePelicula()%></td> 
            		<td><%=p.getCategoria().getNombreCategoria() %></td>
            		<%String imagen = p.getPortada();%> 
            		<td><img src="../../<%=imagen%>" alt="portada" style="width: 100px; height: 100px;"></td>         	
            		<td>
            			<form action="MostrarFunciones" method="get" >
	            			<input type="hidden" name="idPelicula" value="<%= p.getIdPelicula() %>" >
	            			<button type="submit" class="btn btn-dark">Ver funciones</button>
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

<script>
        function volver() {
            window.location.href = '../../Index.jsp';
        }
    </script>