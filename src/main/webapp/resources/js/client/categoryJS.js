$(document).ready(
		function() {

			var cartDB = $("#formCate\\:cart").val();

			if (cartDB != "") {

				$.cookie("cartArray", cartDB, {
					path : '/'
				});
			}
			cartArr = [];
			if ($.cookie("cartArray")) {
				var cartArr = JSON.parse($.cookie("cartArray"));

			}
			addToCart = function(id) {

				if (window.confirm("Thêm Sản Phẩm Vào Giở Hàng?")) {
					var product_id = id;
					if ($.cookie("cartArray") != undefined) {
						console.log($.cookie("cartArray"));
						var cartArrayJs = JSON.parse($.cookie("cartArray"));
						var list_id = [];
						for (i = 0; i < cartArrayJs.length; i++) {
							list_id.push((cartArrayJs[i][0]));
							console.log((cartArrayJs[i][0]));
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
							$("#formCate\\:cart").val(cartArrStr);
							$.cookie("cartArray", cartArrStr, {
								path : '/'
							});
							console.log("cart them moi 1: "
									+ $("#formCate\\:cart").val());
							alert("Đã Thêm Mới");
						} else {
							cartArrStr = JSON.stringify(cartArr);
							$("#formCate\\:cart").val(cartArrStr);
							$.cookie("cartArray", cartArrStr, {
								path : '/'
							});
							console.log("cart da co: "
									+ $("#formCate\\:cart").val());
							alert("Sản Phẩm Đã Có Trong Giở Hàng Của Bạn");
						}
					} else {
						console.log("not have cart");
						let cartArr = [];
						var item = [ product_id, "1" ];
						cartArr.push(item);
						cartArrStr = JSON.stringify(cartArr);
						$.cookie("cartArray", cartArrStr, {
							path : '/'
						});
						$("#formCate\\:cart").val(cartArrStr);
						console.log("cart them moi: "
								+ $("#homeForm\\:cart").val());
						alert("Đã Thêm Mới");

					}
				} else {
					return false;
				}

				return true;
			}
			confirmCreateOrder = function() {
				if (window.confirm("Xác nhận tạo đơn hàng mới?")) {
					$.removeCookie('cartArray', {
						path : '/'
					});
					$("#formCate\\:cart").val("");
					alert($("#formCate\\:cart").val());
					return true;
				} else {
					return false;
				}
			}
			increatmentNum = function(index) {
				var x = $(this).parent().find("#sst");
				alert(x);
				var result = document.getElementById('cartForm\:cartData\:'
						+ index + '\:sst');
				var sst = result.value;
				if (!isNaN(sst))
					result.value++;
				return false;
			}
			descripmentNum = function(index) {
				var result = document.getElementById('cartForm\:cartData\:'
						+ index + '\:sst');
				var sst = result.value;
				if (!isNaN(sst) && sst > 0)
					result.value--;
				return false;
			}

		})