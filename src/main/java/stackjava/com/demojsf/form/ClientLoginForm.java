package stackjava.com.demojsf.form;

import java.io.Serializable;

public class ClientLoginForm implements Serializable{
	private String username;
	private String password;
	private boolean check;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	
	
}
