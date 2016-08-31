package com.kakanshun.controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kakanshun.domain.Grid;
import com.kakanshun.domain.Page;
import com.kakanshun.domain.People;
import com.kakanshun.domain.Record;
import com.kakanshun.server.CommonServer;
import com.kakanshun.server.F1Server;
import com.kakanshun.server.GridServer;
import com.kakanshun.server.RecordServer;
import com.kakanshun.server.impl.CommonServerImpl;
import com.kakanshun.server.impl.F1ServerImpl;
import com.kakanshun.server.impl.GridServerImpl;
import com.kakanshun.server.impl.RecordServerImpl;

public class AdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RecordServer rs = new RecordServerImpl();
		HttpSession session = request.getSession();
		String operation = request.getParameter("operation");
		// String ward = (String) session.getAttribute("ward");
		// String community = (String) session.getAttribute("community");
		// String grid = (String) session.getAttribute("grid");
		java.sql.Date operatetime = new java.sql.Date(new Date().getTime()); // new
																				// Date()为java.util.Date

		String username = (String) session.getAttribute("realuser");

		F1Server fs = new F1ServerImpl();

		if ("removeSession".equals(operation)) { // 退出登录
			request.getSession().invalidate(); // 摧毁session
			// session.removeAttribute("realuser");
			// session.removeAttribute("ward");
			// session.removeAttribute("community");
			// session.removeAttribute("grid");
			// session.removeAttribute("obj");
			// session.removeAttribute("type");
			// session.removeAttribute("isDisply");

			request.getRequestDispatcher("/servlet/GrServlet").forward(request,
					response);
		}

		else if ("showgrid".equals(operation)) {
			CommonServer cs = new CommonServerImpl();
			List<Grid> list = cs.GetAllGrids();
			request.setAttribute("grids", list);
			System.out.println(list.size());
			request.getRequestDispatcher("/statistics/showgrid/allGrid.jsp")
					.forward(request, response);
		}

		else if ("backuser".equals(operation)) {
			GridServer gs = new GridServerImpl();

			String obj = (String) session.getAttribute("realuser");
			// if ("中共黄石港区委统战部".equals(obj)) { // 统战部登录
			// TzbCount(request);
			// } else if (gs.WardCount(obj) != 0) { // 片区登录
			// WardCount(request, obj);
			// } else if (gs.CommunityCount(obj) != 0) { // 社区登录
			// CommunityCount(request, obj);
			// }
			if ("中共黄石港区委统战部".equals(obj)) { // 统战部登录
				// session.removeAttribute("obj2");
				// session.removeAttribute("obj1");
				session.removeAttribute("ward");
				session.removeAttribute("community");
				session.removeAttribute("grid");

				session.setAttribute("obj", obj);

				TzbCount(request);
				DpmcCount(request, obj);
				BsCount(request, obj);
				YtbgxCount(request, obj);
				SfbdcbqyCount(request, obj);
				YqgxCount(request, obj);
				session.setAttribute("isDisplay", "no");
			} else {
				request.setAttribute("message",
						"<script type='text/javascript'>alert('对不起，您没有操作权限！');</script>");
			}
			request.getRequestDispatcher("/statistics/main.jsp").forward(
					request, response);
		}

		else if ("deleteone".equals(operation)) { // f1--f13表中的删除操作
			String pid = request.getParameter("pid");
			int fid = Integer.valueOf(pid).intValue();
			People p = fs.getF1ById(fid);
			fs.DeletePeopleById(fid);

			String scope = p.getWard() + "/" + p.getCommunity() + "/"
					+ p.getWard();
			String obj = p.getName(); // 对象
			String operate = "删除"; // 操作
			String content = username + "删除了" + p.getName() + "的个人信息"; // 内容
			Record r = new Record(username, obj, operate, content, scope,
					operatetime);
			rs.insertRecord(r);

			String type = p.getType();
			if (type != null) {
				Integer temp = (Integer) session.getAttribute(type);
				int sum = temp.intValue() - 1;
				session.setAttribute(type, sum); // 人数-1
			}

			request.setAttribute("message",
					"<script type='text/javascript'>alert('删除信息成功！');</script>");
			request.getRequestDispatcher("/servlet/DetailServlet?form=" + type)
					.forward(request, response);
		}

		else if ("updateone".equals(operation)) {
			String pid = request.getParameter("pid");
			String type = (String) session.getAttribute("type");
			int fid = Integer.valueOf(pid).intValue();
			People p = fs.getF1ById(fid);
			request.setAttribute("people", p);

			String path = "/statistics/addoneform/" + type + ".jsp";
			session.setAttribute("c", path);
			request.getRequestDispatcher("/statistics/main.jsp").forward(
					request, response);
		}

		else if ("addone".equals(operation)) {
			String type = (String) session.getAttribute("type");
			String path = "/statistics/addoneform/" + type + ".jsp";
			session.setAttribute("c", path);
			request.getRequestDispatcher("/statistics/main.jsp").forward(
					request, response);
		}

		else if ("addmany".equals(operation)) {
			String type = (String) session.getAttribute("type");
			String path = "/statistics/addmanyform/" + type + ".jsp";
			session.setAttribute("c", path);
			List<People> list = new ArrayList<People>();
			for (int i = 0; i < 10; i++) {
				list.add(i, new People()); // 初始化
			}
			request.setAttribute("peoples", list);
			if (list != null)
				System.out.println(list.size());
			request.getRequestDispatcher("/statistics/main.jsp").forward(
					request, response);
		}

		else if ("deletemany".equals(operation)) {
			String type = request.getParameter("type");
			String path = "/statistics/selectform/" + type + ".jsp";
			session.setAttribute("c", path);
			request.getRequestDispatcher("/statistics/main.jsp").forward(
					request, response);
		}

		else if ("realdeletemany".equals(operation)) {
			String selectid[] = request.getParameterValues("selectid");
			int ids[] = new int[selectid.length];
			for (int i = 0; i < selectid.length; i++) {
				if (selectid[i] != null & selectid[i] != ""
						& Integer.valueOf(selectid[i]) != 0)
					ids[i] = Integer.valueOf(selectid[i]).intValue(); // String[]--->int[]
			}
			String type = "";
			for (int id : ids) { // 遍历ids数组
				People p = fs.getF1ById(id);
				fs.DeletePeopleById(id);

				String scope = p.getWard() + "/" + p.getCommunity() + "/"
						+ p.getWard();
				String obj = p.getName(); // 对象
				String operate = "删除"; // 操作
				String content = username + "删除了" + p.getName() + "的个人信息"; // 内容
				Record r = new Record(username, obj, operate, content, scope,
						operatetime);
				rs.insertRecord(r);

				type = p.getType();
				if (type != null) {
					Integer temp = (Integer) session.getAttribute(type); // type：f1--f13(String)
																			// 得到人数String
					int sum = temp.intValue() - 1;
					session.setAttribute(type, sum); // 人数-1
				}
			}
			request.setAttribute("message",
					"<script type='text/javascript'>alert('批量删除成功！');</script>");
			request.getRequestDispatcher("/servlet/DetailServlet?form=" + type)
					.forward(request, response);
		}

		else if ("realupdateone".equals(operation)) {
			String type = (String) session.getAttribute("type");
			String pid = request.getParameter("pid");
			int fid = Integer.valueOf(pid).intValue();
			People p = UpdateOne(request);
			p.setId(fid);
			p.setType(type);
			boolean b1 = p.getName() != null && p.getName() != "";
			boolean b2 = p.getSex() != null && p.getSex() != "";
			boolean b3 = p.getWard() != null && p.getWard() != "";
			boolean b4 = p.getGrid() != null && p.getGrid() != "";
			boolean b5 = p.getCommunity() != null && p.getCommunity() != "";
			if (b1 & b2 & b3 & b4 & b5) { // People合法
				fs.updateF1(p);

				String scope = p.getWard() + "/" + p.getCommunity() + "/"
						+ p.getWard();
				String obj = p.getName(); // 对象
				String operate = "修改"; // 操作
				String content = username + "修改了" + p.getName() + "的个人信息"; // 内容
				Record r = new Record(username, obj, operate, content, scope,
						operatetime);
				rs.insertRecord(r);

				request.setAttribute("message",
						"<script type='text/javascript'>alert('修改信息成功！');</script>");
				request.getRequestDispatcher(
						"/servlet/DetailServlet?form=" + type).forward(request,
						response);
			} else { // People不合法
				request.setAttribute("people", p);
				String path = "/statistics/addoneform/" + type + ".jsp";
				session.setAttribute("c", path);
				request.getRequestDispatcher("/statistics/main.jsp").forward(
						request, response);
			}
		}

		else if ("realaddone".equals(operation)) {
			String type = (String) session.getAttribute("type");
			People p = UpdateOne(request);
			p.setType(type);
			boolean b1 = p.getName() != null && p.getName() != "";
			boolean b2 = p.getSex() != null && p.getSex() != "";
			boolean b3 = p.getWard() != null && p.getWard() != "";
			boolean b4 = p.getGrid() != null && p.getGrid() != "";
			boolean b5 = p.getCommunity() != null && p.getCommunity() != "";
			if (b1 & b2 & b3 & b4 & b5) { // People合法
				if ("f1".equals(type)) {
					fs.insertF1(p);
				}
				if ("f2".equals(type)) {
					fs.insertF2(p);
				}
				if ("f3".equals(type)) {
					fs.insertF3(p);
				}
				if ("f4".equals(type)) {
					fs.insertF4(p);
				}
				if ("f5".equals(type)) {
					fs.insertF5(p);
				}
				if ("f6".equals(type)) {
					fs.insertF6(p);
				}
				if ("f7".equals(type)) {
					fs.insertF7(p);
				}
				if ("f8".equals(type)) {
					fs.insertF8(p);
				}
				if ("f9".equals(type)) {
					fs.insertF9(p);
				}
				if ("f10".equals(type)) {
					fs.insertF10(p);
				}
				if ("f11".equals(type)) {
					fs.insertF11(p);
				}
				if ("f12".equals(type)) {
					fs.insertF12(p);
				}
				if ("f13".equals(type)) {
					fs.insertF13(p);
				}

				String scope = p.getWard() + "/" + p.getCommunity() + "/"
						+ p.getWard();
				String obj = p.getName(); // 对象
				String operate = "添加"; // 操作
				String content = username + "增加了" + p.getName() + "的个人信息"; // 内容
				Record r = new Record(username, obj, operate, content, scope,
						operatetime);
				rs.insertRecord(r);

				Integer temp = (Integer) session.getAttribute(type); // type：f1--f13(String)
																		// 得到人数String
				int sum = temp.intValue() + 1;
				session.setAttribute(type, sum);
				request.setAttribute("message",
						"<script type='text/javascript'>alert('插入信息成功！');</script>");
				request.getRequestDispatcher(
						"/servlet/DetailServlet?form=" + type).forward(request,
						response);
			} else { // People不合法
				request.setAttribute("people", p);
				request.getRequestDispatcher("/statistics/main.jsp").forward(
						request, response);
			}
		}

		else if ("findpeoplebykey".equals(operation)) {
			CommonServer cs = new CommonServerImpl();
			String selectkey = "";
			String search = "";

			if (request.getParameter("selectkey") != null)
				selectkey = new String(request.getParameter("selectkey")
						.getBytes("ISO-8859-1"), "UTF-8");

			if (request.getParameter("search") == null) {
				request.setAttribute("message",
						"<script type='text/javascript'>alert('请输入查找信息！');</script>");
				String path = "/statistics/main.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}

			if (request.getParameter("search") != null)
				search = new String(request.getParameter("search").getBytes(
						"ISO-8859-1"), "UTF-8");

			String type = (String) request.getSession().getAttribute("type");
			List<People> searchResult = new ArrayList<People>();
			int count = 0;
			if ("姓名".equals(selectkey)) {
				searchResult = cs.getPeopleByName(search, type);
				Page page = new Page(1, searchResult.size());
				page.setRecords(searchResult);
				request.getSession().setAttribute("page", page); // 多个

//				count = cs.getCountByName(search, type);
			} else if ("身份证号".equals(selectkey)) {
				searchResult = cs.getPeopleBySfzh(search, type);
				Page page = new Page(1, searchResult.size());
				page.setRecords(searchResult);
				request.getSession().setAttribute("page", page);
				
			} else if ("工作单位".equals(selectkey)) {
				searchResult = cs.getPeopleByGzdw(search, type);
				Page page = new Page(1, searchResult.size());
				page.setRecords(searchResult);
				request.getSession().setAttribute("page", page);

//				count = cs.getCountByGzdw(search, type);
			} else if ("党派名称".equals(selectkey)) {
				searchResult = cs.getPeopleByDpmc(search, type);
				Page page = new Page(1, searchResult.size());
				page.setRecords(searchResult);
				request.getSession().setAttribute("page", page);

//				count = cs.getCountByDpmc(search, type);
			}
			// String path = "/statistics/findresult/" + type + ".jsp";
			if(searchResult!=null) {
				count = searchResult.size();
			}
			String c = "findresult/" + type + ".jsp";
			session.setAttribute("c", c);
			request.setAttribute("findcount", count);
			String path = "/statistics/main.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}

		else if ("showrecords".equals(operation)) {
			int totalrecords = rs.RecordCount();
			int num = 1;// 默认值

			String pagenum = request.getParameter("pagenum");// 用户要看的页码
			if (pagenum != null && !"".equals(pagenum.trim()))// 如果用户传进来的是null或者是空字符串，则说明第一次访问，默认显示的页码是第1页
				num = Integer.parseInt(pagenum);

			Page page = new Page(num, totalrecords);

			List<Record> pagelist = rs.getRecords(page.getStartIndex(),
					page.getPagesize());

			page.setRecords(pagelist);
			request.setAttribute("page", page);
			request.setAttribute("isDisplay", "yes");
			session.setAttribute("c", "/statistics/records/Showrecords.jsp");
			request.getRequestDispatcher("/statistics/main.jsp").forward(
					request, response);
			// request.getRequestDispatcher("/statistics/records/Showrecords.jsp")
			// .forward(request, response);

		}

		else if ("realaddmany".equals(operation)) {
			CommonServer cs = new CommonServerImpl();
			response.setCharacterEncoding("utf-8");

			response.setContentType("text/html;charset=utf-8");

			request.setCharacterEncoding("utf-8");

			List<People> list = AddMany(request);
			String type = (String) session.getAttribute("type");
			String message = "";
			String path = "";
			int i = 0;
			boolean isdo = false;

			while (i < 10) { // 找出有用信息
				if (list.get(i) != null) { // people里面有东西
					boolean b1 = list.get(i).getName() != null
							&& list.get(i).getName() != "";
					boolean b2 = list.get(i).getSex() != null
							&& list.get(i).getSex() != "";
					boolean b3 = list.get(i).getWard() != null
							&& list.get(i).getWard() != "";
					boolean b4 = list.get(i).getCommunity() != null
							&& list.get(i).getWard() != "";
					boolean b5 = list.get(i).getGrid() != null
							&& list.get(i).getGrid() != "";

					boolean b6 = false;
					int s = cs.GridIslegal(list.get(i).getWard(), list.get(i)
							.getWard(), list.get(i).getWard());
					if (s > 0) {
						b6 = true;
					}

					boolean b = b1 && b2 && b3 && b4 && b5;
					boolean f = !b1 && !b2 && !b3 && !b4 && !b5; // 主要信息全为空

					if (b == false) {
						if (f != true) { // 主要信息不都为空
							if (!b6) {
								message = "<script type='text/javascript'>alert('"
										+ "第"
										+ (i + 1)
										+ "条数据片区-社区-网格对应关系不正确！"
										+ "');</script>";
								session.setAttribute("c",
										"/statistics/addmanyform/f1.jsp");
								path = "/statistics/main.jsp";

							}
							if (!b5) {
								message = "<script type='text/javascript'>alert('"
										+ "第"
										+ (i + 1)
										+ "条数据网格信息不能为空"
										+ "');</script>";
								session.setAttribute("c",
										"/statistics/addmanyform/f1.jsp");
								path = "/statistics/main.jsp";

								request.setAttribute("message", message);
								request.setAttribute("peoples", list);
								request.getRequestDispatcher(path).forward(
										request, response);
							}

							if (!b4) {
								message = "<script type='text/javascript'>alert('"
										+ "第"
										+ (i + 1)
										+ "条数据社区信息不能为空"
										+ "');</script>";
								System.out.println(message);
								session.setAttribute("c",
										"/statistics/addmanyform/f1.jsp");
								path = "/statistics/main.jsp";

								request.setAttribute("message", message);
								request.setAttribute("peoples", list);
								request.getRequestDispatcher(path).forward(
										request, response);
							}

							if (!b3) {
								message = "<script type='text/javascript'>alert('"
										+ "第"
										+ (i + 1)
										+ "条数据片区信息不能为空"
										+ "');</script>";
								System.out.println(message);
								session.setAttribute("c",
										"/statistics/addmanyform/f1.jsp");
								path = "/statistics/main.jsp";

								request.setAttribute("message", message);
								request.setAttribute("peoples", list);
								request.getRequestDispatcher(path).forward(
										request, response);
							}

							if (!b2) {
								message = "<script type='text/javascript'>alert('"
										+ "第"
										+ (i + 1)
										+ "条数据性别不能为空"
										+ "');</script>";
								System.out.println(message);
								session.setAttribute("c",
										"/statistics/addmanyform/f1.jsp");
								path = "/statistics/main.jsp";

								request.setAttribute("message", message);
								request.setAttribute("peoples", list);
								request.getRequestDispatcher(path).forward(
										request, response);
							}

							if (!b1) {
								message = "<script type='text/javascript'>alert('"
										+ "第"
										+ (i + 1)
										+ "条数据姓名不能为空"
										+ "');</script>";
								System.out.println(message);
								session.setAttribute("c",
										"/statistics/addmanyform/f1.jsp");
								path = "/statistics/main.jsp";

								request.setAttribute("message", message);
								request.setAttribute("peoples", list);
								request.getRequestDispatcher(path).forward(
										request, response);
							} else {
								isdo = true;
								break;
							}
						}
						break;
					}

					else if (b == true) { // 信息可信有用
						list.get(i).setType(type);
						if ("f1".equals(type)) {
							fs.insertF1(list.get(i));
						}
						if ("f2".equals(type)) {
							fs.insertF2(list.get(i));
						}
						if ("f3".equals(type)) {
							fs.insertF3(list.get(i));
						}
						if ("f4".equals(type)) {
							fs.insertF4(list.get(i));
						}
						if ("f5".equals(type)) {
							fs.insertF5(list.get(i));
						}
						if ("f6".equals(type)) {
							fs.insertF6(list.get(i));
						}
						if ("f7".equals(type)) {
							fs.insertF7(list.get(i));
						}
						if ("f8".equals(type)) {
							fs.insertF8(list.get(i));
						}
						if ("f9".equals(type)) {
							fs.insertF9(list.get(i));
						}
						if ("f10".equals(type)) {
							fs.insertF10(list.get(i));
						}
						if ("f11".equals(type)) {
							fs.insertF11(list.get(i));
						}
						if ("f12".equals(type)) {
							fs.insertF12(list.get(i));
						}
						if ("f13".equals(type)) {
							fs.insertF13(list.get(i));
						}

						String scope = list.get(i).getWard() + "/"
								+ list.get(i).getCommunity() + "/"
								+ list.get(i).getWard();
						String obj = list.get(i).getName(); // 对象
						String operate = "添加"; // 操作
						String content = username + "增加了"
								+ list.get(i).getName() + "的个人信息"; // 内容
						Record r = new Record(username, obj, operate, content,
								scope, operatetime);
						rs.insertRecord(r);

						Integer temp = (Integer) session.getAttribute(type); // type：f1--f13(String)
																				// 得到人数String
						int sum = temp.intValue() + 1;
						session.setAttribute(type, sum);
						message = "<script type='text/javascript'>alert('批量插入信息成功!');</script>";
						path = "/servlet/DetailServlet?form=" + type;

					}
				} else if (list.get(i) == null) {
					break;
				}
				i++;
			}

			request.setAttribute("message", message);
			request.setAttribute("peoples", list);
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	public List<People> AddMany(HttpServletRequest request) throws IOException {
		List<People> list = new ArrayList<People>();
		for (int i = 0; i < 10; i++) {
			list.add(i, new People()); // 初始化
		}
		if (request.getParameterValues("name") != null) {
			String[] name = request.getParameterValues("name");
			for (int i = 0; i < name.length; i++) {
				if (name[i] != null && name[i] != "") {
					list.get(i)
							.setName(
									new String(name[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("sex") != null) {
			String[] sex = request.getParameterValues("sex"); // ISO-8859-1
			for (int i = 0; i < sex.length; i++) {
				if (sex[i] != null && sex[i] != "") {
					list.get(i).setSex(
							new String(sex[i].getBytes("ISO-8859-1"), "UTF-8"));
				}
			}
		}

		if (request.getParameterValues("birth") != null) {
			String[] birth = request.getParameterValues("birth");
			for (int i = 0; i < birth.length; i++) {
				if (birth[i] != null && birth[i] != "") {
					list.get(i)
							.setBirth(
									new String(birth[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("origin") != null) {
			String[] origin = request.getParameterValues("origin");
			for (int i = 0; i < origin.length; i++) {
				if (origin[i] != null && origin[i] != "") {
					list.get(i).setOrigin(
							new String(origin[i].getBytes("ISO-8859-1"),
									"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("race") != null) {
			String[] race = request.getParameterValues("race");
			for (int i = 0; i < race.length; i++) {
				if (race[i] != null && race[i] != "") {
					list.get(i)
							.setRace(
									new String(race[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("phone") != null) {
			String[] phone = request.getParameterValues("phone");
			for (int i = 0; i < phone.length; i++) {
				if (phone[i] != null && phone[i] != "") {
					list.get(i)
							.setPhone(
									new String(phone[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("education") != null) {
			String[] education = request.getParameterValues("education");
			for (int i = 0; i < education.length; i++) {
				if (education[i] != null && education[i] != "") {
					list.get(i).setEducation(
							new String(education[i].getBytes("ISO-8859-1"),
									"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("ward") != null) {
			String[] ward = request.getParameterValues("ward");
			for (int i = 0; i < ward.length; i++) {
				if (ward[i] != null && ward[i] != "") {
					list.get(i)
							.setWard(
									new String(ward[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("community") != null) {
			String[] community = request.getParameterValues("community");
			for (int i = 0; i < community.length; i++) {
				if (community[i] != null && community[i] != "") {
					list.get(i).setCommunity(
							new String(community[i].getBytes("ISO-8859-1"),
									"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("grid") != null) {
			String[] grid = request.getParameterValues("grid");
			for (int i = 0; i < grid.length; i++) {
				if (grid[i] != null && grid[i] != "") {
					list.get(i)
							.setGrid(
									new String(grid[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("gzdw") != null) {
			String[] gzdw = request.getParameterValues("gzdw");
			for (int i = 0; i < gzdw.length; i++) {
				if (gzdw[i] != null && gzdw[i] != "") {
					list.get(i)
							.setGzdw(
									new String(gzdw[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("dwzw") != null) {
			String[] dwzw = request.getParameterValues("dwzw");
			for (int i = 0; i < dwzw.length; i++) {
				if (dwzw[i] != null && dwzw[i] != "") {
					list.get(i)
							.setDwzw(
									new String(dwzw[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("shzw") != null) {
			String[] shzw = request.getParameterValues("shzw");
			for (int i = 0; i < shzw.length; i++) {
				if (shzw[i] != null && shzw[i] != "") {
					list.get(i)
							.setShzw(
									new String(shzw[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("rdsj") != null) {
			String[] rdsj = request.getParameterValues("rdsj");
			for (int i = 0; i < rdsj.length; i++) {
				if (rdsj[i] != null && rdsj[i] != "") {
					list.get(i)
							.setRdsj(
									new String(rdsj[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("hjdz") != null) {
			String[] hjdz = request.getParameterValues("hjdz");
			for (int i = 0; i < hjdz.length; i++) {
				if (hjdz[i] != null && hjdz[i] != "") {
					list.get(i)
							.setHjdz(
									new String(hjdz[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("jydz") != null) {
			String[] jydz = request.getParameterValues("jydz");
			for (int i = 0; i < jydz.length; i++) {
				if (jydz[i] != null && jydz[i] != "") {
					list.get(i)
							.setJydz(
									new String(jydz[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("hylb") != null) {
			String[] hylb = request.getParameterValues("hylb");
			for (int i = 0; i < hylb.length; i++) {
				if (hylb[i] != null && hylb[i] != "") {
					list.get(i)
							.setHylb(
									new String(hylb[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("sfzh") != null) {
			String[] sfzh = request.getParameterValues("sfzh");
			for (int i = 0; i < sfzh.length; i++) {
				if (sfzh[i] != null && sfzh[i] != "") {
					list.get(i)
							.setSfzh(
									new String(sfzh[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("zzdz") != null) {
			String[] zzdz = request.getParameterValues("zzdz");
			for (int i = 0; i < zzdz.length; i++) {
				if (zzdz[i] != null && zzdz[i] != "") {
					list.get(i)
							.setZzdz(
									new String(zzdz[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("f4_qt") != null) {
			String[] f4_qt = request.getParameterValues("f4_qt");
			for (int i = 0; i < f4_qt.length; i++) {
				if (f4_qt[i] != null && f4_qt[i] != "") {
					list.get(i)
							.setF4_qt(
									new String(f4_qt[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("byyx") != null) {
			String[] byyx = request.getParameterValues("byyx");
			for (int i = 0; i < byyx.length; i++) {
				if (byyx[i] != null && byyx[i] != "") {
					list.get(i)
							.setByyx(
									new String(byyx[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("dpmc") != null) {
			String[] dpmc = request.getParameterValues("dpmc");
			for (int i = 0; i < dpmc.length; i++) {
				if (dpmc[i] != null && dpmc[i] != "") {
					list.get(i)
							.setDpmc(
									new String(dpmc[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("fm") != null) {
			String[] fm = request.getParameterValues("fm");
			for (int i = 0; i < fm.length; i++) {
				if (fm[i] != null && fm[i] != "") {
					list.get(i).setFm(
							new String(fm[i].getBytes("ISO-8859-1"), "UTF-8"));
				}
			}
		}

		if (request.getParameterValues("zjxy") != null) {
			String[] zjxy = request.getParameterValues("zjxy");
			for (int i = 0; i < zjxy.length; i++) {
				if (zjxy[i] != null && zjxy[i] != "") {
					list.get(i)
							.setZjxy(
									new String(zjxy[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("zjcs") != null) {
			String[] zjcs = request.getParameterValues("zjcs");
			for (int i = 0; i < zjcs.length; i++) {
				if (zjcs[i] != null && zjcs[i] != "") {
					list.get(i)
							.setZjcs(
									new String(zjcs[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("zjrz") != null) {
			String[] zjrz = request.getParameterValues("zjrz");
			for (int i = 0; i < zjrz.length; i++) {
				if (zjrz[i] != null && zjrz[i] != "") {
					list.get(i)
							.setZjrz(
									new String(zjrz[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("db") != null) {
			String[] db = request.getParameterValues("db");
			for (int i = 0; i < db.length; i++) {
				if (db[i] != null && db[i] != "") {
					list.get(i).setDb(
							new String(db[i].getBytes("ISO-8859-1"), "UTF-8"));
				}
			}
		}

		if (request.getParameterValues("f5_qt") != null) {
			String[] f5_qt = request.getParameterValues("f5_qt");
			for (int i = 0; i < f5_qt.length; i++) {
				if (f5_qt[i] != null && f5_qt[i] != "") {
					list.get(i)
							.setF5_qt(
									new String(f5_qt[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("jtdz") != null) {
			String[] jtdz = request.getParameterValues("jtdz");
			for (int i = 0; i < jtdz.length; i++) {
				if (jtdz[i] != null && jtdz[i] != "") {
					list.get(i)
							.setJtdz(
									new String(jtdz[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("f6_qt") != null) {
			String[] f6_qt = request.getParameterValues("f6_qt");
			for (int i = 0; i < f6_qt.length; i++) {
				if (f6_qt[i] != null && f6_qt[i] != "") {
					list.get(i)
							.setF6_qt(
									new String(f6_qt[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("qymc") != null) {
			String[] qymc = request.getParameterValues("qymc");
			for (int i = 0; i < qymc.length; i++) {
				if (qymc[i] != null && qymc[i] != "") {
					list.get(i)
							.setQymc(
									new String(qymc[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("qydz") != null) {
			String[] qydz = request.getParameterValues("qydz");
			for (int i = 0; i < qydz.length; i++) {
				if (qydz[i] != null && qydz[i] != "") {
					list.get(i)
							.setQydz(
									new String(qydz[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("zc") != null) {
			String[] zc = request.getParameterValues("zc");
			for (int i = 0; i < zc.length; i++) {
				if (zc[i] != null && zc[i] != "") {
					list.get(i).setZc(
							new String(zc[i].getBytes("ISO-8859-1"), "UTF-8"));
				}
			}
		}

		if (request.getParameterValues("fddbr") != null) {
			String[] fddbr = request.getParameterValues("fddbr");
			for (int i = 0; i < fddbr.length; i++) {
				if (fddbr[i] != null && fddbr[i] != "") {
					list.get(i)
							.setFddbr(
									new String(fddbr[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("cbsj") != null) {
			String[] cbsj = request.getParameterValues("cbsj");
			for (int i = 0; i < cbsj.length; i++) {
				if (cbsj[i] != null && cbsj[i] != "") {
					list.get(i)
							.setCbsj(
									new String(cbsj[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("hycp") != null) {
			String[] hycp = request.getParameterValues("hycp");
			for (int i = 0; i < hycp.length; i++) {
				if (hycp[i] != null && hycp[i] != "") {
					list.get(i)
							.setHycp(
									new String(hycp[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("jgmcjzw") != null) {
			String[] jgmcjzw = request.getParameterValues("jgmcjzw");
			for (int i = 0; i < jgmcjzw.length; i++) {
				if (jgmcjzw[i] != null && jgmcjzw[i] != "") {
					list.get(i).setJgmcjzw(
							new String(jgmcjzw[i].getBytes("ISO-8859-1"),
									"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("shzl") != null) {
			String[] shzl = request.getParameterValues("shzl");
			for (int i = 0; i < shzl.length; i++) {
				if (shzl[i] != null && shzl[i] != "") {
					list.get(i)
							.setShzl(
									new String(shzl[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("lxgj") != null) {
			String[] lxgj = request.getParameterValues("lxgj");
			for (int i = 0; i < lxgj.length; i++) {
				if (lxgj[i] != null && lxgj[i] != "") {
					list.get(i)
							.setLxgj(
									new String(lxgj[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("xwjzy") != null) {
			String[] xwjzy = request.getParameterValues("xwjzy");
			for (int i = 0; i < xwjzy.length; i++) {
				if (xwjzy[i] != null && xwjzy[i] != "") {
					list.get(i)
							.setXwjzy(
									new String(xwjzy[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("szxx") != null) {
			String[] szxx = request.getParameterValues("szxx");
			for (int i = 0; i < szxx.length; i++) {
				if (szxx[i] != null && szxx[i] != "") {
					list.get(i)
							.setSzxx(
									new String(szxx[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("ggsj") != null) {
			String[] ggsj = request.getParameterValues("ggsj");
			for (int i = 0; i < ggsj.length; i++) {
				if (ggsj[i] != null && ggsj[i] != "") {
					list.get(i)
							.setGgsj(
									new String(ggsj[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("gggzdw") != null) {
			String[] gggzdw = request.getParameterValues("gggzdw");
			for (int i = 0; i < gggzdw.length; i++) {
				if (gggzdw[i] != null && gggzdw[i] != "") {
					list.get(i).setGggzdw(
							new String(gggzdw[i].getBytes("ISO-8859-1"),
									"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("bs") != null) {
			String[] bs = request.getParameterValues("bs");
			for (int i = 0; i < bs.length; i++) {
				if (bs[i] != null && bs[i] != "") {
					list.get(i).setBs(
							new String(bs[i].getBytes("ISO-8859-1"), "UTF-8"));
				}
			}
		}

		if (request.getParameterValues("ytbgx") != null) {
			String[] ytbgx = request.getParameterValues("ytbgx");
			for (int i = 0; i < ytbgx.length; i++) {
				if (ytbgx[i] != null && ytbgx[i] != "") {
					list.get(i)
							.setYtbgx(
									new String(ytbgx[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("szgj") != null) {
			String[] szgj = request.getParameterValues("szgj");
			for (int i = 0; i < szgj.length; i++) {
				if (szgj[i] != null && szgj[i] != "") {
					list.get(i)
							.setSzgj(
									new String(szgj[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("yqgx") != null) {
			String[] yqgx = request.getParameterValues("yqgx");
			for (int i = 0; i < yqgx.length; i++) {
				if (yqgx[i] != null && yqgx[i] != "") {
					list.get(i)
							.setYqgx(
									new String(yqgx[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		if (request.getParameterValues("zytc") != null) {
			String[] zytc = request.getParameterValues("zytc");
			for (int i = 0; i < zytc.length; i++) {
				if (zytc[i] != null && zytc[i] != "") {
					list.get(i)
							.setZytc(
									new String(zytc[i].getBytes("ISO-8859-1"),
											"UTF-8"));
				}
			}
		}

		return list;
	}

	public People UpdateOne(HttpServletRequest request) throws IOException {
		People p = new People();
		GridServer gs = new GridServerImpl();
		if (request.getParameter("name") != null
				& request.getParameter("name") != "") {
			String name = new String(request.getParameter("name").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setName(name);
		}

		if (request.getParameter("sex") != null
				& request.getParameter("sex") != "") {
			String sex = new String(request.getParameter("sex").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setSex(sex);
		}

		if (request.getParameter("birth") != null
				& request.getParameter("birth") != "") {
			String birth = new String(request.getParameter("birth").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setBirth(birth);
		}

		if (request.getParameter("origin") != null
				& request.getParameter("origin") != "") {
			String origin = new String(request.getParameter("origin").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setOrigin(origin);
		}

		if (request.getParameter("race") != null
				& request.getParameter("race") != "") {
			String race = new String(request.getParameter("race").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setRace(race);
		}

		if (request.getParameter("phone") != null
				& request.getParameter("phone") != "") {
			String phone = new String(request.getParameter("phone").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setPhone(phone);
		}

		if (request.getParameter("education") != null
				& request.getParameter("education") != "") {
			String education = new String(request.getParameter("education")
					.getBytes("ISO-8859-1"), "UTF-8");
			p.setEducation(education);
		}

		if (request.getParameter("ward") != null
				& request.getParameter("ward") != "") {
			String ward = new String(request.getParameter("ward").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setWard(ward);
		}

		if (request.getParameter("community") != null
				& request.getParameter("community") != "") {
			String community = new String(request.getParameter("community")
					.getBytes("ISO-8859-1"), "UTF-8");
			p.setCommunity(community);
		}

		if (request.getParameter("grid") != null
				& request.getParameter("grid") != "") {
			String grid = new String(request.getParameter("grid").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setGrid(grid);
		}

		// 信息判断是否正确（信息验证）顺序不可变
		// 网格
		if (gs.GridCount(p.getCommunity(), p.getGrid()) == 0) {
			request.setAttribute("message",
					"<script type='text/javascript'>alert('该社区内不存在该网格！');</script>");
			p.setGrid(null);
		}

		if (request.getParameter("grid") == null
				|| request.getParameter("grid") == "") {
			request.setAttribute("message",
					"<script type='text/javascript'>alert('网格信息不能为空！');</script>");
		}

		// 社区
		if (gs.CommunityCount(p.getCommunity()) == 0) {
			request.setAttribute("message",
					"<script type='text/javascript'>alert('不存在该社区！');</script>");
			p.setCommunity(null);
		}

		if (request.getParameter("community") == null
				|| request.getParameter("community") == "") {
			request.setAttribute("message",
					"<script type='text/javascript'>alert('社区信息不能为空！');</script>");
		}
		// 片区
		if (gs.WardCount(p.getWard()) == 0) {
			request.setAttribute("message",
					"<script type='text/javascript'>alert('不存在该片区！');</script>");
			p.setWard(null);
		}

		if (request.getParameter("ward") == null
				|| request.getParameter("ward") == "") {
			request.setAttribute("message",
					"<script type='text/javascript'>alert('片区信息不能为空！');</script>");
		}

		// 性格
		if (request.getParameter("sex") == null
				|| request.getParameter("sex") == "") {
			request.setAttribute("message",
					"<script type='text/javascript'>alert('性别信息不能为空！');</script>");
		}
		// 姓名
		if (request.getParameter("name") == null
				|| request.getParameter("name") == "") {
			request.setAttribute("message",
					"<script type='text/javascript'>alert('姓名信息不能为空！');</script>");
		}

		// if(request.getParameter("type")!=null&request.getParameter("type")!="")
		// {
		// String type = new
		// String(request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");
		// p.setType(type);
		// }
		//
		// if(request.getParameter("type")==null||request.getParameter("type")=="")
		// {
		// request.setAttribute("message",
		// "<script type='text/javascript'>alert('人员类型信息不能为空！');</script>");
		// }
		//
		if (request.getParameter("gzdw") != null
				& request.getParameter("gzdw") != "") {
			String gzdw = new String(request.getParameter("gzdw").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setGzdw(gzdw);
		}

		if (request.getParameter("dwzw") != null
				& request.getParameter("dwzw") != "") {
			String dwzw = new String(request.getParameter("dwzw").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setDwzw(dwzw);
		}

		if (request.getParameter("shzw") != null
				& request.getParameter("shzw") != "") {
			String shzw = new String(request.getParameter("shzw").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setShzw(shzw);
		}

		if (request.getParameter("rdsj") != null
				& request.getParameter("rdsj") != "") {
			String rdsj = new String(request.getParameter("rdsj").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setRdsj(rdsj);
		}

		if (request.getParameter("hjdz") != null
				& request.getParameter("hjdz") != "") {
			String hjdz = new String(request.getParameter("hjdz").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setHjdz(hjdz);
		}

		if (request.getParameter("jydz") != null
				& request.getParameter("jydz") != "") {
			String jydz = new String(request.getParameter("jydz").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setJydz(jydz);
		}

		if (request.getParameter("hylb") != null
				& request.getParameter("hylb") != "") {
			String hylb = new String(request.getParameter("hylb").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setHylb(hylb);
		}

		if (request.getParameter("sfzh") != null
				& request.getParameter("sfzh") != "") {
			String sfzh = new String(request.getParameter("sfzh").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setSfzh(sfzh);
		}

		if (request.getParameter("zzdz") != null
				& request.getParameter("zzdz") != "") {
			String zzdz = new String(request.getParameter("zzdz").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setZzdz(zzdz);
		}

		if (request.getParameter("f4_qt") != null
				& request.getParameter("f4_qt") != "") {
			String f4_qt = new String(request.getParameter("f4_qt").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setF4_qt(f4_qt);
		}

		if (request.getParameter("byyx") != null
				& request.getParameter("byyx") != "") {
			String byyx = new String(request.getParameter("byyx").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setByyx(byyx);
		}

		if (request.getParameter("dpmc") != null
				& request.getParameter("dpmc") != "") {
			String dpmc = new String(request.getParameter("dpmc").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setDpmc(dpmc);
		}

		if (request.getParameter("fm") != null
				& request.getParameter("fm") != "") {
			String fm = new String(request.getParameter("fm").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setFm(fm);
		}

		if (request.getParameter("zjxy") != null
				& request.getParameter("zjxy") != "") {
			String zjxy = new String(request.getParameter("zjxy").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setZjxy(zjxy);
		}

		if (request.getParameter("zjcs") != null
				& request.getParameter("zjcs") != "") {
			String zjcs = new String(request.getParameter("zjcs").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setZjcs(zjcs);
		}

		if (request.getParameter("zjrz") != null
				& request.getParameter("zjrz") != "") {
			String zjrz = new String(request.getParameter("zjrz").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setZjrz(zjrz);
		}

		if (request.getParameter("db") != null
				& request.getParameter("db") != "") {
			String db = new String(request.getParameter("db").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setDb(db);
		}

		if (request.getParameter("f5_qt") != null
				& request.getParameter("f5_qt") != "") {
			String f5_qt = new String(request.getParameter("f5_qt").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setF5_qt(f5_qt);
		}

		if (request.getParameter("jtdz") != null
				& request.getParameter("jtdz") != "") {
			String jtdz = new String(request.getParameter("jtdz").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setJtdz(jtdz);
		}

		if (request.getParameter("f6_qt") != null
				& request.getParameter("f6_qt") != "") {
			String f6_qt = new String(request.getParameter("f6_qt").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setF6_qt(f6_qt);
		}

		if (request.getParameter("qymc") != null
				& request.getParameter("qymc") != "") {
			String qymc = new String(request.getParameter("qymc").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setQymc(qymc);
		}

		if (request.getParameter("qydz") != null
				& request.getParameter("qydz") != "") {
			String qydz = new String(request.getParameter("qydz").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setQydz(qydz);
		}

		if (request.getParameter("zc") != null
				& request.getParameter("zc") != "") {
			String zc = new String(request.getParameter("zc").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setZc(zc);
		}

		if (request.getParameter("fddbr") != null
				& request.getParameter("fddbr") != "") {
			String fddbr = new String(request.getParameter("fddbr").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setFddbr(fddbr);
		}

		if (request.getParameter("cbsj") != null
				& request.getParameter("cbsj") != "") {
			String cbsj = new String(request.getParameter("cbsj").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setCbsj(cbsj);
		}

		if (request.getParameter("hycp") != null
				& request.getParameter("hycp") != "") {
			String hycp = new String(request.getParameter("hycp").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setHycp(hycp);
		}

		if (request.getParameter("jgmcjzw") != null
				& request.getParameter("jgmcjzw") != "") {
			String jgmcjzw = new String(request.getParameter("jgmcjzw")
					.getBytes("ISO-8859-1"), "UTF-8");
			p.setJgmcjzw(jgmcjzw);
		}

		if (request.getParameter("shzl") != null
				& request.getParameter("shzl") != "") {
			String shzl = new String(request.getParameter("shzl").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setShzl(shzl);
		}

		if (request.getParameter("lxgj") != null
				& request.getParameter("lxgj") != "") {
			String lxgj = new String(request.getParameter("lxgj").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setLxgj(lxgj);
		}

		if (request.getParameter("xwjzy") != null
				& request.getParameter("xwjzy") != "") {
			String xwjzy = new String(request.getParameter("xwjzy").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setXwjzy(xwjzy);
		}

		if (request.getParameter("szxx") != null
				& request.getParameter("szxx") != "") {
			String szxx = new String(request.getParameter("szxx").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setSzxx(szxx);
		}

		if (request.getParameter("ggsj") != null
				& request.getParameter("ggsj") != "") {
			String ggsj = new String(request.getParameter("ggsj").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setGgsj(ggsj);
		}

		if (request.getParameter("gggzdw") != null
				& request.getParameter("gggzdw") != "") {
			String gggzdw = new String(request.getParameter("gggzdw").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setGggzdw(gggzdw);
		}

		if (request.getParameter("bs") != null
				& request.getParameter("bs") != "") {
			String bs = new String(request.getParameter("bs").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setBs(bs);
		}

		if (request.getParameter("ytbgx") != null
				& request.getParameter("ytbgx") != "") {
			String ytbgx = new String(request.getParameter("ytbgx").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setYtbgx(ytbgx);
		}

		if (request.getParameter("szgj") != null
				& request.getParameter("szgj") != "") {
			String szgj = new String(request.getParameter("szgj").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setSzgj(szgj);
		}

		if (request.getParameter("yqgx") != null
				& request.getParameter("yqgx") != "") {
			String yqgx = new String(request.getParameter("yqgx").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setYqgx(yqgx);
		}

		if (request.getParameter("zytc") != null
				& request.getParameter("zytc") != "") {
			String zytc = new String(request.getParameter("zytc").getBytes(
					"ISO-8859-1"), "UTF-8");
			p.setZytc(zytc);
		}
		return p;
	}

	// 黄石统战部用户看到的各表数据人数
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

	// 片区用户看到的各表数据人数
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

	// 社区用户看到的各表数据人数
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

	// f12表中获取华侨、归侨、侨眷人数
	public void YqgxCount(HttpServletRequest request, String username)
			throws IOException {
		CommonServer cs = new CommonServerImpl();
		HttpSession session = request.getSession();
		String community = (String) session.getAttribute("community");

		if ("中共黄石港区委统战部".equals(username)) {
			int f12_1 = cs.GetCountByYqgx("华侨");
			int f12_2 = cs.GetCountByYqgx("归侨");
			int f12_3 = cs.GetCountByYqgx("侨眷");
			session.setAttribute("f12_1", f12_1);
			session.setAttribute("f12_2", f12_2);
			session.setAttribute("f12_3", f12_3);
		} else {
			int f12_1 = cs.GetCountByYqgxAndKey(username, "华侨", community);
			int f12_2 = cs.GetCountByYqgxAndKey(username, "归侨", community);
			int f12_3 = cs.GetCountByYqgxAndKey(username, "侨眷", community);
			session.setAttribute("f12_1", f12_1);
			session.setAttribute("f12_2", f12_2);
			session.setAttribute("f12_3", f12_3);
		}
	}

	// f11表中台湾同胞、台胞家属人数
	public void SfbdcbqyCount(HttpServletRequest request, String username)
			throws IOException {
		CommonServer cs = new CommonServerImpl();
		HttpSession session = request.getSession();
		String community = (String) session.getAttribute("community");

		if ("中共黄石港区委统战部".equals(username)) {
			int f11_3 = cs.GetCountBySfbdcbqy("本地创办");
			int f11_4 = cs.GetCountBySfbdcbqy("外地创办");
			session.setAttribute("f11_3", f11_3);
			session.setAttribute("f11_4", f11_4);
		} else {
			int f11_3 = cs
					.GetCountBySfbdcbqyAndKey(username, "本地创办", community);
			int f11_4 = cs
					.GetCountBySfbdcbqyAndKey(username, "外地创办", community);
			session.setAttribute("f11_3", f11_3);
			session.setAttribute("f11_4", f11_4);
		}
	}

	// f11表中台湾同胞、台胞家属人数
	public void YtbgxCount(HttpServletRequest request, String username)
			throws IOException {
		CommonServer cs = new CommonServerImpl();
		HttpSession session = request.getSession();
		String community = (String) session.getAttribute("community");

		if ("中共黄石港区委统战部".equals(username)) {
			int f11_1 = cs.GetCountByYtbgx("台湾同胞");
			int f11_2 = cs.GetCountByYtbgx("台胞家属");
			session.setAttribute("f11_1", f11_1);
			session.setAttribute("f11_2", f11_2);
		} else {
			int f11_1 = cs.GetCountByYtbgxAndKey(username, "台湾同胞", community);
			int f11_2 = cs.GetCountByYtbgxAndKey(username, "台胞家属", community);
			session.setAttribute("f11_1", f11_1);
			session.setAttribute("f11_2", f11_2);
		}
	}

	// f10表中港澳同胞人数
	public void BsCount(HttpServletRequest request, String username)
			throws IOException {
		CommonServer cs = new CommonServerImpl();
		HttpSession session = request.getSession();
		String community = (String) session.getAttribute("community");

		if ("中共黄石港区委统战部".equals(username)) {
			int f10_1 = cs.GetCountByBs("香港同胞");
			int f10_2 = cs.GetCountByBs("澳门同胞");
			session.setAttribute("f10_1", f10_1);
			session.setAttribute("f10_2", f10_2);
		} else {
			int f10_1 = cs.GetCountByBsAndKey(username, "香港同胞", community);
			int f10_2 = cs.GetCountByBsAndKey(username, "澳门同胞", community);
			session.setAttribute("f10_1", f10_1);
			session.setAttribute("f10_2", f10_2);
		}
	}

	// f1表中各党派人士人数
	public void DpmcCount(HttpServletRequest request, String username)
			throws IOException {
		CommonServer cs = new CommonServerImpl();
		HttpSession session = request.getSession();
		String community = (String) session.getAttribute("community");
		if ("中共黄石港区委统战部".equals(username)) {
			int f1_1 = cs.getCountByDpmc("民革", "f1");
			int f1_2 = cs.getCountByDpmc("民盟", "f1");
			int f1_3 = cs.getCountByDpmc("民建", "f1");
			int f1_4 = cs.getCountByDpmc("民进", "f1");
			int f1_5 = cs.getCountByDpmc("农工党", "f1");
			int f1_6 = cs.getCountByDpmc("致公党", "f1");
			int f1_7 = cs.getCountByDpmc("九三", "f1");
			int f1_8 = cs.getCountByDpmc("台盟", "f1");
			session.setAttribute("f1_1", f1_1);
			session.setAttribute("f1_2", f1_2);
			session.setAttribute("f1_3", f1_3);
			session.setAttribute("f1_4", f1_4);
			session.setAttribute("f1_5", f1_5);
			session.setAttribute("f1_6", f1_6);
			session.setAttribute("f1_7", f1_7);
			session.setAttribute("f1_8", f1_8);
		} else {
			int f1_1 = cs.GetCountByDpmcAndKey(username, "民革", community);
			int f1_2 = cs.GetCountByDpmcAndKey(username, "民盟", community);
			int f1_3 = cs.GetCountByDpmcAndKey(username, "民建", community);
			int f1_4 = cs.GetCountByDpmcAndKey(username, "民进", community);
			int f1_5 = cs.GetCountByDpmcAndKey(username, "农工党", community);
			int f1_6 = cs.GetCountByDpmcAndKey(username, "致公党", community);
			int f1_7 = cs.GetCountByDpmcAndKey(username, "九三", community);
			int f1_8 = cs.GetCountByDpmcAndKey(username, "台盟", community);
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
