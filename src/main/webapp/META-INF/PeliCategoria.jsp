<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import=""%>
<%@ page import="entities.Categoria" %>
<%@ page import="logic.CategoriaABMC" %>
<%@ page import="java.util.LinkedList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% CategoriaABMC c = new CategoriaABMC(); %>
<% LinkedList<Categoria> listaCategoria = new LinkedList<>(c.getAll()); %>
<ul>
        <% for (Categoria Cat : listaCategoria) { %>
    	<li><%= Cat.getNombreCategoria() %></li>
		<% } %>

    </ul>
</body>
</html>