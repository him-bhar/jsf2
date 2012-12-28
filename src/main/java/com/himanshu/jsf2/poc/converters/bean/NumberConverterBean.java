package com.himanshu.jsf2.poc.converters.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "numberConverterBean")
@RequestScoped
public class NumberConverterBean implements Serializable {

	double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
