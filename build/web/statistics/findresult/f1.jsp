<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
<title>黄石港区民主党派成员登记表</title>
<jsp:include page="s.jsp"></jsp:include>
</head>
<body onload="initEvent()">
	<h1 align="center">黄石港区民主党派成员登记表(记录数:${findcount}人)</h1>
    <table id="tableColor">
    	<thead>
    		<th>序号</th>
        	<th>党派名称</th>
            <th>姓名</th>
            <th>性别</th>
            <th>出生年月</th>
            <th>籍贯</th>
            <th>民族</th>
            <th>加入党派时间</th>
            <th>文化程度</th>
            <th>工作单位</th>
            <th>工作职务</th>
            <th>社会职务</th>
            <th>联系电话</th>
            <th>所属社区</th>
            <th>所属网络</th>
            <th>操作</th>
        </thead>
        <c:forEach items="${page.records}" var="c" varStatus="vs">
    	<tr>
    	<%--private String f1 = "dpmc,name,sex,birth,origin,race,rdsj,
    	education,gzdw,dwzw,shzw,phone,community,grid,ward,f1"; --%>
    		<td>${vs.index+1}</td>
            <td>${c.dpmc}</td>
        	<td>${c.name}</td>
            <td>${c.sex}</td>
            <td>${c.birth}</td>
            <td>${c.origin}</td>
            <td>${c.race}</td>
            <td>${c.rdsj}</td>
            <td>${c.education}</td>
            <td>${c.gzdw}</td>
            <td>${c.dwzw}</td>
            <td>${c.shzw}</td>
            <td>${c.phone}</td>
            <td>${c.community}</td>
            <td>${c.grid}</td>
            <td><a href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=updateone&pid=${c.id}">修改</a> <a href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=deleteone&pid=${c.id}">删除</a></td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
