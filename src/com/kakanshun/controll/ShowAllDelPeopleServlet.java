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
		String pagenum = request.getParameter("pagenum");//�û�Ҫ����ҳ��
		
		System.out.println(pagenum);
		
		int num = 1;//Ĭ��ֵ
		if(pagenum!=null&&!"".equals(pagenum.trim()))//����û�����������null�����ǿ��ַ�������˵����һ�η��ʣ�Ĭ����ʾ��ҳ���ǵ�1ҳ
		num = Integer.parseInt(pagenum);
		
		int totalrecords = 0;
		Page page = null;
		
		List<People> pagelist = new ArrayList();
		int count = 0;
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
			for(int id:ids) {    //����id����
				People p = fs.getF1ById(id);
				fs.DeletePeopleById(id);
				
				type = p.getType();
				if(type!=null) {
					Integer temp = (Integer) session.getAttribute(ftype);    //type��f1--f13(String)    �õ�����String
					int sum = temp.intValue()-1;
					session.setAttribute(type, sum);    //����-1
				}
			}
			request.setAttribute("message", "<script type='text/javascript'>alert('����ɾ���ɹ���');</script>");
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
