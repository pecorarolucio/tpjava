<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Categoria" %>
<%@ page import="logic.*" %>
<%@ page import="java.util.LinkedList" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Categorías</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="d-flex justify-content-start align-items-center mb-3">
        <a href="#" onclick="volver()" class="btn btn-secondary btn-sm me-3">Volver</a>
        <h1 class="mb-0">Listado de Categorías</h1>
    </div>

    <% LinkedList<Categoria> categorias = (LinkedList<Categoria>) request.getAttribute("Categorias");
       if (!categorias.isEmpty() && categorias.size() > 0) { %>
        <div class="row row-cols-1 row-cols-md-2 g-4">
            <% for (Categoria cat : categorias) { %>
                <div class="col">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title"><%= cat.getNombreCategoria() %></h5>
                            <% String url = "BuscaPelixCat?idcategoria=" + cat.getIdCategoria(); %>
                            <a href="<%=url%>" class="btn btn-primary">Elegir</a>
                        </div>
                    </div>
                </div>
            <% } %>
        </div>
    <% }
    else { %>
        <h1 class="text-center">No hay categorías ahora mismo</h1>
    <% } %>
</div>

</body>

<script>
	function volver(){
		window.location.href='Index.jsp'
	}
</script>
</html>
