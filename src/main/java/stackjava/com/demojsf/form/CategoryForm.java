package stackjava.com.demojsf.form;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CategoryForm {
	
	/**
	 * 
	 */
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CategoryForm [id=" + id + "]";
	}
	
}
