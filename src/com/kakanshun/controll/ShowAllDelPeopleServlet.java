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

public class ShowAllDelPeopleServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(Integer.MAX_VALUE);
		GridServer gs = new GridServerImpl();
		F1Server fs = new F1ServerImpl();
		CommonServer cs = new CommonServerImpl();
		String type = (String) session.getAttribute("type");
		String obj = (String) session.getAttribute("obj");
		String pagenum = request.getParameter("pagenum");//用户要看的页码
		
		System.out.println(pagenum);
		
		int num = 1;//默认值
		if(pagenum!=null&&!"".equals(pagenum.trim()))//如果用户传进来的是null或者是空字符串，则说明第一次访问，默认显示的页码是第1页
		num = Integer.parseInt(pagenum);
		
		int totalrecords = 0;
		Page page = null;
		
		List<People> pagelist = new ArrayList();
		int count = 0;
		if(gs.CommunityCount(obj)!=0) {   //obj在社区内
			totalrecords = cs.FCountByCommunity(type, obj);
			page = new Page(num, totalrecords);
			pagelist = cs.getF1PageByCommunity(type, obj, page.getStartIndex(), page.getPagesize());
		}
		else if(gs.WardCount(obj)!=0) {    //obj在片区内
			totalrecords = cs.FCountByWard(type, obj);
			page = new Page(num, totalrecords);
			pagelist = cs.getF1PageByWard(type, obj, page.getStartIndex(), page.getPagesize());
		}
		else if(obj.equals("中共黄石港区委统战部")) {   //统战部
			totalrecords = fs.FCount(type);
			page = new Page(num, totalrecords);
			pagelist = fs.getF1PageByF1(type, page.getStartIndex(), page.getPagesize());
		}
		else {    //obj在网格内
			totalrecords = cs.FCountByGrid(type, obj,(String) session.getAttribute("community"));
			page = new Page(num, totalrecords);
			pagelist = cs.getF1PageByGrid(type, obj, (String) session.getAttribute("obj1"),page.getStartIndex(), page.getPagesize());
		
		}
		page.setRecords(pagelist);
		request.setAttribute("page", page);
		
		String selectid[] =request.getParameterValues("selectid");
		if(selectid.length>0) {
			int ids[] = new int[selectid.length];
			for(int i = 0;i < selectid.length;i++) {
				if(selectid[i]!=null&selectid[i]!=""&Integer.valueOf(selectid[i])!=0)
					ids[i]=Integer.valueOf(selectid[i]).intValue();    //String[]--->int[]
			}
			String ftype = "";
			for(int id:ids) {    //便利id数组
				People p = fs.getF1ById(id);
				fs.DeletePeopleById(id);
				
				type = p.getType();
				if(type!=null) {
					Integer temp = (Integer) session.getAttribute(ftype);    //type：f1--f13(String)    得到人数String
					int sum = temp.intValue()-1;
					session.setAttribute(type, sum);    //人数-1
				}
			}
			request.setAttribute("message", "<script type='text/javascript'>alert('批量删除成功！');</script>");
			request.getRequestDispatcher("/servlet/DetailServlet?form="+type).forward(request,response);
		}
		else {
			String path = "/statistics/selectform/"+type+".jsp";
			request.getRequestDispatcher(path).forward(request,response);		
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
