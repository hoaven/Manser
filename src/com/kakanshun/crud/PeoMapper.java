package com.kakanshun.crud;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kakanshun.domain.Area;
import com.kakanshun.domain.Grid;
import com.kakanshun.domain.People;
import com.kakanshun.domain.Record;

public interface PeoMapper {

	/*-----------------------UserServer------------------------*/
	// 查询密码
	@Select("select password from area where name=#{username}")
	public String getPassword(String username);

	// 根据片区的名称查找社区名称
	@Select("select sssq from grid where ssyq=#{ssyq}")
	public List<String> findSssq(String ssyq);

	// 根据社区查找片区名称(取list[0]即可)
	@Select("select ssyq from grid where sssq=#{sssq}")
	public List<String> findSsyq(String sssq);

	// 根据社区名称查找社区ID(取list[0]即可)
	@Select("select sqID from grid where sssq=#{sssq}")
	public List<Integer> findSqId(String sssq);

	// 根据社区ID查询社区的网格名称
	@Select("select szwg from grid where sqID=#{id}")
	public List<String> findSzwg(int id);

	// 查找###在不在片区内
	@Select("select count(*) from grid where ssyq=#{ward}")
	public int WardCount(String ward);

	// 查找###在不在社区内
	@Select("select count(*) from grid where sssq=#{community}")
	public int CommunityCount(String community);

	// 查找###在不在网格内
	@Select("select count(*) from grid where sssq=#{0} and szwg=#{1}")
	public int GridCount(String community, String grid);

	/**
	 * 
	 private String f1 =
	 * "dpmc,name,sex,birth,origin,race,rdsj,education,gzdw,dwzw,shzw,phone,community,grid,ward,f1"
	 * ; private String f2 =
	 * "name,sex,birth,origin,race,education,gzdw,dwzw,shzw,phone,community,grid,ward,f2"
	 * ; private String f3 =
	 * "name,sex,birth,origin,race,education,byyx,gzdw,dwzw,shzw,phone,community,grid,ward,f3"
	 * ; private String f4 =
	 * "name,fm,sex,race,zjxy,zjcs,zjrz,sfzh,phone,db,f4_qt,community,grid,ward,f4"
	 * ; private String f5 =
	 * "name,sex,race,zjxy,hjdz,jydz,hylb,sfzh,zzdz,phone,f5_qt,community,grid,ward,f5"
	 * ; private String f6 =
	 * "name,sex,race,zjxy,hjdz,jtdz,hylb,sfzh,gzdw,db,phone,f6_qt,community,grid,ward,f6"
	 * ; private String f7 =
	 * "name,sex,birth,origin,race,dpmc,education,qymc,qydz,dwzw,zc,fddbr,cbsj,hycp,phone,community,grid,ward,f7"
	 * ; private String f8 =
	 * "name,sex,birth,origin,race,education,jgmcjzw,shzl,phone,community,grid,ward,f8"
	 * ; private String f9 =
	 * "name,sex,birth,origin,race,lxgj,xwjzy,szxx,ggsj,gggzdw,shzw,phone,community,grid,ward,f9"
	 * ; private String f10 =
	 * "name,sex,birth,origin,race,education,gzdw,bs,jtdz,phone,community,grid,ward,f10"
	 * ; private String f11 =
	 * "name,sex,birth,origin,race,education,ytbgx,gzdw,jtdz,shzw,phone,community,grid,ward,f11"
	 * ; private String f12 =
	 * "name,sex,birth,origin,race,education,szgj,yqgx,gzdw,jtdz,shzw,phone,community,grid,ward,f12"
	 * ; private String f13 =
	 * "name,sex,birth,origin,race,education,zytc,gzdw,dwzw,phone,community,grid,ward,f13"
	 * ;
	 */

	/*-----------------------F1Server----------------------*/
	// 插入记录(f13表) ===》四级通用
	@Insert("insert into people (name,sex,birth,origin,race,education,zytc,gzdw,dwzw,phone,community,grid,ward,type,sfzh) values(#{name},#{sex},#{birth},#{origin},#{race},#{education},#{zytc},#{gzdw},#{dwzw},#{phone},#{community},#{grid},#{ward},#{type},#{sfzh})")
	public int insertF13(People p);

	// 插入记录(f12表) ===》四级通用
	@Insert("insert into people (name,sex,birth,origin,race,education,szgj,yqgx,gzdw,jtdz,shzw,phone,community,grid,ward,type,sfzh) values(#{name},#{sex},#{birth},#{origin},#{race},#{education},#{szgj},#{yqgx},#{gzdw},#{jtdz},#{shzw},#{phone},#{community},#{grid},#{ward},#{type},#{sfzh})")
	public int insertF12(People p);

	// 插入记录(f11表) ===》四级通用
	@Insert("insert into people (name,sex,birth,origin,race,education,ytbgx,gzdw,jtdz,shzw,phone,community,grid,ward,type,sfzh) values(#{name},#{sex},#{birth},#{origin},#{race},#{education},#{ytbgx},#{gzdw},#{jtdz},#{shzw},#{phone},#{community},#{grid},#{ward},#{type},#{sfzh})")
	public int insertF11(People p);

	// 插入记录(f10表) ===》四级通用
	@Insert("insert into people (name,sex,birth,origin,race,education,gzdw,bs,jtdz,phone,community,grid,ward,type,sfzh) values(#{name},#{sex},#{birth},#{origin},#{race},#{education},#{gzdw},#{bs},#{jtdz},#{phone},#{community},#{grid},#{ward},#{type},#{sfzh})")
	public int insertF10(People p);

	// 插入记录(f9表) ===》四级通用
	@Insert("insert into people (name,sex,birth,origin,race,lxgj,xwjzy,szxx,ggsj,gggzdw,shzw,phone,community,grid,ward,type,sfzh) values(#{name},#{sex},#{birth},#{origin},#{race},#{lxgj},#{xwjzy},#{szxx},#{ggsj},#{gggzdw},#{shzw},#{phone},#{community},#{grid},#{ward},#{type},#{sfzh})")
	public int insertF9(People p);

	// 插入记录(f8表) ===》四级通用
	@Insert("insert into people (name,sex,birth,origin,race,education,jgmcjzw,shzl,phone,community,grid,ward,type,sfzh) values(#{name},#{sex},#{birth},#{origin},#{race},#{education},#{jgmcjzw},#{shzl},#{phone},#{community},#{grid},#{ward},#{type},#{sfzh})")
	public int insertF8(People p);

	// 插入记录(f7表) ===》四级通用
	@Insert("insert into people (name,sex,birth,origin,race,dpmc,education,qymc,qydz,dwzw,zc,fddbr,cbsj,hycp,phone,community,grid,ward,type,sfzh) values(#{name},#{sex},#{birth},#{origin},#{race},#{dpmc},#{education},#{qymc},#{qydz},#{dwzw},#{zc},#{fddbr},#{cbsj},#{hycp},#{phone},#{community},#{grid},#{ward},#{type},#{sfzh})")
	public int insertF7(People p);

	// 插入记录(f6表) ===》四级通用
	@Insert("insert into people (name,sex,race,zjxy,hjdz,jtdz,hylb,gzdw,db,phone,f6_qt,community,grid,ward,type,sfzh) values(#{name},#{sex},#{race},#{zjxy},#{hjdz},#{jtdz},#{hylb},#{gzdw},#{db},#{phone},#{f6_qt},#{community},#{grid},#{ward},#{type},#{sfzh})")
	public int insertF6(People p);

	// 插入记录(f5表) ===》四级通用
	@Insert("insert into people (name,sex,race,zjxy,hjdz,jydz,hylb,zzdz,phone,f5_qt,community,grid,ward,type,sfzh) values(#{name},#{sex},#{race},#{zjxy},#{hjdz},#{jydz},#{hylb},#{zzdz},#{phone},#{f5_qt},#{community},#{grid},#{ward},#{type},#{sfzh})")
	public int insertF5(People p);

	// 插入记录(f4表) ===》四级通用
	@Insert("insert into people (name,fm,sex,race,zjxy,zjcs,zjrz,phone,db,f4_qt,community,grid,ward,type,sfzh) values(#{name},#{fm},#{sex},#{race},#{zjxy},#{zjcs},#{zjrz},#{phone},#{db},#{f4_qt},#{community},#{grid},#{ward},#{type},#{sfzh})")
	public int insertF4(People p);

	// 插入记录(f3表) ===》四级通用
	@Insert("insert into people (name,sex,birth,origin,race,education,byyx,gzdw,dwzw,shzw,phone,community,grid,ward,type,sfzh) values(#{name},#{sex},#{birth},#{origin},#{race},#{education},#{byyx},#{gzdw},#{dwzw},#{shzw},#{phone},#{community},#{grid},#{ward},#{type},#{sfzh})")
	public int insertF3(People p);

	// 插入记录(f2表) ===》四级通用
	@Insert("insert into people (name,sex,birth,origin,race,education,gzdw,dwzw,shzw,phone,community,grid,ward,type,sfzh) values(#{name},#{sex},#{birth},#{origin},#{race},#{education},#{gzdw},#{dwzw},#{shzw},#{phone},#{community},#{grid},#{ward},#{type},#{sfzh})")
	public int insertF2(People p);

	// 插入记录(f1表) ===》四级通用
	@Insert("insert into people (dpmc,name,sex,birth,origin,race,rdsj,education,gzdw,dwzw,shzw,phone,community,grid,ward,type,sfzh) values(#{dpmc}, #{name}, #{sex}, #{birth}, #{origin}, #{race}, #{rdsj}, #{education}, #{gzdw}, #{dwzw},#{shzw}, #{phone}, #{community}, #{grid},#{ward},#{type},#{sfzh})")
	public int insertF1(People p);

	// 修改记录(13表公共) ===》四级通用
	@Update("update people set " + "name=#{name}," + "sex=#{sex},"
			+ "birth=#{birth}," + "origin=#{origin}," + "race=#{race}," + "phone=#{phone},"
			+ "education=#{education}," + "ward=#{ward}," + "community=#{community}," + "grid=#{grid},"
			+ "type=#{type}," + "gzdw=#{gzdw}," + "dwzw=#{dwzw}," + "shzw=#{shzw},"
			+ "rdsj=#{rdsj}," + "hjdz=#{hjdz}," + "jydz=#{jydz}," + "hylb=#{hylb},"
			+ "sfzh=#{sfzh}," + "zzdz=#{zzdz}," + "f4_qt=#{f4_qt}," + "byyx=#{byyx},"
			+ "dpmc=#{dpmc}," + "fm=#{fm}," + "zjxy=#{zjxy}," + "zjcs=#{zjcs}," + "zjrz=#{zjrz},"
			+ "db=#{db}," + "f5_qt=#{f5_qt}," + "jtdz=#{jtdz}," + "f6_qt=#{f6_qt},"
			+ "qymc=#{qymc}," + "qydz=#{qydz}," + "zc=#{zc}," + "fddbr=#{fddbr},"
			+ "cbsj=#{cbsj}," + "hycp=#{hycp}," + "jgmcjzw=#{jgmcjzw}," + "shzl=#{shzl},"
			+ "lxgj=#{lxgj}," + "xwjzy=#{xwjzy}," + "szxx=#{szxx}," + "ggsj=#{ggsj},"
			+ "gggzdw=#{gggzdw}," + "bs=#{bs}," + "ytbgx=#{ytbgx}," + "szgj=#{szgj},"
			+ "yqgx=#{yqgx}," + "zytc=#{zytc}" + " where id=#{id}")
	public int updateF1(People p);

	// 删除记录(13表公共) ===》四级通用
	@Delete("delete from people where id=#{id}")
	public int DeletePeopleById(int id);

	// 查找页记录(13表公共) ===》统战部
	@Select("select * from people where type=#{0} order by Id desc limit #{1},#{2}")
	public List<People> getF1PageByF1(String type, int startIndex, int pagesize);

	// 根据人员类型查找记录数(13表公共) ===》统战部
	@Select("select count(*) from people where type=#{type}")
	public int FCount(String type);

	// 根据id查找记录(13表公共) ===》四级通用
	@Select("select * from people where id=#{id}")
	public People getF1ById(int id);

	// 查找表中总行数(统战部) ===》统战部
	@Select("select count(*) from people")
	public int TzbCount();

	/*--------------------CommonServer---------------------*/
	// 根据姓名查找记录(13表公共) ===》四级通用
//	@Select("select * from people where name=#{name}")
//	public List<People> getPeopleByName(String name);
	@Select("select * from people where name=#{0} and type=#{1}")
	public List<People> getPeopleByName(String name,String type);
	
	// 根据姓名查找记录条数(13表公共) ===》四级通用
	@Select("select count(*) from people where name=#{name}")
	public int getCountByName(String name);

	// 根据党派名称查找记录条数(13表公共) ===》四级通用
	@Select("select count(*) from people where dpmc=#{dpmc}")
	public int getCountByDpmc(String dpmc);

	// 根据工作单位查找记录条数(13表公共) ===》四级通用
	@Select("select count(*) from people where gzdw=#{gzdw}")
	public int getCountByGzdw(String gzdw);

	// 根据身份证号查找记录(13表公共) ===》四级通用
//	@Select("select * from people where sfzh=#{sfzh}")
//	public People getPeopleBySfzh(String sfzh);
	@Select("select * from people where sfzh=#{0} and type=#{1}")
	public List<People> getPeopleBySfzh(String sfzh,String type);

	// 根据党派名称查找记录(13表公共) ===》四级通用
//	@Select("select * from people where dpmc=#{dpmc}")
//	public List<People> getPeopleByDpmc(String dpmc);
	@Select("select * from people where dpmc=#{0} and type=#{1}")
	public List<People> getPeopleByDpmc(String dpmc,String type);

	// 根据工作单位查找记录(13表公共) ===》四级通用
//	@Select("select * from people where gzdw=#{gzdw}")
//	public List<People> getPeopleByGzdw(String gzdw);
	@Select("select * from people where gzdw=#{0} and type=#{1}")
	public List<People> getPeopleByGzdw(String gzdw,String type);

	// 根据社区查找页记录 ===>社区
	@Select("select * from people where type=#{0} and community=#{1} limit #{2},#{3}")
	public List<People> getF1PageByCommunity(String type, String community,
			int startIndex, int pagesize);

	// 根据行政区查找页记录 ===>行政区
	@Select("select * from people where type=#{0} and ward=#{1} limit #{2},#{3}")
	public List<People> getF1PageByWard(String type, String ward,
			int startIndex, int pagesize);

	// 根据网格查找页记录 ===>网格
	@Select("select * from people where type=#{0} and grid=#{1} and community=#{2} limit #{3},#{4}")
	public List<People> getF1PageByGrid(String type, String grid,
			String community, int startIndex, int pagesize);

	// 根据人员类型,社区查找记录数(13表公共) ===》社区
	@Select("select count(*) from people where type=#{0} and community=#{1}")
	public int FCountByCommunity(String type, String community);

	// 根据人员类型,行政区查找记录数(13表公共) ===》行政区
	@Select("select count(*) from people where type=#{0} and ward=#{1}")
	public int FCountByWard(String type, String ward);

	// 根据人员类型,网格查找记录数(13表公共) ===》网格
	@Select("select count(*) from people where type=#{0} and grid=#{1} and community=#{2}")
	public int FCountByGrid(String type, String grid, String community);

	// 权限查询(除统战部登录外均用该方法进行权限判断)
	@Select("select count(*) from grid where ((ssyq=#{0} and (ssyq=#{1} or sssq=#{1} or szwg=#{1}))  or (sssq=#{0} and (sssq=#{1} or szwg=#{1})))")
	public int FCountByKey(String key1, String key2);

	// 插入操作记录
	@Insert("insert into record (username,obj,operate,content,scope,operatetime) values(#{username},#{obj},#{operate},#{content},#{scope},#{operatetime})")
	public int insertRecord(Record r);

	// 获取page操作记录
	@Select("select * from record order by Id desc limit #{0},#{1}")
	public List<Record> getRecords(int startIndex, int pagesize);

	// 获取操作记录的总条数
	@Select("select count(*) from record")
	public int RecordCount();

	// 获取网格分布情况
	@Select("select * from grid")
	public List<Grid> GetAllGrids();

	// 获取各党派人数
	@Select("select count(*) from people where (ward=#{0} or community=#{0} or (grid=#{0} and community=#{2})) and dpmc=#{1}")
	public int GetCountByDpmcAndKey(String key, String dpmc, String community);

	// 获取港/澳人数
	@Select("select count(*) from people where (ward=#{0} or community=#{0} or (grid=#{0} and community=#{2})) and bs=#{1}")
	public int GetCountByBsAndKey(String key, String bs, String community);

	// 获取全区港/澳人数
	@Select("select count(*) from people where bs=#{bs}")
	public int GetCountByBs(String bs);

	// 获取台湾同胞、台胞家属人数
	@Select("select count(*) from people where (ward=#{0} or community=#{0} or (grid=#{0} and community=#{2})) and ytbgx=#{1}")
	public int GetCountByYtbgxAndKey(String key, String ytbgx, String community);

	// 获取全区台湾同胞、台胞家属人数
	@Select("select count(*) from people where ytbgx=#{ytbgx}")
	public int GetCountByYtbgx(String ytbgx);

	// 获取台企数、台商人数
	@Select("select count(*) from people where (ward=#{0} or community=#{0} or (grid=#{0} and community=#{2})) and sfbdcbqy=#{1}")
	public int GetCountBySfbdcbqyAndKey(String key, String sfbdcbqy,
			String community);

	// 获取全区台企数、台商人数
	@Select("select count(*) from people where sfbdcbqy=#{sfbdcbqy}")
	public int GetCountBySfbdcbqy(String sfbdcbqy);

	// 获取华侨、归侨、侨眷人数
	@Select("select count(*) from people where (ward=#{0} or community=#{0} or (grid=#{0} and community=#{2})) and yqgx=#{1}")
	public int GetCountByYqgxAndKey(String key, String yqgx, String community);

	// 获取全区华侨、归侨、侨眷人数
	@Select("select count(*) from people where yqgx=#{yqgx}")
	public int GetCountByYqgx(String yqgx);

	// 查找所有片区(去掉重复)
	@Select("select distinct(ssyq) from grid")
	public List<String> GetAllGridsSsyq();

	// 根据片区查找社区(去掉重复)
	@Select("select distinct(sssq) from grid where ssyq=#{ssyq}")
	public List<String> GetAllGridsBySsyq(String ssyq);

	// 根据社区查找网格(去掉重复)
	@Select("select distinct(szwg) from grid where sssq=#{sssq}")
	public List<String> GetAllGridsBySssq(String sssq);

	// 查询网格分布情况
	@Select("select grid.sqid as sqid,grid.sssq as sqname,area.sqid as pqid,area.name as pqname,grid.szwg as wgname,grid.wgxh as wgid from grid,area where area.sqid = substring(grid.sqid,1,1)*100 order by sqid,wgid asc")
	public List<Area> GetAllArea();

	// 查询片区--社区--网格是否合法
	@Select("select count(*) from grid where ssyq=#{0} and sssq=#{1} and szwg=#{2}")
	public int GridIslegal(String ward, String community, String grid);

}
