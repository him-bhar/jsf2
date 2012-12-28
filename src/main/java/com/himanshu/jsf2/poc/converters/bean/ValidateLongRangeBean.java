package com.himanshu.jsf2.poc.converters.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

//Even if you don't spcify the managed bean name, this is default made, camel-casing the class name.
@ManagedBean (name="validateLongRangeBean")
@RequestScoped
public class ValidateLongRangeBean {

	int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
