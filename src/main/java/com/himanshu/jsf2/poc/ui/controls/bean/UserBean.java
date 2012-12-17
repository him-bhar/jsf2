package com.himanshu.jsf2.poc.ui.controls.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class UserBean implements Serializable {

	private String hiddenAnswer = "Hello hidden field here!!!";

	public String getHiddenAnswer() {
		return hiddenAnswer;
	}

	public void setHiddenAnswer(String hiddenAnswer) {
		this.hiddenAnswer = hiddenAnswer;
	}

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String user() {
		return "/ui-controls/textBoxControlView";
	}

	public String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}