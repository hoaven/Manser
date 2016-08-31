<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>黄石港区出国和归国留学人员登记表</title>
    <script type="text/javascript">
        function initEvent() {
            var tableCol = document.getElementById("tableColor");
            var trs = tableCol.getElementsByTagName("tr");
            for (var i = 1; i <= trs.length; i++) {
                var tr = trs[i];
				if (i % 2 == 0) {
                    tr.style.background = "#d3d3d3";
                }
                else {
                        tr.style.background = "white";
                }
            }
        }
       
    </script>
</head>
<body onload="initEvent()">
<h1 align="center">黄石港区出国和归国留学人员登记表</h1>
<table id="tableColor">
    <thead>
    	<TH>序号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>出生年月</th>
        <th>籍贯</th>
        <th>民族</th>
        <th>留学国家名称</th>
        <th>攻读学位及专业	</th>
        <th>所在学校名称</th>
        <th>归国时间</th>
        <th>归国工作单位</th>
        <th>社会职务</th>
        <th>联系电话</th>
        <th>操作</th>
    </thead>
    <%--
    private String f9 = "name,sex,birth,orign,race,lxgj,xwjzy,\
    szxx,ggsj,gggzdw,shzw,phone,community,grid,ward,f9";
	 --%>
    <c:forEach items="${page.records}" var="c" varStatus="vs">
    	<tr>
    		<td>${vs.index+1}</td>
        <td>${c.name}</td>
        <td>${c.sex}</td>
        <td>${c.birth}</td>
        <td>${c.origin}</td>
        <td>${c.race}</td>
        <td>${c.lxgj}</td>
        <td>${c.xwjzy}</td>
        <td>${c.szxx}</td>
        <td>${c.ggsj}</td>
        <td>${c.gggzdw}</td>
        <td>${c.shzw}</td>
        <td>${c.phone}</td>
        <td><a href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=updateone&pid=${c.id}">修改</a> <a href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=deleteone&pid=${c.id}">删除</a></td>
    </tr>
    </c:forEach>
</table>
<p align="center"><%@include file="/statistics/form/page.jsp"%></p>
</body>
</html>