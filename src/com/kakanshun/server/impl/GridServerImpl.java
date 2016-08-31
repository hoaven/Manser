package com.kakanshun.server.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kakanshun.crud.PeoMapper;
import com.kakanshun.server.GridServer;

public class GridServerImpl implements GridServer{

	/**
	 * �����������Ʋ�������ID
	 */
	public List<Integer> findSqId(String sssq) throws IOException {
		String resource = "conf.xml";
		//����mybatis �������ļ�����Ҳ���ع�����ӳ���ļ���
		Reader reader = Resources.getResourceAsReader(resource);
		//����sqlSession �Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<Integer> l = mapper.findSqId(sssq);
		session.close();
		return l;
	}

	/**
	 * ��������ID��ѯ��������������
	 */
	public List<String> findSzwg(int id) throws IOException {
		String resource = "conf.xml";
		//����mybatis �������ļ�����Ҳ���ع�����ӳ���ļ���
		Reader reader = Resources.getResourceAsReader(resource);
		//����sqlSession �Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<String> list = mapper.findSzwg(id);
		session.close();
		return list;
	}

	public int WardCount(String ward) throws IOException {
		String resource = "conf.xml";
		//����mybatis �������ļ�����Ҳ���ع�����ӳ���ļ���
		Reader reader = Resources.getResourceAsReader(resource);
		//����sqlSession �Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.WardCount(ward);
		System.out.println(list);
		if (list == 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public int CommunityCount(String community) throws IOException {
		String resource = "conf.xml";
		//����mybatis �������ļ�����Ҳ���ع�����ӳ���ļ���
		Reader reader = Resources.getResourceAsReader(resource);
		//����sqlSession �Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.CommunityCount(community);
		if (list == 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public List<String> findSssq(String ssyq) throws IOException {
		String resource = "conf.xml";
		//����mybatis �������ļ�����Ҳ���ع�����ӳ���ļ���
		Reader reader = Resources.getResourceAsReader(resource);
		//����sqlSession �Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<String> l = mapper.findSssq(ssyq);
		session.close();
		return l;
	}

	public List<String> findSsyq(String sssq) throws IOException {
		String resource = "conf.xml";
		//����mybatis �������ļ�����Ҳ���ع�����ӳ���ļ���
		Reader reader = Resources.getResourceAsReader(resource);
		//����sqlSession �Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<String> list = mapper.findSsyq(sssq);
		session.close();
		return list;
	}

	public int GridCount(String community, String grid) throws IOException {
		String resource = "conf.xml";
		//����mybatis �������ļ�����Ҳ���ع�����ӳ���ļ���
		Reader reader = Resources.getResourceAsReader(resource);
		//����sqlSession �Ĺ���
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.GridCount(community,grid);
		if (list == 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}
}
