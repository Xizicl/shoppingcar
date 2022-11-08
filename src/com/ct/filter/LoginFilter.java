package com.ct.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ct.pojo.Member;
import com.ct.exception.LoginException;
import com.ct.service.MemberService;
import com.ct.util.GetCookie;


@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {


	public LoginFilter() {
	}


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("来到自动登录！");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("admin");
		String url = req.getRequestURI();

		System.out.println("请求的url：" + url);
		/* 登录页面不需要过滤 */
		int idx = url.lastIndexOf("/");
		String endWith = url.substring(idx + 1);

		if (!endWith.equals("index.jsp")) {
			Member user = (Member) session.getAttribute("member");
			if (user != null) {
				System.out.println("session不为空，放行！");
				chain.doFilter(req, response);
			} else {
				Cookie[] cookies = req.getCookies();
				Cookie usre_cookie = GetCookie.getCookie(cookies, "auto_login");
				if (usre_cookie == null) {
					System.out.println("LoginFilter的auto_login为空，需要登录");
					req.getRequestDispatcher("/index.jsp").forward(req, response);
				} else {
					String[] values = usre_cookie.getValue().split("#ytl#");
					try {
						Member member1 = new MemberService().login(values[0], values[1]);
						session.setAttribute("user", member1);
						chain.doFilter(request, response);
					} catch (LoginException e) {
						e.printStackTrace();
						chain.doFilter(request, response);
					}
				}
			}

		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
