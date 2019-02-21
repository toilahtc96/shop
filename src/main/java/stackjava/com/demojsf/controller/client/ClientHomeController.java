package stackjava.com.demojsf.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.xpath.operations.Or;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import net.minidev.json.parser.JSONParser;
import stackjava.com.demojsf.common.CommonController;
import stackjava.com.demojsf.form.CartToClientForm;
import stackjava.com.demojsf.form.CartUpdatedForm;
import stackjava.com.demojsf.form.OrdersForm;
import stackjava.com.demojsf.model.Order;
import stackjava.com.demojsf.model.OrderDetail;
import stackjava.com.demojsf.model.Product;
import stackjava.com.demojsf.model.User;
import stackjava.com.demojsf.service.OrderDetailService;
import stackjava.com.demojsf.service.OrderService;
import stackjava.com.demojsf.service.ProductService;

@SuppressWarnings("serial")
@ManagedBean(name = "clientHomeController", eager = true)
@SessionScoped
@URLMappings(mappings = { @URLMapping(id = "clientHome", pattern = "/client/home", viewId = "/client/home.xhtml"),
		@URLMapping(id = "clientCart", pattern = "/client/cart", viewId = "/client/cart.xhtml"),
		@URLMapping(id = "clientCheckout", pattern = "/client/checkout", viewId = "/client/checkout.xhtml"),
		@URLMapping(id = "clientCategory", pattern = "/client/categories", viewId = "/client/category.xhtml"),
		@URLMapping(id = "clientOrder", pattern = "/client/orders", viewId = "/client/order.xhtml"),
		@URLMapping(id = "clientRegister", pattern = "/client/register", viewId = "/client/register.xhtml"),
		@URLMapping(id = "clientConfirmation", pattern = "/client/confirmation", viewId = "/client/confirmation.xhtml"),
		@URLMapping(id = "clientProductDetail", pattern = "/client/productDetail", viewId = "/client/productDetail.xhtml"),
		@URLMapping(id = "clientContact", pattern = "/client/contact", viewId = "/client/contact.xhtml") })
public class ClientHomeController extends CommonController implements Serializable {

	private static final long serialVersionUID = 1L;
	List<Product> list;

	@ManagedProperty(value = "#{orderDetailService}")
	private OrderDetailService orderDetailService;

	public void setOrderDetailService(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}

	@ManagedProperty(value = "#{orderService}")
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	private String cart;

	public String getCart() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getExternalContext().getSessionMap().get("cartArray") != null) {
			System.out.println(context.getExternalContext().getSessionMap().get("cartArray").toString());
			parse(context.getExternalContext().getSessionMap().get("cartArray").toString());
			return context.getExternalContext().getSessionMap().get("cartArray").toString();
		}

		return cart;
	}

	public void setCart(String cart) {
		this.cart = cart;
	}

	public void updateCart(AjaxBehaviorEvent event) {

		parse(this.getCart());/*
								 * FacesContext context = FacesContext.getCurrentInstance();
								 * context.getExternalContext().getSessionMap().put("cartArray",
								 * this.getCart());
								 */
		System.out.println("ajax call");
	}

	/*
	 * private String test;
	 * 
	 * public String getTest() { return this.parse(this.getCart()); }
	 * 
	 * public void setTest(String test) { this.test = test; }
	 */
	private List<CartUpdatedForm> lstIdProductInCart;

	public List<CartUpdatedForm> getLstIdProductInCart() {
		return lstIdProductInCart;
	}

	public void setLstIdProductInCart(List<CartUpdatedForm> lstIdProductInCart) {
		this.lstIdProductInCart = lstIdProductInCart;
	}

	private List<OrdersForm> lstOrder;

	public List<OrdersForm> getLstOrder() {
		System.out.println("getOrder");
		FacesContext context = FacesContext.getCurrentInstance();
		User u = (User) context.getExternalContext().getSessionMap().get("user");
		int userId = u.getUserId();
		List<Order> lstGetByUserId = orderService.getAllByUserId(userId);
		lstOrder = new ArrayList<OrdersForm>();
		for (Order order : lstGetByUserId) {
			OrdersForm orderForm = new OrdersForm();
			orderForm.setOrdetId(order.getOrderId());
			orderForm.setCreateDate(order.getOrderCreatedAt());
			if (order.getOrderStatus() == 1) {
				orderForm.setStatus("Đã hoàn tất");
			}
			if (order.getOrderStatus() == 2) {
				orderForm.setStatus("Đang chờ");
			}
			if (order.getOrderStatus() == 3) {
				orderForm.setStatus("Có lỗi!");
			}
			orderForm.setTotalPrice(order.getOrderTotalFrice());
			orderForm.setUserName(u.getUserName());
			lstOrder.add(orderForm);
		}
		return lstOrder;
	}

	public void setLstOrder(List<OrdersForm> lstOrder) {
		this.lstOrder = lstOrder;
	}

	public String getHome() {
		return "home?faces-redirect=true";
	}

	public String getCreateOrder() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (lstIdProductInCart != null) {

			float total = 0;
			Order order = new Order();

			User u = (User) context.getExternalContext().getSessionMap().get("user");
			lstOrder = this.getLstOrder();
			List<OrderDetail> lstDetail = new ArrayList<OrderDetail>();
			for (CartUpdatedForm product : lstIdProductInCart) {

				int id = product.getPro().getProId();
				int qty = 10;
				if (product.getQuantity() != null) {
					qty = product.getQuantity();
				} else {
					qty = 9;
				}
				CartUpdatedForm cartOrder = new CartUpdatedForm();
				cartOrder.setPro(productService.getById(id) != null ? productService.getById(id) : null);
				cartOrder.setQuantity(qty);

				System.out.println("quantity: " + qty);
				total += qty * product.getPro().getProPrice();
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setOrdetCreatedAt(new Date());
				orderDetail.setOrdetNote("");
				orderDetail.setOrdetProductId(id);
				orderDetail.setOrdetQuantity(qty);
				orderDetail.setOrdetStatus(1);
				lstDetail.add(orderDetail);
			}
			order.setOrderTotalFrice(total);
			order.setOrderCreatedAt(new Date());
			order.setOrderStatus(1);
			order.setOrderUserId(u.getUserId() != null ? u.getUserId() : -1);
			int orderid = orderService.add(order);
			for (OrderDetail orderDetail : lstDetail) {
				orderDetail.setOrdetOrderId(orderid);
				orderDetailService.add(orderDetail);
			}
			lstIdProductInCart.clear();

		} else {
			System.out.println("list Null");
		}
		return "order?faces-redirect=true";
	}

	public String parse(String jsonLine) {
		lstIdProductInCart = new ArrayList<CartUpdatedForm>();
		JsonElement jelement = new JsonParser().parse(jsonLine);
		JsonArray jobject = jelement.getAsJsonArray();
		for (JsonElement jsonElement : jobject) {
			String productQuantity = jsonElement.toString();
			String text01 = productQuantity.split("\\[")[1];
			String text02 = text01.split("\\]")[0];
			String id = text02.split(",")[0];
			String quantity = text02.split(",")[1].split("\"")[1];
			Product pro = productService.getById(Integer.parseInt(id));
			CartUpdatedForm cartUpdateForm = new CartUpdatedForm();
			cartUpdateForm.setPro(pro);
			cartUpdateForm.setQuantity(Integer.parseInt(quantity));
			lstIdProductInCart.add(cartUpdateForm);
		}
		return "";
	}

	@ManagedProperty(value = "#{productService}")
	ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Product> getList() {
		return this.list = productService.getAll();
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	List<Product> listFilter;

	public List<Product> getListFilter() {
		return this.listFilter = productService.getListFilter();
	}

	public void setListFilter(List<Product> listFilter) {
		this.listFilter = listFilter;
	}

}
