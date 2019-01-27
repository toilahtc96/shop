package stackjava.com.demojsf.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import stackjava.com.demojsf.dao.UserDAO;
import stackjava.com.demojsf.model.User;

@ManagedBean
@SessionScoped
public class UserService implements ModelServiceInterface<User>,Serializable {

	public final static Logger logger = Logger.getLogger(UserService.class);
	@ManagedProperty(value = "#{userDAO}")
	UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(User e) {
		logger.debug("add=================="+ e.toString()); 
		userDAO.add(e);
		return 0;
	}


	@Override
	public int update(int id, User e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	public boolean checkUserByName(String name){
		return userDAO.checkUserByName(name);
	}

	

}
