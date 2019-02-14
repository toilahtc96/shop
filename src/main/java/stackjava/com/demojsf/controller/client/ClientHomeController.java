package stackjava.com.demojsf.controller.client;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import stackjava.com.demojsf.model.Product;
import stackjava.com.demojsf.service.ProductService;

@SuppressWarnings("serial")
@ManagedBean(name = "clientHomeController")
@SessionScoped
@URLMapping(id = "homeClientController", pattern = "/topChanGa", viewId = "/client/home.xhtml")
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

}
