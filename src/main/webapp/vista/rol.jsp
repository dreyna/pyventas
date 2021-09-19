<%-- 
    Document   : prueba
    Created on : 19 set. 2021, 09:31:49
    Author     : BReyna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../WEB-INF/templates/header.jspf" %>
    </head>
    <body>
        <%@include file="../WEB-INF/templates/headerMain.jspf" %>        
        <div class="container" style="max-width: 600px; margin-top: 40px">
            <a href="#" onclick="guardar()" class="btn btn-success"><i class="fa fa-plus" aria-hidden="true"></i></a>
            <table class="table" id="tablita">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID</th>
                        <th scope="col">ROL</th>
                        <th scope="col">ESTADO</th>
                        <th scope="col">FECHA</th>
                        <th scope="col">ACCIÓN</th>
                    </tr>
                </thead>
                <tbody>               
                </tbody>
            </table>
            <div class="container" id="datos">

            </div>
        </div>
        <%@include file="../WEB-INF/templates/footer.jspf" %>
        <script>
            $(document).ready(function () {
                listar();
            });
            function listar() {
                $.get("rc", {"opc": 1}, function (data) {
                    var x = JSON.parse(data);
                    $("#tablita tbody tr").remove();
                    for (var i = 0; i < x.length; i++) {
                        $("#tablita").append("<tr><td>" + (i + 1) + "</td><td>" + x[i].idrol + "</td><td>" + x[i].nomrol + "</td><td>" + x[i].estado + "</td><td>" + x[i].fecha + "</td><td><a href='#' onclick='editar(" + x[i].idrol + ")'><i class='fa fa-pencil' aria-hidden='true'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idrol + ")'><i class='fa fa-trash-o' aria-hidden='true'></i></a></td></tr>");
                    }
                });
            }
            function eliminar(id){alert("Eliminar: "+id);}
            function editar(id){alert("Editar: "+id);}
            function guardar(id){alert("Guardar");}
        </script>
    </body>
</html>
