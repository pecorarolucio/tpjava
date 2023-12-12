<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Sala"%>
<html>
<head>
<title></title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<%
	LinkedList<Sala> salas = (LinkedList<Sala>) request.getAttribute("salas");
	%>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand">Gestion de Salas </a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Salas</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/AgregarSala" class="btn btn-success">Agregar Sala</a>
			</div>
			<br>
			<table class="table table-bordered">
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
            		<td><%=sal.getCapacidadMaxima()%></td>            	
            		<td>
            			<a href="<%=request.getContextPath()%>/EditarSala" class="btn btn-dark">Editar</a>
            			<a href="<%=request.getContextPath()%>/BorrarSala" class="btn btn-danger">Borrar</a>
            		</td>	
					</tr>
						<%} %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>