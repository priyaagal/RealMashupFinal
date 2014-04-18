/**
 * 
 */

$('#registerBtn').click(function(e){
	var formData = $("#registerForm").serializeArray();
	var URL = $("#registerForm").attr("action");
	$.post(URL,formData, function(data) {
	
		var result = data.split(":");
	
		if(result[0]=='success')
			{
			$reply = $("#successMsg").append('<p>'+result[1]+'</p>').append('<a href="login.html" class="btn btn-primary">Login</a>').fadeIn(1000);
			$("#registerForm").prepend($reply)[1].reset();
			}else
			{
				$reply = $("#failureMsg").append(result[1]).fadeIn(1000);
				$("#registerForm").prepend($reply)[1].reset();
			}
	});
	
	
});


$('#loginClearBtn').click(function(e){
	
	$("#loginForm")[0].reset();
	return false;
			
});

	
$("#loginForm").submit(function(e){
		e.preventDefault();
		
		$form = $(this);
		var formData = $("#loginForm").serializeArray();
		var URL = $("#loginForm").attr("action");
		$.post(URL,formData, function(data) {
			var result = data.split(":");
			if(result[0]=='success')
			{
				window.location.href = "index.gsp";
				// forward the request to landing page and remove the below code.
				//$reply = $("#loginMsgSuccess").append(result[1]).fadeIn(1000);
				//$form.prepend($reply)[0].reset();
			
			}else
			{
				$reply = $("#loginMsg").append(result[1]).fadeIn(1000);
				$form.prepend($reply)[0].reset();
			}
			
				
		});
		
	});


/**$('#registerBtn').click(function(e){
var formData = $("#registerForm").serializeArray();
var URL = $("#registerForm").attr("action");
$.post(URL,formData, function(data) {


	if(data=='success')
		{
		$reply = $("#successMsg").fadeIn(1000);
		$("#registerForm").prepend($reply)[1].reset();
		}else
		{
			$reply = $("#failureMsg").fadeIn(1000);
			$("#registerForm").prepend($reply)[1].reset();
		}
});


});*/

//$('#lenovoBtn').click(function(e){
//
//	var URL = "http://laptopcenter.aws.af.cm/home/brand/lenovo";
//	$.get(URL,function(data) {
//	
//		var result = data;
//		window.location.href = result;
//		
//	});
//	
//	
//});
//
//$('#sonyBtn').click(function(e){
//
//	var URL = "http://laptopcenter.aws.af.cm/home/brand/sony";
//	$.get(URL,function(data) {
//	
//		var result = data;
//		window.location.href = result;
//		
//	});
//	
//	
//});
//
//$('#dellBtn').click(function(e){
//
//	var URL = "http://laptopcenter.aws.af.cm/home/brand/dell";
//	$.get(URL,function(data) {
//	
//		var result = data;
//		window.location.href = result;
//		
//	});
//	
//	
//});
//$('#hpBtn').click(function(e){
//
//	var URL = "http://laptopcenter.aws.af.cm/home/brand/hp";
//	$.get(URL,function(data) {
//	
//		var result = data;
//		window.location.href = result;
//		
//	});
//	
//	
//});