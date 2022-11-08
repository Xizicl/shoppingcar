package com.ct.service;

import java.sql.SQLException;
import java.util.List;

import com.ct.dao.BookCartDao;
import com.ct.pojo.BookCart;
import com.ct.exception.BookCartException;

public class BookCartService {
	public void addBookToBookCart(BookCart bookCart) throws BookCartException {
		BookCartDao dao = new BookCartDao();
		int num = 0;
		try {
			num = dao.add(bookCart);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BookCartException("添加失败，数据库有错！");
		}
		if (num == 0) {
			throw new BookCartException("添加失败，数据变化为0");
		}
	}

	public BookCart findBookCart(String memberID) throws BookCartException {
		BookCartDao dao = new BookCartDao();
		List<BookCart> bookCarts = null;
		try {
			bookCarts = dao.find("where memberID = " + memberID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BookCartException("查询失败，数据库有错！");
		}
		if (bookCarts.isEmpty()) {
			throw new BookCartException("查询失败，数据为0");
		}
		return bookCarts.get(0);
	}

	public List<BookCart> findAllBookCart() throws BookCartException {
		BookCartDao dao = new BookCartDao();
		List<BookCart> bookCarts = null;
		try {
			bookCarts = dao.find("");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BookCartException("查询失败，数据库有错！");
		}
		if (bookCarts.isEmpty()) {
			throw new BookCartException("查询失败，数据为0");
		}
		return bookCarts;
	}
}