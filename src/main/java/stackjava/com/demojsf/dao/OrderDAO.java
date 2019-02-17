package stackjava.com.demojsf.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import stackjava.com.demojsf.connection.GetSessionHibernate;
import stackjava.com.demojsf.model.Order;

@ManagedBean
@SessionScoped
public class OrderDAO implements ModelDaoInterface<Order>,Serializable {

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
		getSessionHibernate = this.getGetSessionHibernate();
		Order order = new Order(1, 4, Float.valueOf(15), 1, new Date(), new Date());
		getSessionHibernate.createRecord(order);
		return order;
	}

	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

}
