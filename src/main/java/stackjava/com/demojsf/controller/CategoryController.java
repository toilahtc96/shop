package stackjava.com.demojsf.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import stackjava.com.demojsf.dao.CategoryDAO;
import stackjava.com.demojsf.form.CreateCategoryForm;
import stackjava.com.demojsf.form.UpdateCategoryForm;
import stackjava.com.demojsf.model.Category;
import stackjava.com.demojsf.service.CategoryService;

@ManagedBean
@SessionScoped

@URLMappings(mappings = { @URLMapping(id = "category", pattern = "/category", viewId = "/listCate.xhtml"),
		@URLMapping(id = "addCategory", pattern = "/createCategory", viewId = "/createCategory.xhtml") })
public class CategoryController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Category> list;

	
	@ManagedProperty(value = "#{categoryService}")
	CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@ManagedProperty(value = "#{createCategoryForm}")
	CreateCategoryForm createCategoryForm;

	public CreateCategoryForm getCreateCategoryForm() {
		return createCategoryForm;
	}

	public void setCreateCategoryForm(CreateCategoryForm createCategoryForm) {
		this.createCategoryForm = createCategoryForm;
	}

	@ManagedProperty(value = "#{updateCategoryForm}")
	UpdateCategoryForm updateCategoryForm;

	public UpdateCategoryForm getUpdateCategoryForm() {
		if (updateCategoryForm == null)
			updateCategoryForm = new UpdateCategoryForm();
		return updateCategoryForm;
	}

	public void setUpdateCategoryForm(UpdateCategoryForm updateCategoryForm) {
		this.updateCategoryForm = updateCategoryForm;
	}

	public CategoryController() {
		super();
	}

	public List<Category> getList() {
		return this.list = categoryService.getAll();
	}

	public void setList(List<Category> list) {
		this.list = list;
	}

	public String getCreateCategory() {
		String categoryName = this.createCategoryForm.getCatName();
		Category cat = new Category();
		cat.setCatName(categoryName);
		categoryService.add(cat);
		System.out.println("sussceess");
		return "listCate";
	}

	public String getUpdateCategory() {
		int id = updateCategoryForm.getCatID();
		// Category cate = categoryDAO.getById(id);
		String name = updateCategoryForm.getCatName();
		// cate.setCatName(updateCategoryForm.getCatName());
		Category cate = new Category(id, name, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null);
		categoryService.update(id, cate);
		return "listCate";
	}

	public String doUpdateCategory() {

		FacesContext fc = FacesContext.getCurrentInstance();
		int id = (Integer.parseInt(fc.getExternalContext().getRequestParameterMap().get("id")));
		Category cate = categoryService.getById(id);
		if (cate == null) {
			System.out.println("xxxxx");
		} else {
			System.out.println(cate.getCatName());
		}
		updateCategoryForm = new UpdateCategoryForm();
		updateCategoryForm.setCatName(cate.getCatName());
		updateCategoryForm.setCatID(cate.getCatId());
		return "updateCategory";
	}

	public String deleteCategory() {
		FacesContext fc = FacesContext.getCurrentInstance();
		int id = (Integer.parseInt(fc.getExternalContext().getRequestParameterMap().get("id")));
		categoryService.removeById(id);
		return "listCate";
	}
}