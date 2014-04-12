<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Real Realty - register/sign in</title>
<meta name="viewport" content="width=device-width,initial-scale=1" />
 
<!-- StyleSheet -->
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.css" />
<link rel="stylesheet" href="css/style.css" />
</head>
 
<body>
<!-- Navigation Bar -->
<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
 
            </a>
 
    <a href="#" class="brand">Real Realty</a>
 
    <div class="nav-collapse collapse pull-right">
        <ul class="nav">
            <li><a href="#register" data-toggle="modal"><i class="icon-user icon-white"></i> Register Here</a></li>
            <li class="divider-vertical"></li>
          <!--    <li><a href="#contact" data-toggle="modal"><i class="icon-envelope icon-white"></i> Contact Us</a></li>
            <li class="divider-vertical"></li>-->
 
        </ul>
    </div>
 
    </div>
  </div>
</div>
<!-- Navigation Ends -->
 
 <%--<%@page import="com.laptop.dao.ShoppingCartDAOImpl" %>
<%@ page import="com.sjsu.cmpe295.models.watchList.*" %>
 <%@ page import="com.sjsu.cmpe295.models.User" %> --%>
 <!--  Invalidate User Session -->
 <%
 	/*User user = null ;
 	//ShoppingCart cart = null;
 	boolean result = false;
 	if(session.getAttribute("user")!=null  )
 	{
 		 user = (User)session.getAttribute("user");
 	}	 	
 	*/
 	/* if(session.getAttribute("cart")!=null)
	{
		 cart = (ShoppingCart)session.getAttribute("cart");
		 ShoppingCartDAOImpl shopCartDAOImpl = new ShoppingCartDAOImpl();
		 result = shopCartDAOImpl.saveShoppingCart(cart, user) ;
	} */
 	
 	
/*
	if(result){
		out.print("success:Registration successful!");
	}else
	{
		out.print("failed:Registration Failed, Try Again");
	}
	 
 	session.invalidate();*/
%>
 
<!-- Main Container -->
<section>
<div class="container login">
    <div class="row ">
        <div class="center span4 well">
         <div id = "loginMsg" class = "alert alert-danger" hidden = "true">
		 </div>
		 <div id = "loginMsgSuccess" class = "alert alert-success" hidden = "true">
		 </div>
            <legend>Please Sign In</legend>
           <form method="post" action="AuthController" accept-charset="UTF-8" id = "loginForm">
             <div class="input-prepend">
	                <span class="add-on"><i class="icon-user"></i></span>
	                  <input type="email" id="email" class="span3" name="email" placeholder="Email" required="true"/>
	         </div>
              <div class="input-prepend">
	                <span class="add-on"><i class="icon-lock"></i></span>
	                  <input type="password" id="password" class="span3" name="password" placeholder="Password" required="true"/>
	         </div>
          
            <label class="checkbox">
                <input type="checkbox" name="remember" value="1" /> Remember Me
            </label>
           <input type = "hidden" value = "login" name = "operation"/>
            <button type="submit" name="submit" class="btn btn-success btn-block" id = "loginBtn">Sign in</button>
            <button type="submit" name="submit" class="btn btn-block" id = "loginClearBtn">Clear</button>
          
            </form>
        </div>
    </div>
</div>
<p class="text-center muted ">&copy; Copyright 2013 - Real Realty</p>
</section>
<!-- Main Container Ends -->
 
<!-- Forgot Password Model Box -->
<div id="register" class="modal hide fade in" style="display: none; ">
<div class="modal-header">
<a class="close" data-dismiss="modal" aria-hidden="true"><i class = "icon-remove"> </i></a>
<h3 id = "registerModalLbl">Registration Form</h3>
</div>
<div class="modal-body">

	 <div id = "successMsg" class = "alert alert-success" hidden = "true">
	 </div>
	 <div id = "failureMsg" class = "alert alert-danger" hidden = "true"></div>
	<form id = "registerForm" action="AuthController" method = "post">
      <div class="controls controls-row">
      
          <input id="fname" name="fname" type="text" class="span2" placeholder="First Name" required="true"/>
          <input id="lname" name="lname" type="text" class="span2" placeholder="Last Name" />
      </div>
       <div class="controls controls-row">
       <input id="email" name="email" type="email" class="span4" placeholder="Email address" required="true"/>
       </div>
       <div class="controls controls-row">
  
       <input type="password" id="regpassword" class="span4" name="password" placeholder="Password" required="true"/>
      </div>
       <div class="controls controls-row">
  
       <input type="password" id="regpasswordrep" class="span4" name="passwordrep" placeholder="Re-enter Password" required="true"/>
       <input type = "hidden" value = "register" name = "operation"/>
      </div>
      
     

</form>
</div>
<div class="modal-footer">
<button type="submit" id = "registerBtn" class="btn btn-primary">Submit</button>
<a href="#" class="btn" data-dismiss="modal">Close</a>
</div>
</div>
 
<!-- JavaScript -->
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/operations.js"></script>
</body>
</html>