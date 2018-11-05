package com.test.mymall.service;

import org.apache.ibatis.session.SqlSession;

import com.test.mymall.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	SqlSession sqlSession = null;

	public void updateMember(Member member) {
		System.out.println("MemberService.java - updateMember");
		try {
			sqlSession = DBHelper.getSqlSession();
			memberDao = new MemberDao();
			memberDao.updateMember(sqlSession, member);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public Member selectMember(String id) {
		System.out.println("MemberService.java - selectMember");
		Member selectMember = new Member();
		try {
			sqlSession = DBHelper.getSqlSession();
			memberDao = new MemberDao();
			selectMember = memberDao.selectMember(sqlSession, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return selectMember;
	}

	public boolean deleteMember(Member member) {
		System.out.println("MemberService.java - deleteMember");
		int check = 0;
		boolean checkResult = false;
		try {
			sqlSession = DBHelper.getSqlSession();
			// sqlSession.setAutoCommit(false);
			memberDao = new MemberDao();
			memberItemDao = new MemberItemDao();
			check = memberDao.deleteCheckMember(sqlSession, member);
			if (check >= 1) {
				System.out.println("MemberService.java - DeleteSuccess");
				checkResult = true;
				memberItemDao.deleteMemberItem(sqlSession, member);
				memberDao.deleteMember(sqlSession, member);
				sqlSession.commit();
			} else {
				System.out.println("MemberService.java - DeleteFail");
			}
		} catch (Exception e) {
			try {
				sqlSession.rollback();
			} finally {
				sqlSession.close();
			}
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return checkResult;
	}

	public Member login(Member member) {
		System.out.println("MemberService.java - login");
		memberDao = new MemberDao();
		Member loginmember = new Member();
		try {
			sqlSession = DBHelper.getSqlSession();
			loginmember = memberDao.login(sqlSession, member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return loginmember;
	}

	public void addMember(Member member) {
		System.out.println("MemberService.java - addMember");
		memberDao = new MemberDao();
		try {
			sqlSession = DBHelper.getSqlSession();
			memberDao.insertMember(sqlSession, member);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
}
