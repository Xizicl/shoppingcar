package com.ct.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.ct.domain.Order;
import com.ct.util.JDBCUtil02;

public class OrderDao {
	public List<Order> find(String sql) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from orders " + sql, new BeanListHandler<Order>(Order.class));
	}

	public Integer add(Order order) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.update("insert into orders values(null,?,?,?,?,?,?,?,?,?,?,?)",
				order.getMemberID(), order.getOrderTime(), order.getConsignee(), order.getTel(), order.getAddress(),
				order.getPostNumber(), order.getTotalCount(), order.getTotalPrice(), order.getPaymode(),
				order.getDelivermode(), order.getIsOut());
	}
	
	public Integer select(String sql) throws NumberFormatException, SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return Integer.parseInt(runner.query(sql, new ScalarHandler())+"");
	}
}
