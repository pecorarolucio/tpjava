<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.*" %>
<% LinkedList<Funcion> funciones = (LinkedList<Funcion>) request.getAttribute("funciones");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

	<%if(funciones == null) {%>
	<p>No hay funciones disponible en este momento</p>
	<%} else { for(Funcion f: funciones){ ;%>
		<h1>Fecha: </h1><span><%=f.getFechaFuncion() %></span>
		<h1>HoraInicio: </h1><span><%=f.getHoraInicio() %></span>
		<h1>HoraFin: </h1><span><%=f.getHoraFin() %></span>
		<h1>Sala: </h1><span><%=f.getSala().getIdSala() %></span>
		<h1>Capacidad Maxima: </h1><span><%=f.getSala().getCapacidadMaxima() %></span>
		<%String url= "#"; %>
		<a href="<%=url%>>" class="btn btn-lg btn-danger " >Comprar Boleto</a>
	<%} } %>
</body>
</html>