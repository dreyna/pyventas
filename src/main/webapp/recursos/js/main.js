$(document).ready(function () {
    menu();
});
function  menu() {
    let ad = $("#rol").val().trim();
    var p;
    if (ad === "ADMINISTRADOR") {
        p = "" +
                "<a class='list-group-item list-group-item-action list-group-item-light p-3' href='#!'>Dashboard</a>" +
                "<a class='list-group-item list-group-item-action list-group-item-light p-3' href='mc?op=1'>Ventas</a>" +
                "<a class='list-group-item list-group-item-action list-group-item-light p-3' href='mc?op=2'>Rol</a>" +
                "<a class='list-group-item list-group-item-action list-group-item-light p-3' href='mc?op=3'>Clientes</a>";
    }
    if (ad === "VENDEDOR") {
        p = "" +
                "<a class='list-group-item list-group-item-action list-group-item-light p-3' href='#!'>Dashboard</a>" +
                "<a class='list-group-item list-group-item-action list-group-item-light p-3' href='#!'>Ventas</a>";
    }
    $("#menu").append(p);
}
function rol() {
    //$("#contenido").load("vista/rol.jsp");
    var datos = '';
    $.get("rc", {"opc": 1}, function (data) {
        var roles = JSON.parse(data);
        var lista="";
        for(var i=0;i<roles.length;i++){
            lista = "<tr><td>"+(i+1)+"</td><td>"+roles[i].idrol+"</td><td>"+roles[i].nomrol+"</td><td><a href=#''>Editar</a>&nbsp;<a href=#''>Eliminar</a></td></tr>";
            $("#tablita").append(lista);
        }

    });
}
function opciones(n){    
    $.get("mc?op=1");
}

