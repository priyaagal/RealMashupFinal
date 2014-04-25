<!DOCTYPE html>
<html lang="en">
<head>
<title>Real Estate Prediction Engine</title>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="description">
<meta content="" name="author">

<style type="text/css">

.wrapper{
    margin-top:10px;
 
    position :relative;
    width: 100%;
    margin: 0px auto;
    height:600px;
}
.inner_left {
  position : absolute;
  left:0;
  bottom:0;
  width: 550px; 
  margin-top: 50px;
  
   
}
.inner_right{
  position :absolute;
  right:0;
  bottom:0;
  left: 500px; 
  top: 50px;  
}
</style>
<style>
#map-canvas {
   height: 410px;
   width: 600px;
   padding: 50px;
   overflow: visible;
   float: right;
   border-style: ridge;
   border-width:5px;
   border-color: white;
   padding-left: 50px; 
 }
/**margin:50px 25px 15px 500px;**/
#map-canvas img { max-width: none }

/* Set the fixed height of the footer here */
#footer {
  height: 60px;
  background-color: #f5f5f5;
}

/* Custom page CSS
-------------------------------------------------- */
/* Not required for template or sticky footer method. */

#wrap > .container {
  padding: 60px 15px 0;
}
.container .credit {
  margin: 20px 0;
}

code {
  font-size: 80%;
}

.col-lg-12 {
    min-height: 1px;
    padding-left: 15px;
    padding-right: 15px;
}

.propertyContent {
    padding: 9px;
}

.propertyItem {
    background-color: #FFFFFF;
    box-shadow: 0 1px 3px #D4D4D4;
    margin-bottom: 30px;
    width: 500px; 
    margin-top: 0px; 
    height: 517px;"
}

col-lg-4 col-md-4 col-sm-4{
    min-height: 1px;
    padding-left: 15px;
    padding-right: 15px;
    position: relative;
    float: left
}

.rowText {
    padding-right: 33px;
    padding-top: 17px;
}

.col-lg-8 {
    width: 66.6667%;
    float: left;
    padding-left: 15px;
}

.row {
    margin-left: -15px;
    margin-right: -15px;
}


</style>



<link rel="stylesheet" href="/RealMashupFinal/static/css/bootstrap.min.css">
<link rel="stylesheet" href="/RealMashupFinal/static/css/bootstrap-responsive.min.css">
<link rel="stylesheet" href="/RealMashupFinal/static/fancybox/jquery.fancybox-v=2.1.5.css">
<!-- body { padding-top: 60px; padding-bottom: 40px; } -->
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'bootstrap.min.css')}">
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'bootstrap-responsive.min.css')}">
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'bootstrap-responsive.css')}">

<!-- CSS (necessary for Bootstrap's CSS ) -->


<link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,600,300,200&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
<%--

<script type="text/javascript" src="js/html5shiv.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="fancybox/jquery.fancybox.pack-v=2.1.5.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/jquery.raty.js"></script>

--%>
<g:javascript src="html5shiv.js"></g:javascript>
<g:javascript src="jquery-1.10.2.min.js"></g:javascript>
<g:javascript src="jquery-migrate-1.2.1.min.js"></g:javascript>
<g:javascript src="bootstrap.min.js"></g:javascript>
<g:javascript src="jquery.easing.1.3.js"></g:javascript>
<script type="text/javascript" src="/RealMashupFinal/static/fancybox/jquery.fancybox.pack-v=2.1.5.js"></script>
<g:javascript src="jquery.raty.js"></g:javascript>

<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'style.css')}">

</head>

<body>
	<header>
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner" style="height: 60px;">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span>
						</button>
						<a class="brand" href="#">Real Realty</a>
					</div>
					<div class="nav-collapse collapse navbar-responsive-collapse">
						<ul class="nav">
							<li style="color: white; padding-top: 10px;">
								<i class="icon-home icon-white"></i>  
							</li>
							<li class="active">
								<g:link controller="home" action="index">Home</g:link>
							</li>
						</ul>
						<div class="navbar-search pull-left">
							<g:form class="navbar-form navbar-left" controller="restClient" action="getProperties">
								<div class="form-group fieldcontain text-center">
									<input type="text" title="Search" required = "required" value="" placeholder="Search " class="form-control nav-search" name="query"> 
									<span class="input-group-btn">
										<button class="btn btn-lg btn-primary" type="submit">Go!</button>
									</span>
								</div>
							</g:form>
						</div>
						<ul class="nav pull-right">
							<% if(session.username != null){ %>
								<li style="color: white; padding-top: 10px;">
									<i class="icon-th-list icon-white"></i>
								</li>
								<li>
									<g:link controller="restClient" action="getUserWatchlist">My Watclist</g:link>
								</li>
								<li style="color: white; padding-top: 10px;">
									<i class="icon-user icon-white"></i> ${session.username}</li>
								<li class="divider-vertical"></li>
								<li style="color: white; padding-top: 10px;">
									<i class="icon-user icon-white"></i>
								</li>
								<li>
									<g:link controller="user" action="logout"> Logout</g:link>
								</li>
							<% }
							else
							{ %>
								<li style="color: white; padding-top: 10px;">
									<i class="icon-user icon-white"></i>  
								</li>
								<li>
									<g:link mapping="register"> Sign In</g:link>
								</li>
							<%}%>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>

<!-- === MAIN Background === -->
	<div class="container">
		<hr>
		<div class="row">
			<div class="wrapper">
				<div class ="inner_left">
					<div class="propertyItem">
						<div class="propertyContent row" style="margin-left: 40px; margin-right: 20px; width: 500px;">
							<div class="col-lg-4 col-md-4 col-sm-4">
								<a class="pull-left" href="#"> 
									<img class="media-object img-responsive" style="width: 400px; height: 250px; padding-top: 20px;"
									src="http://images.prd.mris.com/image/V2/1/Yu59d899Ocpyr_RnF0-8qNJX1oYibjwp9TiLy-bZvU9vRJ2iC1zSQgFwW-fTCs6tVkKrj99s7FFm5Ygwl88xIA.jpg" 
									alt="64x64" data-src="holder.js/64x64">
								</a>
							</div>
							<div class="col-lg-8 rowText" style="width: 422px;padding-right: 15px;">
								<h4 align="center" style=" padding-top: 10px; border-top-width: 20px; margin-top: 20px; width: 420px;"">
									${flash.address}<a>,</a> ${flash.city}<a>,</a> ${flash.zip}
									&nbsp&nbsp
									<span class="label label-success"> ${flash.zestAmt}</span>
								</h4>
								<dl class="dl-horizontal">
									<dt>Bathrooms</dt>
									<dd>
									<%if(!flash.bathroom.equals(0)){%>
										${flash.bathroom}
									<%}else{%>
										NA
									<%}%>
									</dd>
									<dt>Bedrooms</dt>
									<dd>
									<%if(!flash.bedroom.equals(0)){%>
										${flash.bedroom}
									<%}else{%>
										NA
									<%}%>
									</dd>
									<dt>Finished Sq.Ft Area</dt>
									<dd>
										<%if(!flash.fArea.equals(0)){%>
											${flash.fArea} <a> sqFt</a>
										<%}else{%>
											NA
										<%}%>
									</dd>
									<dt>Lot Sq.Ft Area</dt>
									<dd>
										<%if(!flash.lArea.equals(0)){%>
											${flash.lArea}<a> sqFt</a>
										<%}else{%>
											NA
										<%}%>
									</dd>
								</dl>
							</div>
						</div>
						<div class="col-md-2" style="float:right">
							<p>
							<% if(session.username != null && watchlist!= "true"){  %>
								<g:form class="col-lg-12" controller="restClient" action="addToUserWatchList" params="${ [address: flash.address]}">
									<button class="btn btn-lg btn-primary" type="submit"> Add to Watchlist!</button>
								</g:form>
							<% } %>
							</p>
						</div>
					</div>
				</div>
				<div class="inner_right">
					<div id="map-canvas" align="right"></div>
				</div>
			</div>	
		</div>
	</div>
	<div class="container">
		<ul id="widgets" class="nav nav-tabs">
			<li class="active"><a href="#pricePrediction" data-toggle="tab">Price Predictions</a></li>
			<li><a href="#ifBuy" data-toggle="tab">Buying Advise</a></li>
			<li><a href="#amenities" data-toggle="tab">Amenities</a></li>
			<li><a href="#crimerate" data-toggle="tab">Crime Rate</a></li>
			<li><a href="#education" data-toggle="tab">Education</a></li>
			<li><a href="#employment" data-toggle="tab">Employment</a></li>
			<li><a href="#weather" data-toggle="tab">Weather</a></li>
			<li><a href="#costOfLiving" data-toggle="tab">Cost of Living</a></li>
		</ul>
		<div id="tabscontent" class="tab-content">
			<div class="tab-pane fade in active" id="pricePrediction">
				<div class="thumbnail pull-left">
					<div class="caption">
						<h3>Price Trend</h3>
					</div>
					<g:if test="${flash.priceAppreciated}">
						<img src="/RealMashupFinal/static/images/prices-up.jpg" alt="">
						<span class="label label-warning">Prices are Up</span>
					</g:if>
					<g:else> 
						<img src="/RealMashupFinal/static/images/prices-down.jpg" alt="">
						<span class="label label-success">Prices are Down</span>
					</g:else>
				</div>
			</div>
			<div class="tab-pane fade" id="ifBuy">
				<div class="thumbnail pull-left">
					<div class="caption">
						<h3>Buy/Not Buy</h3>
					</div>
					<g:if test="${flash.ifBuy}">
						<img src="/RealMashupFinal/static/images/thumbs-up.jpg" alt="">
						<span class="label label-warning">Time to buy</span>
					</g:if>
					<g:else> 
						<img src="/RealMashupFinal/static/images/thumbs-down.jpg" alt="">
						<span class="label label-success">Not a time to buy</span>
					</g:else>
				</div>
			</div>
			<div class="tab-pane fade" id="amenities">
				<div class="thumbnail pull-left">
					<img src="/RealMashupFinal/static/images/amenities.jpg" alt="">
					<div class="caption">
						<h3>Amenities</h3>
						<div id="amenitiesStar"></div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="crimerate">
				<div class="thumbnail pull-left">
					<img src="/RealMashupFinal/static/images/crimerate.jpg" alt="">
					<div class="caption">
						<h3>Crime Rate</h3>
						<div id="crimeRateStar"></div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="education">
				<div class="thumbnail pull-left">
					<img src="/RealMashupFinal/static/images/education1.jpg" alt="">
					<div class="caption">
						<h3>Education</h3>
						<div id="educationStar"></div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="employment">
				<div class="thumbnail pull-left">
					<img src="/RealMashupFinal/static/images/employment.jpg" alt="">
					<div class="caption">
						<h3>Employment</h3>
						<div id="employmentStar"></div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="weather">
				<div class="thumbnail pull-left">
					<img src="/RealMashupFinal/static/images/weather.jpg" alt="">
					<div class="caption">
						<h3>Weather</h3>
						<div id="weatherStar"></div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="costOfLiving">
				<div class="thumbnail pull-left">
					<img src="/RealMashupFinal/static/images/costofliving.jpg" alt="">
					<div class="caption">
						<h3>Cost Of Living</h3>
						<div id="costOfLivingStar"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<div id="footer" class="section footer" style = "height: 100px; background-color:#000000">
		<div class="container align-center" style="margin-top: 0px; border-top-width: 50px; padding-top: 30px;">
			<p class="text-muted credit align-center" style = "color: #777777; font-size: 16px; font-weight: 300; line-height: 1.6em;">&copy; Real Realty 2014</p>
		</div>
	</div>

<script>
	$(function() {
		$('#widgets li:eq(1) a').tab('show');
	});
</script>

<script>
	var amenitiesScore =${flash.amenities}+3
	$('#amenitiesStar').raty({
		readOnly : true,
		score : amenitiesScore
	});
	
	var crimeRateScore = ${flash.crimeRate}+3
	$('#crimeRateStar').raty({
		readOnly : true,
		score : crimeRateScore
	});
	
	var educationScore = ${flash.education}+3
	$('#educationStar').raty({
		readOnly : true,
		score : educationScore
	});
	
	var employmentScore = ${flash.employment}+3
	$('#employmentStar').raty({
		readOnly : true,
		score : employmentScore
	});
	
	var weatherScore =${flash.weather}+3
	$('#weatherStar').raty({
		readOnly : true,
		score : weatherScore
	});
	
	var costOfLivingScore =${flash.costOfLiving}+3
	$('#costOfLivingStar').raty({
		readOnly : true,
		score : costOfLivingScore
	});

</script>
<script>
function initialize() {
  var lat = ${flash.lat}
  var lon = ${flash.lon}
  var mapOptions = {
    zoom: 10,
    center: new google.maps.LatLng(lat, lon)
  };
  var map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);

  var marker = new google.maps.Marker({
	  position: new google.maps.LatLng(lat, lon),    
	  map: map    
   });
}

function loadScript() {
  var script = document.createElement('script');
  script.type = 'text/javascript';
  script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&' +
      'callback=initialize';
  document.body.appendChild(script);
}

window.onload = loadScript;
</script>
<script>
$(document).ready(
		function(ev) {
			$('#custom_carousel').on(
					'slide.bs.carousel',
					function(evt) {
						$('#custom_carousel .controls li.active')
								.removeClass('active');
						$(
								'#custom_carousel .controls li:eq('
										+ $(evt.relatedTarget).index()
										+ ')').addClass('active');
					})
		});
</script>
<script>
$(document).ready(function(e) {
	var lis = $('.nav > li');
	menu_focus(lis[0], 1);

	$(".fancybox").fancybox({
		padding : 10,
		helpers : {
			overlay : {
				locked : false
			}
		}
	});

});
</script>
</body>
</html>
