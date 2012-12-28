package com.himanshu.jsf2.poc.converters.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name = "validateRequiredBean")
@RequestScoped
public class ValidateRequiredBean {
	String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
