<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>订单详细页面</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
	font-size: 16px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

/* orderDetail页面的css */
#orderDetail table {
	width: 700px;
}

#orderDetail th {
	background-color: white;
}

#orderDetail tr {
	width: 100%;
	height: 26px;
}

#orderDetail td {
	background-color: #FAEBD7;
}

#orderDetail #table1 tr td {
	width: 50px;
	max-width: 80px;
	text-align: right;
}

#orderDetail #table1 tr td+td {
	width: 500px;
	text-align: left;
}

#orderDetail #table2 td {
	text-align: center;
}
</style>
</head>
<body id="orderDetail">
	<table id="table1">
		<th colspan="2">*您的订单详情*</th>
		<tr>
			<td>收货人：</td>
			<td>${order.consignee}</td>
		</tr>
		<tr>
			<td>联系电话：</td>
			<td>${order.tel}</td>
		</tr>
		<tr>
			<td>详细地址：</td>
			<td>${order.address}</td>
		</tr>
		<tr>
			<td>邮编：</td>
			<td>${order.postNumber}</td>
		</tr>
		<tr>
			<td>付款方式：</td>
			<td>${order.paymode}</td>
		</tr>
		<tr>
			<td>配送方式：</td>
			<td>${order.delivermode}</td>
		</tr>
		<tr>
			<td>总价格：</td>
			<td>${order.totalPrice}元</td>
		</tr>
		<tr>
			<td>总数量：</td>
			<td>${order.totalCount}本</td>
		</tr>
		<tr>
			<td>是否发货：</td>
			<td><c:if test="${order.isOut=='0'}">
				未发货</c:if>
				<c:if test="${order.isOut=='1'}">
				已发货</c:if>
				<button style="margin-left: 400px;">
					<a href="/book/books.jsp">购物首页</a>
				</button></td>
		</tr>
	</table>
	<table id="table2">
		<th colspan="4">订单详情</th>
		<tr>
			<td style="max-width: 400px;">图书名称</td>
			<td>购买价</td>
			<td>数量</td>
			<td>总价</td>
		</tr>
		<c:forEach items="${orderLists}" var="orderList">
			<tr>
				<td style="max-width: 400px;">${orderList.bookName}</td>
				<td>${orderList.disPrice}</td>
				<td>${orderList.discount}</td>
				<td>${orderList.totalMoney}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
