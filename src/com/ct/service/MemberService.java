package com.ct.service;

import java.sql.SQLException;

import com.ct.dao.MemberDao;
import com.ct.pojo.Member;
import com.ct.exception.LoginException;

public class MemberService {
	MemberDao dao = new MemberDao();
	public Member login(String memberEmail, String memberPassword) throws LoginException {
		Member member = null;
		try {
			member = (Member) dao.selectOne(memberEmail);
			if(member == null) {
				throw new LoginException("该用户名不存在！");
			}
			if(!memberPassword.equals(member.getMemberPassword())) {
				throw new LoginException("密码错误！");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new LoginException("登陆失败！");
		}
		return member;
	}
}
