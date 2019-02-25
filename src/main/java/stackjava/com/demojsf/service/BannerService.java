package stackjava.com.demojsf.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import stackjava.com.demojsf.dao.BannerDAO;
import stackjava.com.demojsf.model.Banner;

@ManagedBean
@SessionScoped
public class BannerService implements Serializable, ModelServiceInterface<Banner>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{bannerDAO}")
	BannerDAO bannerDAO;

	public void setBannerDAO(BannerDAO bannerDAO) {
		this.bannerDAO = bannerDAO;
	}

	@Override
	public Banner getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Banner> getAll() {
		// TODO Auto-generated method stub
		return bannerDAO.getAll();
	}

	@Override
	public int add(Banner e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id, Banner e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
