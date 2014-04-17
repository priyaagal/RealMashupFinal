
function loadMap2(address) {

	var lat = 37.37172
	var lon = -122.03801

	var usCenterPoint = new GLatLng(lat, lon)
	var usZoom = 14
	if (GBrowserIsCompatible()) {
		var map = new GMap2(document.getElementById("map-canvas"))
		map.setCenter(usCenterPoint, usZoom)
		map.addControl(new GLargeMapControl())
		map.addControl(new GMapTypeControl())

		var marker = new GMarker(new GLatLng(lat, lon), {
			title : address
		})
		marker.bindInfoWindowHtml(address)
		map.addOverlay(marker)
	}
}

// Reference
// https://developers.google.com/maps/documentation/javascript/geocoding

//global variables
var geocoder;
var map;
var propertiesData;

function initialize() {
	geocoder = new google.maps.Geocoder();
	// var latlng = new google.maps.LatLng(-34.397, 150.644);
	var mapOptions = {
		zoom : 12,
		// center: latlng,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	}

	map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

}

function geoCodeAddress(query) {

	geocoder.geocode({
		'address' : query
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			map.setCenter(results[0].geometry.location);
			var marker = new google.maps.Marker({
				map : map,
				position : results[0].geometry.location
			});

		} else {
			alert('Geocode was not successful for the following reason: '
					+ status);
		}
	});
}

function listAllProperties(query, properties) {
	
	geoCodeAddress(query);
	
	//mark other properties
	propertyMarkers(properties);
}

function propertyMarkers(properties) {
	if (geocoder && map && properties) {
		var properties = properties.documentElement
				.getElementsByTagName('masterUnSoldProperty');
		var pinImage = new google.maps.MarkerImage(
				"http://localhost:8080/RealEstate/static/images/marker_blue.png");
		// "${resource(dir : 'images', file : 'marker_blue.png')}");
		for (var i = 0; i < properties.length; i++) {
			var property = properties[i];
			var lat = property.getElementsByTagName("latitude");
			var lon = property.getElementsByTagName("longitude");

			var pos = new google.maps.LatLng(lat[0].firstChild.nodeValue,
					lon[0].firstChild.nodeValue);
			var marker = new google.maps.Marker({
				map : map,
				position : pos,
				icon : pinImage
			});
		}
	}
}

function getAllProperties() {
	var query = getParameterByName('query');
	var offset = getParameterByName('offset');
	var max = getParameterByName('max');
	if (!offset) {
		offset = 0;
	}
	if (!max) {
		max = 20;
	}
	
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	//listner 
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			propertiesData = xmlhttp.responseXML;

			//display map
			if (geocoder && map)
				listAllProperties(address, propertiesData);
		}
	}

	xmlhttp.open("GET", "http://localhost:8080/RealMashupFinal/rest?city="
			+ query + "&dtype=xml&offset=" + offset + "&max=" + max, true);
	xmlhttp.send();
}

function getParameterByName(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex
			.exec(location.search);
	return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g,
			" "));
}

//entry point
google.maps.event.addDomListener(window, 'load', initialize);
