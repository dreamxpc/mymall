package com.test.mymall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.test.mymal.commons.DBHelper;
import com.test.mymall.vo.Member;

public class MemberDao {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public Member login(Member member) {
		System.out.println("login 메서드 실행 MemberDao.java");
		Member loginMember = new Member();

		try {
			connection = DBHelper.getConnection();

			preparedStatement = connection.prepareStatement("SELECT id, level FROM member WHERE id=? AND pw=?");
			preparedStatement.setString(1, member.getId());
			preparedStatement.setString(2, member.getPw());

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				loginMember.setId(resultSet.getString("id"));
				loginMember.setLevel(resultSet.getInt("level"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}

		return loginMember;
	}

	public void insertMember(Member member) {
		System.out.println("insertMember 메서드 실행 MemberDao.java");

		try {
			connection = DBHelper.getConnection();

			preparedStatement = connection.prepareStatement("INSERT INTO member (id, pw, level) VALUE (?, ?, ?)");
			preparedStatement.setString(1, member.getId());
			preparedStatement.setString(2, member.getPw());
			preparedStatement.setInt(3, member.getLevel());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}

	}
	
	//회원탈퇴
	public void deleteMember(Connection conn, int no) {
		
	}
	
/*	public void selectMember(Member member) {
		System.out.println("selectMember 메서드 실행 MemberDao.java");

		try {
			connection = DBHelper.getConnection();

			preparedStatement = connection.prepareStatement("INSERT INTO member (id, pw, level) VALUE (?, ?, ?)");
			preparedStatement.setString(1, member.getId());
			preparedStatement.setString(2, member.getPw());
			preparedStatement.setInt(3, member.getLevel());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(connection, preparedStatement, resultSet);
		}

	}*/
}