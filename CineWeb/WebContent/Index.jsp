<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="entities.Persona"%>

<%
HttpSession se = request.getSession();
Persona p = (Persona) se.getAttribute("usuario");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" href="">
</head>
<body>
  <header>
    <!-- navegacion -->   
    <nav class="navbar navbar-expand-sm navbar-dark p-3 bg-dark fixed-top" data-bs-theme="dark">
      <a href="#" class="navbar-brand">LOGO CINE</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
        aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
        <ul class="navbar-nav">
          <li class="nav-item"><a href="#" class="nav-link active">Home</a></li>
          <% if (p != null && "Admin".equals(p.getTipo())){%>
          <li class="nav-item"><a href="#Reportreseña" class="nav-link">Reporte de reseñas</a></li>
          <li class="nav-item"><a href="MenuSala" class="nav-link">Salas</a></li>
          <li class="nav-item"><a href="Admin/menuAdmin.jsp" class="nav-link">Admin</a></li>
          <li class="nav-item"><a href="MenuPelicula" class="nav-link">Peliculas</a></li>
          <li class="nav-item"><a href="#FuncionCRUD" class="nav-link">Funciones</a></li>
          <%} else if (p!= null){%>
          <li class="nav-item"><a href="CancelarTickets.jsp" class="nav-link">Arrepentirse</a></li>
          <li class="nav-item"><a href="MisReseñas" class="nav-link">Mis reseñas</a></li>
          <%} %>
          <% if(p == null){ %>
          <li class="nav-item"><a href="BuscaCategorias" class="nav-link">Cartelera </a></li>
          <li class="nav-item"><a href="login.html" class="nav-link">Iniciar sesion</a></li>
          <%}else { %>
          <li class="nav-item"><a href="SignOut" class="nav-link">Cerrar Sesion</a></li>
          <%} %>
        </ul>
      </div>
    </nav>
  </header>
  
  <main class="bg-black">
    <div id="IDCarousel" class="carousel slide opacity-50" data-bs-ride="carousel" data-bs-theme="light">
      <div class="carousel-indicators">
        <button type="button" data-bs-target="#IDCarousel" data-bs-slide-to="0" class="active" aria-current="true"
          aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#IDCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#IDCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active vh-100" aria-hidden="true" role="listbox"
          style="background:url(image/c5.jpg); background-size: cover;">
          <!-- <img src="image/c5.jpg" class="img-fluid rounded-top" alt="pelicula 5"> -->
        </div>
        <div class="carousel-item vh-100" aria-hidden="true"
          style="background-image: url(image/c3.jpg); background-size: cover;">
          <!--  <img src="image/c3.jpg" class="img-fluid rounded-top" alt="pelicula 5"> -->
        </div>
        <div class="carousel-item vh-100" aria-hidden="true"
          style="background-image: url(image/c2.jpg); background-size: cover;">
          <!--   <img src="image/c2.jpg" class="img-fluid rounded-top" alt="pelicula 5"> -->
        </div>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#IDCarousel" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#IDCarousel" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
    <div>
      <div class="position-absolute top-50 start-50 translate-middle text-center text-light rounded p-2 px-5">
        <h1 style="text-shadow: 2px 2px 2px #000000">Busca tu pelicula</h1>
        <p class="fs-3" style="text-shadow: 2px 2px 2px #000000">Accede a las peliculas en cartelera </p>
        <p><a class="btn btn-lg btn-danger " href="BuscaCategorias">Cartelera</a></p>
      </div>
    </div>
  
  </main>
  <footer>

  </footer>

  <!-- bootstrap -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>