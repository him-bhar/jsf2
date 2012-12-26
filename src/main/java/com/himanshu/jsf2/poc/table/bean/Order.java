package com.himanshu.jsf2.poc.table.bean;

import java.math.BigDecimal;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean (name="orderBean")
@RequestScoped
public class Order {

	String orderNo;
	String productName;
	BigDecimal price;
	int qty;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Order(String orderNo, String productName, BigDecimal price, int qty) {

		this.orderNo = orderNo;
		this.productName = productName;
		this.price = price;
		this.qty = qty;
	}

	public Order() {

	}

	public String addNewOrder () {
		OrderListBean.orderList.add(this);
		return "displayTable?faces-redirect=true";	//Redirection added to avoid resubmission of same form on page refresh
	}

	public String deleteOrder () {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String orderToDelete = params.get("order");
		System.out.println("Order to delete : "+ orderToDelete);
		Order orderToDeleteObj = null;
		for (Order o:OrderListBean.orderList) {
			if (o.getOrderNo().equalsIgnoreCase(orderToDelete)) {
				orderToDeleteObj = o;
				break;
			}
		}
		OrderListBean.orderList.remove(orderToDeleteObj);
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "displayTable?faces-redirect=true";
	}

	// getter and setter methods
}
