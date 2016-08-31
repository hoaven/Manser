package com.kakanshun.server.impl;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kakanshun.crud.PeoMapper;
import com.kakanshun.domain.Pas;
import com.kakanshun.server.UserServer;

public class UserServerImpl implements UserServer{
	public String getPassword(String username) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		String pas = mapper.getPassword(username);
		session.close();
		return pas;
	}
}
