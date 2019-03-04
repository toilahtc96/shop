package stackjava.com.demojsf.controller.client;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import stackjava.com.demojsf.dao.BrandDAO;
import stackjava.com.demojsf.model.Brand;

@ManagedBean
@SessionScoped

public class ClientBrandController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{brandDAO}")
	BrandDAO brandDAO;

	public void setBrandDAO(BrandDAO brandDAO) {
		this.brandDAO = brandDAO;
	}
	
	public List<Brand> getAllListBrand() {
		List<Brand> listBrand = brandDAO.getAll();
		return listBrand;
	}
}
