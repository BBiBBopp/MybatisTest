package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TemplateClone {
	//마이바티스
	public static SqlSession getSqlSession() {
		SqlSession sqlSession = null;
		
		String resource = "/mybatis-config.xml";
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}
}
