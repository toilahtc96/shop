package stackjava.com.demojsf.dao;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import stackjava.com.demojsf.connection.GetSessionHibernate;
import stackjava.com.demojsf.model.Category;
import stackjava.com.demojsf.model.Product;
@ManagedBean
@SessionScoped
public class ProductDAO implements ModelDaoInterface<Product>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{getSessionHibernate}")
	GetSessionHibernate getSessionHibernate;
	
	public void setGetSessionHibernate(GetSessionHibernate getSessionHibernate) {
		this.getSessionHibernate = getSessionHibernate;
	}

	
	public ProductDAO() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public Product getById(int id) {
		Product pro = new Product();
		try {
			Session session = getSessionHibernate.getSessionFactory().openSession();
			pro = (Product) session.get(Product.class, id);
			System.out.println(pro.getProName());
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return pro;
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Product> getAll() {
		@SuppressWarnings("static-access")
		Session sessionObj = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction transObj = sessionObj.beginTransaction();
		List<Product> listPro = sessionObj.createCriteria(Product.class).list();
		return listPro;
	}

	@Override
	public int removeById(int id) {
//		ProductDAO productDAO = new ProductDAO();
		Product pro = this.getById(id);
		return getSessionHibernate.deleteRecord(pro);
	}

	@Override
	public int update(int id, Product e) {
		// TODO Auto-generated method stub
		return getSessionHibernate.updateRecord(e);
	}

	@Override
	public int add(Product e) {
		// TODO Auto-generated method stub
		
		return getSessionHibernate.createRecord(e);
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	public List<Product> getListFilter(){
//		@SuppressWarnings("static-access")
//		Session sessionObj = getSessionHibernate.getSessionFactory().getCurrentSession();
//		Transaction transObj = sessionObj.beginTransaction();
//		List<Product> listPro = sessionObj.createCriteria(Product.class).list();
//		return listPro;
//		 Query query = getSessionHibernate.getSessionFactory().getCurrentSession().createQuery("from  " + Product.class.getProActive() + " where pro_active = 1 ");
//		    query.setParameter("username", username);
//		    return (MemberModel) query.uniqueResult();
		return null;
	}

}
