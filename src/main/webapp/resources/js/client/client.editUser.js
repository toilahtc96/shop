checkParam = function() {
	var email = $("#clientEditUserForm\\:email").val();
	var regex = /^[_A-Za-z0-9-\+]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$/;
	if(!regex.test(String(email))){
		alert('Dinh dang email sai: xxx123@gmail.com');
			return false;
	}
	return true;
}