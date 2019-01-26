package stackjava.com.demojsf.controller;

import java.io.Serializable;
import java.util.List;

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
import stackjava.com.demojsf.service.ProductService;

@ManagedBean
@SessionScoped
@URLMappings(mappings = { @URLMapping(id = "product", pattern = "/products", viewId = "/listProduct.xhtml"),
		@URLMapping(id = "addProduct", pattern = "/createProduct", viewId = "/createProduct.xhtml") })
public class ProductController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Product> list;
	

	@ManagedProperty(value = "#{productService}")
	ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}
	
	@ManagedProperty(value = "#{createProductForm}")
	CreateProductForm createProductForm;

	
	
	public CreateProductForm getCreateProductForm() {
		if(createProductForm == null) {
			createProductForm = new CreateProductForm();
		}
		return createProductForm;
	}

	public void setCreateProductForm(CreateProductForm createProductForm) {
		this.createProductForm = createProductForm;
	}

	@ManagedProperty(value = "#{updateProductForm}")
	UpdateProductForm updateProductForm;
	

	public void setUpdateProductForm(UpdateProductForm updateProductForm) {
		this.updateProductForm = updateProductForm;
	}
	
	public String getCreateProduct() {
		String proName = this.createProductForm.getProName();
		System.out.println(proName);
		Product pro = new Product();
		pro.setProName(proName);
		productService.add(pro);
		System.out.println("sussceess");
		return "listProduct";
	}

	public String getUpdateProduct() {
		int id = updateProductForm.getProId();
		// Category cate = categoryDAO.getById(id);
		String name = updateProductForm.getProName();
		// cate.setCatName(updateProductForm.getCatName());
//		Category cate = new Category(id, name, null, null, null, null, null, null, null, null, null, null, null, null,
//				null, null);
//		productService.update(id, cate);
		return "listProduct";
	}

	public String updateProduct() {

		FacesContext fc = FacesContext.getCurrentInstance();
		int id = (Integer.parseInt(fc.getExternalContext().getRequestParameterMap().get("id")));
		Product pro = productService.getById(id);
		updateProductForm = new UpdateProductForm();
		updateProductForm.setProName(pro.getProName());
		updateProductForm.setProId(pro.getProId());
		return "updateProduct";
	}

	public String deleteProduct() {
		// Category cate = productService.getById(1);
		// if (cate == null) {
		// System.out.println("xxxxx");
		// } else {
		// System.out.println(cate.getCatName());
		// }
		FacesContext fc = FacesContext.getCurrentInstance();
		int id = (Integer.parseInt(fc.getExternalContext().getRequestParameterMap().get("id")));
		// Category cate = categoryDAO.getById(id);
		// updateProductForm = new updateProductForm();
		// updateProductForm.setCatName(cate.getCatName());
		// updateProductForm.setCatID(cate.getCatId());
		productService.removeById(id);
		return "listProduct";
	}

}
