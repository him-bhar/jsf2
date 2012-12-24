package com.himanshu.jsf2.poc.ui.controls.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="panel")
@RequestScoped
public class PanelGridBean {

	int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
