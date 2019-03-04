package stackjava.com.demojsf.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import stackjava.com.demojsf.dao.ProductDAO;
import stackjava.com.demojsf.model.Product;

@ManagedBean
@SessionScoped
public class ProductService implements ModelServiceInterface<Product>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{productDAO}")
	ProductDAO productDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		Product pro = productDAO.getById(id);
		return pro;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return productDAO.getAll();
	}

	@Override
	public int add(Product e) {
		// TODO Auto-generated method stub
		return productDAO.add(e);
	}

	@Override
	public int update(int id, Product e) {
		// TODO Auto-generated method stub
		return productDAO.update(id, e);
	}

	@Override
	public int removeById(int id) {
		// TODO Auto-generated method stub
		return productDAO.removeById(id);
	}

	public List<Product> getListFilter() {
		return productDAO.getListFilter();
	}

	public List<Product> getListPRoByIdCate(int catId, int position, int pageSize) {
		return productDAO.getListProByIdCate(catId, position, pageSize);
	}

	public long countTotalRecords(int idCate) {
		return productDAO.countTotalRecords(idCate);
	}

	public List<String> getAllColorProduct() {
		return productDAO.getAllColorProduct();
	}
}
