package stackjava.com.demojsf.dao;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

import stackjava.com.demojsf.connection.GetSessionHibernate;
import stackjava.com.demojsf.model.Banner;
@ManagedBean
@SessionScoped
public class BannerDAO implements Serializable, ModelDaoInterface<Banner> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{getSessionHibernate}")
	GetSessionHibernate getSessionHibernate;

	public void setGetSessionHibernate(GetSessionHibernate getSessionHibernate) {
		this.getSessionHibernate = getSessionHibernate;
	}

	@Override
	public Banner getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Banner> getAll() {
		@SuppressWarnings("static-access")
		Session sessionObj = getSessionHibernate.getSessionFactory().getCurrentSession();
		Transaction transObj = sessionObj.beginTransaction();
		List<Banner> listBanner = sessionObj.createCriteria(Banner.class).setMaxResults(3).list();
		return listBanner;
	}

	@Override
	public int removeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id, Banner e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Banner e) {
		// TODO Auto-generated method stub
		return 0;
	}

//	public static void main(String[] args) {
//		BannerDAO bannerDAO = new BannerDAO();
//		if (bannerDAO.getAll().size() == 0) {
//			System.out.println("Null");
//		} else {
//			for (Banner ban : bannerDAO.getAll()) {
//				System.out.println(ban.toString());
//			}
//		}
//	}
}
