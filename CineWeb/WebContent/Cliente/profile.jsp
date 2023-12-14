<%@page import="entities.Persona"%>
<%@page import="entities.Reseña"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%LinkedList<Reseña> reseñas = (LinkedList<Reseña>) request.getAttribute("reseñas"); 
  Persona user = (Persona) request.getSession().getAttribute("usuario");%>
<head>
    <meta charset="UTF-8">
    <title>Mi perfil</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand">Mi perfil </a>
			</div>
		</nav>
	</header>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6">
            <h3>Mis datos</h3>
            <p><strong>Nombre:</strong> <%=user.getNombre() %></p>
            <p><strong>Apellido:</strong> <%=user.getApellido() %></p>
            <p><strong>Mail:</strong> <%=user.getMail() %></p>
            <a href="editProfile.jsp" class="btn btn-primary mb-3">Editar</a>

            <h3>Reseñas</h3>
            <% for (Reseña r : reseñas){ %>
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">Pelicula: <%=r.getPelicula().getNombrePelicula() %></h5>
                        <p class="card-text"><strong>Fecha:</strong> <%=r.getFecha() %></p>
                        <p class="card-text"><%=r.getDescripcion() %></p>
                        <button class="btn btn-danger">Borrar</button>
                    </div>
                </div>
            <% } %>
        </div>
    </div>
    <a href="../Index.jsp" class="btn btn-dark">Volver</a>
</div>
</body>
</html>