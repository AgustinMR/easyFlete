function iniciarSesion() {
    $.post("http://localhost:10070/autenticar", "email=" + document.getElementById("email").value + "&pass=" + document.getElementById("pass").value, function (result) {
        alert(result);
    });
}

function registrar() {
    if (document.getElementById("radio").checked === true) {
        $.post("http://localhost:10070/clientes", "nombre=" + document.getElementById("nombre").value + "&email=" + document.getElementById("email").value + "&password=" + document.getElementById("pass").value + "&telefono=" + document.getElementById("telefono").value, function (exito) {
            if (exito === true) {
                $('#exito').modal({
                    onHidden: function(){
                        $.post("login", "email="+document.getElementById("email").value+"&pass="+document.getElementById("pass").value, function(){
                            window.location = "/inicio";
                        });
                    }
                }).modal('show');
                
            } else {
                $('#error').modal('show');
            }
        });
    } else {
        $.post("http://localhost:10070/fleteros", "nombre=" + document.getElementById("nombre").value + "&email=" + document.getElementById("email").value + "&password=" + document.getElementById("pass").value + "&telefono=" + document.getElementById("telefono").value + "&tipoVehiculo=" + document.getElementById("tipoVehiculo").value + "&cargaVehiculo=" + document.getElementById("cargaVehiculo").value, function (exito) {
            alert(exito);
            if (exito === true) {
                $('#exito').modal({
                    onHidden: function(){
                        $.post("login", "email="+document.getElementById("email").value+"&pass="+document.getElementById("pass").value, function(){
                            window.location = "/inicio";
                        });
                    }
                }).modal('show');
            } else {
                $('#error').modal('show');
            }
        });
    }
}
function blurBackground() {
    "use strict";
    $("#backgr").animate({opacity: 0.80 }, 4000, function () {0
        $("#backgr").animate({opacity: 1.00 }, 3000, function () {
            blurBackground();
        });
    });
}
;
function blurBackground2() {
    "use strict";
    $("#backgr").animate({opacity: 0.40 }, 4000, function () {
        $("#backgr").animate({opacity: 1.00 }, 3000, function () {
            blurBackground2();
        });
    });
}
;