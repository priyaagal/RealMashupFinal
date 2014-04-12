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
body { padding-top: 60px; padding-bottom: 40px; }
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'bootstrap.min.css')}">

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
						--%><ul class="nav">
							<li style="color: white; padding-top: 10px;"><i
								class="icon-user icon-white"></i> <%=userName%></li>
							<li><g:link mapping="logout"> Logout</g:link></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>

	<div class="container">

		<!-- Carousel
    ================================================== -->
		<div id="myCarousel" class="carousel slide">
			<div class="carousel-inner">
				<div class="item active">
					<img src="/RealMashupFinal/static/images/property-main-1.jpg" alt="">
					<!--    <div class="container">
            <div class="carousel-caption">
              <h1>Example headline.</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <a class="btn btn-large btn-primary" href="#">Sign up today</a>
            </div>
          </div> -->
				</div>
				<div class="item">
					<img src="/RealMashupFinal/static/images/property-main-2.jpg" alt="">
					<!--   <div class="container">
            <div class="carousel-caption">
              <h1>Another example headline.</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <a class="btn btn-large btn-primary" href="#">Learn more</a>
            </div>
          </div> -->
				</div>
				<div class="item">
					<img src="/RealMashupFinal/static/images/property-main-3.jpg" alt="">
					<!--   <div class="container">
            <div class="carousel-caption">
              <h1>One more for good measure.</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <a class="btn btn-large btn-primary" href="#">Browse gallery</a>
            </div>
          </div> -->
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="right carousel-control" href="#myCarousel"
				data-slide="next">&rsaquo;</a>
		</div>
		<!-- /.carousel -->
		<!-- Main hero unit for a primary marketing message or call to action -->


		<div class="row">
			<div class="col-lg-12 text-center v-center">
				<h1>Welcome to Real Realty!</h1>
				<p class="lead">Find the Best Places to Live</p>
				<form class="col-lg-12" method="get" action="/search">
					<div class="input-group input-group-lg col-sm-offset-4 col-sm-4">
						<input type="text" class="center-block form-control input-lg"
							title="Search" placeholder="e.g. San Jose"> <span
							class="input-group-btn">
							<button class="btn btn-lg btn-primary" type="button">Go!</button>
						</span>
					</div>
				</form>
			</div>
		</div>
		<!-- /row -->
		<!-- Example row of columns -->
		
		<hr>

		<footer>
			<p>&copy; Real Realty 2014</p>
		</footer>

	</div>
	<!-- /container -->

	<!-- 
    ================================================== -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/operations.js"></script>
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
