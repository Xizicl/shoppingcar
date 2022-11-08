package com.ct.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ct.domain.BookCart;
import com.ct.domain.CartList;
import com.ct.util.JDBCUtil02;

public class BookCartDao {
	public Integer add(BookCart bookCart) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.update("insert into bookcart values(null,?,?,?,?)", bookCart.getMemberID(),
				bookCart.getCreateTime(), bookCart.getTotalPrice(), bookCart.getTotalCount());
	}

	public List<BookCart> find(String sql) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from bookcart " + sql, new BeanListHandler<BookCart>(BookCart.class));
	}
	
	public Integer update(int totalPrice, int totalCount, int memberID) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.update("update bookCart set totalPrice = ?, totalCount = ? where memberID = ?",totalPrice,totalCount);
	}

}
