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
style type ="text /css">.gm-style .gm-style-mtc label,.gm-style .gm-style-mtc div {
	font-weight: 400
}
</style>
<style type="text/css">
.gm-style .gm-style-cc span,.gm-style .gm-style-cc a,.gm-style .gm-style-mtc div {
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
<script src="js/html5shiv.js"></script>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="fancybox/jquery.fancybox.pack-v=2.1.5.js"></script>
<script src="js/script.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
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
							$('#custom_carousel .controls li:eq('
											+ $(evt.relatedTarget).index()
											+ ')').addClass('active');
						})
			});
</script>

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
					<div class="nav-collapse collapse navbar-responsive-collapse">
						<ul class="nav">
						<!--  <ul class="nav nav-pills pull-center">-->
							<li class="active"><a href="#">Home</a></li>
							<li><a href="#about">About</a></li>
							<li><a href="#contact">Contact</a></li>
						</ul>
						<!--/.nav-collapse -->
						<div class="navbar-search pull-left">
							<g:form class="navbar-form navbar-left" controller="home" action="listingSingleAddress">
								<div class="form-group fieldcontain text-center">
									<input type="text" title="Search" value="" placeholder="Search ..." class="form-control nav-search" name="query"> 
									<span class="input-group-btn">
										<button class="btn btn-lg btn-primary" type="submit">Go!</button>
									</span>
								</div>
							</g:form>
						</div>
						<ul class="nav pull-right">
							<% if(session.username != null){ %>
							<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">WatchList<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li>
										<a href=“#watchlist”>My Watclist</a>
									</li>
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

	<!-- === MAIN Background === -->
<div id="wrap">
	<div class="container">
		<hr>
		<% 
		if(offset == null)
			offset = 0
	
		if (max ==null)
			max = 10
	
		for(int i=offset;i<offset+max;i++){ %>
		<div class="row-fluid">
			<div class="panel panel-default">
				<div class="right-sec">
					<ul class="media-list">
						<li class="media span7"><a class="pull-left" href="#"> <img
								class="media-object"
								src="http://photos.foter.com/68/new-money-movement_300x300.jpg"
								style="" alt="64x64" data-src="holder.js/64x64">
						</a>
							<div class="media-body">
								<h4>
									<g:link controller="home" action="listSingleAddress" params="${['query':properties[i].address]}" >
									${properties[i].address}</g:link>
									<span class="label label-success pull-right">$123,456</span>
								</h4>
								<dl class="dl-horizontal">
									<dt>City</dt>
									<dd>
										${properties[i].city}
									</dd>
									<dt>Zip</dt>
									<dd>
										${properties[i].zipcode}
									</dd>
									<dt>Bathrooms</dt>
									<dd>
										${properties[i].bathroom}
									</dd>
									<dt>Bedrooms</dt>
									<dd>
										${properties[i].bedroom}
									</dd>
									<dt>Finished Sq.Ft Area</dt>
									<dd>
										${properties[i].finishedSqFt}
									</dd>
									<dt>Lot Sq.Ft Area</dt>
									<dd>
										${properties[i].lotSizeSqFt}
									</dd>
									<dt>Estimated Price</dt>
									<dd>
										${properties[i].zest_amt}
									</dd>
								</dl>
								<div class="col-md-2">
									<p>
										<% if(session.username != null){ %>
										<g:form class="col-lg-12" controller="home"
											action="AddToUserWatchList"
											params="${ [address: flash.address]}">
											<button class="btn btn-lg btn-primary" type="submit">
												Watchlist!</button>
										</g:form>
										<% } %>
									</p>
								</div>
							</div></li>
					</ul>
				</div>
			</div>
		</div> <% } %>
		
		<div class="pagination">
        <g:paginate class="btn btn-lg btn-primary"  total="${ total}" next="Forward" prev="Back" controller="home" 
                    action="paginateAddresses" params="${['query':params.query, 'total':total]}" />
    	</div>
	</div>
	<div id="footer">
		<div class="container">
			<p class="text-muted credit">&copy; Real Realty 2014</p>
		</div>
	</div>
</div>
	
</body>
</html>
