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
.gm-style .gm-style-mtc label,.gm-style .gm-style-mtc div
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
<link rel="stylesheet" type="text/css"  href="${resource(dir: 'fancybox', file: 'jquery.fancybox-v=2.1.5.css')}" media="screen">

<!-- CSS (necessary for Bootstrap's CSS ) -->

<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'font-awesome.min.css')}" >
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'style.css')}">
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Titillium+Web:400,600,300,200&subset=latin,latin-ext">

<style>
/**marketing **/

.marketing {
    color: #5A5A5A;
    text-align: center;
}

.marketing h1 {
    font-size: 60px;
    font-weight: 200;
    letter-spacing: -1px;
    line-height: 1;
    margin: 60px 0 10px;
}

.marketing .marketing-byline {
    color: #999999;
    font-size: 20px;
    font-weight: 300;
    line-height: 1.25;
    margin-bottom: 40px;
}

.marketing-img {
    display: block;
    margin: 0 auto 30px;
    max-height: 200px;
}

/* CUSTOMIZE THE CAROUSEL
-------------------------------------------------- */

/* Carousel base class */
.carousel {
  margin-bottom: 60px;
}
/* Since positioning the image, we need to help out the caption */
.carousel-caption {
  z-index: 10;
}

/* Declare heights because of positioning of img element */
.carousel .item {
  height: 400px;
  background-color:#555;
}
.carousel img {
  position: absolute;
  top: 0;
  left: 0;
  min-height: 600px;
}

/* faster sliding speed */
.carousel-inner > .item {
    -webkit-transition: 0.3s ease-in-out left;
    -moz-transition: 0.3s ease-in-out left;
    -o-transition: 0.3s ease-in-out left;
    transition: 0.3s ease-in-out left;
}
</style>

<g:javascript src="html5shiv.js"></g:javascript>
<g:javascript src="jquery-1.10.2.min.js"></g:javascript>
<g:javascript src="jquery-migrate-1.2.1.min.js"></g:javascript>
<g:javascript src="bootstrap.min.js"></g:javascript>
<g:javascript src="jquery.easing.1.3.js"></g:javascript>
<g:javascript src="jquery.raty.js"></g:javascript>
<script type="text/javascript" src="fancybox/jquery.fancybox.pack-v=2.1.5.js"></script>
<g:javascript src="operations.js"></g:javascript>
<script type="text/javascript" src="www.google-analytics.com/ga.js"></script>

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
!function($) {
	$(function() {
		// carousel demo
		$('#myCarousel').carousel()
	})
}(window.jQuery)
</script>
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
							<li class="active"><g:link controller="home" action="index">Home</g:link></li>
							<li style="color: white; padding-top: 10px;">
								<i class="icon-user icon-white"></i>  
							</li>
							<li><a href="#about">About Us</a></li>
							<li style="color: white; padding-top: 10px;">
								<i class="icon-signal icon-white"></i>  
							</li>
							<li><a href="#whatwedo">What We Do</a></li>
							<li style="color: white; padding-top: 10px;">
								<span class="icon-envelope icon-white"></span>  
							</li>
						</ul>
						<div class="navbar-search pull-left">
							<g:form class="navbar-form navbar-left" controller="restClient" action="getProperties">
								<div class="form-group fieldcontain text-center">
									<input type="text" title="Search" value="" placeholder="Search " class="form-control nav-search" name="query"> 
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
	<div class="container" style="width: 1280px; height: 600px;">
	<!-- === MAIN Background === -->
		<!-- Carousel
    	================================================== -->
		<div id="myCarousel" class="carousel slide" style="height: 340px;">
			<div class="carousel-inner" style="height: 380px;">
				<div class="item active">
					<img src="/RealMashupFinal/static/images/property-main-1.jpg" class="img-responsive">
				</div>
				<div class="item">
					<img src="/RealMashupFinal/static/images/property-main-2.jpg" class="img-responsive">
				</div>
				<div class="item">
					<img src="/RealMashupFinal/static/images/property-main-3.jpg" class="img-responsive">
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
	     	<a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
		</div>
		<!-- /.carousel -->
		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="col-lg-12 text-center v-center">
			<h1>Welcome to Real Realty!</h1>
			<p class="lead">Find the Best Places to Live</p>
			<g:form class="col-lg-12" controller="restClient" action="getProperties">
				<div class="form-group fieldcontain text-center">
					<input class="center-block form-control input-lg" type="text" title="Search" placeholder="e.g. San Jose" name="query">
					<span class="input-group-btn">
						<button class="btn btn-lg btn-primary btn-inverse" type="submit">
							<i class="icon-search icon-white"></i>
						</button>
					</span>
				</div>
			</g:form>
		</div>
	</div>
	<section id="about" class="section appear clearfix">
		<div class="marketing">
			<h2>Introducing </h2>
			<p class="marketing-byline">Team Real Realty</p>
			<div class="row-fluid">
				<div class="span4">
					<img src="/RealMashupFinal/static/images/Minion-1.jpg" style="width: 388px; padding-left: 4px; padding-right: 6px; border-left-width: 6px; border-right-width: 6px;"/>
					<h4>Priyanka Agal</h4>
				</div>
				<div class="span4">
					<img src="/RealMashupFinal/static/images/Minion-2.jpg"  style="height: 474px; padding-right: 6px; border-left-width: 6px; padding-left: 4px;"/>
					<h4>Snehal Dmello</h4>
				</div>
				<div class="span4">
					<img src="/RealMashupFinal/static/images/Minion-3.jpg" style="height: 474px; width: 388px; padding-left: 4px; border-left-width: 6px; padding-right: 6px; border-right-width: 6px;"/>
					<h4>Abhijeet Upadhye</h4>
				</div>
			</div>
		</div>
	</section>
	<section>
	</section>
	<hr class="soften">
	<div id="footer">
		<div class="container">
			<p class="text-muted credit">&copy; Real Realty 2014</p>
		</div>
	</div>
</body>
</html>