package com.kakanshun.server;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.kakanshun.domain.People;
import com.kakanshun.domain.Record;

public interface RecordServer {
//	获取所有操作记录
	public List<Record> getRecords(int startIndex,int pagesize) throws IOException;
	
//	插入操作记录
	public int insertRecord(Record r) throws IOException;
	
//	获取操作记录的总条数
	public int RecordCount() throws IOException;
}
