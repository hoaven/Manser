package com.kakanshun.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kakanshun.server.CommonServer;
import com.kakanshun.server.GridServer;
import com.kakanshun.server.impl.CommonServerImpl;
import com.kakanshun.server.impl.GridServerImpl;

public class LimitServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("page"); // ���֮ǰ��ҳ����Ϣ
		session.removeAttribute("isDisplay"); // ���¸�����obj,isDisplayֵΪ��yes
		System.out.println("������");
		CommonServer cs = new CommonServerImpl();
		GridServer gs = new GridServerImpl();
		String obj = new String(request.getParameter("obj").getBytes(
				"ISO-8859-1"), "UTF-8");
		String value1 = request.getParameter("value1"); // ISO-8859-1
		String value2 = request.getParameter("value2");
		session.setMaxInactiveInterval(Integer.MAX_VALUE);
		String user = (String) session.getAttribute("user");

		int flag = 0; // ��־ѡ�е��Ƿ�Ϊ����

		if (value1 != null && value2 != null) { // ѡ�е�������
			value1 = new String(request.getParameter("value1").getBytes(
					"ISO-8859-1"), "UTF-8"); // ת�루��valueΪ���򱨿�ָ���쳣��
			value2 = new String(request.getParameter("value2").getBytes(
					"ISO-8859-1"), "UTF-8");
			flag = 1;
		}

		if (!"�й���ʯ����ίͳս��".equals(user)) {
			if (user.equals(value1) || user.equals(value2) || flag == 0) {
				int sum = cs.FCountByKey(user, obj);
				if (sum == 0) { // ��Ȩ��
					request.setAttribute("message",
							"<script type='text/javascript'>alert('�Բ�����û�в���Ȩ�ޣ�');</script>");
				} else { // ��Ȩ��
					if (flag == 1) { // ѡ�е�������
//						session.setAttribute("obj2", value1); // Ƭ��
//						session.setAttribute("obj1", value2); // ����

						session.setAttribute("ward", value1);
						session.setAttribute("community", value2);
						session.setAttribute("grid", obj);

						System.out.println("ѡ�е�������" + value1 + value2 + obj);
					} else if (gs.WardCount(obj) != 0) { // ѡ�е���Ƭ��
//						session.removeAttribute("obj1");
//						session.removeAttribute("obj2");

						session.setAttribute("ward", obj);
						System.out.println("ѡ�е���Ƭ����" + obj);

					} else if (gs.CommunityCount(obj) != 0) { // ѡ�е�������
//						session.removeAttribute("obj1");
//						session.removeAttribute("obj2");
						
						if ("��������".equals(obj)) {
//							session.setAttribute("obj2", "����������");

							session.setAttribute("ward", "����������");
							session.setAttribute("community", obj);
						} else {
							List<String> list = gs.findSsyq(obj);
							if (list != null) {
//								session.setAttribute("obj2", list.get(0));

								session.setAttribute("ward", list.get(0));
								session.setAttribute("community", obj);
//								System.out.println("ѡ�е�������" + obj);
							}
						}
					}
					session.setAttribute("obj", obj); // �޸Ĳ�������
				}
			} else {
				request.setAttribute("message",
						"<script type='text/javascript'>alert('�Բ�����û�в���Ȩ�ޣ�');</script>");
			}
		}

		else { // ���еĶ���Ȩ��(ͳս��)
		// session.setAttribute("obj", obj);
		//
		// session.setAttribute("grid", obj);

			if (flag == 1) { // ѡ�е�������
//				session.setAttribute("obj2", value1); // Ƭ��
//				session.setAttribute("obj1", value2); // ����

				session.setAttribute("ward", value1);
				session.setAttribute("community", value2);
				session.setAttribute("grid", obj);

			} else if (gs.WardCount(obj) != 0) { // ѡ�е���Ƭ��
//				session.removeAttribute("obj1");
//				session.removeAttribute("obj2");

				session.setAttribute("ward", obj);
				
				session.removeAttribute("community");
				session.removeAttribute("grid");

			} else if (gs.CommunityCount(obj) != 0) { // ѡ�е�������
//				session.removeAttribute("obj1");
//				session.removeAttribute("obj2");
				
				session.removeAttribute("grid");
				if ("��������".equals(obj)) {
//					session.setAttribute("obj2", "����������");

					session.setAttribute("ward", "����������");
					session.setAttribute("community", obj);
				} else {
					List<String> list = gs.findSsyq(obj);
					if (list != null) {
//						session.setAttribute("obj2", list.get(0));

						session.setAttribute("ward", list.get(0));
						session.setAttribute("community", obj);
					}
				}
			}
			session.setAttribute("obj", obj); // �޸Ĳ�������
		}
		
		request.getRequestDispatcher("/servlet/CountServlet").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
