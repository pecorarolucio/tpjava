<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entities.Sala"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%LinkedList<Sala> salas = (LinkedList<Sala>) request.getAttribute("salas"); %>
<h2>Agregar Funcion</h2>

    <form action="AgregarFuncion" method="post">
        <label for="fecha">Fecha:</label>
        <input type="text" id="fecha" name="fecha" placeholder="YYYY-MM-DD" required>
        <br>

        <label for="Hora_Inicio">Hora_Inicio:</label>
        <input type="text" id="Hora_Inicio" name="Hora_Inicio" placeholder="HH:MM:SS" required>
        <br>
		
		<label for="Hora_Fin">Hora_Fin:</label>
        <input type="text" id="Hora_Fin" name="Hora_Fin" placeholder="HH:MM:SS" required>
        <br>
		
        <label for="idSala">Sala:</label>
        <select id="idSala" name="idSala" required>
            <!-- Iterar sobre las categorías recuperadas y generar las opciones -->
            <% for (Sala s: salas) { %>
                <option value="<%=s.getIdSala() %>"> <%=s.getIdSala() %> </option>
            <% } %>
        </select>
        <br>
        
		<input type="hidden" name="idPelicula" value="<%= request.getAttribute("idpeli") %>" >
		 <br>
        <input type="submit" value="Agregar Funcion">
    </form>
</body>
</html>