package com.ct.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ct.dao.CartListDao;
import com.ct.domain.CartList;
import com.ct.exception.CartListException;

public class CartListService {
	public void addCartList(CartList cartList) throws CartListException {
		CartListDao dao = new CartListDao();
		int num = 0;
		try {
			num = dao.add(cartList);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CartListException("数据库添加失败！");
		}
		if(num==0) {
			throw new CartListException("添加失败！");
		}
	}
	
	public List<CartList> findAllCartList() throws CartListException {
		CartListDao dao = new CartListDao();
		List<CartList> cartList = null;
		try {
			cartList = dao.find("");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CartListException("数据库查询失败！");
		}
		if(cartList.isEmpty()) {
			throw new CartListException("查询失败失败！");
		}
		return cartList;
	}
	
	public Map<Integer, Integer> findCartList(int cartID) throws CartListException {
		CartListDao dao = new CartListDao();
		List<CartList> cartList = null;
		try {
			cartList = dao.find("where cartID = "+cartID);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CartListException("数据库查询失败！");
		}
		if(cartList.isEmpty()) {
			throw new CartListException("数据为空！");
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (CartList cartList2 : cartList) {
			map.put(cartList2.getBookID(), cartList2.getBookCount());
		}
		return map;
	}
}
