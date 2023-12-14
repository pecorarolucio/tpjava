<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Sala"%>
<%LinkedList<Sala> salas = (LinkedList<Sala>) request.getAttribute("salas"); %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Editar Función</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <h2>Editar Función</h2>

        <form action="EditarFuncion" method="post">
            <div class="form-group">
                <label for="fecha">Fecha:</label>
                <input type="text" class="form-control" id="fecha" name="fecha" placeholder="YY-MM-DD" required>
            </div>

            <div class="form-group">
                <label for="horainicio">Hora Inicio:</label>
                <input type="text" class="form-control" id="horainicio" name="Hora_Inicio" placeholder="HH:MM:SS" required>
            </div>

            <div class="form-group">
                <label for="horafin">Hora Fin:</label>
                <input type="text" class="form-control" id="horafin" name="Hora_Fin" placeholder="HH:MM:SS" required>
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

            <button type="submit" class="btn btn-primary">Editar Función</button>
            <button type="button" class="btn btn-secondary" onclick="volver()">Volver</button>
        </form>
    </div>

    <script>
        function volver() {
            window.location.href = 'MenuFunciones';
        }
    </script>
</body>
</html>
