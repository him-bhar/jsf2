package com.himanshu.jsf2.poc.events.bean;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean (name="valueChangeListenerBean")
@SessionScoped
public class ValueChangeListenerBean {
	private static final long serialVersionUID = 1L;

	private static Map<String, String> countries;

	private String localeCode = "en"; // default value

	static {
		countries = new LinkedHashMap<String, String>();
		countries.put("United Kingdom", "en"); // label, value
		countries.put("French", "fr");
		countries.put("German", "de");
		countries.put("China", "zh_CN");
	}

	public void countryLocaleCodeChanged(ValueChangeEvent e) {
		// assign new value to localeCode
		System.out.println("Value change listener called in bean.");
		localeCode = e.getNewValue().toString();

	}

	public Map<String, String> getCountryInMap() {
		return this.countries;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}
}
