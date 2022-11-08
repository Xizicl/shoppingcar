package com.ct.pojo;

public class CartList {
	private Integer cartlistID;
	private Integer cartID;
	private Integer bookID;
	private double disPrice;
	private Integer bookCount;

	public Integer getCartlistID() {
		return cartlistID;
	}

	public void setCartlistID(Integer cartlistID) {
		this.cartlistID = cartlistID;
	}

	public Integer getCartID() {
		return cartID;
	}

	public void setCartID(Integer cartID) {
		this.cartID = cartID;
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

	public Integer getBookCount() {
		return bookCount;
	}

	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}

	@Override
	public String toString() {
		return "CartList [cartlistID=" + cartlistID + ", cartID=" + cartID + ", bookID=" + bookID + ", disPrice="
				+ disPrice + ", bookCount=" + bookCount + "]";
	}

}
