package stackjava.com.demojsf.controller.admin;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

import stackjava.com.demojsf.form.LoginForm;
import stackjava.com.demojsf.model.User;
import stackjava.com.demojsf.service.UserService;

@ManagedBean
@SessionScoped

@URLMappings(mappings = { @URLMapping(id = "login", pattern = "/admin/login", viewId = "/login.xhtml"),
		@URLMapping(id ="adminHome", pattern = "/admin/home", viewId = "/adminHome.xhtml")})
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean checkSave;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;


	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@ManagedProperty(value = "#{loginForm}")
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

	public void login() {

		String email = loginForm.getEmail();
		String pass = loginForm.getPassword();
		FacesContext context = FacesContext.getCurrentInstance();
		if (userService.checkUserByName(email)) {
			User user = userService.getUserByEmailAndPassword(email, pass);

			if (user != null) {
				context.getExternalContext().getSessionMap().put("user", user);
				try {
					context.getExternalContext().redirect("/JavaServerFaces/admin/home");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				// Send an error message on Login Failure
				context.addMessage(null, new FacesMessage("Authentication Failed. Check username or password."));
			}

		}

	}

	public void logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		try {
			context.getExternalContext().redirect("/JavaServerFaces");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}