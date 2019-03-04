checkParam = function() {
	$.removeCookie('cartArray', { path: '/' });
	var password = $('#contactForm\\:password').val();
	var username = $('#contactForm\\:name').val();
	if (password === "" || username === "") {
		alert('Can nhap du thong tin');
		return false;
	}
	return true;
}

