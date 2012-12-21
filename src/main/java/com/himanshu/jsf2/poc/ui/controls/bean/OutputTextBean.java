package com.himanshu.jsf2.poc.ui.controls.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class OutputTextBean {
	private String greet = "Greeting from class";
	private String inputHtml = "<input type='text' />";

	public String getInputHtml() {
		return inputHtml;
	}

	public void setInputHtml(String inputHtml) {
		this.inputHtml = inputHtml;
	}

	public String getGreet() {
		return greet;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}
}
