<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Real Estate Analytics</title>

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="${resource(dir: 'css', file: 'bootstrap.min.css')}">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link rel="stylesheet"
	href="${resource(dir: 'fancybox', file: 'jquery.fancybox-v=2.1.5.css')}"
	type="text/css" media="screen">


<!-- CSS (necessary for Bootstrap's CSS ) -->

<link rel="stylesheet"
	href="${resource(dir: 'css', file: 'font-awesome.min.css')}"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${resource(dir: 'css', file: 'style.css')}">

<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,600,300,200&subset=latin,latin-ext'
	rel='stylesheet' type='text/css'>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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

	<div class="row-fluid">
		<ul class="thumbnails">
			<li class="span3">
				<div class="thumbnail">
					<img data-src="" alt="">
					<div class="caption">
						<h3>Your property search</h3>
						
							<a href="#" class="btn btn-primary" id="dellBtn">Start Here</a>
						</p>
					</div>
				</div>
			</li>
		</ul>
	</div>

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

		</div>
		<!-- /container -->
	</div>
	
	<div class="container-fluid">
    <div id="custom_carousel" class="carousel slide" data-ride="carousel" data-interval="2500">
        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-3"><img src="http://placehold.it/350x250" class="img-responsive"></div>
                        <div class="col-md-9">
                            <h2>Slide 1</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi, labore, magni illum nemo ipsum quod voluptates ab natus nulla possimus incidunt aut neque quaerat mollitia perspiciatis assumenda asperiores consequatur soluta.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi, labore, magni illum nemo ipsum quod voluptates ab natus nulla possimus incidunt aut neque quaerat mollitia perspiciatis assumenda asperiores consequatur soluta.</p>
                        </div>
                    </div>
                </div>            
            </div> 
            <div class="item">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-3"><img src="http://placehold.it/350x250" class="img-responsive"></div>
                        <div class="col-md-9">
                            <h2>Slide 2</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi, labore, magni illum nemo ipsum quod voluptates ab natus nulla possimus incidunt aut neque quaerat mollitia perspiciatis assumenda asperiores consequatur soluta.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi, labore, magni illum nemo ipsum quod voluptates ab natus nulla possimus incidunt aut neque quaerat mollitia perspiciatis assumenda asperiores consequatur soluta.</p>
                        </div>
                    </div>
                </div>            
            </div> 
            <div class="item">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-3"><img src="http://placehold.it/350x250" class="img-responsive"></div>
                        <div class="col-md-9">
                            <h2>Slide 3</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi, labore, magni illum nemo ipsum quod voluptates ab natus nulla possimus incidunt aut neque quaerat mollitia perspiciatis assumenda asperiores consequatur soluta.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi, labore, magni illum nemo ipsum quod voluptates ab natus nulla possimus incidunt aut neque quaerat mollitia perspiciatis assumenda asperiores consequatur soluta.</p>
                        </div>
                    </div>
                </div>           
            </div> 
            <div class="item">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-3"><img src="http://placehold.it/350x250" class="img-responsive"></div>
                        <div class="col-md-9">
                            <h2>Slide 4</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi, labore, magni illum nemo ipsum quod voluptates ab natus nulla possimus incidunt aut neque quaerat mollitia perspiciatis assumenda asperiores consequatur soluta.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Animi, labore, magni illum nemo ipsum quod voluptates ab natus nulla possimus incidunt aut neque quaerat mollitia perspiciatis assumenda asperiores consequatur soluta.</p>
                        </div>
                    </div>
                </div>           
            </div> 
        <!-- End Item -->
        </div>
        <!-- End Carousel Inner -->
        <div class="controls">
            <ul class="nav">
                <li data-target="#custom_carousel" data-slide-to="1" class="active"><a href="#"><img src="http://placehold.it/50x50"><small>Slide One</small></a></li>
                <li data-target="#custom_carousel" data-slide-to="2"><a href="#"><img src="http://placehold.it/50x50"><small>Slide Two</small></a></li>
                <li data-target="#custom_carousel" data-slide-to="3"><a href="#"><img src="http://placehold.it/50x50"><small>Slide Three</small></a></li>
                <li data-target="#custom_carousel" data-slide-to="4"><a href="#"><img src="http://placehold.it/50x50"><small>Slide Four</small></a></li>
            </ul>
        </div>
    </div>
    <!-- End Carousel -->
</div>
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
$(document).ready(function(ev){
    $('#custom_carousel').on('slide.bs.carousel', function (evt) {
      $('#custom_carousel .controls li.active').removeClass('active');
      $('#custom_carousel .controls li:eq('+$(evt.relatedTarget).index()+')').addClass('active');
    })
});

</script>

</html>
