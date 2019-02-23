$(document).ready(
		function() {
			var cartDB = $("#productDetailForm\\:cartInDetail").val();

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
							$("#productDetailForm\\:cartInDetail").val(
									cartArrStr);
							$.cookie("cartArray", cartArrStr, {
								path : '/'
							});
							console.log("cart them moi 1: "
									+ $("#productDetailForm\\:cartInDetail")
											.val());
							alert("Đã Thêm Mới");
						} else {
							cartArrStr = JSON.stringify(cartArr);
							$("#productDetailForm\\:cartInDetail").val(
									cartArrStr);
							$.cookie("cartArray", cartArrStr, {
								path : '/'
							});
							console.log("cart da co: "
									+ $("#productDetailForm\\:cartInDetail")
											.val());
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
						$("#productDetailForm\\:cartInDetail").val(cartArrStr);
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
					$("#productDetailForm\\:cartInDetail").val("");
					alert($("#productDetailForm\\:cartInDetail").val());
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