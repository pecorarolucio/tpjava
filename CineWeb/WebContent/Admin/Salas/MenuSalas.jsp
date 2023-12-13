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

				<a href="agregarSala.jsp" class="btn btn-success">Agregar Sala</a>
				
				<button class="btn btn-dark" onclick="volver()">Volver</button>
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
            			<form action="EditarSala" method="get" >
	            			<input type="hidden" name="idSala" value="<%= sal.getIdSala() %>" >
	            			<button type="submit" class="btn btn-dark">Editar</button>
	            		</form>
	            		<form action="BorrarSala" method="post">
	            		<input type="hidden" name="idSala" value="<%=sal.getIdSala() %>">
            			<button type="submit" class="btn btn-danger">Borrar</button>
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
    history.back();
}
</script>