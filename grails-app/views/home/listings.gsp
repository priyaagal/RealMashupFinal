<!DOCTYPE html>
<html lang="en">
<head>
<title>Real Estate Prediction Engine</title>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="description">
<meta content="" name="author">

<!-- Le styles -->

<style type="text/css">
<style type ="text /css">.gm-style .gm-style-mtc label,.gm-style .gm-style-mtc div
	{
	font-weight: 400
}
</style>
<style type="text/css">
.gm-style .gm-style-cc span,.gm-style .gm-style-cc a,.gm-style .gm-style-mtc div
	{
	font-size: 10px
}
</style>
<link type="text/css" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
<style type="text/css">
@media print {
	.gm-style .gmnoprint,.gmnoprint {
		display: none
	}
}

@media screen {
	.gm-style .gmnoscreen,.gmnoscreen {
		display: none
	}
}
</style>
<style type="text/css">
.gm-style {
	font-family: Roboto, Arial, sans-serif;
	font-size: 11px;
	font-weight: 400;
	text-decoration: none
}
</style>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-responsive.min.css">
<link rel="stylesheet" href="css/font-awesome.css">
<script src="//www.google-analytics.com/ga.js" style=""></script>
<script src="js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
<!-- body { padding-top: 60px; padding-bottom: 40px; } -->
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'bootstrap.min.css')}">
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'bootstrap-responsive.min.css')}">
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'bootstrap-responsive.css')}">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link rel="stylesheet" href="${resource(dir: 'fancybox', file: 'jquery.fancybox-v=2.1.5.css')}" type="text/css" media="screen">

<!-- CSS (necessary for Bootstrap's CSS ) -->

<link rel="stylesheet" href="${resource(dir: 'css', file: 'font-awesome.min.css')}" rel="stylesheet">
<link rel="stylesheet" type="text/css"href="${resource(dir: 'css', file: 'style.css')}">

<link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,600,300,200&subset=latin,latin-ext' rel='stylesheet' type='text/css'>

<g:javascript src="html5shiv.js"></g:javascript>
<g:javascript src="jquery-1.10.2.min.js"></g:javascript>
<g:javascript src="jquery-migrate-1.2.1.min.js"></g:javascript>
<g:javascript src="bootstrap.min.js"></g:javascript>
<g:javascript src="jquery.easing.1.3.js"></g:javascript>
<g:javascript src="jquery.raty.js"></g:javascript>
<g:javascript src="application.js"></g:javascript>
<g:javascript src="script.js"></g:javascript>
<g:javascript src="gmaps.js"></g:javascript>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>

</head>
<body>
	<header>
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<button type="button" class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="brand" href="#">Real Realty</a>
					<div class="nav-collapse collapse">
						<!--  <ul class="nav nav-pills pull-center">-->
						<ul class="nav">
							<li class="active"><a href="#">Home</a></li>
							<li><a href="#about">About</a></li>
							<li><a href="#contact">Contact</a></li>
							<!--  
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Brand Options <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="dell/dell-home.jsp">Dell</a></li>
                     <li class="divider"></li>
                  <li><a href="lenovo/lenovo-home.jsp">Lenovo</a></li>
                     <li class="divider"></li>
                  <li><a href="sony/sony-home.jsp">Sony</a></li>
                    <li class="divider"></li>
                 <li><a href="hp/hp-home.jsp">HP</a></li>
                </ul>
              </li> -->
						</ul>

					</div>
					<!--/.nav-collapse -->

					<div class="nav-collapse collapse pull-right">
						<%--<%
							String userName = "";
							if (session.getAttribute("user") != null) {
								User userDto = (User) session.getAttribute("user");
								userName = userDto.getUsername();
							}
						%>
						--%>
						<ul class="nav">
							<% if(session.username != null){ %>
							<li style="color: white; padding-top: 10px;"><i
								class="icon-user icon-white"></i> ${session.username}</li>
							<li><g:link controller="user" action="logout" > Logout</g:link></li>
							<% }
							else
							{ %>
								<li style="color: white; padding-top: 10px;"><i
								class="icon-user icon-white"></i>  </li>
								<li><g:link mapping="register"> Sign In</g:link></li>
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
		<div class="row-fluid">
			<div class="panel panel-default">
				<div class="right-sec">
					<ul class="media-list">
						<li class="media span7">
						<a class="pull-left" href="#"> 
							<img class="media-object" src="http://photos.foter.com/68/new-money-movement_300x300.jpg" style="" alt="64x64" data-src="holder.js/64x64">
						</a>
						<div class="media-body">
							<h4>
								${flash.address}
								<span class="label label-success pull-right">$123,456</span>
							</h4>
							<dl class="dl-horizontal">
								<dt>City</dt>
								<dd>
									${flash.city}
								</dd>
								<dt>Zip</dt>
								<dd>
									${flash.zip}
								</dd>
								<dt>Bathrooms</dt>
								<dd>
									${flash.bathroom}
								</dd>
								<dt>Bedrooms</dt>
								<dd>
									${flash.bedroom}
								</dd>
								<dt>Finished Sq.Ft Area</dt>
								<dd>
									${flash.fArea}
								</dd>
								<dt>Lot Sq.Ft Area</dt>
								<dd>
									${flash.lArea}
								</dd>
								<dt>Estimated Price</dt>
								<dd>
									${flash.zestAmt}
								</dd>
							</dl>
							<div class="col-md-2">
								<p>
									<% if(session.username != null){  %>
									<g:form class="col-lg-12" controller="home"
										action="AddToUserWatchList"
										params="${ [address: flash.address]}">
										<button class="btn btn-lg btn-primary" type="submit">
											Watchlist!</button>
									</g:form>
									<% } %>
								</p>
							</div>
							<div class="col-md-6">
								<div id="map"></div>
							</div>
						</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!--  Tab bar for widgets -->
	<div class="container">
		<ul id="widgets" class="nav nav-tabs">
			<li class="active">
				<a href="#amenities" data-toggle="tab">Amenities</a>
			</li>
			<li><a href="#crimerate" data-toggle="tab">Crime Rate</a></li>
			<li><a href="#education" data-toggle="tab">Education</a></li>
			<li><a href="#employment" data-toggle="tab">Employment</a></li>
			<li><a href="#weather" data-toggle="tab">Weather</a></li>
		</ul>
		<div id="tabscontent" class="tab-content">
			<div class="tab-pane fade in active" id="amenities">
				<div class="thumbnail pull-left">
					<img src="/RealMashupFinal/static/images/weather.jpg" alt="">
					<div class="caption">
						<h3>Amenities</h3>
						<div id="amenitiesStar"></div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="crimerate">
				<div class="thumbnail pull-left">
					<img src="/RealMashupFinal/static/images/weather.jpg" alt="">
					<div class="caption">
						<h3>Crime Rate</h3>
						<div id="crimeRateStar"></div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="education">
				<div class="thumbnail pull-left">
					<img src="/RealMashupFinal/static/images/weather.jpg" alt="">
					<div class="caption">
						<h3>Education</h3>
						<div id="educationStar"></div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="employment">
				<div class="thumbnail pull-left">
					<img src="/RealMashupFinal/static/images/weather.jpg" alt="">
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
		</div>
	</div>
	
	<!-- Tab bar for widgets ends -->

<%-- 
			<button type="button" class="btn btn-primary" onclick="codeAddress()"
				data-loading-text="LOading...">View Map!</button>
			<div id="map-canvas" style="width: 300px; height: 300px"></div>
--%>

	<!-- /container -->
</body>


<!-- fancybox init -->
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
<script type="text/javascript">
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
	$(function() {
		$('#widgets li:eq(1) a').tab('show');
	});
</script>


<%--<script>
var map;
$(document).ready(function(){
  map = new GMaps({
	div: '#map',
    lat: ${flash.lat},
    lng: ${flash.lon},
    title:'${flash.address}'
  });
});
</script>
--%></html>
