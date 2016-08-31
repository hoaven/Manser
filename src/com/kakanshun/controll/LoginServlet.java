package com.kakanshun.controll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kakanshun.server.UserServer;
import com.kakanshun.server.impl.UserServerImpl;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String obj = "";
		if(request.getParameter("two")!=null)
			obj = new String(request.getParameter("two").getBytes("ISO-8859-1"),"UTF-8");
		String inputPas = request.getParameter("password");
		UserServer us = new UserServerImpl();
		String password = us.getPassword(obj);
		if(inputPas==""||inputPas==null) {
			request.setAttribute("message", "<script type='text/javascript'>alert('您输入的密码为空!请您点击确定后重新登录');</script>");
			request.getRequestDispatcher("/mainLogin/login.jsp").forward(request, response);
		}
		else if(password!=""&&password!=null) {
			if(password.equals(inputPas)) {
				request.getRequestDispatcher("/servlet/ShowServlet").forward(request, response);
			}
		}
		else {
			request.setAttribute("message", "<script type='text/javascript'>alert('您输入的密码有误!请您点击确定后重新登录');</script>");
			request.getRequestDispatcher("/mainLogin/login.jsp").forward(request, response);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
