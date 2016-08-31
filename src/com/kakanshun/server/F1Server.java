package com.kakanshun.server;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kakanshun.domain.People;

public interface F1Server {
//	�����¼(f13��)   	 ===���ļ�ͨ�� 																													
	public void insertF13(People p)throws IOException;
//	�����¼(f12��)   	 ===���ļ�ͨ�� 																													
	public void insertF12(People p)throws IOException;
//	�����¼(f11��)   	 ===���ļ�ͨ�� 																													
	public void insertF11(People p)throws IOException;
//	�����¼(f10��)   	 ===���ļ�ͨ�� 																													
	public void insertF10(People p)throws IOException;
//	�����¼(f9��)   	 ===���ļ�ͨ�� 																													
	public void insertF9(People p)throws IOException;
//	�����¼(f8��)   	 ===���ļ�ͨ�� 																													
	public void insertF8(People p)throws IOException;
//	�����¼(f7��)   	 ===���ļ�ͨ�� 																													
	public void insertF7(People p)throws IOException;
//	�����¼(f6��)   	 ===���ļ�ͨ�� 																													
	public void insertF6(People p)throws IOException;
//	�����¼(f5��)   	 ===���ļ�ͨ�� 																													
	public void insertF5(People p)throws IOException;
//	�����¼(f4��)   	 ===���ļ�ͨ�� 																													
	public void insertF4(People p)throws IOException;
//	�����¼(f3��)   	 ===���ļ�ͨ�� 																													
	public void insertF3(People p)throws IOException;
//	�����¼(f2��)   	 ===���ļ�ͨ�� 																													
	public void insertF2(People p)throws IOException;
//	�����¼F1
	public void insertF1(People p) throws IOException;
//	ɾ����¼
	public void DeletePeopleById(int id) throws IOException;
//	�޸ļ�¼
	public void updateF1(People p) throws IOException;
//	����ҳ��¼
	public List<People> getF1PageByF1(String type,int startIndex,int pagesize) throws IOException;
//	���Ҽ�¼��
	public int FCount(String type) throws IOException;
//	����id���Ҽ�¼
	public People getF1ById(int id) throws IOException;
//	ͳս���û����Ҹ�������
	public int TzbCount() throws IOException;
}
