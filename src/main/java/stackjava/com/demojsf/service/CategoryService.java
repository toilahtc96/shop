package stackjava.com.demojsf.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import stackjava.com.demojsf.dao.CategoryDAO;
import stackjava.com.demojsf.dao.UserDAO;
import stackjava.com.demojsf.model.Category;

@ManagedBean
@SessionScoped
public class CategoryService implements ModelServiceInterface<Category> {

	@ManagedProperty(value = "#{categoryDAO}")
	CategoryDAO categoryDAO;

	public CategoryDAO getCategoryDAO() {
		if(categoryDAO == null){
			categoryDAO = new CategoryDAO();
		}

		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	public Category getById(int id) {
		Category cate = categoryDAO.getById(id);
		return cate;
	}
	public static void main(String[] args) {
		CategoryService sv = new CategoryService();
		sv.getById(1);
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryDAO.getAll();

	}

	@Override
	public int add(Category e) {
		return categoryDAO.add(e);
	}

	@Override
	public int update(int id,Category cat) {
		// TODO Auto-generated method stub
		return categoryDAO.update(id, cat);
	}

	@Override
	public int removeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
