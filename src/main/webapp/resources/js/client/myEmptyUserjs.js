$(document)
		.ready(
				function() {

					addToCart = function(id) {
						if (window
								.confirm("Bạn cần đăng nhập để thêm mới giỏ hàng! Tới Trang Đăng Nhập?")) {
							window.location
									.replace('http://localhost:8080/JavaServerFaces/client/login');
						} else {
						}
					}

				})