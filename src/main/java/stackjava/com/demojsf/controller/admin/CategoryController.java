package stackjava.com.demojsf.controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import stackjava.com.demojsf.form.CreateCategoryForm;
import stackjava.com.demojsf.form.UpdateCategoryForm;
import stackjava.com.demojsf.model.Category;
import stackjava.com.demojsf.service.CategoryService;

@ManagedBean(name = "categoryController")
@SessionScoped
@URLMappings(mappings = {
		@URLMapping(id = "category", pattern = "/admin/categories", viewId = "/admin/listCategory.xhtml"),
		@URLMapping(id = "addCategory", pattern = "/admin/createCategory", viewId = "/admin/createCategory.xhtml"),
		@URLMapping(id = "updateCategory", pattern = "/admin/updateCategory", viewId = "/admin/updateCategory.xhtml") })
@MultipartConfig
public class CategoryController extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;
	List<Category> list;
	List<Integer> keyList;
	private String folder = "c:/Users/dvgp_admin/Desktop/images";
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

	private Part image;

	public Part getImage() {
		return image;
	}

	public void setImage(Part image) {
		this.image = image;
	}

	public void uploadImage(AjaxBehaviorEvent event) {
		System.out.println("ajax Call");
		Part uploadedFile = getImage();

		// final Path destination = Paths.get("c:/temp/" +
		// FilenameUtils.getName(getSubmittedFileName(uploadedFile)));

		// When using servlet 3.1
		final Path destination = Paths.get(
				"c:/Users/dvgp_admin/Desktop/images/" + FilenameUtils.getName(uploadedFile.getSubmittedFileName()));

		InputStream bytes = null;

		if (uploadedFile != null) {

			try {
				bytes = uploadedFile.getInputStream();
				Files.copy(bytes, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

		}

	}

	@ManagedProperty(value = "#{createCategoryForm}")
	CreateCategoryForm createCategoryForm;

	public CreateCategoryForm getCreateCategoryForm() {
		return createCategoryForm;
	}

	public void setCreateCategoryForm(CreateCategoryForm createCategoryForm) {
		try {
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
		if (this.getImage() != null) {
			System.out.println("!=null");
			System.out.println(this.getImage().getSubmittedFileName());
			final Path destination = Paths
					.get("C:/Users/HaiHiep/Desktop/images/" + FilenameUtils.getName(image.getSubmittedFileName()));

			InputStream bytes = null;

			try {
				bytes = image.getInputStream();
				Files.copy(bytes, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("null");
		}

		/*
		 * Part image = this.createCategoryForm.getImage(); this.setImage(image);
		 * System.out.println("xxx"); this.doUpLoad();
		 */
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
		// categoryService.add(cat);
		System.out.println("sussceess");
		return "/admin/listCategory?faces-redirect=true";
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