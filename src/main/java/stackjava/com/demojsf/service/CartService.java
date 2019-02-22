package stackjava.com.demojsf.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import stackjava.com.demojsf.dao.CartDAO;
import stackjava.com.demojsf.dao.CategoryDAO;
import stackjava.com.demojsf.dao.UserDAO;
import stackjava.com.demojsf.model.Cart;
import stackjava.com.demojsf.model.Category;

@ManagedBean
@SessionScoped
public class CartService implements ModelServiceInterface<Cart>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{cartDAO}")
	CartDAO cartDAO;

	@Override

	public Cart getById(int id) {
		// TODO Auto-generated method stub
		return cartDAO.getById(id);
	}

	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	@Override
	public List<Cart> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Cart e) {
		// TODO Auto-generated method stub
		return cartDAO.add(e);
	}

	@Override
	public int update(int id, Cart e) {
		// TODO Auto-generated method stub
		return cartDAO.update(id, e);
	}

	
	@Override
	public int removeById(int id) {
		// TODO Auto-generated method stub
		return cartDAO.removeById(id);
	}

	public Cart getByUserId(int userid) {
		return cartDAO.getByUserId(userid);
	}

}
