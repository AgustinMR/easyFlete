function addNavbarTop() {
    "use strict";
    var navbar = document.getElementById("nav");
    if (document.body.scrollTop > 100 || document.documentElement.scrollTop > 100) {
        navbar.className = "w3-bar" + " w3-card-2" + " w3-animate-top" + " w3-white";
    } else {
        navbar.className = navbar.className.replace(" w3-card-2 w3-animate-top w3-white", "");
    }
}
window.onscroll = function () {
    "use strict";
    addNavbarTop();
};
function toggleFunction() {
    "use strict";
    var x = document.getElementById("navMobile");
    if (x.className.indexOf("w3-show") === -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}
function iniciarSesion(){
    $.post("http://localhost:10070/autenticar", "email=" + document.getElementById("email").value +"&pass=" + document.getElementById("pass").value  , function(result){
        alert(result);
    });
}

function registrarCliente(){
    $.post("http://localhost:10070/clientes", "nombre=" + document.getElementById("nombre").value + "email=" + document.getElementById("email").value +"&password=" + document.getElementById("pass").value +"&telefono=" + document.getElementById("telefono").value  , function(result){
        alert(result);
    });
}

function registrarFletero(){
    $.post("http://localhost:10070/feleteros", "nombre=" + document.getElementById("nombre").value + "email=" + document.getElementById("email").value +"&password=" + document.getElementById("pass").value +"&telefono=" + document.getElementById("telefono").value  , function(result){
        alert(result);
    });
}