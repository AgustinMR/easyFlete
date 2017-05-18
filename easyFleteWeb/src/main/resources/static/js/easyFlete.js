function iniciarSesion() {
    $.post("http://localhost:10070/autenticar", "email=" + document.getElementById("email").value + "&pass=" + document.getElementById("pass").value, function (result) {
        alert(result);
    });
}

function registrar() {
    if (document.getElementById("radio").checked === true) {
        $.post("http://localhost:10070/clientes", "nombre=" + document.getElementById("nombre").value + "&email=" + document.getElementById("email").value + "&password=" + document.getElementById("pass").value + "&telefono=" + document.getElementById("telefono").value, function (exito) {
            if (exito === true) {
                $('#exito').modal('show');
            } else {
                $('#error').modal('show');
            }
        });
    } else {
        $.post("http://localhost:10070/fleteros", "nombre=" + document.getElementById("nombre").value + "&email=" + document.getElementById("email").value + "&password=" + document.getElementById("pass").value + "&telefono=" + document.getElementById("telefono").value + "&tipoVehiculo=" + document.getElementById("tipoVehiculo").value + "&cargaVehiculo=" + document.getElementById("cargaVehiculo").value, function (exito) {
            alert(exito);
            if (exito === true) {
                $('#exito').modal('show');
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
window.onload = function () {
    "use strict";
    var raster = new ol.layer.Tile({source: new ol.source.OSM()});
    var source = new ol.source.Vector({wrapX: false});
    var vector = new ol.layer.Vector({source: source});
    var select = document.createElement("select");
    var option = document.createElement("option");
    option.innerHTML = "LineString";
    select.appendChild(option);
    select.id = "draw-type";
    var typeSelect = document.getElementById('draw-type');
    var map = new ol.Map({
        layers: [raster, vector],
        target: 'map',
        view: new ol.View({
            center: [-6252314.099176527, -4144802.9589933674], zoom: 12
                    //minZoom: 11,
                    //maxZoom: 17
        })
    });

    var features = new ol.Collection();
    var featureOverlay = new ol.layer.Vector({
        source: new ol.source.Vector({features: features}),
        style: new ol.style.Style({
            fill: new ol.style.Fill({
                color: 'rgba(255, 255, 255, 0.2)'
            }),
            stroke: new ol.style.Stroke({
                color: '#ffcc33',
                width: 2
            }),
            image: new ol.style.Circle({
                radius: 7,
                fill: new ol.style.Fill({
                    color: '#ffcc33'
                })
            })
        })
    });
    featureOverlay.setMap(map);

    var modify = new ol.interaction.Modify({
        features: features,
        // the SHIFT key must be pressed to delete vertices, so
        // that new vertices can be drawn at the same position
        // of existing vertices
        deleteCondition: function (event) {
            return ol.events.condition.shiftKeyOnly(event) &&
                    ol.events.condition.singleClick(event);
        }
    });
    map.addInteraction(modify);

    var draw; // global so we can remove it later
    function addInteraction() {
        draw = new ol.interaction.Draw({
            source: source,
            features: features,
            type: "Point"
        });
        map.addInteraction(draw);

        draw.on('drawend',
                function (evt) {
                    console.log(evt.feature);
                    var parser = new ol.format.GeoJSON();
                    var features = source.getFeatures();
                    var featuresGeoJSON = parser.writeFeatures(features);
                    alert(featuresGeoJSON);
                },
                this);
    }


    /**
     * Handle change event.
     */
    typeSelect.onchange = function () {
        map.removeInteraction(draw);
        addInteraction();
    };

    addInteraction();

    function toGeoJson() {
        var parser = new ol.format.GeoJSON();
        var features = source.getFeatures();
        var featuresGeoJSON = parser.writeFeatures(features);
        alert(featuresGeoJSON);

    }

};