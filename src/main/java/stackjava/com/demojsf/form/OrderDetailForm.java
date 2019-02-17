package stackjava.com.demojsf.form;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class OrderDetailForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ordId;
	private String ordUserId;
	private String ordTotalPrice;
	private String ordStatus;
	private String ordCreateAt;
	public String getOrdId() {
		return ordId;
	}
	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}
	public String getOrdUserId() {
		return ordUserId;
	}
	public void setOrdUserId(String ordUserId) {
		this.ordUserId = ordUserId;
	}
	public String getOrdTotalPrice() {
		return ordTotalPrice;
	}
	public void setOrdTotalPrice(String ordTotalPrice) {
		this.ordTotalPrice = ordTotalPrice;
	}
	public String getOrdStatus() {
		return ordStatus;
	}
	public void setOrdStatus(String ordStatus) {
		this.ordStatus = ordStatus;
	}
	public String getOrdCreateAt() {
		return ordCreateAt;
	}
	public void setOrdCreateAt(String ordCreateAt) {
		this.ordCreateAt = ordCreateAt;
	}
	
	
}
