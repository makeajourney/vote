function chkformSignup() {	
	var id = document.getElementById("inputSignId").value;
	var pass = document.getElementById("inputSignPassword").value;
	var mail = document.getElementById("inputSignEmail").value;

	if(id == "") {
		alert("intput your ID");
		return false;
	}

	if(mail == "") {
		alert("intput your Emailaddress");
		return false;
	}

	if(pass == "") {
		alert("intput your password");
		return false;
	}
	return true;
}

function chkformLogin() {	

	var id = document.getElementById("inputLoginEmail").value;
	var pass = document.getElementById("inputLoginPassword").value;

	if(id == "") {
		alert("intput your ID");
		return false;
	}

	if(pass == "") {
		alert("intput your password");
		return false;
	}
	return true;
}

$(document).ready(function() {

	$('#loginToggle').click(function() {
		$('#logindiv').addClass('enable');
		$('#logindiv').removeClass('disable');
		$('#signupdiv').addClass('disable');
		$('#signupdiv').removeClass('enable');

	});
	
	$('#signupToggle').click(function() {
		$('#logindiv').addClass('disable');
		$('#logindiv').removeClass('enable');
		$('#signupdiv').addClass('enable');
		$('#signupdiv').removeClass('disable');
	});
	
	// for facebook login
	window.fbAsyncInit = function() {
		FB.init({
			appId      : '1754268318165046',
			xfbml      : true,
			version    : 'v2.7'
		});
	};

	(function(d, s, id){
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id)) {return;}
		js = d.createElement(s); js.id = id;
		js.src = "//connect.facebook.net/en_US/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));

});