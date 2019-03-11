package stackjava.com.demojsf.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.Cookie;
import javax.servlet.http.Part;
import javax.xml.ws.Action;

import org.openqa.selenium.remote.server.handler.GetCookie;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLBeanName;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import stackjava.com.demojsf.common.CommonController;
import stackjava.com.demojsf.dao.ProductDAO;
import stackjava.com.demojsf.form.CreateProductForm;
import stackjava.com.demojsf.form.ProductDetailForm;
import stackjava.com.demojsf.form.UpdateCategoryForm;
import stackjava.com.demojsf.form.UpdateProductForm;
import stackjava.com.demojsf.model.Category;
import stackjava.com.demojsf.model.Product;
import stackjava.com.demojsf.service.CategoryService;
import stackjava.com.demojsf.service.ProductService;

@ManagedBean(name = "productController")
@SessionScoped
@URLMappings(mappings = { @URLMapping(id = "product", pattern = "/admin/products", viewId = "/admin/listProduct.xhtml"),
		@URLMapping(id = "addProductx", pattern = "/admin/createProduct", viewId = "/admin/createProduct.xhtml"),
		@URLMapping(id = "clientProductDetail", pattern = "/client/productDetail", viewId = "/client/productDetail.xhtml"),
		@URLMapping(id = "updateProductx", pattern = "/admin/updateProduct", viewId = "/admin/updateProduct.xhtml") })
public class ProductController extends CommonController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Product> list;

	private int idCate;

	@PostConstruct
	public void init() {

	}

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

	@ManagedProperty(value = "#{productDetailForm}")
	ProductDetailForm productDetailForm;

	public ProductDetailForm getProductDetailForm() {
		if (productDetailForm == null) {
			productDetailForm = new ProductDetailForm();
		}
		return productDetailForm;
	}

	public void setProductDetailForm(ProductDetailForm productDetailForm) {
		this.productDetailForm = productDetailForm;
	}

	public String addAbcProduct() {
		System.out.println("add Product");
		String proName = " ";
		if (this.createProductForm.getProName() != null) {
			proName = this.createProductForm.getProName();
		}

		int idCategory = 1;
		Part image = this.createProductForm.getProImg();
		this.setImage(image);
		Product pro = new Product();
		pro.setProName(proName);
		pro.setProCategoryId(idCategory);

		if (this.createProductForm.getProImg() != null) {
			String folderName = "product";
			String imageName = this.createProductForm.getProImg().getSubmittedFileName();
			doUpLoad(folderName, imageName, this.createProductForm.getProImg());
		} else {
			System.out.println("null");
		}
		// productService.add(pro);
		return "/admin/listProduct?faces-redirect=true";
	}

	public String getPathImge() {
		String projectDir = new File("").getAbsolutePath();
		
		String path = projectDir+"\\src\\main\\webapp\\resources\\img";
		return path;
	}
	public String doUpdateProduct() {
		int id = updateProductForm.getProId();
		String name = updateProductForm.getProName();
		Product pro = new Product(id, name, null, null, null, null, null, null, null, null, null);
		productService.update(id, pro);
		return "listProduct?faces-redirect=true";

		// updateCategoryForm = new UpdateCategoryForm();
		// updateCategoryForm.setCatName(cate.getCatName());
		// updateCategoryForm.setCatID(cate.getCatId());
		// return "updateCategory?faces-redirect=true";
	}

	public String productDetail(int id) {
		
		// FacesContext fc = FacesContext.getCurrentInstance();
		// int id =
		// (Integer.parseInt(fc.getExternalContext().getRequestParameterMap().get("id")));
		// System.out.println(id);
		Product pro = productService.getById(id);
		productDetailForm = new ProductDetailForm();
		productDetailForm.setProID(pro.getProId());
		productDetailForm.setProName(pro.getProName());
		productDetailForm.setProPrice(pro.getProPrice());
		return "productDetail?faces-redirect=true";
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

	List<Product> listProGetByIdCate;

	public List<Product> getListProGetByIdCate() {
		return listProGetByIdCate;
	}

	public void setListProGetByIdCate(List<Product> listProGetByIdCate) {
		this.listProGetByIdCate = listProGetByIdCate;
	}

}
