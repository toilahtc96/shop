package stackjava.com.demojsf.dao;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.jws.soap.SOAPBinding.Use;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import stackjava.com.demojsf.connection.GetSessionHibernate;
import stackjava.com.demojsf.model.Product;
import stackjava.com.demojsf.model.User;

@ManagedBean
@SessionScoped
public class UserDAO implements ModelDaoInterface<User>, Serializable {
	@ManagedProperty(value = "#{getSessionHibernate}")
	GetSessionHibernate getSessionHibernate;

	public void setGetSessionHibernate(GetSessionHibernate getSessionHibernate) {
		this.getSessionHibernate = getSessionHibernate;
	}

	public UserDAO() {
		super();
	}

	@SuppressWarnings("static-access")
	public boolean checkUserByName(String name) {
		getSessionHibernate = new GetSessionHibernate();
		Session session = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		User user = (User) session.createQuery("From stackjava.com.demojsf.model.User u where u.userEmail = :email")
				.setParameter("email", name).uniqueResult();
		tran.commit();
		if (user != null) {
			return true;
		}
		return false;
	}

	public boolean checkUser(String email, String password) {
		getSessionHibernate = new GetSessionHibernate();
		@SuppressWarnings("static-access")
		Session session = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
//		Query query = session
//				.createQuery("from  " + User.class.getName() + " where use_email = :email and use_password = :pass");
//		query.setParameter("email", email);
//		query.setParameter("pass", password);
//		User user = new User();
//		user = (User) query.setMaxResults(1).list();
		User user = (User) session.createQuery("from  " + User.class.getName() + " where use_email = :email and use_password = :password")
		.setParameter("email", email).setParameter("password", password).uniqueResult();
		tran.commit();
		if (user != null) {
			return true;
		}
		return false;
	}

	public User getUserByEmailAndPassWord(String email, String password) {
		getSessionHibernate = new GetSessionHibernate();
		User user = null;
		@SuppressWarnings("static-access")
		Session session = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction tran = session.beginTransaction();
		user = (User) session
				.createQuery("from  " + User.class.getName() + " where use_email = :email and use_password = :password")
				.setParameter("email", email).setParameter("password", password).uniqueResult();
		tran.commit();
		if (user != null) {
			return user;
		}
		return null;
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

		int rs = getSessionHibernate.createRecord(e);

		// TODO Auto-generated method stub
		return rs;
	}

}
