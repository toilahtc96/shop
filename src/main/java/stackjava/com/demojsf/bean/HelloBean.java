package stackjava.com.demojsf.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import stackjava.com.demojsf.model.User;
import stackjava.com.demojsf.service.HelloService;
import stackjava.com.demojsf.service.UserService;

@ManagedBean
@RequestScoped
public class HelloBean {

	@ManagedProperty(value = "#{helloService}")
	HelloService helloService;
	@ManagedProperty(value = "#{userService}")
	UserService userService;
	
	public UserService getUserService() {
		userService = new UserService();
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;		
	}

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String sayHello() {
//		userService = this.getUserService();
//		User user = new User();
//		user.setUserEmail(name);
//		user.setUserName(getName());
//		user.setUserPassword(name);
//		user.setUserActive(1);
//		user.setUserBirthday(new Date());
//		user.setUserGender(1);
//		user.setUserAvarta(name);
//		user.setUserFacebook(name);
//		userService.add(user);
//		return "hello?face-redirect=true";
//	}
	
	public String adminLogin(){
		return "adminLogin";
	}

	public HelloService getHelloService() {
		if (this.helloService == null) {
			helloService = new HelloService();
		}
		return helloService;
	}

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}

}
