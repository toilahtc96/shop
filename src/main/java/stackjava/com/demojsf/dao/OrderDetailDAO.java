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
import stackjava.com.demojsf.model.OrderDetail;
import stackjava.com.demojsf.model.Product;

@ManagedBean
@SessionScoped
public class OrderDetailDAO implements ModelDaoInterface<OrderDetail>, Serializable {

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

	public OrderDetailDAO() {
		super();
		BasicConfigurator.configure();
	}

	public OrderDetail getById(int id) {
		// getSessionHibernate = this.getGetSessionHibernate();
		// Order order = new Order(1, 4, Float.valueOf(15), 1, new Date(), new Date());
		// getSessionHibernate.createRecord(order);
		// return order;
		OrderDetail orderDetail = new OrderDetail();
		try {
			@SuppressWarnings("static-access")
			Session session = getSessionHibernate.getSessionFactory().openSession();
			orderDetail = (OrderDetail) session.get(OrderDetail.class, id);
			// System.out.println(order.get());

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return orderDetail;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public List<OrderDetail> getAll() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		@SuppressWarnings("static-access")
		Session sessionObj = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction transObj = sessionObj.beginTransaction();
		List<OrderDetail> listOrderDetail = sessionObj.createCriteria(OrderDetail.class).list();
		return listOrderDetail;
	}

	public int removeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int add(OrderDetail e) {
		Session sessionObj = getSessionHibernate.getSessionFactory().openSession();

		// Creating Transaction Object
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(e);

		// Transaction Is Committed To Database
		transObj.commit();

		// Closing The Session Object
		sessionObj.close();
		// logger.info("Successfully Created " + e.toString());
		return e.getOrdetId();

	}

	@Override
	public int update(int id, OrderDetail e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
