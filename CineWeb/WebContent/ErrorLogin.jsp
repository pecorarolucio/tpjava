<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>logins</title>
  <!-- Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- CSS -->
  <link rel="stylesheet" href="css/login.css">
  <script src="js/verificador.js"></script>
</head>
<body>
  <!-- video fondo -->
  <video src="image/fondo.mp4" autoplay loop muted class="video-bg"></video>
  <!-- Login -->
  <div class="row justify-content-center align-items-center m-0 vh-100">
    <div class="col-10 col-sm-6 col-md-7 col-lg-6 col-xl-4 formulario text-center formulario p-5  ">
      <form method="post" action="Verificador">
        <div class="mb-3 form-group">
          <label for="" class="form-label">Email</label>
          <input type="email" class="form-control" name="Loginnombre" id="nombre" aria-describedby="emailHelpId" placeholder="abc@gmail.com">
          <small id="emailHelpId" class="form-text text-muted"></small>
        </div>
        <div class="mb-3 form-group">
          <label for="" class="form-label">Contraseņa</label>
          <input type="password" class="form-control" name="Contrasenia" id="correo" placeholder="password">
        </div>
        <div class="d-grid gap-2 form-group">
          <button type="submit" class="btn btn-primary">Login</button>
           <p class="--bs-danger-text-emphasis">Los datos ingresados son incorrectos</p>
        </div>
      </form>
    </div>
  </div>
  <!-- bootstrap -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</body>
</html>