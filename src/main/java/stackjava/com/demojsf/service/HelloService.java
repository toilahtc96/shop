package stackjava.com.demojsf.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


import stackjava.com.demojsf.model.Order;

@ManagedBean
@SessionScoped
public class HelloService {
	public final static Logger logger = Logger.getLogger(HelloService.class);

	@ManagedProperty(value = "#{OrderService}")
	OrderService orderService;
	
	

	public HelloService() {
		super();

		BasicConfigurator.configure();
	}

	public OrderService getOrderService() {
		if (orderService == null) {
			orderService = new OrderService();
		}
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public String convert(String input) {
		logger.info("get by ID ===============================" + input);
		orderService = this.getOrderService();
		Order order = orderService.getById(13);
		return order.toString();
	}
}
