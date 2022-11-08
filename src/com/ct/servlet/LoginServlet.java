package com.ct.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ct.domain.Member;
import com.ct.exception.BookException;
import com.ct.exception.LoginException;
import com.ct.service.BookService;
import com.ct.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60*30);
		PrintWriter pw = response.getWriter();
//		String memberName = request.getParameter("memberName");
		String memberEmail = request.getParameter("memberEmail");
		String memberPassword = request.getParameter("memberPassword");
		MemberService service = new MemberService();
		Member member = null;
		try {
			member = service.login(memberEmail, memberPassword);
			session.setAttribute("member", member);
			Cookie cookie = new Cookie("auto_login", memberEmail+"#ytl#"+memberPassword);
			cookie.setMaxAge(60*60*24*7);//7天有效期
//			cookie.setPath("/LoginFilter");
//			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
			response.sendRedirect("books.jsp");
		} catch (LoginException e) {
			e.printStackTrace();
			pw.println("<script>alert('"+e.getMessage()+"')</script>");
			pw.print("<script>location.href='index.jsp'</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
