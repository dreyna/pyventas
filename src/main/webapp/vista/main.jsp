<%-- 
    Document   : main
    Created on : 1 ago. 2021, 13:43:21
    Author     : dreyna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
        <link href="recursos/faw/web-fonts-with-css/css/fontawesome-all.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="recursos/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="recursos/css/main.css"/>
    </head>
    <body>
        <div class="container">
            <h1>Bienvenido</h1>
            <!--<a href="logout">Salir</a>-->
            <a href="#" id="salir">Salir</a>
        </div>
        <script src="recursos/js/jquery.js"></script>
        <script src="recursos/js/bootstrap.min.js"></script>
        <script src="../recursos/js/main.js"></script>
        <script>
            (function () {
                $('#msbo').on('click', function () {
                    $('body').toggleClass('msb-x');
                });
            }());
           $("#salir").click(function(){
               sessionStorage.removeItem("usuario");
               $.get("logout", function(){
                   window.location = "http://localhost:9092/pyventas/login"; 
               });
               
           });
        </script>
    </body>
</html>
