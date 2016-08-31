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
		session.removeAttribute("page"); // 清除之前的页面信息
		session.removeAttribute("isDisplay"); // 重新更改了obj,isDisplay值为非yes
		System.out.println("进来了");
		CommonServer cs = new CommonServerImpl();
		GridServer gs = new GridServerImpl();
		String obj = new String(request.getParameter("obj").getBytes(
				"ISO-8859-1"), "UTF-8");
		String value1 = request.getParameter("value1"); // ISO-8859-1
		String value2 = request.getParameter("value2");
		session.setMaxInactiveInterval(Integer.MAX_VALUE);
		String user = (String) session.getAttribute("user");

		int flag = 0; // 标志选中的是否为网格

		if (value1 != null && value2 != null) { // 选中的是网格
			value1 = new String(request.getParameter("value1").getBytes(
					"ISO-8859-1"), "UTF-8"); // 转码（若value为空则报空指针异常）
			value2 = new String(request.getParameter("value2").getBytes(
					"ISO-8859-1"), "UTF-8");
			flag = 1;
		}

		if (!"中共黄石港区委统战部".equals(user)) {
			if (user.equals(value1) || user.equals(value2) || flag == 0) {
				int sum = cs.FCountByKey(user, obj);
				if (sum == 0) { // 无权限
					request.setAttribute("message",
							"<script type='text/javascript'>alert('对不起，您没有操作权限！');</script>");
				} else { // 有权限
					if (flag == 1) { // 选中的是网格
//						session.setAttribute("obj2", value1); // 片区
//						session.setAttribute("obj1", value2); // 社区

						session.setAttribute("ward", value1);
						session.setAttribute("community", value2);
						session.setAttribute("grid", obj);

						System.out.println("选中的是网格：" + value1 + value2 + obj);
					} else if (gs.WardCount(obj) != 0) { // 选中的是片区
//						session.removeAttribute("obj1");
//						session.removeAttribute("obj2");

						session.setAttribute("ward", obj);
						System.out.println("选中的是片区：" + obj);

					} else if (gs.CommunityCount(obj) != 0) { // 选中的是社区
//						session.removeAttribute("obj1");
//						session.removeAttribute("obj2");
						
						if ("江北社区".equals(obj)) {
//							session.setAttribute("obj2", "江北管理区");

							session.setAttribute("ward", "江北管理区");
							session.setAttribute("community", obj);
						} else {
							List<String> list = gs.findSsyq(obj);
							if (list != null) {
//								session.setAttribute("obj2", list.get(0));

								session.setAttribute("ward", list.get(0));
								session.setAttribute("community", obj);
//								System.out.println("选中的是社区" + obj);
							}
						}
					}
					session.setAttribute("obj", obj); // 修改操作对象
				}
			} else {
				request.setAttribute("message",
						"<script type='text/javascript'>alert('对不起，您没有操作权限！');</script>");
			}
		}

		else { // 所有的都有权限(统战部)
		// session.setAttribute("obj", obj);
		//
		// session.setAttribute("grid", obj);

			if (flag == 1) { // 选中的是网格
//				session.setAttribute("obj2", value1); // 片区
//				session.setAttribute("obj1", value2); // 社区

				session.setAttribute("ward", value1);
				session.setAttribute("community", value2);
				session.setAttribute("grid", obj);

			} else if (gs.WardCount(obj) != 0) { // 选中的是片区
//				session.removeAttribute("obj1");
//				session.removeAttribute("obj2");

				session.setAttribute("ward", obj);
				
				session.removeAttribute("community");
				session.removeAttribute("grid");

			} else if (gs.CommunityCount(obj) != 0) { // 选中的是社区
//				session.removeAttribute("obj1");
//				session.removeAttribute("obj2");
				
				session.removeAttribute("grid");
				if ("江北社区".equals(obj)) {
//					session.setAttribute("obj2", "江北管理区");

					session.setAttribute("ward", "江北管理区");
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
			session.setAttribute("obj", obj); // 修改操作对象
		}
		
		request.getRequestDispatcher("/servlet/CountServlet").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
