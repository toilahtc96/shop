package stackjava.com.demojsf.form;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ClientRegisterForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String useName;
	private String usePhone;
	private String usePassword;
	private Date useBirthday;
	private String useAddress;
	private String useEmail;
	public String getUseName() {
		return useName;
	}
	public void setUseName(String useName) {
		this.useName = useName;
	}
	public String getUsePhone() {
		return usePhone;
	}
	public void setUsePhone(String usePhone) {
		this.usePhone = usePhone;
	}
	public String getUsePassword() {
		return usePassword;
	}
	public void setUsePassword(String usePassword) {
		this.usePassword = usePassword;
	}
	public Date getUseBirthday() {
		return useBirthday;
	}
	public void setUseBirthday(Date useBirthday) {
		this.useBirthday = useBirthday;
	}
	public String getUseAddress() {
		return useAddress;
	}
	public void setUseAddress(String useAddress) {
		this.useAddress = useAddress;
	}
	public String getUseEmail() {
		return useEmail;
	}
	public void setUseEmail(String useEmail) {
		this.useEmail = useEmail;
	}
	
	
}
