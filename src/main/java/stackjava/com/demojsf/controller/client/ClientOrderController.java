package stackjava.com.demojsf.controller.client;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import stackjava.com.demojsf.form.OrderDetailForm;
import stackjava.com.demojsf.model.Order;
import stackjava.com.demojsf.service.OrderService;

@ManagedBean
@SessionScoped
public class ClientOrderController implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{orderService}")
	OrderService orderService;

	List<Order> list;
	

	public List<Order> getList() {
		return this.list = orderService.getAll();
	}

	public void setList(List<Order> list) {
		this.list = list;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@ManagedProperty(value = "#{orderDetailForm}")
	OrderDetailForm orderDetailForm;

	public OrderDetailForm getOrderDetailForm() {
		if (orderDetailForm == null) {
			orderDetailForm = new OrderDetailForm();
		}
		return orderDetailForm;
	}

	public void setOrderDetailForm(OrderDetailForm orderDetailForm) {
		this.orderDetailForm = orderDetailForm;
	}

	public String getDetailOrder(int ordId) {
		Order order = orderService.getById(ordId);
		orderDetailForm = new OrderDetailForm();
		orderDetailForm.setOrdId(String.valueOf(order.getOrderId()));
		orderDetailForm.setOrdUserId(String.valueOf(order.getOrderUserId()));
		orderDetailForm.setOrdTotalPrice(String.valueOf(order.getOrderTotalFrice()));
		orderDetailForm.setOrdStatus(String.valueOf(order.getOrderStatus()));
		orderDetailForm.setOrdCreateAt(String.valueOf(order.getOrderCreatedAt()));
		return "orderDetail?faces-redirect=true";
	}
}
