function iniciarSesion() { 
    $.post("http://localhost:10070/autenticar", "email=" + document.getElementById("email").value + "&pass=" + document.getElementById("pass").value, function (result) {
        alert(result);
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
