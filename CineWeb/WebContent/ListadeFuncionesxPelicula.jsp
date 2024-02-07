<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedList" %>
<%@ page import="entities.*" %>
<% LinkedList<Funcion> funciones = (LinkedList<Funcion>) request.getAttribute("funciones");%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Funciones Disponibles</title>
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }

        .container {
            margin-top: 20px;
        }

        .funcion-details {
            margin-bottom: 20px;
            border: 1px solid #dee2e6;
            padding: 15px;
            border-radius: 5px;
            background-color: #fff;
        }

        .btn-comprar {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <% if (funciones == null || funciones.isEmpty()) { %>
            <p>No hay funciones disponibles en este momento</p>
        <% } else {
            for (Funcion f : funciones) { %>
                <div class="funcion-details">
                    <h4 class="mb-3">Fecha: <%= f.getFechaFuncion() %></h4>
                    <p class="mb-3"><strong>Hora Inicio:</strong> <%= f.getHoraInicio() %></p>
                    <p class="mb-3"><strong>Hora Fin:</strong> <%= f.getHoraFin() %></p>
                    <p class="mb-3"><strong>Sala:</strong> <%= f.getSala().getIdSala() %></p>
                    <p class="mb-3"><strong>Capacidad Máxima:</strong> <%= f.getSala().getCapacidadMaxima() %></p>
                    <% String url = "ComprarEntrada?fecha=" + f.getFechaFuncion() + "&hora=" + f.getHoraInicio() +
                                    "&idSala=" + f.getSala().getIdSala(); %>
                    <a href="<%= url %>" class="btn btn-lg btn-primary btn-comprar">Comprar Boleto</a>
                </div>
            <% }
        } %>
    </div>
</body>
</html>
