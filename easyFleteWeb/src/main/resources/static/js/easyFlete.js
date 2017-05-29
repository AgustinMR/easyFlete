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
                    onHidden: function () {
                        $.post("login", "email=" + document.getElementById("email").value + "&pass=" + document.getElementById("pass").value, function () {
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
            if (exito === true) {
                $('#exito').modal({
                    onHidden: function () {
                        $.post("login", "email=" + document.getElementById("email").value + "&pass=" + document.getElementById("pass").value, function () {
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
function getSolicitudesByCliente(email) {
    $.get("http://localhost:10070/clientes/solicitudes", "email=" + email, function (response) {
        $.each(response, function (index, x) {
            var solicitud = JSON.parse(JSON.stringify(x));
            var item = document.createElement("div");
            item.className = "item";

            var content = document.createElement("div");
            content.style.backgroundColor = "#FBFBFB";
            content.className = "content";
            
            var row1 = document.createElement("div");
            row1.className = "row w3-light-grey";
            
            var div = document.createElement("div");
            div.className = "w3-padding";
            div.style.height = "32px";
            var h3 = document.createElement("h3");
            h3.className = "ui header text w3-text-easyFlete-orange w3-left";
            h3.innerHTML = solicitud.titulo;
            var select = document.createElement("select");
            select.className = "ui dropdown w3-right";
            select.style.height = "25px";
            var option1 = document.createElement("option");
            option1.value = "Nuevo";
            option1.innerHTML = "Nuevo";
            var option2 = document.createElement("option");
            option2.value = "Cancelado";
            option2.innerHTML = "Cancelado";
            var option3 = document.createElement("option");
            option3.value = "Confirmado";
            option3.innerHTML = "Confirmado";
            var option4 = document.createElement("option");
            option4.value = "Terminado";
            option4.innerHTML = "Terminado";
            select.appendChild(option1);
            select.appendChild(option2);
            select.appendChild(option3);
            select.appendChild(option4);
            select.value = solicitud.estado;
            div.appendChild(h3);
            div.appendChild(select);
            row1.appendChild(div);
            content.appendChild(row1);
            
            var row2 = document.createElement("div");
            row2.className = "meta w3-row";
            var span1 = document.createElement("span");
            span1.className = "w3-margin-left";
            var strong1 = document.createElement("strong");
            strong1.innerHTML = solicitud.precio;
            span1.appendChild(strong1);
            var span2 = document.createElement("span");
            span2.className = "w3-margin-left";
            var strong2 = document.createElement("strong");
            strong2.innerHTML = solicitud.fecha;
            span2.appendChild(strong2);
            var div2 = document.createElement("div");
            div2.className = "ui star rating w3-margin-left";
            div2.dataRating = solicitud.valoracion;
            div2.dataMaxRating = 5;
            row2.appendChild(span1);
            row2.appendChild(span2);
            row2.appendChild(div2);
            content.appendChild(row2);
            var div3 = document.createElement("div");
            div3.className = "description";
            var p = document.createElement("p");
            p.className = "w3-margin";
            p.innerHTML = solicitud.descripcion;
            div3.appendChild(p);
            content.appendChild(div3);
            item.appendChild(content);
            document.getElementById("items").apendChild(item);
        });
    });
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
