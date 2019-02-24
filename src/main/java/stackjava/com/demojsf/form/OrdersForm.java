package stackjava.com.demojsf.form;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class OrdersForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ordetId;
	private float totalPrice;
	private String userName;
	private String status;
	private Date createDate;
	public int getOrdetId() {
		return ordetId;
	}
	public void setOrdetId(int ordetId) {
		this.ordetId = ordetId;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public OrdersForm() {
		super();
	}
	
	
}
