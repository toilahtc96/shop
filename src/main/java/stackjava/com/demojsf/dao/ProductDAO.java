package stackjava.com.demojsf.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import stackjava.com.demojsf.common.PaginationResult;
import stackjava.com.demojsf.connection.GetSessionHibernate;
import stackjava.com.demojsf.model.Category;
import stackjava.com.demojsf.model.Product;

@ManagedBean
@SessionScoped
public class ProductDAO implements ModelDaoInterface<Product>, PaginationInterface<Product>, Serializable {

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
			@SuppressWarnings("static-access")
			Session session = getSessionHibernate.getSessionFactory().openSession();
			pro = (Product) session.get(Product.class, id);
			// System.out.println(pro.getProName());

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
		List<Product> listPro = sessionObj.createCriteria(Product.class).setMaxResults(8).list();
		return listPro;
	}

	@Override
	public int removeById(int id) {
		// ProductDAO productDAO = new ProductDAO();
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
	public List<Product> getListFilter() {
		List<Product> listFilter = new ArrayList<Product>();
		@SuppressWarnings("static-access")
		Session sessionObj = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction transObj = sessionObj.beginTransaction();
		Query query = sessionObj.createQuery("from  " + Product.class.getName() + " where pro_active = :active ");
		query.setParameter("active", "1");
		listFilter = (List<Product>) query.setMaxResults(8).list();
		return listFilter;

	}

	@SuppressWarnings({ "unchecked", "unused" })
	public List<Product> getListProByIdCate(int catId, int position, int pageSize) {
		List<Product> listPro = new ArrayList<Product>();
		@SuppressWarnings("static-access")
		Session sessionObj = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction transObj = sessionObj.beginTransaction();
		Query query = sessionObj.createQuery(
				"from  " + Product.class.getName() + " where pro_category_id = :catId order by pro_price asc");
		query.setParameter("catId", catId);
		query.setFirstResult(position);
		query.setMaxResults(1);
		listPro = query.list();
		System.out.println("ProductDao list size: "+ listPro.size());
		System.out.println("position"+position);
		System.out.println("pageSize"+pageSize);
		return listPro;
	}

	@Override
	public long countTotalRecords() {
		Session session = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction transObj = session.beginTransaction();
		String countQ = "Select count (c.proId) from " + Product.class.getName() + " c";
		Query countQuery = session.createQuery(countQ);
		System.out.println("count: "+(Long) countQuery.uniqueResult() );
		return (Long) countQuery.uniqueResult();
	}

	@Override
	public List<Product> getUsingSession(int position, int pageSize) {
		Session session = getSessionHibernate.getSessionFactory().openSession();
		Query query = session.createQuery("FROM " + Product.class.getName());
		query.setFirstResult(position);
		query.setMaxResults(pageSize);
		return query.list();
	}

	// @SuppressWarnings({ "unchecked", "unused" })
	// public List<Product> getListProByIdCateSortByDate(int catId) {
	// List<Product> listPro = new ArrayList<Product>();
	// @SuppressWarnings("static-access")
	// Session sessionObj =
	// getSessionHibernate.getSessionFactory().getCurrentSession();
	// Transaction transObj = sessionObj.beginTransaction();
	// Query query = sessionObj.createQuery(
	// "from " + Product.class.getName() + " where pro_category_id = :catId order by
	// pro_name asc");
	// query.setParameter("catId", catId);
	// listPro = query.setMaxResults(6).list();
	// return listPro;
	// }
	//
	// @SuppressWarnings({ "unchecked", "unused" })
	// public List<Product> getListProByIdCateSortByName(int catId) {
	// List<Product> listPro = new ArrayList<Product>();
	// @SuppressWarnings("static-access")
	// Session sessionObj =
	// getSessionHibernate.getSessionFactory().getCurrentSession();
	// Transaction transObj = sessionObj.beginTransaction();
	// Query query = sessionObj.createQuery(
	// "from " + Product.class.getName() + " where pro_category_id = :catId order by
	// pro_create_time desc");
	// query.setParameter("catId", catId);
	// listPro = query.setMaxResults(6).list();
	// return listPro;
	// }

}
