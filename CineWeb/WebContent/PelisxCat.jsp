<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Pelicula" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Listado de Películas</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }

        .movie-container {
            margin-bottom: 20px;
        }

        .movie-title {
            font-size: 24px;
            margin-bottom: 10px;
        }

        .movie-image {
            max-width: 100%;
            height: auto;
            margin-bottom: 20px;
        }

        .view-functions {
            display: block;
            margin-bottom: 20px;
        }

        .no-movies {
            font-size: 18px;
            font-weight: bold;
            margin-top: 20px;
        }

        .back-button {
            position: absolute;
            top: 10px;
            left: 21%;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <% LinkedList<Pelicula> peliculas = (LinkedList<Pelicula>) request.getAttribute("peliculas");
           if (!peliculas.isEmpty() && peliculas.size() > 0) {
               for (Pelicula pel : peliculas) { %>
                <div class="movie-container">
                    <h1 class="movie-title"><%= pel.getNombrePelicula() %></h1>
                    <img class="movie-image" src="<%=pel.getPortada()%>" alt="portada">
                    <form action="DetallePelicula" method="get">
                        <input type="hidden" name="id" value="<%=pel.getIdPelicula() %>">
                        <button type="submit" class="btn btn-primary view-functions">Ver funciones</button>
                    </form>
                </div>
            <% }
           } else { %>
            <p class="no-movies">No hay películas disponibles</p>
        <% } %>
        <a href="#" class="btn btn-secondary back-button" onclick="volver()">Volver</a>
        </div>

</body>
<script>
function volver(){
	window.location.href='BuscaCategorias'
}
</script>

</html>


