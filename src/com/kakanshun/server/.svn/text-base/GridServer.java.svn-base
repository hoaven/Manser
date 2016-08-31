package com.kakanshun.server;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface GridServer {
	public List<Integer> findSqId(String sssq) throws IOException;
	public List<String> findSzwg(int id) throws IOException;
	public List<String> findSssq(String ssyq) throws IOException;
//	查找###在不在片区内
	public int WardCount(String ward) throws IOException;
	public List<String> findSsyq(String sssq) throws IOException;
//	查找###在不在片社区内
	public int CommunityCount(String community) throws IOException;
//	查找###在不在网格内
	public int GridCount(String community,String grid) throws IOException;
}
