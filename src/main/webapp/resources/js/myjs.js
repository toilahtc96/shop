$(document).ready(function() {
	cartArr = [];
	if ($.cookie("cartArray")) {
		var cartArr = JSON.parse($.cookie("cartArray"));
		console.log(cartArr);
	}
	addToCart = function(id) {
		if (!1) {
			if (window.confirm("Bạn cần đăng nhập! Đi tới trang đăng nhập?")) {
				window.location.replace("/login")
			} else {

			}
		} else {

			if (window.confirm("Thêm Sản Phẩm Vào Giở Hàng?")) {
				// They clicked Yes
				var quantity = $(document).find(".a_quantity");
				var quantityNum = quantity.text();
				var product_id = id;
				if ($.cookie("cartArray") != undefined) {
					var cartArrayJs = JSON.parse($.cookie("cartArray"));
					var list_id = [];
					for (i = 0; i < cartArrayJs.length; i++) {
						list_id.push((cartArrayJs[i][0]));
					}
					if (!list_id.includes(product_id)) {
						var item = [ product_id, "1" ];
						cartArr.push(item);
						cartArr = JSON.stringify(cartArr);
						console.log(cartArr);
						$("#homeForm\\:cart").val(cartArr);
						$.cookie("cartArray", cartArr, {
							path : '/'
						});
						alert("Đã Thêm Mới");
					} else {
						alert("Sản Phẩm Đã Có Trong Giở Hàng Của Bạn");
					}
				} else {
					var item = [ product_id, "1" ];
					cartArr.push(item);
					cartArr = JSON.stringify(cartArr);
					$.cookie("cartArray", cartArr, {
						path : '/'
					});
					$("#homeForm\\:cart").val(cartArr);
					alert("Đã Thêm Mới");

				}
			} else {
			}
		}
		return false;
	}
})