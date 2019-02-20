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
				var product_id = id;
				if ($.cookie("cartArray") != undefined) {
					var cartArrayJs = JSON.parse($.cookie("cartArray"));
					var list_id = [];
					for (i = 0; i < cartArrayJs.length; i++) {
						list_id.push((cartArrayJs[i][0]));
					}
					if (!list_id.includes(product_id)) {
						var item = [ product_id, "1" ];
						if (typeof cartArr === "string") {
							cartArr = JSON.parse(cartArr);
						}
						console.log(typeof cartArr);
						cartArr.push(item);
						cartArrStr = JSON.stringify(cartArr);
						console.log(cartArrStr);
						$("#homeForm\\:cart").val(cartArrStr);
						$.cookie("cartArray", cartArrStr, {
							path : '/'
						});
						alert("Đã Thêm Mới");
					} else {
						alert("Sản Phẩm Đã Có Trong Giở Hàng Của Bạn");
					}
				} else {
					var item = [ product_id, "1" ];
					cartArr.push(item);
					cartArrStr = JSON.stringify(cartArr);
					$.cookie("cartArray", cartArrStr, {
						path : '/'
					});
					$("#homeForm\\:cart").val(cartArrStr);
					alert("Đã Thêm Mới");

				}
			} else {
			}
		}

		return true;
	}

})