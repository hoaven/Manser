package com.kakanshun.server.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kakanshun.crud.PeoMapper;
import com.kakanshun.domain.People;
import com.kakanshun.domain.Record;
import com.kakanshun.server.RecordServer;

public class RecordServerImpl implements RecordServer {

	public List<Record> getRecords(int startIndex, int pagesize)
			throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<Record> list = mapper.getRecords(startIndex, pagesize);
		if (list == null) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public int insertRecord(Record r) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertRecord(r);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return k;
	}

	public int RecordCount() throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.RecordCount();
		if (list == 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

}
