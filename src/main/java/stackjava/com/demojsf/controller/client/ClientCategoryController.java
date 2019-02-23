package stackjava.com.demojsf.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import stackjava.com.demojsf.dao.ProductDAO;
import stackjava.com.demojsf.model.Category;
import stackjava.com.demojsf.model.Product;
import stackjava.com.demojsf.service.CategoryService;
import stackjava.com.demojsf.service.ProductService;

@ManagedBean
@SessionScoped
public class ClientCategoryController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Product> list;

	@ManagedProperty(value = "#{categoryService}")
	CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	List<Category> listCate;

	public List<Category> getListCate() {
		return this.listCate = categoryService.getAll();
	}

	public void setListCate(List<Category> listCate) {
		this.listCate = listCate;
	}

	private String startList;

	public String getStartList() {
		if (this.getList() == null) {
			listCate = this.getListCate();
			System.out.println(listCate.get(0).getCatId());
			if (listCate.get(0) != null) {
				this.list = productService.getListPRoByIdCate(listCate.get(0).getCatId());
			}
		}
		return startList;
	}

	public void setStartList(String startList) {

		this.startList = startList;
	}

	public List<Product> getList() {

		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	@ManagedProperty(value = "#{productService}")
	ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Product> getListProByIdCate(int catId) {
		List<Product> listPro = new ArrayList<Product>();
		listPro = productService.getListPRoByIdCate(catId);
		this.setList(listPro);
		return listPro;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	// @ManagedProperty(value = "#{productDAO}")
	// ProductDAO productDAO;
	//
	// public ProductDAO getProductDAO() {
	// return productDAO;
	// }
	//
	// public void setProductDAO(ProductDAO productDAO) {
	// this.productDAO = productDAO;
	// }
	//
	// public List<Product> getListProByIdCateSortByDate(int catId) {
	// List<Product> listPro = new ArrayList<Product>();
	// listPro = productDAO.getListProByIdCateSortByDate(catId);
	// this.setList(listPro);
	// return listPro;
	// }
	//
	// public List<Product> getListProByIdCateSortByName(int catId) {
	// List<Product> listPro = new ArrayList<Product>();
	// listPro = productDAO.getListProByIdCateSortByName(catId);
	// this.setList(listPro);
	// return listPro;
	// }
	//
	// List<Product> listProSortByDate;
	//
	// List<Product> listProSortByName;
	//
	// public List<Product> getListProSortByDate(int catId) {
	// return this.listProSortByDate =
	// productDAO.getListProByIdCateSortByDate(catId);
	// }
	//
	// public void setListProSortByDate(List<Product> listProSortByDate) {
	// this.listProSortByDate = listProSortByDate;
	// }
	//
	// public List<Product> getListProSortByName(int catId) {
	// return this.listProSortByDate =
	// productDAO.getListProByIdCateSortByName(catId);
	// }
	//
	// public void setListProSortByName(List<Product> listProSortByName) {
	// this.listProSortByName = listProSortByName;
	// }
	//

}
