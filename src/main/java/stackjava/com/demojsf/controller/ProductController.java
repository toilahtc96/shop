package stackjava.com.demojsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import stackjava.com.demojsf.dao.ProductDAO;
import stackjava.com.demojsf.form.CreateProductForm;
import stackjava.com.demojsf.form.UpdateProductForm;
import stackjava.com.demojsf.model.Category;
import stackjava.com.demojsf.model.Product;
import stackjava.com.demojsf.service.CategoryService;
import stackjava.com.demojsf.service.ProductService;

@ManagedBean(name = "productController")
@SessionScoped
@URLMappings(mappings = { @URLMapping(id = "product", pattern = "/products", viewId = "/listProduct.xhtml"),
		@URLMapping(id = "addProduct", pattern = "/createProduct", viewId = "/createProduct.xhtml"),
		@URLMapping(id = "updateProduct", pattern = "/updateProduct", viewId = "/updateProduct.xhtml") })
public class ProductController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Product> list;

	private int idCate;
	
	public int getIdCate() {
		return idCate;
	}

	public void setIdCate(int idCate) {
		this.idCate = idCate;
	}

	@ManagedProperty(value = "#{productService}")
	ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ProductController() {
		super();
	}

	public List<Product> getList() {
		return this.list = productService.getAll();
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	@ManagedProperty(value = "#{createProductForm}")
	CreateProductForm createProductForm;

	public CreateProductForm getCreateProductForm() {
		if (createProductForm == null) {
			createProductForm = new CreateProductForm();
		}
		return createProductForm;
	}

	public void setCreateProductForm(CreateProductForm createProductForm) {
		this.createProductForm = createProductForm;
	}

	@ManagedProperty(value = "#{updateProductForm}")
	UpdateProductForm updateProductForm;

	public UpdateProductForm getUpdateProductForm() {

		if (updateProductForm == null) {
			updateProductForm = new UpdateProductForm();
		}

		return updateProductForm;
	}

	public void setUpdateProductForm(UpdateProductForm updateProductForm) {
		this.updateProductForm = updateProductForm;
	}
	
	public String getCreateProduct() {
		String proName = this.createProductForm.getProName();
		int idCategory = this.getIdCate();
		Product pro = new Product();
		pro.setProName(proName);
		pro.setProCategoryId(idCategory);
		productService.add(pro);
		return "listProduct?faces-redirect=true";
	}

	public String doUpdateProduct() {
		int id = updateProductForm.getProId();
		String name = updateProductForm.getProName();
		Product pro = new Product(id, name, null, null, null, null, null, null, null, null, null);
		productService.update(id, pro);
		return "listProduct?faces-redirect=true";
	}

	public String updateProduct() {
		FacesContext fc = FacesContext.getCurrentInstance();
		int id = (Integer.parseInt(fc.getExternalContext().getRequestParameterMap().get("id")));
		Product pro = productService.getById(id);
		updateProductForm = new UpdateProductForm();
		updateProductForm.setProName(pro.getProName());
		updateProductForm.setProId(pro.getProId());
		return "updateProduct?faces-redirect=true";
	}
	
	public String deleteProduct() {
		FacesContext fc = FacesContext.getCurrentInstance();
		int id = (Integer.parseInt(fc.getExternalContext().getRequestParameterMap().get("id")));
		productService.removeById(id);
		return "listProduct?faces-redirect=true";
	}

}
