<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>黄石港区统战服务系统</title>
<jsp:include page="s.jsp"></jsp:include>
</head>
<body onload="initEvent()">
	<h1 align="center">黄石港区少数民族流动人口登记表</h1>
	<form
		action="${pageContext.request.contextPath}/servlet/AdminServlet?operation=realaddmany"
		method="post">
		<table id="tableColor" cellpadding="0" cellspacing="0" border="0px"
			align="center">
			<thead>
				<th>序号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>身份证号</th>
				<th>民族</th>
				<th>宗教信仰</th>
				<th>户籍地址</th>
				<th>经营地址</th>
				<th>行业类别</th>
				<th>租住地址</th>
				<th>联系方式</th>
				<th>其它</th>
				<th>所属片区</th>
				<th>所属社区</th>
				<th>所属网络</th>
			</thead>
			<c:forEach items="${peoples}" var="people" varStatus="vs">
				<tr>
					<td><input type="text" name="index" value="${vs.index+1}" />
					</td>
					<td><input type="text" name="name" value="${people.name}" />
					</td>
					<td><input type="text" name="sex" value="${people.sex}" /></td>
					<td><input type="text" name="sfzh" value="${people.sfzh}" />
					</td>
					<td><input type="text" name="race" value="${people.race}" />
					</td>
					<td><input type="text" name="zjxy" value="${people.zjxy}" />
					</td>
					<td><input type="text" name="hjdz" value="${people.hjdz}" />
					</td>
					<td><input type="text" name="jydz" value="${people.jydz}" />
					</td>
					<td><input type="text" name="hylb" value="${people.hylb}" />
					</td>
					<td><input type="text" name="zzdz" value="${people.zzdz}" />
					</td>
					<td><input type="text" name="phone" value="${people.phone}" />
					</td>
					<td><input type="text" name="f4_qt" value="${people.f4_qt}" />
					</td>
					<td><input type="text" name="ward" value="${people.ward}" />
					</td>
					<td><input type="text" name="community"
						value="${people.community}" /></td>
					<td><input type="text" name="grid" value="${people.grid}" />
					</td>
				</tr>
			</c:forEach>

		</table>
		<p align="center">
			<input type="submit" value="插入" />
		</p>
	</form>
</body>
</html>
