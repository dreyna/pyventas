$(document).ready(function () {

});
$("#login").click(function (event) {
    event.preventDefault();
    if (!$("#username").val().length < 1 && !$("#password").val().length < 1) {
        $.ajax({
            "method": "POST",
            url: "lc",
            data: {username: $("#username").val(), password: $("#password").val()}
        }).done(function (data) {
            const x = JSON.parse(data);
            if(jQuery.isEmptyObject(x)){
                window.location = "http://localhost:9092/pyventas/login";      
            }else{
                sessionStorage.setItem("usuario",x.usuario);
                window.location = "http://localhost:9092/pyventas/bienvenido";
            }
        });
    } else {
        alert("Faltan Datos...!");
    }

});


