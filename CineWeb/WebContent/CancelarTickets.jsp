<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.Entrada" %>
<%@ page import="entities.Persona" %>
<%@ page import="logic.EntradaABMC" %>
<%@ page import="logic.PersonaABMC" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ver Entradas Compradas</title>
</head>
<body>

<%
Persona p = new Persona();
p = (Persona) session.getAttribute("usuario");
EntradaABMC miE = new EntradaABMC();
if (p != null) {
   
    LinkedList<Entrada> entradasCompradas = miE.findFromUser(p.getId());

    if (!entradasCompradas.isEmpty()) {
%>

        <h1>Entradas Compradas por <%= p.getNombre() %></h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID de Entrada</th>
                    <th>Fecha de funcion</th>
                  	<th>Precio de Entrada</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% for (Entrada entrada : entradasCompradas) { %>
                    <tr>
                        <td><%= entrada.getCodEntrada() %></td>
                        <td><%= entrada.getFuncion().getFechaFuncion()%></td>
                		<td><%= entrada.getPrecio() %></td>
                        <td>
                            <form action="CancelarTickets" method="post">
                                <input type="hidden" name="entradaId" value="<%= entrada.getCodEntrada() %>">
                                <button type="submit">Cancelar</button>
                            </form>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>

<%
    } else {
%>

        <p>No has comprado ninguna entrada.</p>

<%
    }
} else {
%>

    <p>Debes iniciar sesión para ver tus entradas.</p>

<%
}
%>

</body>
</html>
