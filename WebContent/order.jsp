<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>您的订单</title>
<style type="text/css">
/* order页面的css */
* {
	padding: 0;
	margin: 0;
	font-size: 16px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

#order th {
	background-color: white;
}

#order table {
	width: 700px;
}

#order tr {
	width: 100%;
	height: 26px;
}

#order td {
	background-color: white;
}

#order table tr td {
	width: 200px;
	max-width: 80px;
	text-align: right;
}

#order table tr td+td {
	width: 500px;
	text-align: left;
}
</style>
</head>
<body id="order">
	<form action="AddOrderServlet" method="post">
		<table>
			<th colspan="4">*您的订单*</th>
			<tr>
				<td>收货人：</td>
				<td colspan="3"><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>联系电话：</td>
				<td colspan="3"><input type="text" name="phone"
					placeholder="电话号码为11位" /></td>
			</tr>
			<tr>
				<td>详细地址：</td>
				<td colspan="3"><input type="text" name="address"
					style="width: 500px;" /></td>
			</tr>
			<tr>
				<td>邮编：</td>
				<td colspan="3"><input type="text" name="youbian"
					style="width: 80px;" /></td>
			</tr>
			<tr>
				<td>付款方式：</td>
				<td colspan="3"><select name="money" style="width: 89px;">
						<option value="邮局汇款" selected="selected">邮局汇款</option>
						<option value="银行转账">银行转账</option>
						<option value="货到付款">货到付款</option>
				</select></td>
			</tr>
			<tr>
				<td>配送方式</td>
				<td colspan="3"><select name="kuaidi" style="width: 89px;">
						<option value="普通邮寄" selected="selected">普通邮寄</option>
						<option value="送货上门">送货上门</option>
						<option value="特快快递">货到付款</option>
				</select></td>
			</tr>
			<tr>
				<td style="width: 200px;">操作</td>
				<td><button type="submit">提交</button></td>
				<td><button type="button">
						<a href="shopMenu.jsp">查看购物车</a>
					</button></td>
				<td><button type="button">
						<a href="books.jsp">暂不下单，继续选购</a>
					</button></td>
			</tr>
		</table>
	</form>
</body>
</html>
