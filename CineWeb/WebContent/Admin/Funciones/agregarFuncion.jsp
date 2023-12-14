<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Sala"%>
<%LinkedList<Sala> salas = (LinkedList<Sala>) request.getAttribute("salas"); %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Agregar Función</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <h2>Agregar Función</h2>

        <form action="AgregarFuncion" method="post">
            <div class="form-group">
                <label for="fecha">Fecha:</label>
                <input type="text" class="form-control" id="fecha" name="fecha" placeholder="YYYY-MM-DD" required>
            </div>

            <div class="form-group">
                <label for="Hora_Inicio">Hora Inicio:</label>
                <input type="text" class="form-control" id="Hora_Inicio" name="Hora_Inicio" placeholder="HH:MM:SS" required>
            </div>

            <div class="form-group">
                <label for="Hora_Fin">Hora Fin:</label>
                <input type="text" class="form-control" id="Hora_Fin" name="Hora_Fin" placeholder="HH:MM:SS" required>
            </div>

            <div class="form-group">
                <label for="idSala">Sala:</label>
                <select class="form-control" id="idSala" name="idSala" required>
                    <!-- Iterar sobre las salas recuperadas y generar las opciones -->
                    <% for (Sala s: salas) { %>
                        <option value="<%=s.getIdSala() %>"><%=s.getIdSala() %></option>
                    <% } %>
                </select>
            </div>

            <input type="hidden" name="idPelicula" value="<%= request.getAttribute("idpeli") %>">
            
            <button type="submit" class="btn btn-primary">Agregar Función</button>
            
            <a href="#" onclick="volver()" class="btn btn-secondary ml-2">Volver</a>
        
        </form>
    </div>

    <script>
    function volver() {
        window.location.href = 'MenuFunciones';
    }
    </script>
</body>
</html>
