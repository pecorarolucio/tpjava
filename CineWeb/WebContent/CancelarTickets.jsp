<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Entrada" %>
<%@ page import="entities.Persona" %>
<%@ page import="logic.EntradaABMC" %>
<%@ page import="logic.PersonaABMC" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ver Entradas Compradas</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <%
		Persona p = new Persona();
		p = (Persona) session.getAttribute("usuario");
		EntradaABMC miE = new EntradaABMC();
		if (p != null) {
   
    	LinkedList<Entrada> entradasCompradas = miE.findFromUser(p.getId());

    	if (!entradasCompradas.isEmpty()) {
		%>

           
		<a href="#" onclick="volver()" class="btn btn-secondary ml-2">Volver</a>
       
        <h1 class="text-center mb-4">Entradas compradas por: <%=p.getNombre() %></h1>
        
        <h2 class="mt-4">Entradas:</h2>
        <ul class="list-group">
            <% for (Entrada entradaComprada : entradasCompradas) { %>
            <li class="list-group-item">
            	<p class="mb-1"><strong>Pelicula:</strong> <%=entradaComprada.getFuncion().getPelicula().getNombrePelicula() %>
                <p class="mb-1"><strong>Precio:</strong> <%= entradaComprada.getPrecio() %></p>
                <p class="mb-1"><strong>Funcion:</strong> <%= entradaComprada.getFuncion().getFechaFuncion() %></p>
                    <form method="post" action="CancelarTickets" class="float-right">
                        <input type="hidden" name="entradaId" value="<%=entradaComprada.getCodEntrada()%>" >
                        <button type="submit" class="btn btn-danger btn-sm">Borrar Entrada</button>
                    </form>
            </li>
            <%} %>
            <%} else { %>
            <p> No has comprado ninguna entrada. </p>
            <%} %>
            <%} %>
        </ul>
    </div>
   	
</body>
<script>
function volver(){
	window.location.href='Index.jsp'
}
</script>
</html>