package com.himanshu.jsf2.poc.events.bean;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class ActionListenerImpl implements ActionListener {

	@Override
	public void processAction(ActionEvent event)
			throws AbortProcessingException {

		System.out.println("Any use case here?");

	}

}