checkParam = function() {
	var name = $('#createUserForm\\:name').val();
	var pass1 = $('#createUserForm\\:pass1').val();
	var pass2 = $('#createUserForm\\:pass2').val();
	var number = $('#createUserForm\\:number').val();
	var address = $('#createUserForm\\:address').val();
	var email = $('#createUserForm\\:email').val();
	var dob = $('#createUserForm\\:dob').val();
	if (name === "" || pass1 === "" || pass2 === "" || number === ""
			|| address === "" || email === "" || dob === "") {
		alert('Can nhap du thong tin!');
		return false;
	}
	if (pass1 !== pass2) {
		alert('Xac nhan mat khau khong trung khop!');
		return false;
	}
	return true;
}