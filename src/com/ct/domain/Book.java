package com.ct.domain;

import com.ct.util.UtilDemo;

public class Book {
	private Integer bookID;
	private String isbn;
	private String bookName;
	private double bookPrice;
	private double discount;
	private String author;
	private String publisher;
	private String totalMoney;

	public String getTotalMoney() {
		return UtilDemo.round(getBookPrice() * getDiscount());
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = UtilDemo.round(getBookPrice() * getDiscount());
	}

	public Integer getBookID() {
		return bookID;
	}

	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", isbn=" + isbn + ", bookName=" + bookName + ", bookPrice=" + bookPrice
				+ ", discount=" + discount + ", author=" + author + ", publisher=" + publisher + ", totalMoney="
				+ totalMoney + "]";
	}

	
	
}
