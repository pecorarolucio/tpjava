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
        <label for="nombre">Fecha:</label>
        <input type="text" id="nombre" name="fecha" placeholder="YY/MM/DD" required>
        <br>

        <label for="portada">Hora_Inicio:</label>
        <input type="text" id="portada" name="Hora_Inicio" placeholder="HH/MM/SS" required>
        <br>
		
		<label for="portada">Hora_Fin:</label>
        <input type="text" id="portada" name="Hora_Fin" placeholder="HH/MM/SS" required>
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
		
        <input type="submit" value="Agregar Película">
    </form>
</body>
</html>