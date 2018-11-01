package com.test.mymall.service;

import java.sql.Connection;

import com.test.mymal.commons.DBHelper;
import com.test.mymall.dao.MemberDao;
import com.test.mymall.dao.MemberItemDao;
import com.test.mymall.vo.Member;

public class MemberService {
	private MemberDao memberDao;
	private MemberItemDao memberItemDao;
	
	// RemoveMemberController → MemberService.removeMember()호출
	public void removeMember(int no) {
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			conn.setAutoCommit(false);
			memberDao = new MemberDao();
			memberDao.deleteMember(conn, no);
			memberItemDao = new MemberItemDao();
			memberItemDao.deleteMemberItem(conn, no);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			DBHelper.close(null, null, conn);
		}
		
	}
	public void addMember(Member member) {
		memberDao = new MemberDao();
		memberDao.insertMember(member);
	}
}
