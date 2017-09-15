
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1 charset =UTF-8">
<link rel="stylesheet" type="text/css" href="css/signin.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" 
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"crossorigin="anonymous"/>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous">
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous">
</script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous">
</script>

<title>Signin page</title>

</head>
<body>
	<div class="container">
		<h2>sign in</h2>
		<hr>
		<form action="signin" name="signin" method="post" onsubmit="return validateEmail()">
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<h2>use other account</h2>
						<p>You can also sign in using facebook account and google
							account</p>
						<br>
						<button id="facebook" class="btn facebook" style="background-color: blue">
							login using facebook</button>
						<br> <br>
						<button id="google" type="button" class="btn google"
							style="background-color: black">login using google</button>
					</div>
				</div>
				<div class="col-sm-6 right">
					<div class="form-group">
						<h3>Using your account</h3>
						<input id="email" class="email" type="text" name="email" placeholder="Enter ur mail"><br>
						<input id="password" class="password" type="password" name="password" placeholder="Enter ur password"><br>
						<input type="hidden" value="LOGIN" name="ACTION_MODE"> <br>
						<input type="submit" value="Submit" class="submit">
						<br> <br>
						<a href="">Forgot ur password?</a><a href="Registration.jsp">register</a>
					</div>
				</div>
				</div>
		</form>
	</div>
</body>
</html>