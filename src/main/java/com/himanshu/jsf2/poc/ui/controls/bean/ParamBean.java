package com.himanshu.jsf2.poc.ui.controls.bean;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ParamBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	private String countryName;

	public String outcome() {
		FacesContext fc = FacesContext.getCurrentInstance(); // Context for the current page
		this.countryName = getCountryParam(fc);
		return "/ui-controls/param/result";
	}

	// get value from "f:param"
	public String getCountryParam(FacesContext fc) {
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get("country");

	}
}
