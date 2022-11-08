package com.ct.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ct.domain.CartList;
import com.ct.util.JDBCUtil02;

public class CartListDao {
	public Integer add(CartList cartList) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.update("insert into cartlist values(null,?,?,?,?)", cartList.getCartID(),cartList.getBookID(),cartList.getDisPrice(),cartList.getBookCount());
	}
	
	public List<CartList> find(String sql) throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from cartlist "+sql, new BeanListHandler<CartList>(CartList.class));
	} 
}
