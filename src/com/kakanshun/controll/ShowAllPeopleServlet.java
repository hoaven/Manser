package com.kakanshun.controll;

import java.io.IOException;
import java.io.PrintWriter;
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

public class ShowAllPeopleServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(Integer.MAX_VALUE);
		GridServer gs = new GridServerImpl();
		F1Server fs = new F1ServerImpl();
		CommonServer cs = new CommonServerImpl();
		String type = (String) session.getAttribute("type");
		String obj = (String) session.getAttribute("obj");
		
		String pagenum = request.getParameter("pagenum");//�û�Ҫ����ҳ��
		
		int num = 1;//Ĭ��ֵ
		if(pagenum!=null&&!"".equals(pagenum.trim()))//����û�����������null�����ǿ��ַ�������˵����һ�η��ʣ�Ĭ����ʾ��ҳ���ǵ�1ҳ
			num = Integer.parseInt(pagenum);
		
		int totalrecords = 0;
		Page page = null;
		
		List<People> pagelist = new ArrayList<People>();
		if(gs.CommunityCount(obj)!=0) {   //obj��������
			totalrecords = cs.FCountByCommunity(type, obj);
			page = new Page(num, totalrecords);
			pagelist = cs.getF1PageByCommunity(type, obj, page.getStartIndex(), page.getPagesize());
		}
		else if(gs.WardCount(obj)!=0) {    //obj��Ƭ����
			totalrecords = cs.FCountByWard(type, obj);
			page = new Page(num, totalrecords);
			pagelist = cs.getF1PageByWard(type, obj, page.getStartIndex(), page.getPagesize());
		}
		else if(obj.equals("�й���ʯ����ίͳս��")) {   //ͳս��
			totalrecords = fs.FCount(type);
			page = new Page(num, totalrecords);
			pagelist = fs.getF1PageByF1(type, page.getStartIndex(), page.getPagesize());
		}
		else {    //obj��������
			totalrecords = cs.FCountByGrid(type, obj,(String) session.getAttribute("community"));
			page = new Page(num, totalrecords);
			pagelist = cs.getF1PageByGrid(type, obj,(String) session.getAttribute("obj1"), page.getStartIndex(), page.getPagesize());
		
		}
		
		page.setRecords(pagelist);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/statistics/main.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
