package com.test.mymall.commons;

import java.io.InputStream;
import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBHelper {
	public static SqlSession getSqlSession() throws Exception {
		System.out.println("DBHelper.java - getSqlSession");
		InputStream inputStream = null;

		try {
			String resource = "mybatis-config.xml";
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();

//		 sqlSession.commit();
//		 sqlSession.rollback();
//		 sqlSession.close();
		return sqlSession;

	}
}