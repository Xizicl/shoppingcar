package com.ct.pojo;

import com.ct.exception.OrderException;
import com.ct.service.OrderService;

public class Order {
	private static Integer orderID;
	private Integer memberID;
	private String orderTime;
	private String consignee;
	private String tel;
	private String address;
	private String postNumber; 
	private Integer totalCount;
	private double totalPrice;
	private String paymode;
	private String delivermode;
	private String isOut;
	
	static {
		try {
			int count = new OrderService().lastOrderID()+1;
			orderID = count++;
		} catch (OrderException e) {
			e.printStackTrace();
		}
	}

	public String getDelivermode() {
		return delivermode;
	}

	public void setDelivermode(String delivermode) {
		this.delivermode = delivermode;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymode() {
		return paymode;
	}

	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}

	public String getIsOut() {
		return isOut;
	}

	public void setIsOut(String isOut) {
		this.isOut = isOut;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", memberID=" + memberID + ", orderTime=" + orderTime + ", consignee="
				+ consignee + ", tel=" + tel + ", address=" + address + ", postNumber=" + postNumber + ", totalCount="
				+ totalCount + ", totalPrice=" + totalPrice + ", paymode=" + paymode + ", delivemode=" + delivermode
				+ ", isOut=" + isOut + "]";
	}

}
