$(document)
		.ready(
				function() {
					var url = window.location.host;
					var proto = window.location.protocol;
					var pathName = window.location.pathname;
					var rootURL = proto + "//" + url;
					var urlLogin = rootURL + '/JavaServerFaces/client/login';
					addToCart = function(id) {
						if (window
								.confirm("Bạn cần đăng nhập để thêm mới giỏ hàng! Tới Trang Đăng Nhập?")) {
							window.location.replace(urlLogin);
						} else {
						}
					}

				})