<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>黄石港区宗教人士登记表</title>
<jsp:include page="s.jsp"></jsp:include>
</head>
<body onload="initEvent()">
	<h1 align="center">黄石港区无党派人士登记表</h1>

	<table id="tableColor">
		<thead>
			<th>序号</th>
			<th>姓名</th>
			<th>法名</th>
			<th>性别</th>
			<th>名族</th>
			<th>宗教信仰</th>
			<th>宗教场所</th>
			<th>宗教任职</th>
			<th>身份证号</th>
			<th>联系方式</th>
			<th>代表（委员）</th>
			<th>其他</th>
			<th>操作</th>
		</thead>
		<c:forEach items="${page.records}" var="c" varStatus="vs">
			<tr>
				<td>${vs.index+1}</td>
				<td>${c.name}</td>
				<td>${c.fm}</td>
				<td>${c.sex}</td>
				<td>${c.race}</td>
				<td>${c.zjxy}</td>
				<td>${c.zjcs}</td>
				<td>${c.zjrz}</td>
				<td>${c.sfzh}</td>
				<td>${c.phone}</td>
				<td>${c.db}</td>
				<td>${c.f4_qt}</td>
				<td><a
					href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=updateone&pid=${c.id}">修改</a>
					<a
					href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=deleteone&pid=${c.id}" onclick="return confirm('确实要删除吗？')">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p align="center"><%@include file="/statistics/form/page.jsp"%></p>
</body>
</html>
