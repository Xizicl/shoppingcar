package com.ct.service;

import java.sql.SQLException;
import java.util.List;

import com.ct.dao.OrderListDao;
import com.ct.pojo.OrderList;
import com.ct.exception.OrderException;

public class OrderListService {
	public void add(OrderList orderList) throws OrderException {
		OrderListDao dao = new OrderListDao();
		int rows = 0;
		try {
			rows = dao.add("insert into orderlist values(null"+"," + orderList.getOrderID() + "," + orderList.getBookID()
					+ "," + orderList.getDisPrice() + "," + orderList.getDiscount() + ")");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (rows == 0) {
			throw new OrderException("订单列表处理异常！");
		}
	}
	public int lastOrderID() throws OrderException {
		OrderListDao dao = new OrderListDao();
		try {
			List<OrderList> orderLists = dao.find("");
			return orderLists.get(orderLists.size()-1).getOrderlistID();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OrderException("数据库订单处理异常！");
		}
	}
}
