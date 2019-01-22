package stackjava.com.demojsf.dao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import stackjava.com.demojsf.connection.GetSessionHibernate;
import stackjava.com.demojsf.model.User;

@ManagedBean
@SessionScoped
public class UserDAO implements ModelDaoInterface<User>{
	public final static Logger logger = Logger.getLogger(UserDAO.class);
	@ManagedProperty(value = "#{getSessionHibernate}")
	GetSessionHibernate getSessionHibernate;

	public GetSessionHibernate getGetSessionHibernate() {
		if(getSessionHibernate == null) {
			getSessionHibernate = new GetSessionHibernate();
		}
		return getSessionHibernate;
	}

	public void setGetSessionHibernate(GetSessionHibernate getSessionHibernate) {
		this.getSessionHibernate = getSessionHibernate;
	}

	public UserDAO() {
		super();
		BasicConfigurator.configure();
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
	public int removeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id, User e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(User e) {
		
		logger.info("OK Men");
		getSessionHibernate = this.getGetSessionHibernate();
		int rs = getSessionHibernate.createRecord(e);
		logger.debug(e.toString() + "==============================================");
		// TODO Auto-generated method stub
		return rs;
	}

	

}
