package stackjava.com.demojsf.form;

import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UpdateProductForm {
	int proId;
	String proName;
	HashMap<Integer, String> lstCate;
	public HashMap<Integer, String> getLstCate() {
		return lstCate;
	}
	public void setLstCate(HashMap<Integer, String> lstCate) {
		this.lstCate = lstCate;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	
}
