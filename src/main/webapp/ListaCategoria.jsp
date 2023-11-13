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
<% CategoriaABMC categoriaABMC = new CategoriaABMC();
LinkedList<entities.Categoria> listaCategoria = categoriaABMC.getAll(); %>

<div class="row col-md-6">
	<% for (entities.Categoria Cat : listaCategoria) { ;%>
  <div class="col-sm-12">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title"><%= Cat.getNombreCategoria() %></h5>
        <%
        int parametro = Cat.getIdCategoria();
        String url = "BuscaPelixCat?nombreVariable=" + parametro;
   		 %>
        <a href="<%=url%>" class="btn btn-primary">Elegir</a>
      </div>
    </div>
  </div>
  <% } %>
  
</div>

</body>
</html>