package stackjava.com.demojsf.controller.client;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import stackjava.com.demojsf.model.Product;
import stackjava.com.demojsf.service.ProductService;

@SuppressWarnings("serial")
@ManagedBean(name = "clientHomeController")
@SessionScoped
@URLMappings(mappings = { @URLMapping(id = "clientHome", pattern = "/client/home", viewId = "/client/home.xhtml"),
		@URLMapping(id = "clientCart", pattern = "/client/cart", viewId = "/client/cart.xhtml"),
		@URLMapping(id = "clientCheckout", pattern = "/client/checkout", viewId = "/client/checkout.xhtml"),
		@URLMapping(id = "clientLogin", pattern = "/client/login", viewId = "/client/login.xhtml"),
		@URLMapping(id = "clientConfirmation", pattern = "/client/confirmation", viewId = "/client/confirmation.xhtml"),
		@URLMapping(id = "clientProductDetail", pattern = "/client/productDetail", viewId = "/client/productDetail.xhtml"),
		@URLMapping(id = "clientContact", pattern = "/client/contact", viewId = "/client/contact.xhtml") })
public class ClientHomeController implements Serializable {

	private static final long serialVersionUID = 1L;
	List<Product> list;
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
