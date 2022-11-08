package com.ct.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ct.pojo.Member;
import com.ct.util.JDBCUtil02;

public class MemberDao{
	public Member selectOne(String memberEmail) throws SQLException {
		QueryRunner query = new QueryRunner();
		Connection conn = JDBCUtil02.getConn();
		return query.query(conn, "select * from member where memberEmail = ?", new BeanHandler<Member>(Member.class), memberEmail);
	}

}
