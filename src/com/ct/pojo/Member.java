package com.ct.pojo;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.ct.exception.BookCartException;
import com.ct.exception.CartListException;
import com.ct.service.BookCartService;
import com.ct.service.CartListService;

public class Member implements HttpSessionBindingListener{
	private Integer memberID;
	private String memberEmail;
	private String memberName;
	private String memberPassword;

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	@Override
	public String toString() {
		return "Member [memberID=" + memberID + ", memberEmail=" + memberEmail + ", memberName=" + memberName
				+ ", memberPassword=" + memberPassword + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		HttpSession session  = arg0.getSession();
		Member m = (Member) arg0.getValue();
		BookCart bookCart = null;
		Map<Integer, Integer> cartMap = null;
		try {
			System.out.println("=============");
			System.out.println("ID==="+m.getMemberID());
			bookCart = new BookCartService().findBookCart(m.getMemberID()+"");
			cartMap = new CartListService().findCartList(bookCart.getCartID());
		} catch (BookCartException e) {
			e.printStackTrace();
		} catch (CartListException e) {
			e.printStackTrace();
		}
		session.setAttribute("dataBaseBookCart", bookCart);
		session.setAttribute("dataBaseCartMap", cartMap);
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		HttpSession session  = arg0.getSession();
		
	}

}
