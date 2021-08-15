<%-- 
    Document   : index
    Created on : 1 ago. 2021, 13:41:00
    Author     : dreyna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Expires" content="0" /> 
        <meta http-equiv="Pragma" content="no-cache" />
        <title>Login</title>
        <link href="recursos/faw/web-fonts-with-css/css/fontawesome-all.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="recursos/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="recursos/css/login.css"/>
         <script>
            function deshabilitaRetroceso() {
                window.location.hash = "no-back-button";
                window.location.hash = "Again-No-back-button"; //chrome
                window.onhashchange = function () {
                    window.location.hash = "no-back-button";
                };
            }
        </script>
    </head>
    <body onload="deshabilitaRetroceso() ">
        <div class="modal-dialog text-center">
            <div class="col-sm-8 main-section">
                <div class="modal-content">
                    <div class="col-12 user-img">
                        <img src="recursos/img/user2.png" />
                    </div>
                    <form class="col-12 max" >
                        <div class="form-group">
                            <input  type="text" class="form-control" placeholder="Usuario" id="username"/>
                        </div>
                        <div class="form-group">
                            <input  type="password" class="form-control" placeholder="Password" id="password"/>
                        </div>
                        <button type="submit" class="btn btn-primary" id="login"><i class="fa fa-sign-in-alt"></i>  Enviar</button>
                    </form>
                </div>
            </div>
        </div>
        <script src="recursos/js/jquery.js"></script>
        <script src="recursos/js/bootstrap.min.js"></script>
        <script src="recursos/js/login.js"></script>
       
    </body>
</html>
