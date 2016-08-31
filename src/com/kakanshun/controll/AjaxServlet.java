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
		response.setContentType("text/html;charset=UTF-8"); // 设置发送数据的类型(html普通文本)和编码
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		HashMap areagrid = (HashMap) session.getAttribute("areagrid");
		
		String ward = request.getParameter("ward");
		
		if (gs.WardCount(ward)>0) {
			HashMap map = (HashMap) areagrid.get(ward);			//根据片区ward得到社区
			List<String> clist = new ArrayList<String>();
			Set keyset = map.keySet();			//得到map的key值==社区
			clist.addAll(keyset);    //set-->list
			
//			clist = cs.GetAllGridsBySsyq(ward);
			request.setAttribute("clist", clist);
			String json = JSONArray.fromObject(clist).toString(); // list--->json的字符串 ****import net.sf.json.JSONArray;
			out.write(json);
		} else if(gs.CommunityCount(ward)>0) {			//ward为社区
			String pq = request.getParameter("pq");
			HashMap community = (HashMap) areagrid.get(pq);			//根据片区pq得到社区
			
			List<String> clist = new ArrayList<String>();
			clist = (List<String>) community.get(ward);			//根据社区ward得到网格
			
			request.setAttribute("clist", clist);
			String json = JSONArray.fromObject(clist).toString(); // list--->json的字符串
			out.write(json);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
