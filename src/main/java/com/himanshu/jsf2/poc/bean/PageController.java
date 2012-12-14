package com.himanshu.jsf2.poc.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "pageControl")
@SessionScoped
public class PageController implements Serializable {

	private static final long serialVersionUID = 1L;

	public String processPage1() {
		return "success";
	}

	public String processPage2() {
		return "success";
	}
}