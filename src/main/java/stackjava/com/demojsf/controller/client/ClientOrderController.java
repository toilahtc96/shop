package stackjava.com.demojsf.controller.client;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import stackjava.com.demojsf.service.OrderService;

@ManagedBean
@SessionScoped
public class ClientOrderController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{orderService}")
	OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public String getDetailOrder() {
		return "orderDetail?faces-redirect=true";
	}
}
