$('#btnEnviar2').click(function validar1() {
    var miCampoTexto = document.getElementById("Nombre1", "Nombre2", "Nombre3", "Direccion1").value;
    var miCampoTexto2 = document.getElementById("Email1").value;
    if (miCampoTexto.length == 0 || miCampoTexto2.length == 0) {
        alert("No tiene informacion en los nombres o Gmail")
        return false;
    } else {
        alert("Mensaje fue enviado")
        return true;
    }
});
$('#btnEnviar').click(function validar2() {
    var miCampoTexto = document.getElementById("mensaje", "nombre", "asunto", ).value;
    var miCampoTexto2 = document.getElementById("email").value;
    if (miCampoTexto.length == 0 || miCampoTexto2.length == 0) {
        alert("No tiene informacion en nombres o Gmail")
        return false;
    } else {
        alert("Mensaje fue enviado")
        return true;
    }
});
$('#btnEnviar3').click(function validar3() {
    var miCampoTexto = document.getElementById("Email2").value;
    if (miCampoTexto.length == 0) {
        alert("No tiene informacion Gmail, tiene que poner @")
        return false;
    } else {
        alert("Mensaje fue enviado")
        return true;
    }
});