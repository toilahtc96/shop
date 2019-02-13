package stackjava.com.demojsf.form;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CreateProductForm implements Serializable {
	String proName;
	String selectCate;
	float proPrice;
	int proActive;
	String proDescription;
	Date proGuarantee;
	
	
	public float getProPrice() {
		return proPrice;
	}

	public void setProPrice(float proPrice) {
		this.proPrice = proPrice;
	}

	public int getProActive() {
		return proActive;
	}

	public void setProActive(int proActive) {
		this.proActive = proActive;
	}

	public String getProDescription() {
		return proDescription;
	}

	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}

	public Date getProGuarantee() {
		return proGuarantee;
	}

	public void setProGuarantee(Date proGuarantee) {
		this.proGuarantee = proGuarantee;
	}

	public String getSelectCate() {
		return selectCate;
	}

	public void setSelectCate(String selectCate) {
		this.selectCate = selectCate;
	}

	//de phuc vu cho selectBox
	HashMap<Integer, String> lstCate;

	public HashMap<Integer, String> getLstCate() {
		return lstCate;
	}

	public void setLstCate(HashMap<Integer, String> lstCate) {
		this.lstCate = lstCate;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

}
