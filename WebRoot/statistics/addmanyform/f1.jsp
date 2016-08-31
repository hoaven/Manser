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
	<h1 align="center">黄石港区民主党派成员登记表</h1>
	<form action="${pageContext.request.contextPath}/servlet/AdminServlet?operation=realaddmany" method="post">
	    <table id="tableColor"  cellpadding="0" cellspacing="0" border="0px" align="center">
	    	<thead>
	    		<th>序号</th>
	        	<th>党派名称</th>
	            <th>姓名</th>
	            <th>性别</th>
	            <th>身份证号</th>
	            <th>出生年月</th>
	            <th>籍贯</th>
	            <th>名族</th>
	            <th>加入党派时间</th>
	            <th>文化程度</th>
	            <th>工作单位</th>
	            <th>工作职务</th>
	            <th>社会职务</th>
	            <th>联系电话</th>
	            <th>所属片区</th>
	            <th>所属社区</th>
	            <th>所属网络</th>
	        </thead>
	        <c:forEach items="${peoples}" var="people" varStatus="vs">
	    	<tr>
	    		<td><input type="text" name="index" value="${vs.index+1}"/></td>
	            <td><input type="text" name="dpmc" value="${people.dpmc}"/></td>
	        	<td><input type="text" name="name" value="${people.name}"/></td>
	            <td><input type="text" name="sex" value="${people.sex}"/></td>
	            <td><input type="text" name="sfzh" value="${people.sfzh}"/></td>
	            <td><input type="text" name="birth" value="${people.birth}"/></td>
	            <td><input type="text" name="origin" value="${people.origin}"/></td>
	            <td><input type="text" name="race" value="${people.race}"/></td>
	            <td><input type="text" name="rdsj" value="${people.rdsj}"/></td>
	            <td><input type="text" name="education" value="${people.education}"/></td>
	            <td><input type="text" name="gzdw" value="${people.gzdw}"/></td>
	            <td><input type="text" name="dwzw" value="${people.dwzw}"/></td>
	            <td><input type="text" name="shzw" value="${people.shzw}"/></td>
	            <td><input type="text" name="phone" value="${people.phone}"/></td>
	            <td><input type="text" name="ward" value="${people.ward}"/></td>
	            <td><input type="text" name="community" value="${people.community}"/></td>
	            <td><input type="text" name="grid" value="${people.grid}"/></td>
	        </tr>
	        </c:forEach>
	        
	    </table>
	    <p align="center"><input type="submit" value="插入"/></p>
    </form>
</body>
</html>
