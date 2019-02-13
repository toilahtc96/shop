package stackjava.com.demojsf.form;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped	
public class UpdateCategoryForm  implements Serializable{
	int catID; 
	String catName;
	String catAlias;
	public int getCatID() {
		return catID;
	}
	public void setCatID(int catID) {
		this.catID = catID;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatAlias() {
		return catAlias;
	}
	public void setCatAlias(String catAlias) {
		this.catAlias = catAlias;
	}
	
	
}
