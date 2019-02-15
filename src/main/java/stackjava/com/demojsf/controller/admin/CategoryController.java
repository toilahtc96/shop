package stackjava.com.demojsf.controller.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import stackjava.com.demojsf.dao.CategoryDAO;
import stackjava.com.demojsf.form.CreateCategoryForm;
import stackjava.com.demojsf.form.UpdateCategoryForm;
import stackjava.com.demojsf.model.Category;
import stackjava.com.demojsf.service.CategoryService;

@ManagedBean(name="categoryController")
@SessionScoped

@URLMappings(mappings = { @URLMapping(id = "category", pattern = "/admin/category", viewId = "/admin/listCategory.xhtml"),
		@URLMapping(id = "addCategory", pattern = "/admin/createCategory", viewId = "/admin/createCategory.xhtml"),
		@URLMapping(id = "updateCategory", pattern = "/admin/updateCategory", viewId = "/admin/updateCategory.xhtml") })
public class CategoryController extends CommonController implements Serializable {
	private static final long serialVersionUID = 1L;

	List<Category> list;
	List<Integer> keyList;
	private int idCate;

	public int getIdCate() {
		return idCate;
	}

	public void setIdCate(int idCate) {
		this.idCate = idCate;
	}

	public List<Integer> getKeyList() {
		return keyList;
	}

	public void setKeyList(List<Integer> keyList) {
		this.keyList = keyList;
	}

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
		if (createCategoryForm == null) {
			createCategoryForm = new CreateCategoryForm();
		}
		List<Category> getListCate = categoryService.getAll();
		HashMap<Integer, String> hashMap = createCategoryForm.getListCate();
		for (Category category : getListCate) {
			if (hashMap == null) {
				hashMap = new HashMap<Integer, String>();
				hashMap.put(0, "Chose Parent");
			}
			hashMap.put(category.getCatId(), category.getCatName());
			createCategoryForm.setListCate(hashMap);
		}
		keyList = new ArrayList<Integer>(hashMap.keySet());
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

	public String addCreateCategory() {
		String catName = this.createCategoryForm.getCatName();
		Part image = this.createCategoryForm.getImage();
		this.setImage(image);
		System.out.println("xxx");
		this.doUpLoad();
		// String catAlias = this.createCategoryForm.getCatAlias();
		// String catSeoText = this.createCategoryForm.getCatSeoText();
		// String catPicture = this.createCategoryForm.getCatPicture();
		// String catDes = this.createCategoryForm.getCatDes();
		// String catType = this.createCategoryForm.getCatType();
		// int catActive = this.createCategoryForm.getCatActive();
		// int catParent = this.createCategoryForm.getCatParent();
		// int catChild = this.createCategoryForm.getCatChild();
		// int catHot = this.createCategoryForm.getCatHot();
		// int catNew = this.createCategoryForm.getCatNew();
		// int catRoot = this.createCategoryForm.getCatRoot();
		// String catSlug = this.createCategoryForm.getCatSlug();
		// Date catCreate = this.createCategoryForm.getCatCreat();
		// Date catUpdate = this.createCategoryForm.getCatUpdate();
		Category cat = new Category();
		cat.setCatName(catName);
		categoryService.add(cat);
		System.out.println("sussceess");
		return "listCategory?faces-redirect=true";
	}

	public String getUpdateCategory() {
		int id = updateCategoryForm.getCatID();
		String name = updateCategoryForm.getCatName();
		Category cate = new Category(id, name, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null);
		categoryService.update(id, cate);
		return "listCategory?faces-redirect=true";
	}

	public String doUpdateCategory() {

		FacesContext fc = FacesContext.getCurrentInstance();
		int id = (Integer.parseInt(fc.getExternalContext().getRequestParameterMap().get("id")));
		Category cate = categoryService.getById(id);
		updateCategoryForm = new UpdateCategoryForm();
		updateCategoryForm.setCatName(cate.getCatName());
		updateCategoryForm.setCatID(cate.getCatId());
		return "updateCategory?faces-redirect=true";
	}

	public String deleteCategory() {
		FacesContext fc = FacesContext.getCurrentInstance();
		int id = (Integer.parseInt(fc.getExternalContext().getRequestParameterMap().get("id")));
		categoryService.removeById(id);
		return "listCategory?faces-redirect=true";
	}
}