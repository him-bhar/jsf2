package com.himanshu.jsf2.poc.ui.controls.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@RequestScoped
public class AttributeBean {
	public String nickname;

	// action listener event
	public void attrListener(ActionEvent event) {
		nickname = (String) event.getComponent().getAttributes().get("username");
	}

	public String outcome() {
		return "result";
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
