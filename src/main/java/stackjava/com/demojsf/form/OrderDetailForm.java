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
	private int ordetId;
	private int ordetOrderId;
	private int ordetProductId;
	private int ordetQuantity;
	private int ordetStatus;
	private String ordetNote;
	private String ordetCreatedAt;
	public int getOrdetId() {
		return ordetId;
	}
	public void setOrdetId(int ordetId) {
		this.ordetId = ordetId;
	}
	public int getOrdetOrderId() {
		return ordetOrderId;
	}
	public void setOrdetOrderId(int ordetOrderId) {
		this.ordetOrderId = ordetOrderId;
	}
	public int getOrdetProductId() {
		return ordetProductId;
	}
	public void setOrdetProductId(int ordetProductId) {
		this.ordetProductId = ordetProductId;
	}
	public int getOrdetQuantity() {
		return ordetQuantity;
	}
	public void setOrdetQuantity(int ordetQuantity) {
		this.ordetQuantity = ordetQuantity;
	}
	public int getOrdetStatus() {
		return ordetStatus;
	}
	public void setOrdetStatus(int ordetStatus) {
		this.ordetStatus = ordetStatus;
	}
	public String getOrdetNote() {
		return ordetNote;
	}
	public void setOrdetNote(String ordetNote) {
		this.ordetNote = ordetNote;
	}
	public String getOrdetCreatedAt() {
		return ordetCreatedAt;
	}
	public void setOrdetCreatedAt(String ordetCreatedAt) {
		this.ordetCreatedAt = ordetCreatedAt;
	}
	
}
