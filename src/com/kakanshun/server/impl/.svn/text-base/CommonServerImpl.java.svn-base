package com.kakanshun.server.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kakanshun.crud.PeoMapper;
import com.kakanshun.domain.Area;
import com.kakanshun.domain.Grid;
import com.kakanshun.domain.People;
import com.kakanshun.server.CommonServer;

public class CommonServerImpl implements CommonServer {

	public List<People> getPeopleByName(String name,String type) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<People> list = mapper.getPeopleByName(name,type);
		if (list == null) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public List<People> getF1PageByCommunity(String type, String community,
			int startIndex, int pagesize) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<People> list = mapper.getF1PageByCommunity(type, community, startIndex, pagesize);
		if (list == null) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public List<People> getF1PageByWard(String type, String ward,
			int startIndex, int pagesize) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<People> list = mapper.getF1PageByWard(type, ward, startIndex, pagesize);
		if (list == null) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public List<People> getF1PageByGrid(String type, String grid,
			String community,int startIndex, int pagesize) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<People> list = mapper.getF1PageByGrid(type, grid, community,startIndex, pagesize);
		if (list == null) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public int FCountByCommunity(String type, String community)
			throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.FCountByCommunity(type, community);
		if (list == 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public int FCountByWard(String type, String ward) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.FCountByWard(type, ward);
		if (list == 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public int FCountByGrid(String type, String grid,String community) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.FCountByGrid(type, grid,community);
		if (list == 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public int FCountByKey(String key1, String key2) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.FCountByKey(key1, key2);
		if (list == 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public List<People> getPeopleByGzdw(String gzdw, String type) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<People> list = mapper.getPeopleByGzdw(gzdw,type);
		if (list == null) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public List<People> getPeopleBySfzh(String sfzh, String type) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<People> list = mapper.getPeopleBySfzh(sfzh,type);
		session.commit();
		session.close();
		return list;
	}

	public List<People> getPeopleByDpmc(String dpmc, String type) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<People> list = mapper.getPeopleByDpmc(dpmc,type);
		session.commit();
		session.close();
		return list;
	}

	public int getCountByName(String name, String type) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.getCountByName(name);
		if (list == 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public int getCountByDpmc(String dpmc, String type) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.getCountByDpmc(dpmc);
		if (list == 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public int getCountByGzdw(String gzdw, String type) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.getCountByGzdw(gzdw);
		if (list == 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public List<Grid> GetAllGrids() throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<Grid> list = mapper.GetAllGrids();
		if (list == null) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public int GetCountByDpmcAndKey(String key, String dpmc,String community)
			throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.GetCountByDpmcAndKey(key, dpmc, community);
		session.commit();
		session.close();
		return list;
	}

	public int GetCountByBsAndKey(String key, String bs,String community) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.GetCountByBsAndKey(key, bs, community);
		session.commit();
		session.close();
		return list;
	}

	public int GetCountByBs(String bs) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.GetCountByBs(bs);
		session.commit();
		session.close();
		return list;
	}

	public int GetCountByYtbgxAndKey(String key, String ytbgx,String community)
			throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.GetCountByYtbgxAndKey(key, ytbgx, community);
		session.commit();
		session.close();
		return list;
	}

	public int GetCountByYtbgx(String ytbgx) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.GetCountByYtbgx(ytbgx);
		session.commit();
		session.close();
		return list;
	}

	public int GetCountBySfbdcbqyAndKey(String key, String sfbdcbqy,String community)
			throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.GetCountBySfbdcbqyAndKey(key, sfbdcbqy, community);
		session.commit();
		session.close();
		return list;
	}

	public int GetCountBySfbdcbqy(String sfbdcbqy) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.GetCountBySfbdcbqy(sfbdcbqy);
		session.commit();
		session.close();
		return list;
	}

	public int GetCountByYqgxAndKey(String key, String yqgx,String community) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.GetCountByYqgxAndKey(key, yqgx, community);
		session.commit();
		session.close();
		return list;
	}

	public int GetCountByYqgx(String yqgx) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.GetCountByYqgx(yqgx);
		session.commit();
		session.close();
		return list;
	}

	public List<String> GetAllGridsBySsyq(String ssyq) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<String> list = mapper.GetAllGridsBySsyq(ssyq);
		if (list == null) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public List<String> GetAllGridsBySssq(String sssq) throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<String> list = mapper.GetAllGridsBySssq(sssq);
		if (list == null) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public List<String> GetAllGridsSsyq() throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<String> list = mapper.GetAllGridsSsyq();
		if (list == null) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return list;
	}

	public List<Area> GetAllArea() throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		List<Area> list = mapper.GetAllArea();
		if (list == null) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		if(list!=null) {
			System.out.println(list.size());
		}
		return list;
	}

	public int GridIslegal(String ward, String community, String grid)
			throws IOException {
		String resource = "conf.xml";
		//加载mybatis 的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource);
		//构建sqlSession 的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		PeoMapper mapper = session.getMapper(PeoMapper.class);
		int list = mapper.GridIslegal(ward, community, grid);
		
		session.commit();
		session.close();
		
		return list;
	}
}
