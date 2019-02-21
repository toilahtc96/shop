package stackjava.com.demojsf.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import stackjava.com.demojsf.dao.ProductDAO;
import stackjava.com.demojsf.form.OrderDetailCheckoutForm;
import stackjava.com.demojsf.form.OrderDetailForm;
import stackjava.com.demojsf.model.Order;
import stackjava.com.demojsf.model.OrderDetail;
import stackjava.com.demojsf.model.Product;
import stackjava.com.demojsf.service.OrderDetailService;
import stackjava.com.demojsf.service.OrderService;
import stackjava.com.demojsf.service.ProductService;

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

	private List<OrderDetailCheckoutForm> listToCheckout;

	public List<OrderDetailCheckoutForm> getListToCheckout() {
		return listToCheckout;
	}

	public void setListToCheckout(List<OrderDetailCheckoutForm> listToCheckout) {
		this.listToCheckout = listToCheckout;
	}

	public void setOrderDetailService(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}

	@ManagedProperty(value = "#{productService}")
	private ProductService productService;
	

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String getDetailOrder(int ordId) {
		System.out.println("get Detail");
		listToCheckout = new ArrayList<OrderDetailCheckoutForm>();
		List<OrderDetail> lstOrderDetailByOrderId = orderDetailService.getAllByOrderDetail(ordId);
		for (OrderDetail orderDetail : lstOrderDetailByOrderId) {
			OrderDetailCheckoutForm form = new OrderDetailCheckoutForm();
			form.setQuantity(orderDetail.getOrdetQuantity());
			Product p = productService.getById(orderDetail.getOrdetProductId());
			if(p!=null) {
				form.setProductId(p.getProName());
				form.setPrice(p.getProPrice());
			}
			listToCheckout.add(form);
		}
		return "checkout?faces-redirect=true";
	}

}
