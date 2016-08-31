package com.kakanshun.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kakanshun.server.CommonServer;
import com.kakanshun.server.F1Server;
import com.kakanshun.server.GridServer;
import com.kakanshun.server.impl.CommonServerImpl;
import com.kakanshun.server.impl.F1ServerImpl;
import com.kakanshun.server.impl.GridServerImpl;

public class ShowServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	// ��¼����������
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GridServer gs = new GridServerImpl(); // �����û���������һ��
		CommonServer cs = new CommonServerImpl();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(Integer.MAX_VALUE);
		String username1 = new String(request.getParameter("one").getBytes("ISO-8859-1"),"UTF-8");		//��¼��һ
		String username = new String(request.getParameter("two").getBytes("ISO-8859-1"),"UTF-8");		//��¼����

		if ("�й���ʯ����ίͳս��".equals(username)) { // ͳս����¼
			TzbCount(request);
			session.setAttribute("user", username);
			session.setAttribute("obj", username);
			
//			session.setAttribute("ward", username);
		} else if (gs.WardCount(username) != 0) { // Ƭ����¼
			WardCount(request, username);
			session.setAttribute("user", username);
			session.setAttribute("obj", username);
			
			session.setAttribute("ward", username);
		} else if (gs.CommunityCount(username) != 0) { // ������¼
			CommunityCount(request,username);
			session.setAttribute("user", username);
			session.setAttribute("obj", username);
			
			session.setAttribute("ward", username1);
			session.setAttribute("community", username);
		}
		DpmcCount(request,username);
		BsCount(request,username);
		YtbgxCount(request,username);
		SfbdcbqyCount(request,username);
		YqgxCount(request,username);
		
		session.setAttribute("realuser", username);
		request.getRequestDispatcher("/statistics/main.jsp").forward(request,
				response);
	}
	//f12���л�ȡ���ȡ����ȡ��Ⱦ�����
			public void YqgxCount(HttpServletRequest request,String username) throws IOException {
				CommonServer cs = new CommonServerImpl();
				HttpSession session = request.getSession();
				String community = (String) session.getAttribute("community");
				
				if("�й���ʯ����ίͳս��".equals(username)) {
					int f12_1 = cs.GetCountByYqgx("����");
					int f12_2 = cs.GetCountByYqgx("����");
					int f12_3 = cs.GetCountByYqgx("�Ⱦ�");
					session.setAttribute("f12_1", f12_1);
					session.setAttribute("f12_2", f12_2);
					session.setAttribute("f12_3", f12_3);
				}else {
					int f12_1 = cs.GetCountByYqgxAndKey(username,"����",community);
					int f12_2 = cs.GetCountByYqgxAndKey(username,"����",community);
					int f12_3 = cs.GetCountByYqgxAndKey(username,"�Ⱦ�",community);
					session.setAttribute("f12_1", f12_1);
					session.setAttribute("f12_2", f12_2);
					session.setAttribute("f12_3", f12_3);
				}
			}
			//f11����̨��ͬ����̨����������
			public void SfbdcbqyCount(HttpServletRequest request,String username) throws IOException {
				CommonServer cs = new CommonServerImpl();
				HttpSession session = request.getSession();
				String community = (String) session.getAttribute("community");
				
				if("�й���ʯ����ίͳս��".equals(username)) {
					int f11_3 = cs.GetCountBySfbdcbqy("���ش���");
					int f11_4 = cs.GetCountBySfbdcbqy("��ش���");
					session.setAttribute("f11_3", f11_3);
					session.setAttribute("f11_4", f11_4);
				}else {
					int f11_3 = cs.GetCountBySfbdcbqyAndKey(username,"���ش���",community);
					int f11_4 = cs.GetCountBySfbdcbqyAndKey(username,"��ش���",community);
					session.setAttribute("f11_3", f11_3);
					session.setAttribute("f11_4", f11_4);
				}
			}
	//f11����̨��ͬ����̨����������
		public void YtbgxCount(HttpServletRequest request,String username) throws IOException {
			CommonServer cs = new CommonServerImpl();
			HttpSession session = request.getSession();
			String community = (String) session.getAttribute("community");
			
			if("�й���ʯ����ίͳս��".equals(username)) {
				int f11_1 = cs.GetCountByYtbgx("̨��ͬ��");
				int f11_2 = cs.GetCountByYtbgx("̨������");
				session.setAttribute("f11_1", f11_1);
				session.setAttribute("f11_2", f11_2);
			}else {
				int f11_1 = cs.GetCountByYtbgxAndKey(username, "̨��ͬ��",community);
				int f11_2 = cs.GetCountByYtbgxAndKey(username, "̨������",community);
				session.setAttribute("f11_1", f11_1);
				session.setAttribute("f11_2", f11_2);
			}
		}
	//f10���и۰�ͬ������
	public void BsCount(HttpServletRequest request,String username) throws IOException {
		CommonServer cs = new CommonServerImpl();
		HttpSession session = request.getSession();
		String community = (String) session.getAttribute("community");
		
		if("�й���ʯ����ίͳս��".equals(username)) {
			int f10_1 = cs.GetCountByBs("���ͬ��");
			int f10_2 = cs.GetCountByBs("����ͬ��");
			session.setAttribute("f10_1", f10_1);
			session.setAttribute("f10_2", f10_2);
		}else {
			int f10_1 = cs.GetCountByBsAndKey(username,"���ͬ��",community);
			int f10_2 = cs.GetCountByBsAndKey(username,"����ͬ��",community);
			session.setAttribute("f10_1", f10_1);
			session.setAttribute("f10_2", f10_2);
		}
	}
	//f1���и�������ʿ����
	public void DpmcCount(HttpServletRequest request,String username) throws IOException {
		CommonServer cs = new CommonServerImpl();
		HttpSession session = request.getSession();
		String community = (String) session.getAttribute("community");
		
		if("�й���ʯ����ίͳս��".equals(username)) {
			 int f1_1 = cs.getCountByDpmc("���", "f1");
			 int f1_2 = cs.getCountByDpmc("����", "f1");
			 int f1_3 = cs.getCountByDpmc("��", "f1");
			 int f1_4 = cs.getCountByDpmc("���", "f1");
			 int f1_5 = cs.getCountByDpmc("ũ����", "f1");
			 int f1_6 = cs.getCountByDpmc("�¹���", "f1");
			 int f1_7 = cs.getCountByDpmc("����", "f1");
			 int f1_8 = cs.getCountByDpmc("̨��", "f1");
			 session.setAttribute("f1_1", f1_1);
			 session.setAttribute("f1_2", f1_2);
			 session.setAttribute("f1_3", f1_3);
			 session.setAttribute("f1_4", f1_4);
			 session.setAttribute("f1_5", f1_5);
			 session.setAttribute("f1_6", f1_6);
			 session.setAttribute("f1_7", f1_7);
			 session.setAttribute("f1_8", f1_8);
		}else {
			 int f1_1 = cs.GetCountByDpmcAndKey(username,"���",community);
			 int f1_2 = cs.GetCountByDpmcAndKey(username,"����",community);
			 int f1_3 = cs.GetCountByDpmcAndKey(username,"��",community);
			 int f1_4 = cs.GetCountByDpmcAndKey(username,"���",community);
			 int f1_5 = cs.GetCountByDpmcAndKey(username,"ũ����",community);
			 int f1_6 = cs.GetCountByDpmcAndKey(username,"�¹���",community);
			 int f1_7 = cs.GetCountByDpmcAndKey(username,"����",community);
			 int f1_8 = cs.GetCountByDpmcAndKey(username,"̨��",community);
			 session.setAttribute("f1_1", f1_1);
			 session.setAttribute("f1_2", f1_2);
			 session.setAttribute("f1_3", f1_3);
			 session.setAttribute("f1_4", f1_4);
			 session.setAttribute("f1_5", f1_5);
			 session.setAttribute("f1_6", f1_6);
			 session.setAttribute("f1_7", f1_7);
			 session.setAttribute("f1_8", f1_8);
		}
	}
	// ��ʯͳս���û������ĸ�����������
	public void TzbCount(HttpServletRequest request) throws IOException {
		F1Server fs = new F1ServerImpl();
		HttpSession session = request.getSession();
		int f1 = fs.FCount("f1");
		int f2 = fs.FCount("f2");
		int f3 = fs.FCount("f3");
		int f4 = fs.FCount("f4");
		int f5 = fs.FCount("f5");
		int f6 = fs.FCount("f6");
		int f7 = fs.FCount("f7");
		int f8 = fs.FCount("f8");
		int f9 = fs.FCount("f9");
		int f10 = fs.FCount("f10");
		int f11 = fs.FCount("f11");
		int f12 = fs.FCount("f12");
		int f13 = fs.FCount("f13");
		int sum = fs.TzbCount();

		session.setAttribute("f1", f1);
		session.setAttribute("f2", f2);
		session.setAttribute("f3", f3);
		session.setAttribute("f4", f4);
		session.setAttribute("f5", f5);
		session.setAttribute("f6", f6);
		session.setAttribute("f7", f7);
		session.setAttribute("f8", f8);
		session.setAttribute("f9", f9);
		session.setAttribute("f10", f10);
		session.setAttribute("f11", f11);
		session.setAttribute("f12", f12);
		session.setAttribute("f13", f13);
		session.setAttribute("sum", sum);
	}

	// Ƭ���û������ĸ�����������
	public void WardCount(HttpServletRequest request, String ward)
			throws IOException {
		CommonServer fs = new CommonServerImpl();
		HttpSession session = request.getSession();
		int f1 = fs.FCountByWard("f1", ward);
		int f2 = fs.FCountByWard("f2", ward);
		int f3 = fs.FCountByWard("f3", ward);
		int f4 = fs.FCountByWard("f4", ward);
		int f5 = fs.FCountByWard("f5", ward);
		int f6 = fs.FCountByWard("f6", ward);
		int f7 = fs.FCountByWard("f7", ward);
		int f8 = fs.FCountByWard("f8", ward);
		int f9 = fs.FCountByWard("f9", ward);
		int f10 = fs.FCountByWard("f10", ward);
		int f11 = fs.FCountByWard("f11", ward);
		int f12 = fs.FCountByWard("f12", ward);
		int f13 = fs.FCountByWard("f13", ward);
		// int sum = fs.TzbCount();

		session.setAttribute("f1", f1);
		session.setAttribute("f2", f2);
		session.setAttribute("f3", f3);
		session.setAttribute("f4", f4);
		session.setAttribute("f5", f5);
		session.setAttribute("f6", f6);
		session.setAttribute("f7", f7);
		session.setAttribute("f8", f8);
		session.setAttribute("f9", f9);
		session.setAttribute("f10", f10);
		session.setAttribute("f11", f11);
		session.setAttribute("f12", f12);
		session.setAttribute("f13", f13);
		// session.setAttribute("sum", sum);
	}

	// �����û������ĸ�����������
	public void CommunityCount(HttpServletRequest request, String community)
			throws IOException {
		CommonServer fs = new CommonServerImpl();
		HttpSession session = request.getSession();
		int f1 = fs.FCountByCommunity("f1", community);
		int f2 = fs.FCountByCommunity("f2", community);
		int f3 = fs.FCountByCommunity("f3", community);
		int f4 = fs.FCountByCommunity("f4", community);
		int f5 = fs.FCountByCommunity("f5", community);
		int f6 = fs.FCountByCommunity("f6", community);
		int f7 = fs.FCountByCommunity("f7", community);
		int f8 = fs.FCountByCommunity("f8", community);
		int f9 = fs.FCountByCommunity("f9", community);
		int f10 = fs.FCountByCommunity("f10", community);
		int f11 = fs.FCountByCommunity("f11", community);
		int f12 = fs.FCountByCommunity("f12", community);
		int f13 = fs.FCountByCommunity("f13", community);
		// int sum = fs.TzbCount();

		session.setAttribute("f1", f1);
		session.setAttribute("f2", f2);
		session.setAttribute("f3", f3);
		session.setAttribute("f4", f4);
		session.setAttribute("f5", f5);
		session.setAttribute("f6", f6);
		session.setAttribute("f7", f7);
		session.setAttribute("f8", f8);
		session.setAttribute("f9", f9);
		session.setAttribute("f10", f10);
		session.setAttribute("f11", f11);
		session.setAttribute("f12", f12);
		session.setAttribute("f13", f13);
		// session.setAttribute("sum", sum);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
