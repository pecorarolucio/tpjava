<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Categoria" %>
<%@ page import="logic.*" %>
<%@ page import="java.util.LinkedList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

<div class="row col-md-6">
	<%	LinkedList<Categoria> categoria = (LinkedList<Categoria>) request.getAttribute("Categorias");
		if  (!categoria.isEmpty() && categoria.size() >0) {%>
	
	<% for (Categoria Cat : categoria ) { ;%>
  <div class="col-sm-12">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title"><%= Cat.getNombreCategoria() %></h5>
        <%
        String url = "BuscaPelixCat?nombreVariable=" + Cat.getIdCategoria();
   		 %>
        <a href="<%=url%>" class="btn btn-primary">Elegir</a>
      </div>
    </div>
  </div>
  <% } } 
	else { %>
	<h1>No hay categorias ahora mismo</h1>
	<%} %>  
</div>

</body>
</html>