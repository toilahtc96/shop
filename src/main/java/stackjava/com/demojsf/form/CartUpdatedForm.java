package stackjava.com.demojsf.form;

import java.io.Serializable;

import stackjava.com.demojsf.model.Product;

public class CartUpdatedForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Product pro;
	private Integer quantity;
	public Product getPro() {
		return pro;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	

}
