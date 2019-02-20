package stackjava.com.demojsf.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.xpath.operations.Or;
import org.hibernate.Session;
import org.hibernate.Transaction;

import stackjava.com.demojsf.connection.GetSessionHibernate;
import stackjava.com.demojsf.model.Category;
import stackjava.com.demojsf.model.Order;
import stackjava.com.demojsf.model.Product;
import stackjava.com.demojsf.model.User;

@ManagedBean
@SessionScoped
public class OrderDAO implements ModelDaoInterface<Order>, Serializable {

	private static final long serialVersionUID = 1L;
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

	public OrderDAO() {
		super();
		BasicConfigurator.configure();
	}

	public Order getById(int id) {
		// getSessionHibernate = this.getGetSessionHibernate();
		// Order order = new Order(1, 4, Float.valueOf(15), 1, new Date(), new Date());
		// getSessionHibernate.createRecord(order);
		// return order;
		Order order = new Order();
		try {
			@SuppressWarnings("static-access")
			Session session = getSessionHibernate.getSessionFactory().openSession();
			order = (Order) session.get(Order.class, id);
			// System.out.println(order.get());

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return order;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public List<Order> getAll() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		@SuppressWarnings("static-access")
		Session sessionObj = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction transObj = sessionObj.beginTransaction();
		List<Order> listOrder = sessionObj.createCriteria(Order.class).list();
		return listOrder;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public List<Order> getAllByUserId(int userId) {
		FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		@SuppressWarnings("static-access")
		
		Session sessionObj = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction transObj = sessionObj.beginTransaction();
		List<Order> listOrder = (List<Order>) sessionObj
				.createQuery("From stackjava.com.demojsf.model.Order u where u.orderUserId = :userId").setParameter("userId", userId).list();
		return listOrder;
	}

	public int removeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(int id, Order e) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int add(Order e) {
		Session sessionObj = getSessionHibernate.getSessionFactory().openSession();

		// Creating Transaction Object
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(e);

		// Transaction Is Committed To Database
		transObj.commit();

		// Closing The Session Object
		sessionObj.close();
		// logger.info("Successfully Created " + e.toString());
		return e.getOrderId();

	}

}
