<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
<title>黄石港区新的社会阶层人士登记表</title>
<jsp:include page="s.jsp"></jsp:include>
</head>
<body onload="initEvent()">
	<h1 align="center">黄石港区新的社会阶层人士登记表</h1>
    <table id="tableColor">
    	<thead>
    		<th>序号</th>
        	<th>姓名</th>
            <th>性别</th>
            <th>身份证号</th>
            <th>出生年月</th>
            <th>籍贯</th>
            <th>民族</th>
            <th>文化程度</th>
            <th>创办机构名称及职务</th>
            <th>所获专利或生产主导产品</th>
            <th>联系电话</th>
            <th>操作</th>
        </thead>
        <%--
        private String f8 = "name,sex,birth,orign,race,education,
        jgmcjzw,shzl,phone,community,grid,ward,f8";
	 --%>
        <c:forEach items="${page.records}" var="c" varStatus="vs">
    	<tr>
    		<td>${vs.index+1}</td>
        	<td>${c.name}</td>
            <td>${c.sex}</td>
            <td>${c.sfzh}</td>
            <td>${c.birth}</td>
            <td>${c.origin}</td>
            <td>${c.race}</td>
            <td>${c.education}</td>
            <td>${c.jgmcjzw}</td>
            <td>${c.shzl}</td>
            <td>${c.phone}</td>
            <td><a href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=updateone&pid=${c.id}">修改</a> <a href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=deleteone&pid=${c.id}">删除</a></td>
        </tr>
        </c:forEach>
    </table>
    <p align="center"><%@include file="/statistics/form/page.jsp"%></p>
</body>
</html>
