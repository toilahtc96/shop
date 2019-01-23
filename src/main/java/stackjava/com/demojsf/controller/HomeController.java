package stackjava.com.demojsf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.ocpsoft.pretty.faces.annotation.URLMapping;

import stackjava.com.demojsf.form.CategoryForm;
import stackjava.com.demojsf.form.CategoryFormNew;
import stackjava.com.demojsf.model.Category;
import stackjava.com.demojsf.service.CategoryService;

@ManagedBean
@SessionScoped
@URLMapping(id = "category", pattern = "/category", viewId = "/ListCategory.xhtml")
public class HomeController {

	List<Category> list;

	@ManagedProperty(value = "#{categoryService}")
	CategoryService categoryService;

	public CategoryService getCategoryService() {
	
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	CategoryFormNew categoryForm;

	public CategoryFormNew getCategoryForm() {
		if (categoryForm == null)
			categoryForm = new CategoryFormNew();
		return categoryForm;
	}

	public void setCategoryForm(CategoryFormNew categoryForm) {
		this.categoryForm = categoryForm;
	}

	public HomeController() {
		super();
	}

	public List<Category> getList() {
		return this.list = categoryService.getAll();
	}

	public void setList(List<Category> list) {
		this.list = list;
	}

	public String getCreateCategory() {
		String categoryName = this.categoryForm.getCatName();
		Category cat = new Category();
		cat.setCatName(categoryName);
		categoryService.add(cat);
		System.out.println("sussceess");
		return "index";
	}

	public String getUpdateCategory() {
		String catName = this.categoryForm.getCatName();
		return "";
	}

	public String updateCategory() {

//		FacesContext fc = FacesContext.getCurrentInstance();

//		int id= (Integer.parseInt(fc.getExternalContext().getRequestParameterMap().get("id")));
		Category cate = categoryService.getById(1);
		if (cate == null) {
			System.out.println("xxxxx");
		} else {
			System.out.println(cate.getCatName());
		}
		categoryForm.setCatName("test");
		return "index";
		// sau thay trang nay = 1 trang update moi
	}

	// public List<Category> getListCategory(){
	// list = categoryService.getAll();
	// return list;
	// }
	public static void main(String[] args) {
		CategoryService cates = new CategoryService();
		cates.getById(1);
	}
}
