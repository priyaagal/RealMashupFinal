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
<
style type ="text /css">.gm-style .gm-style-mtc label,.gm-style .gm-style-mtc div
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
	<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'style.css')}">	
	
	<link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,600,300,200&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
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
							<li style="color: white; padding-top: 10px;"><i
								class="icon-user icon-white"></i> <%=userName%></li>
							<li><a href="register.gsp"> Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- === MAIN Background === -->
	<g:javascript src="mapUtil.js"></g:javascript>
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
										<button class="btn btn-lg btn-primary" type="submit">
											Watchlist!</button>
									</p>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	<div class="container">
		<div class="row-fluid">
			<div class="col-sm-6 col-md-3">
				<ul class="thumbnails">
					<li class="span3">
						<div class="thumbnail">
							<img src="/bootstrap/images/kittens.jpg"
								alt="Generic placeholder thumbnail">
							<div class="caption">
								<h3>Thumbnail label</h3>
								<p>Some sample text. Some sample text.</p>
								<p>
									<a href="#" class="btn btn-primary" role="button"> Button </a>
								</p>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!--
<%--  
	<div class="slide story" id="slide-1" data-slide="1">
		<div>
			<h1 id="address" hidden="true">
				${flash.address}
			</h1>
		</div>
		<div class="container">
			<table class="table table-bordered">
				<tr>
					<!--Body content-->
					<td>Address</td>
					<td>City</td>
					<td>Zip</td>
					<td>Bathrooms</td>
					<td>Bedrooms</td>
					<td>Finished Sq.Ft Area</td>
					<td>Lot Sq.Ft Area</td>
					<td>Estimated Price</td>
				</tr>
				<%--<tr>
					<!--Body content-->
					<td>
						${flash.address}
					</td>
					<td>
						${flash.city}
					</td>
					<td>
						${flash.zip }
					</td>
					<td>
						${flash.bathroom}
					</td>
					<td>
						${flash.bedroom}
					</td>
					<td>
						${flash.fArea}
					</td>
					<td>
						${flash.lArea}
					</td>
					<td>
						${flash.zestAmt}
					</td>
				</tr>
			--%></table>
			<button type="button" class="btn btn-primary" onclick="codeAddress()"
				data-loading-text="LOading...">View Map!</button>
			<div id="map-canvas" style="width: 300px; height: 300px"></div>
--%>
		</div>
-->
		<!-- /container -->
</body>


<script src="js/html5shiv.js"></script>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript"
	src="fancybox/jquery.fancybox.pack-v=2.1.5.js"></script>
<script src="js/script.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
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

</html>
