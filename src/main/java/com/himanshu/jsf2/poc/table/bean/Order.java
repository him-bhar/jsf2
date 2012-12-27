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

	boolean editable = false;

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

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
		return "addOrder?faces-redirect=true";	//Redirection added to avoid resubmission of same form on page refresh
	}

	public String deleteOrder () {
		String orderToDelete = lookupOrder();
		System.out.println("Order to delete : "+ orderToDelete);
		Order orderToDeleteObj = null;
		for (Order o:OrderListBean.orderList) {
			if (o.getOrderNo().equalsIgnoreCase(orderToDelete)) {
				orderToDeleteObj = o;
				break;
			}
		}
		OrderListBean.orderList.remove(orderToDeleteObj);
		return "displayTable?faces-redirect=true";
	}

	public String editOrder () {
		String orderToDelete = lookupOrder();
		System.out.println("Order to edit : "+ orderToDelete);
		Order orderToEditObj = null;
		for (Order o:OrderListBean.orderList) {
			if (o.getOrderNo().equalsIgnoreCase(orderToDelete)) {
				o.setEditable(Boolean.TRUE);
				orderToEditObj = o;
				break;
			}
		}
		this.orderNo = orderToEditObj.orderNo;
		this.price = orderToEditObj.price;
		this.productName = orderToEditObj.productName;
		this.qty = orderToEditObj.qty;
		this.editable = orderToEditObj.editable;
		return "displayTable?faces-redirect=true";
	}

	private String lookupOrder () {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String orderToDelete = params.get("order");
		return orderToDelete;
	}

	public String updateOrder (Order newOrder) {
		String orderToDelete = newOrder.getOrderNo();
		System.out.println("Order to update : "+ orderToDelete);
		Order orderToDeleteObj = null;
		for (Order o:OrderListBean.orderList) {
			if (o.getOrderNo().equalsIgnoreCase(orderToDelete)) {
				orderToDeleteObj = o;
				break;
			}
		}
		OrderListBean.orderList.remove(orderToDeleteObj);
		OrderListBean.orderList.add(newOrder);
		orderToDeleteObj.setEditable(Boolean.FALSE);
		return "displayTable?faces-redirect=true";
	}

	public String gotoTable() {
		return "displayTable?faces-redirect=true";
	}
	// getter and setter methods
}
