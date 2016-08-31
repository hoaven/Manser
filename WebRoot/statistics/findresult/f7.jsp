<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
<jsp:include page="s.jsp"></jsp:include>
</head>
<body onload="initEvent()">
	<h1 align="center">黄石港区非公有制经济人士登记表</h1>
    <table id="tableColor">
    	<thead>
    		<th>序号</th>
        	<th>姓名</th>
            <th>性别</th>
            <th>身份证号</th>
            <th>出生年月</th>
            <th>籍贯</th>
            <th>民族</th>
            <th>党派</th>
            <th>文化程度</th>
            <th>企业名称</th>
            <th>企业地址</th>
            <th>职务</th>
            <th>职称</th>
            <th>法定代表人</th>
            <th>企业创办时间</th>
            <th>企业所在行业及主导产品</th>
            <th>联系电话</th>
            <th>操作</th>
        </thead>
        <%--
        private String f7 = "name,sex,birth,orign,race,dpmc,
        education,qymc,qydz,dwzw,zc,fddbr,cbsj,hycp,phone,community,grid,ward,f7";
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
            <td>${c.dpmc}</td>
            <td>${c.education}</td>
            <td>${c.qymc}</td>
            <td>${c.qydz}</td>
            <td>${c.dwzw}</td>
            <td>${c.zc}</td>
            <td>${c.fddbr}</td>
            <td>${c.cbsj}</td>
            <td>${c.hycp}</td>
            <td>${c.phone}</td>
            <td><a href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=updateone&pid=${c.id}">修改</a> <a href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=deleteone&pid=${c.id}">删除</a></td>
        </tr>
        </c:forEach>
    </table>
    <p align="center"><%@include file="/statistics/form/page.jsp"%></p>
</body>
</html>
