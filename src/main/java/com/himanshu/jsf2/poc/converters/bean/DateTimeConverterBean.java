package com.himanshu.jsf2.poc.converters.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "dateTimeConverterBean")
@RequestScoped
public class DateTimeConverterBean {
	Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
