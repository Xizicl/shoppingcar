package com.ct.util;

import javax.servlet.http.Cookie;

public class GetCookie {
	public static Cookie getCookie(Cookie[] cookies, String name) {
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				if(name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}
	
}
