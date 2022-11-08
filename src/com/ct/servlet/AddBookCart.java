package com.ct.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ct.domain.BookCart;
import com.ct.domain.Member;

/**
 * Servlet implementation class AddBookCart
 */
@WebServlet("/AddBookCart")
public class AddBookCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("来到了AddBookCart");
//		PrintWriter pw = response.getWriter();
//		HttpSession session = request.getSession();
//		// 封装数据
//		Object obj = session.getAttribute("dataBaseBookCart");
//		Map<Integer, Integer> dataBaseCartMap = (HashMap<Integer, Integer>)session.getAttribute("dataBaseCartMap");
//		Map<String, BookCart> tmp = new HashMap<String, BookCart>();
//		if (obj != null) {
//			System.out.println("session不为空！");
//			tmp = (HashMap<String, BookCart>) obj;
//			if (tmp.keySet().contains(id)) {
//				BookCart oldBookCart = tmp.get(id);
//				int tmpCount = oldBookCart.getTotalCount();
//				int count = tmpCount + 1;
//				oldBookCart.setTotalCount(count);
//				tmp.put(id, oldBookCart);
//				if (tmp.get(id).getTotalCount() > tmpCount) {
//					System.out.println("添加成功�?");
//					session.setAttribute("nowBookCarts", tmp);
//					pw.println("<script>alert('购物车添加成功！')</script>");
//					pw.print("<script>location.href='/book/books.jsp'</script>");
//				} else {
//					System.out.println("添加失败�?");
//					pw.println("<script>alert('购物车添加失败！')</script>");
//					pw.print("<script>location.href='/book/books.jsp'</script>");
//				}
//			} else {
//				//封装数据
//				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				String createTime = format.format(new Date());
//				BookCart bookCart = new BookCart();
//				bookCart.setCreateTime(createTime);
//				Member member = (Member) session.getAttribute("member");
//				bookCart.setMemberID(member.getMemberID());
//				bookCart.setTotalCount(1);
//				bookCart.setTotalPrice(num);
//				session.setAttribute("nowBookCarts", tmp);
//				pw.println("<script>alert('购物车添加成功！')</script>");
//				pw.print("<script>location.href='/book/books.jsp'</script>");
//			}
//		} else {
//			
//			System.out.println("session为空�?");
//			//封装数据
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String createTime = format.format(new Date());
//			BookCart bookCart = new BookCart();
//			bookCart.setCreateTime(createTime);
//			Member member = (Member) session.getAttribute("member");
//			bookCart.setMemberID(member.getMemberID());
//			bookCart.setTotalCount(1);
//			bookCart.setTotalPrice(num);
//			session.setAttribute("nowBookCarts", tmp);
//			pw.println("<script>alert('购物车添加成功！')</script>");
//			pw.print("<script>location.href='/book/books.jsp'</script>");
//		}
//	}

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
