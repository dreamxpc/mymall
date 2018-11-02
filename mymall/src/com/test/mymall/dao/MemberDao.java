package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.mymall.vo.Member;

public class MemberDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void insertMember(Connection conn, Member m) throws SQLException {
		System.out.println("MemberDao.java - insertMember");
		pstmt = conn.prepareStatement("insert into member(id,pw,level) value(?,?,?)");
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPw());
		pstmt.setInt(3, m.getLevel());
		pstmt.executeUpdate();
		pstmt.close();
	}

	public Member login(Connection conn, Member m) throws SQLException {
		System.out.println("MemberDao.java - login");
		pstmt = conn.prepareStatement("select no,id,level from member where id=? and pw=?");
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPw());
		rs = pstmt.executeQuery();
		if (rs.next()) {
			m.setNo(rs.getInt(1));
			m.setId(rs.getString(2));
			m.setLevel(rs.getInt(3));
			m.setPw("");
		} else {
			m = null;
		}
		rs.close();
		pstmt.close();
		return m;
	}
	public Member selectMember(Connection conn,String id) {
		sysou
	}
}