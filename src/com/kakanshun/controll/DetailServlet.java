package com.kakanshun.controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kakanshun.domain.Page;
import com.kakanshun.domain.People;
import com.kakanshun.server.CommonServer;
import com.kakanshun.server.F1Server;
import com.kakanshun.server.GridServer;
import com.kakanshun.server.impl.CommonServerImpl;
import com.kakanshun.server.impl.F1ServerImpl;
import com.kakanshun.server.impl.GridServerImpl;

public class DetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		GridServer gs = new GridServerImpl();
		F1Server fs = new F1ServerImpl();
		CommonServer cs = new CommonServerImpl();
		String isDisplay = "yes";
		String type = request.getParameter("form"); // 人员类型
		session.setAttribute("type", type);
		session.setMaxInactiveInterval(Integer.MAX_VALUE);
		String obj = (String) session.getAttribute("obj");

		List<People> pagelist = new ArrayList<People>();
		int count = 0;
		if (gs.CommunityCount(obj) != 0) { // obj在社区内
			pagelist = cs.getF1PageByCommunity(type, obj, 0, 50);
			count = cs.FCountByCommunity(type, obj);
		} else if (gs.WardCount(obj) != 0) { // obj在片区内
			pagelist = cs.getF1PageByWard(type, obj, 0, 50);
			count = cs.FCountByWard(type, obj);
		} else if ("中共黄石港区委统战部".equals(obj)) { // 统战部
			pagelist = fs.getF1PageByF1(type, 0, 50);
			count = fs.FCount(type);
		} else { // obj在网格内
			pagelist = cs.getF1PageByGrid(type, obj,
					(String) session.getAttribute("community"), 0, 50);
			count = cs.FCountByGrid(type, obj,
					(String) session.getAttribute("community"));
		}

		session.setAttribute("isDisplay", isDisplay);
		Page page = new Page(1, count); // 初始状态
		page.setRecords(pagelist);
		session.setAttribute("page", page);

		String path = "form/" + type + ".jsp";
		session.setAttribute("c", path);
		request.getRequestDispatcher("/statistics/main.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
