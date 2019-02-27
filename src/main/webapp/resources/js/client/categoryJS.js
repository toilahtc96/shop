$(document)
		.ready(
				function() {
					
					var cartDB = $("#formCate\\:cartInCate").val();

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
								var cartArrayJs = JSON.parse($
										.cookie("cartArray"));
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
									$("#formCate\\:cartInCate").val(cartArrStr);
									$.cookie("cartArray", cartArrStr, {
										path : '/'
									});
									console
											.log("cart them moi 1: "
													+ $(
															"#formCate\\:cartInCate")
															.val());
									alert("Đã Thêm Mới");
								} else {
									cartArrStr = JSON.stringify(cartArr);
									$("#formCate\\:cartInCate").val(cartArrStr);
									$.cookie("cartArray", cartArrStr, {
										path : '/'
									});
									console
											.log("cart da co: "
													+ $(
															"#formCate\\:cartInCate")
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
								$("#formCate\\:cartInCate").val(cartArrStr);
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
							$("#formCate\\:cartInCate").val("");
							alert($("#formCate\\:cartInCate").val());
							return true;
						} else {
							return false;
						}
					}
					increatmentNum = function(index) {
						var x = $(this).parent().find("#sst");
						alert(x);
						var result = document
								.getElementById('cartForm\:cartData\:' + index
										+ '\:sst');
						var sst = result.value;
						if (!isNaN(sst))
							result.value++;
						return false;
					}
					descripmentNum = function(index) {
						var result = document
								.getElementById('cartForm\:cartData\:' + index
										+ '\:sst');
						var sst = result.value;
						if (!isNaN(sst) && sst > 0)
							result.value--;
						return false;
					}

					function handleAjax(data) {
						
						var status = data.status;

						switch (status) {
						case "begin":
							// This is the start of the AJAX request.
							console.log("begin");
							document.getElementsByTagName('body')[0].className = 'loading';
							break;

						case "complete":
							console.log("complete");
							// This is invoked right after AJAX response is
							// returned.
							break;

						case "success":
							console.log("success");
							// This is invoked right after successful processing
							// of AJAX response and update of HTML DOM.
							document.getElementsByTagName('body')[0].className = 'loading';
							break;
						}
					}
					// Setup the statusUpdate function to hear all events on the
					// page
					jsf.ajax.addOnEvent(handleAjax);

				})