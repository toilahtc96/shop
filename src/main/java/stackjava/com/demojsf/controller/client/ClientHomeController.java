package stackjava.com.demojsf.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import net.minidev.json.parser.JSONParser;
import stackjava.com.demojsf.common.CommonController;
import stackjava.com.demojsf.form.CartToClientForm;
import stackjava.com.demojsf.model.Product;
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

	private String cart;

	public String getCart() {
		return cart;
	}

	public void setCart(String cart) {
		this.cart = cart;
	}

	public void updateCart(AjaxBehaviorEvent event) {
		parse(this.getCart());
		System.out.println("test ajax" + this.getCart());

	}

	

	/*
	 * private String test;
	 * 
	 * public String getTest() { return this.parse(this.getCart()); }
	 * 
	 * public void setTest(String test) { this.test = test; }
	 */
	public String parse(String jsonLine) {
		JsonElement jelement = new JsonParser().parse(jsonLine);
		JsonArray jobject = jelement.getAsJsonArray();
		for (JsonElement jsonElement : jobject) {
			String productQuantity = jsonElement.toString();
			String text01 = productQuantity.split("\\[")[1];
			String text02 = text01.split("\\]")[0];
			String id = text02.split(",")[0];
			String quantity =  text02.split(",")[1];
			System.out.println("id: " + id);
			System.out.println("quantity: "+ quantity);
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
