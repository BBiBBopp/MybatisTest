package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	// 마이바티스
	public static SqlSession getSqlSession() {
		// mybatis-config.xml파일을 읽어들여서
		// 해당 DB와 접속된 SqlSession 객체를 생성해서 반환
		SqlSession sqlSession = null;
		
		// SqlSession 객체를 생성하기 위해서는 SqlSessionFactory 객체 필요
		// SqlSessionFactory 객체를 생성하기 위해서는 SqlSessionFactoryBuilder객체 필요
		String resource = "/mybatis-config.xml";
		// / 는 모든 소스폴더의 최상위 폴더들을 의미(resources, src)

		try {
			InputStream stream = Resources.getResourceAsStream(resource); // 자원으로부터 통로를 얻어내겠다.
			
			// 1단계 : new SqlSessionFactoryBuilder() : sqlSessionFactoryBuilder 객체 생성
			// 2단계 : .build(stream) : 통로로부터 mybatis-config.xml파일을 읽어들여서 sqlSessionFactory객체를 만들겠다.
			// 3단계 : .openSession(false) : sqlSession객체 생성 및 앞으로 트랜잭션 처리 시 자동으로 commit을 할건지 안할건지 여부 지정
			// => false == 자동커밋을 하지 않겠다. == 개발자가 직접 commit하겠다
			// => openSession() 기본값은 false이긴 함
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return sqlSession;
	}
	

}
