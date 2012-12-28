package com.himanshu.jsf2.poc.converters.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "customConverterBean")
@RequestScoped
public class CustomConverterBean {
	String bookmarkURL;

	public String getBookmarkURL() {
		return bookmarkURL;
	}

	public void setBookmarkURL(String bookmarkURL) {
		this.bookmarkURL = bookmarkURL;
	}
}
