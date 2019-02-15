package stackjava.com.demojsf.form;

import java.io.Serializable;

public class ProductDetailForm implements Serializable{
	private static final long serialVersionUID = 1L;
	private int proID;
	private String proName;
	public int getProID() {
		return proID;
	}
	public void setProID(int proID) {
		this.proID = proID;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	

}
