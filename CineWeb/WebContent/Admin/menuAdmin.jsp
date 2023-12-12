<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Admin</title>
</head>
<body>
  <a href="<%=request.getContextPath()%>/Admin/Peliculas/MenuPelicula">
        <button type="button">Peliculas</button>
    </a>

    <!-- Botón Salas -->
    <a href="<%=request.getContextPath()%>/Admin/Salas/MenuSala">
        <button type="button">Salas</button>
    </a>

    <!-- Botón Funciones -->
    <a href="<%=request.getContextPath()%>/Admin/MenuFuncione">
        <button type="button">Funciones</button>
    </a>

</body>
</html>