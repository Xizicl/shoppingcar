package com.ct.service;

import java.sql.SQLException;
import java.util.List;

import com.ct.dao.BookDao;
import com.ct.domain.Book;
import com.ct.exception.BookException;

public class BookService {
	public List<Book> selectAll() throws BookException{
		BookDao dao = new BookDao();
		List<Book> books = null;
		try {
			books = dao.find("");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BookException("书籍查询失败！");
		}
		if(books.isEmpty()||books.size()==0) {
			throw new BookException("书籍的个数为0！");
		}
		return books;
	}
	
	public Book selectOne(String bookID) throws BookException{
		BookDao dao = new BookDao();
		List<Book> books = null;
		try {
			books = dao.find("where bookID = " + bookID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BookException("书籍查询失败！");
		}
		if(books.isEmpty()||books.size()==0) {
			throw new BookException("书籍的个数为0！");
		}
		return books.get(0);
	}
}
