package com.himanshu.jsf2.poc.ui.controls.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LinkBackingBean {

	private String userName;
	private String password;
	private String alertUserName = "PRE_RENDER_DUMMY_USER";

	public String getAlertUserName() {
		return alertUserName;
	}

	public void setAlertUserName(String alertUserName) {
		this.alertUserName = alertUserName;
	}

	private String VALID_USERNAME = "HIMANSHU";
	private String VALID_PASSWORD = "password";

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String gotoLoginSuccessPage() {
		return "/ui-controls/link/loginSuccess";
	}

	public String gotoLoginFailedPage() {
		return "/ui-controls/link/loginFailed";
	}

	public String goLoginPage() {
		if (VALID_USERNAME.equalsIgnoreCase(getUserName())
				&& VALID_PASSWORD.equals(getPassword())) {
			return gotoLoginSuccessPage();
		} else {
			return gotoLoginFailedPage();
		}
	}

	public String  gotoLoginAlertPage() {
		return "/ui-controls/link/loginAlert";
	}
}
