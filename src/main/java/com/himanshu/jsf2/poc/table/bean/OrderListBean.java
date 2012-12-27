package com.himanshu.jsf2.poc.table.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "orderListBean")
@SessionScoped
public class OrderListBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final List<Order> orderList = new ArrayList<Order>();

	public List<Order> getOrderList() {
		return orderList;
	}

	public String gotoAddOrder() {
		return "addOrder?faces-redirect=true";
	}

}
