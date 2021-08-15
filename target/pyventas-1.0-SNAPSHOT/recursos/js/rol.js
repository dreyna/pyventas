$(document).ready(function () {

});
function listar() {
    alert("main");
    $.get("rc", function (data) {
        $("#datos").html(data);
    });
}


