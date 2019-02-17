package stackjava.com.demojsf.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import stackjava.com.demojsf.dao.OrderDAO;
import stackjava.com.demojsf.model.Order;

@ManagedBean
@SessionScoped
public class OrderService implements ModelServiceInterface<Order>,Serializable {
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{orderDAO}")
	OrderDAO orderDAO;

	public OrderDAO getOrderDAO() {
		if (orderDAO == null) {
			orderDAO = new OrderDAO();
		}
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public Order getById(int id) {
		orderDAO = this.getOrderDAO();
		Order order = orderDAO.getById(id);
		return order;
	}

	public List<Order> getAll() {
		// TODO Auto-generated method stub
		
		return orderDAO.getAll();
	}

	public int add(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id, Order e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
