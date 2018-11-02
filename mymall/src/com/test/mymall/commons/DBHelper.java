package com.test.mymall.commons;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBHelper{
	public static SqlSession getConnection() {
		InputStream inputStream = null;
		try {
			String resource = "mybatis-config.xml";
			inputStream  = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
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