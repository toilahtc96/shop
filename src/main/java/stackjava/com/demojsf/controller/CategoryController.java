package stackjava.com.demojsf.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import stackjava.com.demojsf.form.CategoryFormNew;
import stackjava.com.demojsf.model.Category;
import stackjava.com.demojsf.service.CategoryService;

@ManagedBean
@SessionScoped

public class CategoryController {

	@ManagedProperty(value = "#{categoryService}")
	CategoryService categoryService;
	
	CategoryFormNew categoryForm;

	public CategoryFormNew getCategoryForm() {
		return categoryForm;
	}

	public void setCategoryForm(CategoryFormNew categoryForm) {
		this.categoryForm = categoryForm;
	}

	public String getCreateCategory() {
		String categoryName = this.categoryForm.getCatName();
		Category cat = new Category();
		cat.setCatName(categoryName);
		categoryService.add(cat);
		System.out.println("sussceess");
		return "index";
	}
}
