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
	<%String estado =(String) request.getAttribute("resultado");
		if (estado != null){%>
			<%if(estado == "exito"){ %>
			<div class="container mt-4">
				<!-- Aquí se muestra la notificación -->
    			<div class="alert alert-success alert-dismissible fade show" role="alert">
    			EXITOS EXITOS EXITOS.
     			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
      			<span aria-hidden="true">&times;</span>
      			</button>
    			</div>
 			 </div>
			<%}else{ %>
			<div class="container mt-4">
				<!-- Aquí se muestra la notificación -->
    			<div class="alert alert-success alert-dismissible fade show" role="alert">
    			FALLOS FALLOS FALLOS.
     			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
      			<span aria-hidden="true">&times;</span>
      			</button>
    			</div>
 			 </div>
			<%} %>
		<%} %>


	<%if(funciones == null) {%>
	<p>No hay funciones disponible en este momento</p>
	<%} else { 
		for(Funcion f: funciones) { %>
		<h1>Fecha: </h1><span><%=f.getFechaFuncion() %></span>
		<h1>HoraInicio: </h1><span><%=f.getHoraInicio() %></span>
		<h1>HoraFin: </h1><span><%=f.getHoraFin() %></span>
		<h1>Sala: </h1><span><%=f.getSala().getIdSala() %></span>
		<h1>Capacidad Maxima: </h1><span><%=f.getSala().getCapacidadMaxima() %></span>
		<%String url= "ComprarEntrada?fecha="+f.getFechaFuncion()+"&hora="+f.getHoraInicio()+"&idSala="+f.getSala().getIdSala(); %>
		<a href="<%=url%>" class="btn btn-lg btn-danger " >Comprar Boleto</a>
	<% } 
	} %>
</body>
</html>