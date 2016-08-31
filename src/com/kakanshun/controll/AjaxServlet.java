package com.kakanshun.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.kakanshun.server.CommonServer;
import com.kakanshun.server.GridServer;
import com.kakanshun.server.impl.CommonServerImpl;
import com.kakanshun.server.impl.GridServerImpl;

public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommonServer cs = new CommonServerImpl();
		GridServer gs = new GridServerImpl();
		response.setContentType("text/html;charset=UTF-8"); // ���÷������ݵ�����(html��ͨ�ı�)�ͱ���
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		HashMap areagrid = (HashMap) session.getAttribute("areagrid");
		
		String ward = request.getParameter("ward");
		
		if (gs.WardCount(ward)>0) {
			HashMap map = (HashMap) areagrid.get(ward);			//����Ƭ��ward�õ�����
			List<String> clist = new ArrayList<String>();
			Set keyset = map.keySet();			//�õ�map��keyֵ==����
			clist.addAll(keyset);    //set-->list
			
//			clist = cs.GetAllGridsBySsyq(ward);
			request.setAttribute("clist", clist);
			String json = JSONArray.fromObject(clist).toString(); // list--->json���ַ��� ****import net.sf.json.JSONArray;
			out.write(json);
		} else if(gs.CommunityCount(ward)>0) {			//wardΪ����
			String pq = request.getParameter("pq");
			HashMap community = (HashMap) areagrid.get(pq);			//����Ƭ��pq�õ�����
			
			List<String> clist = new ArrayList<String>();
			clist = (List<String>) community.get(ward);			//��������ward�õ�����
			
			request.setAttribute("clist", clist);
			String json = JSONArray.fromObject(clist).toString(); // list--->json���ַ���
			out.write(json);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
