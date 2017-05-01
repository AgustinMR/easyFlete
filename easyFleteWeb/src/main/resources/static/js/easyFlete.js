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
function iniciarSesion() {
    $.post("http://localhost:10070/autenticar", "email=" + document.getElementById("email").value + "&pass=" + document.getElementById("pass").value, function (result) {
        alert(result);
    });
}

function registrar() {
    if (document.getElementById("radio").checked === true) {
        $.post("http://localhost:10070/clientes", "nombre=" + document.getElementById("nombre").value + "&email=" + document.getElementById("email").value + "&password=" + document.getElementById("pass").value + "&telefono=" + document.getElementById("telefono").value, function (result) {
            alert(result);
        });
    } else {
        $.post("http://localhost:10070/fleteros", "nombre=" + document.getElementById("nombre").value + "&email=" + document.getElementById("email").value + "&password=" + document.getElementById("pass").value + "&telefono=" + document.getElementById("telefono").value + "&vehiculo_nombre=" + document.getElementById("tipoVehiculo").value + "&vehiculo_carga=" + document.getElementById("cargaVehiculo").value, function (result) {
            alert(result);
        });
    }

}
window.onload = function(){
	"use strict";
	var raster = new ol.layer.Tile({ source: new ol.source.OSM() });
	var source = new ol.source.Vector({wrapX: false});
	var vector = new ol.layer.Vector({ source: source  });
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
        deleteCondition: function(event) {
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
          type: typeSelect.value
        });
        map.addInteraction(draw);

        draw.on('drawend',
          function(evt) {
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
      typeSelect.onchange = function() {
        map.removeInteraction(draw);
        addInteraction();
      };

      //addInteraction();
			
			function toGeoJson(){
				var parser = new ol.format.GeoJSON();
            var features = source.getFeatures();
            var featuresGeoJSON = parser.writeFeatures(features);
            alert(featuresGeoJSON);
				
			}
			
};