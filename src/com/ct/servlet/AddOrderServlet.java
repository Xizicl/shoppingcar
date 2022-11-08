package com.ct.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ct.domain.Book;
import com.ct.domain.Member;
import com.ct.domain.Order;
import com.ct.domain.OrderList;
import com.ct.exception.BookException;
import com.ct.service.BookService;
import com.ct.service.OrderListService;
import com.ct.service.OrderService;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		HashMap<Integer, Integer> map = (HashMap<Integer, Integer>) session.getAttribute("dataBaseCartMap");
		Member m = (Member)session.getAttribute("member");
		PrintWriter pw = response.getWriter();
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String postNumber = request.getParameter("youbian");
		String paymode = request.getParameter("money");
		String delivermode = request.getParameter("kuaidi");
		Order order = new Order();
		order.setOrderTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		order.setMemberID(m.getMemberID());
		order.setConsignee(userName);
		order.setTel(phone);
		order.setAddress(address);
		order.setPostNumber(postNumber);
		order.setTotalCount((Integer) session.getAttribute("count"));
		order.setTotalPrice(Double.parseDouble(session.getAttribute("totalMoney") + ""));
		order.setPaymode(paymode);
		order.setDelivermode(delivermode);
		order.setIsOut("0");
		System.out.println(order);
		List<OrderList> orderLists = new ArrayList<OrderList>();
		BookService service = new BookService();

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			OrderList orderList = new OrderList();
			orderList.setOrderID(order.getOrderID());
			orderList.setBookID(entry.getKey());
			try {
				Book book = service.selectOne(entry.getKey() + "");
				orderList.setDisPrice(Double.parseDouble(book.getTotalMoney()));
				orderList.setBookName(book.getBookName());
			} catch (BookException e) {
				e.printStackTrace();
			}
			orderList.setDiscount(entry.getValue());
			orderLists.add(orderList);
		}

		try {
			new OrderService().addOrder(order);
			for (OrderList orderList : orderLists) {
				new OrderListService().add(orderList);
			}
		}catch(Exception e){
			e.printStackTrace();
			pw.println("<script>alert('"+e.getMessage()+"')</script>");
			pw.print("<script>location.href='index.jsp'</script>");
		}
		request.setAttribute("order", order);
		request.setAttribute("orderLists", orderLists);
		request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
