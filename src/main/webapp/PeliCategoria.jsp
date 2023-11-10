<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Categoria" %>
<%@ page import="logic.*" %>
<%@ page import="java.util.LinkedList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><% CategoriaABMC categoriaABMC = new CategoriaABMC();
LinkedList<entities.Categoria> listaCategoria = categoriaABMC.getAll(); %>
<ul>
        <% for (entities.Categoria Cat : listaCategoria) { ;%>
    	<li> <%= Cat.getNombreCategoria() %></li>
		<% } %>


    </ul>
</body>
</html>