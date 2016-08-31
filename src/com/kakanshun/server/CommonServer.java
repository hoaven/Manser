package com.kakanshun.server;

import java.io.IOException;  
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.kakanshun.domain.Area;
import com.kakanshun.domain.Grid;
import com.kakanshun.domain.People;

public interface CommonServer {
//	根据姓名查找记录(13表公共)   ===》四级通用
	public List<People> getPeopleByName(String name,String type) throws IOException;
	
//	根据身份证号查找记录(13表公共)   ===》四级通用
	public List<People> getPeopleBySfzh(String sfzh,String type) throws IOException;
	
//	根据党派名称查找记录(13表公共)   ===》四级通用
	public List<People> getPeopleByDpmc(String dpmc,String type) throws IOException;
	
//	根据工作单位查找记录(13表公共)   ===》四级通用
	public List<People> getPeopleByGzdw(String gzdw,String type) throws IOException;
	
//	根据社区查找页记录   ===>社区
	public List<People> getF1PageByCommunity(String type,String community,int startIndex,int pagesize) throws IOException;
	
//	根据行政区查找页记录   ===>行政区
	public List<People> getF1PageByWard(String type,String ward,int startIndex,int pagesize) throws IOException;
	
//	根据网格查找页记录   ===>网格
	public List<People> getF1PageByGrid(String type,String grid,String community,int startIndex,int pagesize) throws IOException;
	
//	根据人员类型,社区查找记录数(13表公共)  ===》社区
	public int FCountByCommunity(String type,String community) throws IOException;
	
//	根据人员类型,行政区查找记录数(13表公共)  ===》行政区
	public int FCountByWard(String type,String ward) throws IOException;
	
//	根据人员类型,网格查找记录数(13表公共)  ===》网格
	public int FCountByGrid(String type,String grid,String community) throws IOException;
	
//	权限查询(除统战部登录外均用该方法进行权限判断)
	public int FCountByKey(String key1,String key2) throws IOException;
	
//	根据姓名查找记录条数(13表公共)   ===》四级通用
	public int getCountByName(String name,String type) throws IOException;
	
//	根据党派名称查找记录条数(13表公共)   ===》四级通用
	public int getCountByDpmc(String dpmc,String type) throws IOException;
	
//	根据工作单位查找记录条数(13表公共)   ===》四级通用
	public int getCountByGzdw(String gzdw,String type) throws IOException;
	
//	获取网格分布情况
	public List<Grid> GetAllGrids() throws IOException;
	
//	获取各党派人数
	public int GetCountByDpmcAndKey(String key,String dpmc,String community) throws IOException;
	
//	获取港/澳人数
	public int GetCountByBsAndKey(String key,String bs,String community) throws IOException;
	
//	获取全区港/澳人数
	public int GetCountByBs(String bs) throws IOException;
	
//	获取台湾同胞、台胞家属人数
	public int GetCountByYtbgxAndKey(String key,String ytbgx,String community) throws IOException;
	
//	获取全区台湾同胞、台胞家属人数
	public int GetCountByYtbgx(String ytbgx) throws IOException;
	
//	获取台企数、台商人数
	public int GetCountBySfbdcbqyAndKey(String key,String sfbdcbqy,String community) throws IOException;
	
//	获取全区台企数、台商人数
	public int GetCountBySfbdcbqy(String sfbdcbqy) throws IOException;
	
//	获取华侨、归侨、侨眷人数
	public int GetCountByYqgxAndKey(String key,String yqgx,String community) throws IOException;
	
//	获取全区华侨、归侨、侨眷人数
	public int GetCountByYqgx(String yqgx) throws IOException;
	
//	查找所有的片区名称
	public List<String> GetAllGridsSsyq() throws IOException;
	
//	根据片区查找社区
	public List<String> GetAllGridsBySsyq(String ssyq) throws IOException;
	
//	根据社区查找网格
	public List<String> GetAllGridsBySssq(String sssq) throws IOException;
	
//	查询网格分布情况
	public List<Area> GetAllArea() throws IOException;
	
//	查询片区--社区--网格是否合法
	public int GridIslegal(String ward,String community,String grid) throws IOException;
}
