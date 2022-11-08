package com.ct.pojo;

public class BookCart {
	private Integer cartID;
	private int memberID;
	private String createTime;
	private double totalPrice;
	private Integer totalCount;

	public Integer getCartID() {
		return cartID;
	}

	public void setCartID(Integer cartID) {
		this.cartID = cartID;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "BookCart [cartID=" + cartID + ", memberID=" + memberID + ", createTime=" + createTime + ", totalPrice="
				+ totalPrice + ", totalCount=" + totalCount + "]";
	}

}
