package stackjava.com.demojsf.controller.client;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import stackjava.com.demojsf.form.ClientLoginForm;
import stackjava.com.demojsf.model.User;
import stackjava.com.demojsf.service.UserService;

@ManagedBean
@SessionScoped
@URLMapping(id = "clientLogin", pattern = "/client/login", viewId = "/client/login.xhtml")
public class ClientLoginController implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{clientLoginForm}")
	private ClientLoginForm clientLoginForm;

	public ClientLoginForm getClientLoginForm() {
		return clientLoginForm;
	}

	public void setClientLoginForm(ClientLoginForm clientLoginForm) {
		this.clientLoginForm = clientLoginForm;
	}

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void login() {
		String email = clientLoginForm.getEmail();
		String password = clientLoginForm.getPassword();
		FacesContext context = FacesContext.getCurrentInstance();
		if (email.equals("") || password.equals("")) {
			// so ra 1 alert
			context.addMessage(null, new FacesMessage("Thiếu thông tin đăng nhập!"));
		} else {
			if (userService.checkUser(email, password)) {
				User user = userService.getUserByEmailAndPassword(email, password);
				if (user != null) {
					context.getExternalContext().getSessionMap().put("user", user);
					try {
						context.getExternalContext().redirect("home");
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					context.addMessage(null, new FacesMessage("Authentication Failed. Check username or password."));
				}
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
	
	public String getUserNameById(int useId) {
		return userService.getUserNameById(useId);
	}
}
