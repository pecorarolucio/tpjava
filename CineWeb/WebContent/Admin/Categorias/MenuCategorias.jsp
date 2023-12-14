<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Categoria"%>
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
	LinkedList<Categoria> categorias = (LinkedList<Categoria>) request.getAttribute("categorias");
	%>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand">Gestion de Categorias </a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Categorias</h3>
			<hr>
			<div class="container text-left">

				<a href="agregarCategoria.jsp" class="btn btn-success">Agregar Categoria</a>

				<button class="btn btn-dark" onclick="volver()">Volver</button>
				</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>						
                  		<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
						<%for (Categoria c: categorias ) { %>
            		<tr>
            		<td><%=c.getIdCategoria()%></td>
            		<td><%=c.getNombreCategoria()%></td>             	  
            		<td>
            			<form action="EditarCategoria" method="get" >
	            			<input type="hidden" name="idCategoria" value="<%= c.getIdCategoria() %>" >
	            			<button type="submit" class="btn btn-dark">Editar</button>
	            		</form>
	            		<form action="BorrarCategoria" method="post">
	            		<input type="hidden" name="idCategoria" value="<%= c.getIdCategoria() %>" >
            			<button type="submit" class="btn btn-danger">Borrar</button>
            			</form>
            		</td>	
					</tr>
						<%} %>
				</tbody>
			</table>
			<% if(request.getAttribute("mensaje") != null) {%>
      		<div class="alert-danger alert alert-dismissable">
      		${requestScope.mensaje}
      		</div>
      		<% } %>	
		</div>
	</div>
</body>
</html>

<script>
        function volver() {
            window.location.href = '../../Index.jsp';
        }
    </script>