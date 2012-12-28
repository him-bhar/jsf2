package com.himanshu.jsf2.poc.events.bean;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class ValueChangeListenerImpl implements ValueChangeListener {

	@Override
	public void processValueChange(ValueChangeEvent event)
			throws AbortProcessingException {
		System.out.println("Value change listener called in impl.");
		// access country bean directly
		ValueChangeListenerBean country = (ValueChangeListenerBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("valueChangeListenerBean");
		country.setLocaleCode(event.getNewValue().toString());
	}

}