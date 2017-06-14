function iniciarSesion() { 
    $.post("http://localhost:10070/autenticar", "email=" + document.getElementById("email").value + "&pass=" + document.getElementById("pass").value, function (result) {
        alert(result);
    });
}

function registrar() {
    if(document.getElementById("pass").value === "" || document.getElementById("email").value === "" || document.getElementById("nombre").value === "" || document.getElementById("telefono").value === ""){
        $('#error').modal('show');
    }
    else if (document.getElementById("radio").checked === true) {
        var hash = md5(document.getElementById("pass").value);
        $.post("http://localhost:10070/clientes","nombre="+ document.getElementById("nombre").value + "&email=" + document.getElementById("email").value + "&password=" + String(hash) + "&telefono=" + document.getElementById("telefono").value, function (exito) {
            if (exito === true) {
                $('#exito').modal({
                    onHidden: function () {
                        $.post("login", "email=" + document.getElementById("email").value + "&pass=" + String(hash), function () {
                            window.location = "/inicio";
                        });
                    }
                }).modal('show');

            } else {
                $('#error').modal('show');
            }
        });
        } else {
        var hash = md5(document.getElementById("pass").value);
        $.post("http://localhost:10070/fleteros", "nombre=" + document.getElementById("nombre").value + "&email=" + document.getElementById("email").value + "&password=" + String(hash) + "&telefono=" + document.getElementById("telefono").value + "&tipoVehiculo=" + document.getElementById("tipoVehiculo").value + "&cargaVehiculo=" + document.getElementById("cargaVehiculo").value, function (exito) {
            if (exito === true) {
                $('#exito').modal({
                    onHidden: function () {
                        $.post("login", "email=" + document.getElementById("email").value + "&pass=" + String(hash), function () {
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
    $("#backgr").animate({opacity: 0.80}, 4000, function () {
        $("#backgr").animate({opacity: 1.00}, 3000, function () {
            blurBackground();
        });
    });
}
;
function blurBackground2() {
    "use strict";
    $("#backgr").animate({opacity: 0.40}, 4000, function () {
        $("#backgr").animate({opacity: 1.00}, 3000, function () {
            blurBackground2();
        });
    });
}
;
function mostrarStep1() {
    document.getElementById("step1").style.display = "block";
    document.getElementById("step2").style.display = "none";
    document.getElementById("step3").style.display = "none";
    document.getElementById("step4").style.display = "none";
    document.getElementById("s1").className = "active step";
    document.getElementById("s2").className = "link step";
    document.getElementById("s3").className = "link step";
    document.getElementById("s4").className = "link step";
}

function mostrarStep2() {
    document.getElementById("step1").style.display = "none";
    document.getElementById("step2").style.display = "block";
    document.getElementById("step3").style.display = "none";
    document.getElementById("step4").style.display = "none";
    document.getElementById("s2").className = "active step";
    document.getElementById("s1").className = "link step";
    document.getElementById("s3").className = "link step";
    document.getElementById("s4").className = "link step";
}

function mostrarStep3() {
    document.getElementById("step1").style.display = "none";
    document.getElementById("step2").style.display = "none";
    document.getElementById("step3").style.display = "block";
    document.getElementById("step4").style.display = "none";
    document.getElementById("s3").className = "active step";
    document.getElementById("s2").className = "link step";
    document.getElementById("s1").className = "link step";
    document.getElementById("s4").className = "link step";
}

function mostrarStep4() {
    document.getElementById("step1").style.display = "none";
    document.getElementById("step2").style.display = "none";
    document.getElementById("step3").style.display = "none";
    document.getElementById("step4").style.display = "block";
    document.getElementById("s4").className = "active step";
    document.getElementById("s2").className = "link step";
    document.getElementById("s3").className = "link step";
    document.getElementById("s1").className = "link step";
}
