package stackjava.com.demojsf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.BasicConfigurator;
import stackjava.com.demojsf.model.Category;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import stackjava.com.demojsf.connection.GetSessionHibernate;

@ManagedBean
@SessionScoped
public class CategoryDAO implements ModelDaoInterface<Category> {

	@ManagedProperty(value = "#{getSessionHibernate}")
	GetSessionHibernate getSessionHibernate;

	public GetSessionHibernate getGetSessionHibernate() {
		if (getSessionHibernate == null) {
			getSessionHibernate = new GetSessionHibernate();
		}
		return getSessionHibernate;
	}

	public void setGetSessionHibernate(GetSessionHibernate getSessionHibernate) {
		this.getSessionHibernate = getSessionHibernate;
	}

	public CategoryDAO() {
		super();
		BasicConfigurator.configure();
	}

	@Override
	public Category getById(int id) {
		Category cate = new Category();
		try {
			Session session = getSessionHibernate.getSessionFactory().openSession();
			cate = (Category) session.get(Category.class, id);
			System.out.println(cate.getCatName());
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return cate;
	}


	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Category> getAll() {
		@SuppressWarnings("static-access")
		Session sessionObj = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction transObj = sessionObj.beginTransaction();
		List<Category> listCate = sessionObj.createCriteria(Category.class).list();
		return listCate;
	}

	@Override
	public int removeById(int id) {
		return 0;
	}

	@Override
	public int update(int id, Category e) {
		// TODO Auto-generated method stub
		return getSessionHibernate.updateRecord(e);
	}

	@Override
	public int add(Category e) {
		return getSessionHibernate.createRecord(e);
	}
	

}
