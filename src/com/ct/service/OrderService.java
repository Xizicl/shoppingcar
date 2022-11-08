package com.ct.service;

import java.sql.SQLException;
import java.util.List;

import com.ct.dao.OrderDao;
import com.ct.domain.Order;
import com.ct.exception.OrderException;

public class OrderService {
	public void addOrder(Order order) throws OrderException {
		OrderDao dao = new OrderDao();
		int rows = 0;
		try {
			rows = dao.add(order);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OrderException("数据库订单处理异常！");
		}
		if(rows == 0) {
			throw new OrderException("订单处理异常！");
		}
	}
	public int lastOrderID() throws OrderException {
		OrderDao dao = new OrderDao();
		try {
			List<Order> orders = dao.find("");
			return orders.get(orders.size()-1).getOrderID();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OrderException("数据库订单处理异常！");
		}
	}
}
