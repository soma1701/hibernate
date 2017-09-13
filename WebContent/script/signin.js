function validateEmail() {
		var email = document.getElementById("email").value;
		var pass = document.getElementById("password").value;
		var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

		var isValid = false;
		isValid = re.test(email);
		if (!isValid) {
			alert("email is not valid");
		}

		if (pass == "") {
			alert("password cann't be empty");
			isValid = false;
		}

		return isValid;
}