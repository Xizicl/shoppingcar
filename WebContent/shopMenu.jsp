<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.util.Map.Entry"%>
<%@ page import="com.ct.domain.*,com.ct.service.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>购物清单</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
	font-size: 16px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

/* shopMenu页面的css */
#shopMenu table {
	width: 700px;
	margin: 0 auto;
	/* table-layout: fixed;
				word-break: break-all;
				word-wrap: break-word; */
}

#shopMenu .wenzi-right {
	text-align: right;
}

#shopMenu .wenzi-center {
	text-align: center;
}

#shopMenu table tr {
	background-color: white;
	width: 700px;
	height: 20px;
}

#shopMenu .anniu {
	padding: 0 260px;
}

#shopMenu .anniu button {
	margin: 0 5px;
}

#shopMenu #result {
	width: 50px;
	height: 20px;
	display: inline-block;
	border: 1px solid black;
}
</style>
</head>
<body id="shopMenu">
	<table border="0">
		<th colspan="5" style="font-size: 26px;">*您的购物清单*</th>
		<tr style="text-align: center;">
			<td>图书名称</td>
			<td>市场价</td>
			<td>折扣价</td>
			<td>数量</td>
			<td>删除</td>
		</tr>
		<%
			HashMap<Integer, Integer> map = (HashMap<Integer, Integer>) session.getAttribute("dataBaseCartMap");
			BookService service = new BookService();
			BigDecimal totalMoney = new BigDecimal("0.00");
			int count = 0;
			BigDecimal chajia = new BigDecimal("0.00");
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				Book book = service.selectOne(entry.getKey() + "");
				BigDecimal tmp1 = new BigDecimal(book.getTotalMoney());
				totalMoney = totalMoney.add(tmp1.multiply(new BigDecimal(entry.getValue() + "")));
				count += entry.getValue();
				chajia = chajia.add(new BigDecimal(entry.getValue() + "")
						.multiply(new BigDecimal(book.getBookPrice() + "").subtract(tmp1)));
		%>
		<tr>
			<td style="width: 200px; max-width: 200px;"><%=book.getBookName()%></td>
			<td class="wenzi-right, yuanjia" style="width: 150px;"><%=book.getBookPrice()%></td>
			<td class="wenzi-right, total" style="width: 150px;"><%=book.getTotalMoney()%></td>
			<td class="wenzi-right" style="width: 150px;"><input
				type="number" name="number" id="count"
				style="width: 50px; margin-right: 5px;"
				value="<%=entry.getValue()%>" />
				<button type="button" onclick="add('<%=book.getBookID()%>')">确定</button></td>
			<td class="wenzi-center" style="width: 50px;"><button
					type="button">
					<a href="/shoppingcar/DeleteNumServlet?id=<%=book.getBookID()%>">删除</a>
				</button></td>
		</tr>
		<%
			}
			session.setAttribute("totalMoney", totalMoney);
			session.setAttribute("count", count);
			pageContext.setAttribute("chajia", chajia);
		%>
		<script type="text/javascript">
			function add(id) {
				var count = document.getElementById("count").value;
				location.href = "/shoppingcar/AddNumServlet?id=" + id + "&count="
						+ count;
			}
		</script>
		<tr>
			<td colspan="5" style="background-color: white;"></td>
		</tr>
		<tr>
			<td class="wenzi-right">金额合计：${totalMoney}<span id="result">${totalMoney}</span></td>
			<td class="wenzi-center">数量合计：</td>
			<td class="wenzi-right">${count}本</td>
			<td class="wenzi-center">您节省了</td>
			<td class="wenzi-right">${chajia}元</td>
		</tr>
		<tr>
			<td colspan="5"></td>
		</tr>
		<tr>
			<td colspan="5" class="anniu"><button type="button">
					<a href="books.jsp">继续选购</a>
				</button>
				<button type="button">
					<a href="order.jsp">下单</a>
				</button></td>
		</tr>
	</table>
</body>
</html>
