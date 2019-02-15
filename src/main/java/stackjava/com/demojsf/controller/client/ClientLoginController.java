package stackjava.com.demojsf.controller.client;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
@ManagedBean(name = "userController")
@SessionScoped
@URLMapping(id = "clientLogin", pattern = "/client/login", viewId = "/client/login.xhtml")
public class ClientLoginController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public void login() {
		
	}
	
	public void logout() {

	}
}
