package stackjava.com.demojsf.controller.client;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import stackjava.com.demojsf.common.CommonController;
import stackjava.com.demojsf.model.Banner;
import stackjava.com.demojsf.service.BannerService;

@ManagedBean(name = "clientBannerController")
@SessionScoped
public class ClientBannerController extends CommonController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{bannerService}")
	BannerService bannerService;
	
	public void setBannerService(BannerService bannerService) {
		this.bannerService = bannerService;
	}

	List<Banner> listBanner;

	public List<Banner> getListBanner() {
		return this.listBanner = bannerService.getAll();
	}

	public void setListBanner(List<Banner> listBanner) {
		this.listBanner = listBanner;
	}
	
	
}
