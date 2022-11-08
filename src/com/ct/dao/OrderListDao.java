package com.ct.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ct.domain.OrderList;
import com.ct.util.JDBCUtil02;

public class OrderListDao {
	public List<OrderList> find(String sql) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from orderlist " + sql, new BeanListHandler<OrderList>(OrderList.class));
	}

	public Integer add(String sql) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.update(sql);
	}
}
