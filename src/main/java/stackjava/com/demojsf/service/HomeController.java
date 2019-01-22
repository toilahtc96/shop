package stackjava.com.demojsf.service;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


import com.ocpsoft.pretty.faces.annotation.URLMapping;

import stackjava.com.demojsf.form.CategoryForm;

@ManagedBean
@SessionScoped
@URLMapping(id="category", pattern="/category", 
viewId="/createCategory.xhtml")
public class HomeController {

	@ManagedProperty(value = "#{categoryForm}")
	CategoryForm categoryForm = new CategoryForm();
	

	public CategoryForm getCategoryForm() {

		if (categoryForm == null) {
			this.categoryForm = new CategoryForm();
		}
		return categoryForm;
	}

	public void setCategoryForm(CategoryForm categoryForm) {
		this.categoryForm = categoryForm;
	}

	public HomeController() {
		super();
		if (categoryForm == null) {
			categoryForm = new CategoryForm();
		}
	}

	public String getCreateCategory() {

		System.out.println(categoryForm.toString());
		return "hello";
	}
}
