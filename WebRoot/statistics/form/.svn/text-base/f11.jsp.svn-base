<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>黄石港区台湾同胞及其在大陆亲属登记表</title>
<jsp:include page="s.jsp"></jsp:include>
</head>
<body onload="initEvent()">
	<h1 align="center">黄石港区台湾同胞及其在大陆亲属登记表</h1>
	<table id="tableColor">
		<thead>
			<th>序号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>出生年月</th>
			<th>身份证号</th>
			<th>籍贯</th>
			<th>民族</th>
			<th>文化程度</th>
			<th>与台胞关系</th>
			<th>工作单位</th>
			<th>家庭住址</th>
			<th>社会职务</th>
			<th>联系电话</th>
			<th>操作</th>
		</thead>

		<c:forEach items="${page.records}" var="c" varStatus="vs">
			<tr>
				<td>${vs.index+1}</td>
				<td>${c.name}</td>
				<td>${c.sex}</td>
				<td>${c.birth}</td>
				<td>${c.sfzh}</td>
				<td>${c.origin}</td>
				<td>${c.race}</td>
				<td>${c.education}</td>
				<td>${c.ytbgx}</td>
				<td>${c.gzdw}</td>
				<td>${c.jtdz}</td>
				<td>${c.shzw}</td>
				<td>${c.phone}</td>
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
