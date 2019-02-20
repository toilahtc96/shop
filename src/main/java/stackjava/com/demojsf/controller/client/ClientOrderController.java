package stackjava.com.demojsf.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import stackjava.com.demojsf.form.OrderDetailForm;
import stackjava.com.demojsf.model.Order;
import stackjava.com.demojsf.model.OrderDetail;
import stackjava.com.demojsf.service.OrderDetailService;
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

	@ManagedProperty(name = "orderDetailService", value = "#{orderDetailService}")
	private OrderDetailService orderDetailService;

	private List<OrderDetail> listToCheckout;

	public List<OrderDetail> getListToCheckout() {
		return listToCheckout;
	}

	public void setListToCheckout(List<OrderDetail> listToCheckout) {
		this.listToCheckout = listToCheckout;
	}

	public void setOrderDetailService(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}

	public String getDetailOrder(int ordId) {
		listToCheckout = new ArrayList<OrderDetail>();
		listToCheckout = orderDetailService.getAllByOrderDetail(ordId);
		return "checkout?faces-redirect=true";
	}

}
