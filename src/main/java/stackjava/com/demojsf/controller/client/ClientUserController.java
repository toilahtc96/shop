package stackjava.com.demojsf.controller.client;

import java.io.Serializable;
import java.sql.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import stackjava.com.demojsf.form.ClientEditUserForm;
import stackjava.com.demojsf.form.ClientLoginForm;
import stackjava.com.demojsf.model.User;
import stackjava.com.demojsf.service.UserService;

@ManagedBean
@SessionScoped
public class ClientUserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{userService}")
	UserService userService;

	@ManagedProperty(value = "#{clientLoginForm}")
	ClientLoginForm clientLoginForm;

	public void setClientLoginForm(ClientLoginForm clientLoginForm) {
		this.clientLoginForm = clientLoginForm;
	}

	@ManagedProperty(value = "#{clientEditUserForm}")
	ClientEditUserForm clientEditUserForm;

	public ClientEditUserForm getClientEditUserForm() {
		if (clientEditUserForm == null) {
			clientEditUserForm = new ClientEditUserForm();
		}
		return clientEditUserForm;
	}

	public void setClientEditUserForm(ClientEditUserForm clientEditUserForm) {
		this.clientEditUserForm = clientEditUserForm;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUpdateUserInfomation() {
		String useName = clientLoginForm.getName();
		String usePass = clientLoginForm.getPassword();
		String useNewPass = clientEditUserForm.getUseNewPass();
//		System.out.println(clientEditUserForm.toString());
		// System.out.println(useName + " " + usePass);
		User user = userService.getUserByNameAndPassword(useName, usePass);
		int useId = user.getUserId();
		// User user = new User();
		user.setUserName(clientLoginForm.getName());
		user.setUserPassword(clientEditUserForm.getUseNewPass());
		user.setUserActive(1);
		user.setUserAddress(clientEditUserForm.getUseAddress());
		user.setUserAvarta(clientEditUserForm.getUseAvatar());
		// user.setUserBirthday(Date.valueOf(clientEditUserForm.getUseDob()));
		user.setUserEmail(clientEditUserForm.getUseEmail());
		user.setUserGender(clientEditUserForm.getUseGender());
		user.setUserFacebook(clientEditUserForm.getUseFacebook());
		// Date date = (Date) new java.util.Date();
		// user.setUserUpdateTime(date);
		user.setUserPhone(clientEditUserForm.getUsePhone());
		userService.update(useId, user);
		return "home?faces-redirect=true";
	}
}
