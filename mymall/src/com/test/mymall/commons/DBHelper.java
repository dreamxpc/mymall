package com.test.mymall.commons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBHelper {
	public static Connection getConnection() throws Exception {
		System.out.println("DBHelper.java");
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		String jdbcDriver = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=euckr";
		String dbID = "root";
		String dbPW = "java0000";
		conn = DriverManager.getConnection(jdbcDriver, dbID, dbPW);
		return conn;
	}

	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
	}
}