package com.himanshu.jsf2.poc.events.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "actionListenerBean")
@RequestScoped
public class ActionListenerBean {
	public String buttonId;

	public void printIt(ActionEvent event) {

		// Get submit button id
		buttonId = event.getComponent().getClientId();
		System.out.println("Action listener captures : "+buttonId);

	}

	public String outcome() {
		return "result";
	}
}
