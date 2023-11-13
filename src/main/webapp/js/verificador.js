/**
 * 
 */
 function validarFormulario() {
        var nombre = document.getElementById("nombre").value;
        var correo = document.getElementById("correo").value;

        if (nombre === "" || correo === "") {
            alert("Completa todos los campos requeridos");
            return false; // Detener el envío del formulario
        }
        return true; // Permitir el envío del formulario
    }