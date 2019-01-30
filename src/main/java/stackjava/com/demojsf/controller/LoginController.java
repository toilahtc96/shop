package stackjava.com.demojsf.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import stackjava.com.demojsf.form.LoginForm;
import stackjava.com.demojsf.service.UserService;

@ManagedBean
@SessionScoped
@URLMapping(id = "login", pattern = "/admin/login", viewId = "/login.xhtml")
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean checkSave;
	
	@ManagedProperty(value="#{userService}")
	private UserService userService;
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@ManagedProperty(value="#{loginForm}")
	private LoginForm loginForm;
	

	public boolean isCheckSave() {
		return checkSave;
	}

	public void setCheckSave(boolean checkSave) {
		this.checkSave = checkSave;
	}

	public LoginForm getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}

	
	public String login(){
		
		String email = loginForm.getEmail();
		String pass = loginForm.getPassword();
		if(userService.checkUserByName(email)){
			return "index";
		}else{
			return "login";
		}
		
	}

}