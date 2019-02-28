package stackjava.com.demojsf.form;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ClientEditUserForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String useName;
	private String useNewPass;
	private String usePhone;
	private String useEmail;
	private String useAddress;
	private String useDob;
	private int useGender;
	private String useAvatar;
	private String useFacebook;
	public String getUseName() {
		return useName;
	}
	public void setUseName(String useName) {
		this.useName = useName;
	}
	public String getUseNewPass() {
		return useNewPass;
	}
	public void setUseNewPass(String useNewPass) {
		this.useNewPass = useNewPass;
	}
	public String getUsePhone() {
		return usePhone;
	}
	public void setUsePhone(String usePhone) {
		this.usePhone = usePhone;
	}
	public String getUseEmail() {
		return useEmail;
	}
	public void setUseEmail(String useEmail) {
		this.useEmail = useEmail;
	}
	public String getUseAddress() {
		return useAddress;
	}
	public void setUseAddress(String useAddress) {
		this.useAddress = useAddress;
	}
	public String getUseDob() {
		return useDob;
	}
	public void setUseDob(String useDob) {
		this.useDob = useDob;
	}
	public int getUseGender() {
		return useGender;
	}
	public void setUseGender(int useGender) {
		this.useGender = useGender;
	}
	public String getUseAvatar() {
		return useAvatar;
	}
	public void setUseAvatar(String useAvatar) {
		this.useAvatar = useAvatar;
	}
	public String getUseFacebook() {
		return useFacebook;
	}
	public void setUseFacebook(String useFacebook) {
		this.useFacebook = useFacebook;
	}
	@Override
	public String toString() {
		return "ClientEditUserForm [useName=" + useName + ", useNewPass=" + useNewPass + ", usePhone=" + usePhone
				+ ", useEmail=" + useEmail + ", useAddress=" + useAddress + ", useDob=" + useDob + ", useGender="
				+ useGender + ", useAvatar=" + useAvatar + ", useFacebook=" + useFacebook + "]";
	}
	

	
}
