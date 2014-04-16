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
<link type="text/css" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
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
					<a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</a>
					<a class="brand" href="#">Real Realty</a>
					 <div class="nav-collapse collapse navbar-responsive-collapse">
						<ul class="nav">
						<!--  <ul class="nav nav-pills pull-center">-->
							<li class="active"><a href="#">Home</a></li>
							<li><a href="#about">About</a></li>
							<li><a href="#contact">Contact</a></li>
						</ul>
					</div>
					<!--/.nav-collapse -->
					<div class="nav-collapse collapse pull-right">
						<ul class="nav">
							<% if(session.username != null){ %>
								<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">WatchList<b class="caret"></b></a>
								  <ul class="dropdown-menu">
									<li><g:link controller="home" action="getUserWatchlist" >My Watclist</g:link></li>
									   <li class="divider"></li>
								  </ul>
								</li>
							<li style="color: white; padding-top: 10px;">
							<i class="icon-user icon-white"></i> ${session.username}</li>
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
<style>
/* Wrapper for page content to push down footer */
#wrap {
  min-height: 100%;
  height: auto !important;
  height: 100%;
  /* Negative indent footer by its height */
  margin: 0 auto -60px;
  /* Pad bottom by footer height */
  padding: 0 0 60px;
}

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

#footer > .container {
  padding-left: 15px;
  padding-right: 15px;
}

code {
  font-size: 80%;
}

</style>
<!-- === MAIN Background === -->
<div id="wrap">
	<div class="container">
		<!-- Carousel
    ================================================== -->
		<div id="myCarousel" class="carousel slide">
			<div class="carousel-inner">
				<div class="item active">
					<img src="/RealMashupFinal/static/images/property-main-1.jpg" alt="">
				</div>
				<div class="item">
					<img src="/RealMashupFinal/static/images/property-main-2.jpg" alt="">
				</div>
				<div class="item">
					<img src="/RealMashupFinal/static/images/property-main-3.jpg" alt="">
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
		</div>
		<!-- /.carousel -->
		<!-- Main hero unit for a primary marketing message or call to action -->


		<div class="row">
			<div class="col-lg-12 text-center v-center">
				<h1>Welcome to Real Realty!</h1>
				<p class="lead">Find the Best Places to Live</p>
				<g:form class="col-lg-12" controller="home" action="parseRequest">
					<div class="input-group input-group-lg col-sm-offset-4 col-sm-4">
						<input type="text" class="center-block form-control input-lg" title="Search" placeholder="e.g. San Jose" name="query">
						<span class="input-group-btn">
							<button class="btn btn-lg btn-primary" type="submit">Go!</button>
						</span>
					</div>
				</g:form>
			</div>
		</div>
		<!-- /row -->
		<!-- Example row of columns -->

		<hr>
	</div>
	<div id="footer">
		<div class="container">
			<p class="text-muted credit">&copy; Real Realty 2014</p>
		</div>
	</div>
</div>

	<!-- /container -->

<g:javascript src="jquery-1.10.2.min.js"></g:javascript>
<g:javascript src="bootstrap.js"></g:javascript>
<g:javascript src="operations.js"></g:javascript>
<g:javascript src="script.js"></g:javascript>
<script>
	!function($) {
		(function() {
			// carousel demo
			$('#myCarousel').carousel()
		})
	}(window.jQuery)
</script>
</body>
</html>