package stackjava.com.demojsf.controller.client;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

import stackjava.com.demojsf.form.ClientLoginForm;
import stackjava.com.demojsf.form.ClientRegisterForm;
import stackjava.com.demojsf.model.Cart;
import stackjava.com.demojsf.model.User;
import stackjava.com.demojsf.service.CartService;
import stackjava.com.demojsf.service.UserService;

@ManagedBean
@SessionScoped
@URLMapping(id = "clientLogin", pattern = "/client/login", viewId = "/client/login.xhtml")
public class ClientLoginController implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{clientLoginForm}")
	private ClientLoginForm clientLoginForm;

	@ManagedProperty(value = "#{cartService}")
	private CartService cartService;

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}

	@ManagedProperty(value = "#{clientHomeController}")
	private ClientHomeController clientHomeController;

	public void setClientHomeController(ClientHomeController clientHomeController) {
		this.clientHomeController = clientHomeController;
	}

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

	@ManagedProperty(value = "#{clientRegisterForm}")
	ClientRegisterForm clientRegisterForm;

	public ClientRegisterForm getClientRegisterForm() {
		return clientRegisterForm;
	}

	public void setClientRegisterForm(ClientRegisterForm clientRegisterForm) {
		this.clientRegisterForm = clientRegisterForm;
	}

	public void login() {
		String name = clientLoginForm.getName();
		String password = clientLoginForm.getPassword();
		FacesContext context = FacesContext.getCurrentInstance();
		if (name.equals("") || password.equals("")) {
			// so ra 1 alert
			context.addMessage(null, new FacesMessage("Thiếu thông tin đăng nhập!"));
		} else {
			if (userService.checkUser(name, password)) {
				User user = userService.getUserByNameAndPassword(name, password);
				if (user != null) {
					context.getExternalContext().getSessionMap().put("user", user);

					try {

						if (cartService.getByUserId(clientHomeController.getUserId()) != null) {
							Cart cartO = cartService.getByUserId(clientHomeController.getUserId());
							clientHomeController.setCart(cartO.getCarListProductQuantity());
						}
						context.getExternalContext().redirect("home");
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					context.addMessage(null, new FacesMessage("Authentication Failed. Check username or password."));
				}
			} else {
				context.addMessage(null, new FacesMessage("Thông tin đăng nhập sai!"));
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

	public String getCreateAccount() {
		return "register?faces-redirect=true";
	}

	public String getCancelRegister() {
		return "login?faces-redirect=true";
	}

	public String CreateAnAccount() {
		String useName = this.clientRegisterForm.getUseName();
		String usePassword = this.clientRegisterForm.getUsePassword();
		String usePhone = this.clientRegisterForm.getUsePhone();
		String useEmail = this.clientRegisterForm.getUseEmail();
		String useAddress = this.clientRegisterForm.getUseAddress();
		String useBirhtday = this.clientRegisterForm.getUseBirthday();
		User user = new User();
		user.setUserName(useName);
		user.setUserPassword(usePassword);
		user.setUserPhone(usePhone);
		user.setUserEmail(useEmail);
		user.setUserAddress(useAddress);
		user.setUserBirthday(Date.valueOf(useBirhtday));
		user.setUserActive(1);
		user.setUserGender(1);
		user.setUserFacebook("damhaihiep");
		if (userService.checkUserByName(useName)) {
			System.out.println("User da ton tai! ");
			return "";
		}
		userService.add(user);
		return "login?faces-redirect=true";
	}
}
