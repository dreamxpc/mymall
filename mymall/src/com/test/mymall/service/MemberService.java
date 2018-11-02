package com.test.mymall.service;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	
	// RemoveMemberController → MemberService.removeMember()호출
	public void removeMember(int no) {
		SqlSession sqlSession;
		try {
			sqlSession = DBHelper.getSqlSession();
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	public void addMember(Member member) {
		memberDao = new MemberDao();
		memberDao.insertMember(member);
	}
}
