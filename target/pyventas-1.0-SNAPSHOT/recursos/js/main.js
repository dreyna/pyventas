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