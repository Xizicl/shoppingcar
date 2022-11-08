<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ct.service.*,com.ct.exception.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>图书列表界面</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
	font-size: 16px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

#books td {
	background-color: white;
}
</style>
</head>
<%
	BookService service = new BookService();
	try {
		pageContext.setAttribute("books", service.selectAll());
	} catch (BookException e) {
		e.printStackTrace();
		out.println("<script>alert('" + e.getMessage() + "')</script>");
	}
%>
<body id="books">
	<table border="0" style="width: 800px; margin: 0 auto;">
		<th colspan="8">*库存图书列表*
			<button style="position: relative; left: 260px;">
				<a href="shopMenu.jsp">购物车</a>
			</button>
		</th>
		<tr>
			<td width="100px">图书名称</td>
			<td width="150px">ISBN</td>
			<td width="120px">作者</td>
			<td width="120px">出版社</td>
			<td width="70px">定价</td>
			<td width="70px">折扣</td>
			<td width="70px">折扣价</td>
			<td width="100px">购买</td>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
				<td width="100px">${book.bookName}</td>
				<td width="150px">${book.isbn}</td>
				<td width="120px">${book.author}</td>
				<td width="120px">${book.publisher}</td>
				<td width="70px">${book.bookPrice}</td>
				<td width="70px">${book.discount}</td>
				<td width="70px">${book.totalMoney}</td>
				<td width="100px"><a
					href="AddCartListServlet?id=${book.bookID}">购买</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
