<%@page import="entities.Persona"%>
<%@page import="entities.Pelicula"%>
<%@page import="entities.Rese�a" %>
<%@page import="java.util.LinkedList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%HttpSession se = request.getSession();
Persona p = (Persona) se.getAttribute("usuario"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles pelicula</title>
</head>
<body>
	<%
		Pelicula pel = (Pelicula) request.getAttribute("pelicula");
		LinkedList<Rese�a> rese�as = (LinkedList<Rese�a>) request.getAttribute("rese�as"); //No se si esto funciona, cuando se setea rese�as?
		if (pel != null){
	%>
	<h1>Detalles pelicula</h1>
	<p>Titulo: <%= pel.getNombrePelicula() %></p>
	<p>Categoria: <%=pel.getCategoria().getNombreCategoria() %></p>
	<p><%=pel.getPortada() %></p> <%--pel.getCategoria().getNombreCategoria() --%>
	
	<h2>Rese�as:</h2>
	<% if (rese�as.isEmpty()){ %>
	<p>No hay rese�as a�n</p>
	<% } %>
	<ul>
	<% for (Rese�a rese�a : rese�as) {
		Persona Autor = rese�a.getAutor(); %>
	<li><p><%= Autor.getNombre() %></p>
		<p><%= rese�a.getFecha() %></p>
		<p><%= rese�a.getDescripcion() %></p>
		<%if(p!= null && p.getTipo().equals("Admin")){ %>
			<form method="post" action="BorrarRese�a">
			<input type="hidden" name="idRese�a" value="<%=rese�a.getCodigo()%>" >
			<button type="submit"  value="Borrar Rese�a">Borrar</button>
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
	<h1>Realizar rese�a</h1>
	<form action="PublicarRese�a" method="Post">
		<input type="hidden" name="idPelicula" value="<%=pel.getIdPelicula() %>">
	     <label for="descripcion">Descripci�n:</label>
	     <textarea name="descripcion" id="descripcion" rows="4" cols="50"></textarea>
	     <input type="submit" value="Publicar Rese�a">
    </form>
	<%
	} else {
	%>
	<p>No se encontro la pelicula especificada</p>
	<% } %>
	

</body>
</html>