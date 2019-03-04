package stackjava.com.demojsf.dao;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

import stackjava.com.demojsf.connection.GetSessionHibernate;
import stackjava.com.demojsf.model.Brand;

@ManagedBean
@SessionScoped
public class BrandDAO implements ModelDaoInterface<Brand>, Serializable{
	@ManagedProperty(value = "#{getSessionHibernate}")
	GetSessionHibernate getSessionHibernate;

	public void setGetSessionHibernate(GetSessionHibernate getSessionHibernate) {
		this.getSessionHibernate = getSessionHibernate;
	}

	@Override
	public Brand getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({"unchecked","unused"})
	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		@SuppressWarnings("static-access")
		Session session = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Brand> listBrand = session.createCriteria(Brand.class).list();
		return listBrand;
	}

	@Override
	public int removeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id, Brand e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Brand e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
