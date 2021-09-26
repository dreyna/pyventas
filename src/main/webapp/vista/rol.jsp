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
            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo" style="margin-bottom: 20px"><i class="fa fa-plus" aria-hidden="true"></i></button>
            <table class="table" id="tablita">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID</th>
                        <th scope="col">ROL</th>
                        <th scope="col">ESTADO</th>
                        <th scope="col">FECHA</th>
                        <th scope="col"colspan="2">ACCIÓN</th>
                    </tr>
                </thead>
                <tbody>               
                </tbody>
            </table>
            <div class="container" id="datos">

            </div>
        </div>
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">New Rol</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Rol:</label>
                                <input type="text" class="form-control" id="rol_n">
                            </div> 
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Estado:</label>
                                <input type="text" class="form-control" id="estado">
                                <input type="hidden" id="idr" value="0">
                            </div> 
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="guardar()">Guardar</button>
                    </div>
                </div>
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
                        $("#tablita").append("<tr><td>" + (i + 1) + "</td><td>" + x[i].idrol + "</td><td>" + x[i].nomrol + "</td><td>" + x[i].estado + "</td><td>" + x[i].fecha + "</td><td><a href='#' onclick='editar(" + x[i].idrol + ")' class='text-warning'><i class='fa fa-pencil' aria-hidden='true'></i></a></td><td><a href='#' onclick='eliminar(" + x[i].idrol + ")' class='text-danger'><i class='fa fa-trash-o' aria-hidden='true'></i></a></td></tr>");
                    }
                });
            }
            function eliminar(id) {
                $.get("rc", {"opc": 4, "idr":id}, function (data) {
                    listar(); 
                });
            }
            function editar(id) {
                alert("Editar: " + id);
            }
            function guardar() {
                let idr = $("#idr").val();
                let rol = $("#rol_n").val();
                let est = $("#estado").val();
                $.post("rc", {"opc": 2, "rol": rol}, function (data) {
                    listar();                    
                });
                $("#exampleModal").modal("hide");
            }
        </script>
    </body>
</html>
