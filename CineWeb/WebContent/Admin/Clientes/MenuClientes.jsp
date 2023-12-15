<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Persona"%>
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
	LinkedList<Persona> clientes = (LinkedList<Persona>) request.getAttribute("clientes");
	%>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand">Gestion de Clientes </a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Clientes</h3>
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
						<th>Apellido</th>
						<th>Correo</th>					
                  		<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
						<%for (Persona c: clientes ) { %>
            		<tr>
            		<td><%=c.getId()%></td>
            		<td><%=c.getNombre()%></td>
            		<td><%=c.getApellido()%></td> 
            		<td><%=c.getMail()%></td>              	  
            		<td>
	            		<form action="BorrarCliente" method="post">
	            		<input type="hidden" name="idCategoria" value="<%= c.getId() %>" >
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
            window.location.href = '../../Index.jsp';
        }
    </script>