package com.test.mymall.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.vo.Member;
import com.test.mymall.vo.MemberItem;

public class MemberItemDao {
	private static String namespace = "com.test.mymall.dao.MemberItemMapper";

	public void deleteMemberItem(SqlSession sqlSession, Member member) {
		System.out.println("MemberItemDao.java - deleteMemberItem");
		sqlSession.delete(namespace + ".deleteMemberItem", member);
	}

	public int order(SqlSession sqlSession, MemberItem memberItem) {
		System.out.println("MemberItemDao.java - order");
		return sqlSession.insert(namespace + ".order", memberItem);
	}

	public List<Map<String, Object>> orderList(SqlSession sqlSession, Member member) {
		System.out.println("MemberItemDao.java - orderList");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if (member.getLevel() == 0) {
			list = sqlSession.selectList(namespace + ".guestOrderList", member);
		} else if (member.getLevel() == 1) {
			list = sqlSession.selectList(namespace + ".adminOrderList", member);
		}
		return list;
	}
}
