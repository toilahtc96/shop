package stackjava.com.demojsf.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import stackjava.com.demojsf.dao.OrderDAO;
import stackjava.com.demojsf.dao.OrderDetailDAO;
import stackjava.com.demojsf.model.Order;
import stackjava.com.demojsf.model.OrderDetail;

@ManagedBean
@SessionScoped
public class OrderDetailService implements ModelServiceInterface<OrderDetail>,Serializable {
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{orderDetailDAO}")
	OrderDetailDAO orderDetailDAO;

	public OrderDetailDAO getOrderDetailDAO() {
		return orderDetailDAO;
	}

	public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
		this.orderDetailDAO = orderDetailDAO;
	}

	@Override
	public int removeById(int id) {
		// TODO Auto-generated method stub
		return orderDetailDAO.removeById(id);
	}

	@Override
	public OrderDetail getById(int id) {
		// TODO Auto-generated method stub
		return orderDetailDAO.getById(id);
	}

	@Override
	public List<OrderDetail> getAll() {
		// TODO Auto-generated method stub
		return orderDetailDAO.getAll();
	}

	@Override
	public int add(OrderDetail e) {
		// TODO Auto-generated method stub
		return orderDetailDAO.add(e);
	}

	@Override
	public int update(int id, OrderDetail e) {
		// TODO Auto-generated method stub
		return orderDetailDAO.update(id, e);
	}

	public List<OrderDetail> getAllByOrderDetail(int orderId){
		return orderDetailDAO.getAllByOrderId(orderId);
	}

}
