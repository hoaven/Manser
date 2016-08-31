<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>操作记录</title>
</head>
<body onload="initEvent()">
<div class="container">
    <h1 align="center">操作记录</h1>
    <form action="" method="post">
        <table border="1px dashed" align="center">
            <thead>
            <tr class="info">
                <th>用户</th>
                <th>对象</th>
                <th>操作</th>
                <th>内容</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.records}" var="c">
	            <tr >
	                <td>${c.username}</td>
	                <td>${c.obj}</td>
	                <td>${c.operate}</td>
	                <td class="more ">${c.content}</td>
	            </tr>
	           </c:forEach>
            </tbody>
        </table>
    </form>
	<p align="center"><%@include file="/statistics/records/page.jsp"%></p>
</div>
</body>
</html>