package com.kakanshun.controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.kakanshun.domain.Area;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kakanshun.server.CommonServer;
import com.kakanshun.server.impl.CommonServerImpl;

//获得菜单的数据，保存在session
public class GrServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
//取得导航树
//	{江北管理区={江北社区=[第一网格]}, 黄石港片区管理委员会={延安岭社区=[第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 黄石港社区=[第十网格, 第九网格, 第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 纺织社区=[第九网格, 第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 黄印村社区=[第十网格, 第九网格, 第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 大桥社区=[第十网格, 第九网格, 第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 新闸社区=[第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 青山湖社区=[第十网格, 第九网格, 第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格]}, 胜阳港片区管理委员会={文化宫社区=[第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 钟楼社区=[第十网格, 第九网格, 第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 南京路社区=[第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 湖滨路社区=[第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 天桥社区=[第九网格, 第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 胜阳港社区=[第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格]}, 环磁湖片区管理委员会={亚光社区=[第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 红旗桥社区=[第十三网格, 第十二网格, 第十一网格, 第十网格, 第九网格, 第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 桂花湾社区=[第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 沈家营社区=[第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 王家里社区=[第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 楠竹林社区=[第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 凤凰山社区=[第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 师院社区=[第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 南岳社区=[第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 覆盆山社区=[第九网格, 第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 海观山社区=[第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 市建村社区=[第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格]}, 花湖街道办事处={天虹社区=[第八网格, 第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 天方社区=[第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 老虎头社区=[第七网格, 第六网格, 第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 锁前社区=[第三网格, 第二网格, 第一网格], 花湖社区=[第五网格, 第四网格, 第三网格, 第二网格, 第一网格], 大码头社区=[第五网格, 第四网格, 第三网格, 第二网格, 第一网格]}}
		
				
		
		HashMap map = (HashMap) session.getAttribute("areagrid");

		if (map == null) {
			CommonServer cs = new CommonServerImpl();
			List<Area> area = cs.GetAllArea();

			HashMap pq = new HashMap();
			HashMap sq = new HashMap();
			ArrayList wg = new ArrayList();
			for (Area a : area) {
				if (!pq.containsKey(a.getPqname()))
					pq.put(a.getPqname(), new HashMap());
				sq = (HashMap) pq.get(a.getPqname());
				if (!sq.containsKey(a.getSqname())) {
					sq.put(a.getSqname(), new ArrayList());
				}
				wg = (ArrayList) sq.get(a.getSqname());
				wg.add(a.getWgname());
				sq.put(a.getSqname(), wg);
				pq.put(a.getPqname(), sq);

			}
			session.setAttribute("areagrid", pq);
		}
		// 带着网格数据转向至显示页面
		request.getRequestDispatcher("/mainLogin/login.jsp").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
