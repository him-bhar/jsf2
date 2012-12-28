package com.himanshu.jsf2.poc.events.bean;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean (name="preRenderViewEventBean")
@RequestScoped
public class PreRenderViewEventBean {
	public void isAdmin(ComponentSystemEvent event) {

		FacesContext fc = FacesContext.getCurrentInstance();

		if (!"admin"
				.equals(fc.getExternalContext().getSessionMap().get("role"))) {

			ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc
					.getApplication().getNavigationHandler();

			nav.performNavigation("access-denied");
		}
	}

}
