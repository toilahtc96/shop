package stackjava.com.demojsf.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.BasicConfigurator;

import stackjava.com.demojsf.model.Cart;
import stackjava.com.demojsf.model.Category;
import stackjava.com.demojsf.model.OrderDetail;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import stackjava.com.demojsf.connection.GetSessionHibernate;

@ManagedBean
@SessionScoped
public class CartDAO implements ModelDaoInterface<Cart>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{getSessionHibernate}")
	GetSessionHibernate getSessionHibernate;

	// public GetSessionHibernate getGetSessionHibernate() {
	// if (getSessionHibernate == null) {
	// getSessionHibernate = new GetSessionHibernate();
	// }
	// return getSessionHibernate;
	// }

	public void setGetSessionHibernate(GetSessionHibernate getSessionHibernate) {
		this.getSessionHibernate = getSessionHibernate;
	}

	public CartDAO() {
		super();

		// BasicConfigurator.configure();
	}

	@Override
	public Cart getById(int id) {
		Cart cart = new Cart();
		try {
			Session session = getSessionHibernate.getSessionFactory().openSession();
			cart = (Cart) session.get(Cart.class, id);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return cart;
	}

	public Cart getByUserId(int userid) {

		FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		@SuppressWarnings("static-access")
		Session sessionObj = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction transObj = sessionObj.beginTransaction();
		Cart cart = (Cart) sessionObj
				.createQuery("From Cart c where c.carUserId = :carUserId")
				.setParameter("carUserId", userid).uniqueResult();
		return cart;

	}

	@Override
	public List<Cart> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeById(int id) {
		Session sessionObj = getSessionHibernate.getSessionFactory().openSession();
		Transaction tranObj = sessionObj.beginTransaction();
		Cart e = getById(id);
		sessionObj.delete(e);
		tranObj.commit();
		sessionObj.close();
		return 1;
	}

	@Override
	public int update(int id, Cart e) {
		Session sessionObj = getSessionHibernate.getSessionFactory().openSession();

		// Creating Transaction Object
		Transaction transObj = sessionObj.beginTransaction();
		
		sessionObj.saveOrUpdate(e);

		// Transaction Is Committed To Database
		transObj.commit();

		// Closing The Session Object
		sessionObj.close();
		// logger.info("Successfully Created " + e.toString());
		return e.getCarId();
	}

	@Override
	public int add(Cart e) {
		Session sessionObj = getSessionHibernate.getSessionFactory().openSession();

		// Creating Transaction Object
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(e);

		// Transaction Is Committed To Database
		transObj.commit();

		// Closing The Session Object
		sessionObj.close();
		// logger.info("Successfully Created " + e.toString());
		return e.getCarId();
	}

}
