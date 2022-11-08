package com.ct.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ct.domain.Book;
import com.ct.util.JDBCUtil02;

public class BookDao {
	public List<Book> find(String sql) throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from books "+sql, new BeanListHandler<Book>(Book.class));
	}
}
