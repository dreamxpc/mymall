package com.test.mymall.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.test.mymall.vo.Item;

public class ItemDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<Item> selectItemList(Connection conn, int currentPage, int rowPerPage) throws SQLException {
		System.out.println("ItemDao.java - ArrayList<Item>");
		ArrayList<Item> itemList = new ArrayList<Item>();
		pstmt = conn.prepareStatement("select no,name,price from item where no limit ?, ?");
		pstmt.setInt(1, (currentPage - 1) * rowPerPage);
		pstmt.setInt(2, rowPerPage);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Item item = new Item();
			item.setNo(rs.getInt(1));
			item.setName(rs.getString(2));
			item.setPrice(rs.getInt(3));
			itemList.add(item);
		}
		rs.close();
		pstmt.close();
		return itemList;
	}

	public int getTotalItemCount(Connection conn) throws SQLException {
		System.out.println("ItemDao.java - getTotalItemCount");
		int totalCount = 0;
		pstmt = conn.prepareStatement("select count(*) from item where no");
		rs = pstmt.executeQuery();
		if (rs.next()) {
			totalCount = rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		return totalCount;
	}
}