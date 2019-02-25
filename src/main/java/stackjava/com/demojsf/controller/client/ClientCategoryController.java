package stackjava.com.demojsf.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.hibernate.internal.jaxb.SourceType;

import stackjava.com.demojsf.dao.ProductDAO;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import stackjava.com.demojsf.form.CartUpdatedForm;
import stackjava.com.demojsf.model.Cart;
import stackjava.com.demojsf.model.Category;
import stackjava.com.demojsf.model.Product;
import stackjava.com.demojsf.model.User;
import stackjava.com.demojsf.service.CartService;
import stackjava.com.demojsf.service.CategoryService;
import stackjava.com.demojsf.service.OrderDetailService;
import stackjava.com.demojsf.service.ProductService;

@ManagedBean
@SessionScoped
public class ClientCategoryController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sortString;
	private int pageCurrent;
	private int pageSize;
	private static int PAGESIZE = 10;
	private long totalPage;
	private List<Integer> listPage;
	private int idCateCurrent;

	public int getIdCateCurrent() {
		return idCateCurrent;
	}

	public void setIdCateCurrent(int idCateCurrent) {
		this.idCateCurrent = idCateCurrent;
	}

	public List<Integer> getListPage() {
		return listPage;
	}

	public void setListPage(List<Integer> listPage) {
		this.listPage = listPage;
	}

	@PostConstruct
	public void init() {
		this.setTotalPage(productService.countTotalRecords());
		if (this.pageCurrent <= 0) {
			this.setPageCurrent(1);
			System.out.println("so page " + (productService.countTotalRecords() / PAGESIZE + 1));
			System.out.println("set page In clientCateController");
		}
		if (this.getSortString() == null || this.getSortString().equals("")) {
			this.setSortString("Sort Product By");
		}
		if (this.getList() == null) {
			listCate = this.getListCate();
			idCateCurrent = listCate.get(0).getCatId();
			System.out.println(listCate.get(0).getCatId());
			if (listCate.get(0) != null) {
				this.list = productService.getListPRoByIdCate(listCate.get(0).getCatId(), (pageCurrent - 1) * pageSize,
						this.getPageSize());
				System.out.println("page total: " + this.list.size());
				this.setTotalPage(this.list.size() / PAGESIZE + 1);
				int check = (this.list.size() / PAGESIZE) + 1;
				System.out.println("so page : " + check);
				List<Integer> listPageSet = new ArrayList<Integer>();
				for (int i = 1; i <= this.getTotalPage(); i++) {
					listPageSet.add(i);
				}
				this.setListPage(listPageSet);
			}
		}
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return PAGESIZE;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public String getSortString() {

		return sortString;
	}

	public void setSortString(String sortString) {
		this.sortString = sortString;
	}

	private String cartInCate;

	public String getCartInCate() {
		return cartInCate;
	}

	public void setCartInCate(String cartInCate) {
		this.cartInCate = cartInCate;
	}

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

	public List<Product> getList() {

		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	@ManagedProperty(value = "#{cartService}")
	private CartService cartService;

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	private List<CartUpdatedForm> lstIdProductInCart;

	public List<CartUpdatedForm> getLstIdProductInCart() {
		return lstIdProductInCart;
	}

	public void setLstIdProductInCart(List<CartUpdatedForm> lstIdProductInCart) {
		this.lstIdProductInCart = lstIdProductInCart;
	}

	@ManagedProperty(value = "#{productService}")
	ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Product> getListProByIdCate(int catId) {
		this.setIdCateCurrent(catId);
		List<Product> listPro = new ArrayList<Product>();
		listPro = productService.getListPRoByIdCate(catId, (pageCurrent - 1) * pageSize, this.getPageSize());
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

	@ManagedProperty(value = "#{productDAO}")
	ProductDAO productDAO;

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public List<Product> getListProByIdCateSort() {
		if (value.equals("") || value.equals("Price")) {
			list = productDAO.getListProByIdCate(idCateCurrent, (pageCurrent - 1) * pageSize, this.getPageSize());
		} else if (value.equals("Date")) {
			list = productDAO.getListProByIdCateSortByDate(idCateCurrent);
		} else if (value.equals("Name")) {
			list = productDAO.getListProByIdCateSortByName(idCateCurrent);
		}
		return list;
	}

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
	public void updateCart(AjaxBehaviorEvent event) {

		if (this.getCartInCate() != null && !this.getCartInCate().equals("")) {
			System.out.println("1");
			parse(this.getCartInCate());
		}
		System.out.println("2");
		/*
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * context.getExternalContext().getSessionMap().put("cartArray",
		 * this.getCart());
		 */
		System.out.println("ajax call");
	}

	public int getUserId() {
		FacesContext context = FacesContext.getCurrentInstance();
		User u = (User) context.getExternalContext().getSessionMap().get("user");
		if (u != null) {
			return u.getUserId();
		} else {
			return -1;
		}
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
		Cart cart = new Cart();
		cart.setCarCreatedAt(new Date());
		cart.setCarListProductQuantity(jsonLine);
		cart.setCarStatus(1);
		cart.setCarUserId(this.getUserId());

		if (cartService.getByUserId(this.getUserId()) != null) {
			System.out.println("not null");
			System.out.println(jsonLine);
			cart.setCarId(cartService.getByUserId(this.getUserId()).getCarId());
			cartService.update(cart.getCarId(), cart);
		} else {
			cartService.add(cart);
			return "/client/login";
		}

		return "";
	}

}
