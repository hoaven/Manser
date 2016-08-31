package com.kakanshun.server.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kakanshun.crud.PeoMapper;
import com.kakanshun.domain.People;
import com.kakanshun.server.F1Server;

public class F1ServerImpl implements F1Server{
//	插入记录(todo)
	public void insertF1(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertF1(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

//	删除记录
	public void DeletePeopleById(int id) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.DeletePeopleById(id);
		System.out.println(k);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

//	F1表记录总数
	public int FCount(String type) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int sum = mapper.FCount(type);
		session.close();
		return sum;
	}

//	更新一条记录
	public void updateF1(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.updateF1(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

	public List<People> getF1PageByF1(String type,int startIndex, int pagesize)
			throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<People> list = mapper.getF1PageByF1(type,startIndex, pagesize);
		session.commit();
		session.close();
		return list;
	}

	public People getF1ById(int id) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		People p = mapper.getF1ById(id);
		session.commit();
		session.close();
		return p;
	}

	public int TzbCount() throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int sum = mapper.TzbCount();
		session.close();
		return sum;
	}

	public void insertF13(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertF13(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}		

	public void insertF12(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertF12(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

	public void insertF11(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertF11(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

	public void insertF10(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertF10(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

	public void insertF9(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertF9(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

	public void insertF8(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertF8(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

	public void insertF7(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertF7(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

	public void insertF6(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertF6(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

	public void insertF5(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertF5(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

	public void insertF4(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertF4(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

	public void insertF3(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertF3(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

	public void insertF2(People p) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int k = mapper.insertF2(p);
		if (k == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
	}

}
