<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Sala"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar funcion</title>
</head>
<body>
<%LinkedList<Sala> salas = (LinkedList<Sala>) request.getAttribute("salas"); %>
<h2>Editar Funcion</h2>

    <form action="EditarFuncion" method="post">
        <label for="fecha">Fecha:</label>
        <input type="text" id="fecha" name="fecha" placeholder="YY-MM-DD" required>
        <br>

        <label for="horainicio">Hora_Inicio:</label>
        <input type="text" id="horainicio" name="Hora_Inicio" placeholder="HH:MM:SS" required>
        <br>
		
		<label for="horafin">Hora_Fin:</label>
        <input type="text" id="horafin" name="Hora_Fin" placeholder="HH:MM:SS" required>
        <br>
		
        <label for="idSala">Sala:</label>
        <select id="idSala" name="idSala" required>
            <% for (Sala s: salas) { %>
                <option value="<%=s.getIdSala() %>"> <%=s.getIdSala() %> </option>
            <% } %>
        </select>
        <br>
		
        <input type="submit" value="Editar Funcion">
        
        <button type="button" onclick="volver()">Volver</button>
    </form>
</body>
</html>

<script>
        function volver() {
            window.location.href = 'MostrarFunciones';
        }
    </script>