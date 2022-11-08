package com.ct.domain;

import java.math.BigDecimal;

import com.ct.exception.OrderException;
import com.ct.service.OrderListService;
import com.ct.service.OrderService;

public class OrderList {
	private static Integer orderlistID;
	private Integer orderID;
	private Integer bookID;
	private double disPrice;
	private Integer discount;
	private String bookName;
	private BigDecimal totalMoney;
	
	static {
		try {
			int count = new OrderListService().lastOrderID()+1;
			orderlistID = count++;
		} catch (OrderException e) {
			e.printStackTrace();
		}
	}
	
	public BigDecimal getTotalMoney() {
		BigDecimal tmp1 = new BigDecimal(getDiscount()+"");
		BigDecimal tmp2 = new BigDecimal(getDisPrice()+"");
		return tmp2.multiply(tmp1);
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getOrderlistID() {
		return orderlistID;
	}

	public void setOrderlistID(Integer orderlistID) {
		this.orderlistID = orderlistID;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getBookID() {
		return bookID;
	}

	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}

	public double getDisPrice() {
		return disPrice;
	}

	public void setDisPrice(double disPrice) {
		this.disPrice = disPrice;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "OrderList [orderlistID=" + orderlistID + ", orderID=" + orderID + ", bookID=" + bookID + ", disPrice="
				+ disPrice + ", discount=" + discount + "]";
	}

}
