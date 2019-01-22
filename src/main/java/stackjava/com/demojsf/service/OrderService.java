package stackjava.com.demojsf.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import stackjava.com.demojsf.dao.OrderDAO;
import stackjava.com.demojsf.model.Order;

@ManagedBean
@RequestScoped
public class OrderService implements ModelServiceInterface<Order> {

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
		return null;
	}

	public int add(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int removeById() {
		// TODO Auto-generated method stub
		return 0;
	}

}
