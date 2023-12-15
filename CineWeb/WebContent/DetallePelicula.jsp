<%@page import="entities.Persona"%>
<%@page import="entities.Pelicula"%>
<%@page import="entities.Reseña" %>
<%@page import="java.util.LinkedList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%HttpSession se = request.getSession();
Persona p = (Persona) se.getAttribute("usuario"); %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalles Película</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
	<%
		Pelicula pel = (Pelicula) request.getAttribute("pelicula");
		LinkedList<Reseña> reseñas = (LinkedList<Reseña>) request.getAttribute("reseñas"); //No se si esto funciona, cuando se setea reseñas?
		if (pel != null){
	%>
	<h1>Detalles pelicula</h1>
	<p>Titulo: <%= pel.getNombrePelicula() %></p>
	<p>Categoria: <%=pel.getCategoria().getNombreCategoria() %></p>
	 <%--pel.getCategoria().getNombreCategoria() --%>
    <img src="<%=pel.getPortada()%>" alt="portada">    
	
	<h2>Reseñas:</h2>
	<% if (reseñas.isEmpty()){ %>
	<p>No hay reseñas añn</p>
	<% } %>
	<ul>
	<% for (Reseña reseña : reseñas) {
		Persona Autor = reseña.getAutor(); %>
	<li><p><%= Autor.getNombre() %></p>
		<p><%= reseña.getFecha() %></p>
		<p><%= reseña.getDescripcion() %></p>
		<%if(p!= null && p.getTipo().equals("Admin")){ %>
			<form method="post" action="BorrarReseña">
			<input type="hidden" name="idReseña" value="<%=reseña.getCodigo()%>" >
			<input type="hidden" name="idPelicula" value="<%=pel.getIdPelicula()%>" >
			<button type="submit"  value="Borrar Reseña">Borrar</button>
			</form>
			<% }%>
	</li>
		<% } %>
	</ul>
	<% if(p == null){%>
	<a href="login.html" class="btn btn-primary">Inicie sesion para comprar la entrada</a>
	<%}else{%>
	<%String url = "ListaFunciones?IdPelicula=" + pel.getIdPelicula();%>
	<a href="<%=url%>" class="btn btn-primary">Comprar entrada</a>
	<%} %>
	<h1>Realizar reseña</h1>
	<form action="PublicarReseña" method="Post">
		<input type="hidden" name="idPelicula" value="<%=pel.getIdPelicula() %>">
	     <label for="descripcion">Descripcion:</label>
	     <textarea name="descripcion" id="descripcion" rows="4" cols="50"></textarea>
	     <input type="submit" value="Publicar Reseña">
    </form>
	<%
	} else {
	%>
	<p>No se encontro la pelicula especificada</p>
	<% } %>
	

           if (pel != null) { %>
          
         <a href="#" onclick="volver()" class="btn btn-secondary ml-2">Volver</a>

        <h1 class="text-center mb-4">Detalles Película</h1>
        <div class="card">
            <div class="card-body">
                <p class="card-text"><strong>Titulo:</strong> <%= pel.getNombrePelicula() %></p>
                <p class="card-text"><strong>Categoria:</strong> <%=pel.getCategoria().getNombreCategoria() %></p>
                <img class="img-fluid" src="<%=pel.getPortada()%>" alt="portada">
            </div>
        </div>

        <h2 class="mt-4">Reseñas:</h2>
        <% if (reseñas.isEmpty()){ %>
            <p>No hay reseñas aún</p>
        <% } %>
        <ul class="list-group">
            <% for (Reseña reseña : reseñas) {
                Persona Autor = reseña.getAutor(); %>
            <li class="list-group-item">
                <p class="mb-1"><strong>Autor:</strong> <%= Autor.getNombre() %></p>
                <p class="mb-1"><strong>Fecha:</strong> <%= reseña.getFecha() %></p>
                <p class="mb-1"><strong>Descripción:</strong> <%= reseña.getDescripcion() %></p>
                <% if(p != null && p.getTipo().equals("Admin")){ %>
                    <form method="post" action="BorrarReseña" class="float-right">
                        <input type="hidden" name="codigo" value="<%=reseña.getCodigo()%>" >
                        <input type="hidden" name="idPelicula" value="<%=pel.getIdPelicula()%>" >
                        <button type="submit" class="btn btn-danger btn-sm">Borrar Reseña</button>
                    </form>
                <% } %>
            </li>
            <% } %>
        </ul>

        <% if(p == null){ %>
        <a href="login.html" class="btn btn-primary mt-4">Inicie sesión para comprar la entrada</a>
        <% } else { %>
        <% String url = "ListaFunciones?IdPelicula=" + pel.getIdPelicula(); %>
        <a href="<%=url%>" class="btn btn-primary mt-4">Comprar entrada</a>
        <% } %>

        <h1 class="mt-4">Realizar reseña</h1>
        <form action="PublicarReseña" method="Post">
            <input type="hidden" name="idPelicula" value="<%=pel.getIdPelicula() %>">
            <div class="form-group">
                <label for="descripcion">Descripción:</label>
                <textarea class="form-control" name="descripcion" id="descripcion" rows="4" required></textarea>
            </div>
            <input type="submit" class="btn btn-primary" value="Publicar Reseña">
        </form>

        <% } else { %>
        <p>No se encontró la película especificada</p>
        <% } %>
    </div>
</body>

<script>
	function volver(){
		window.location.href='BuscaCategorias'
	}
</script>
</html>

