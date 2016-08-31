<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
<title>黄石港区少数民族流动人口登记表</title>
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
	<h1 align="center">黄石港区少数民族流动人口登记表</h1>
    <table id="tableColor">
    	<thead>
    		<th>序号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>民族</th>
            <th>宗教信仰</th>
            <th>户籍地址</th>
            <th>经营地址</th>
            <th>行业类别</th>
            <th>身份证号</th>
            <th>租住地址</th>
            <th>联系方式</th>
            <th>其它</th>
            <th>操作</th>
        </thead>
        <%--private String f5 = "name,sex,race,zjxy,hjdz,jydz,hylb,
        sfzh,zzdz,phone,f5_qt,community,grid,ward,f5";
	 --%>
        <c:forEach items="${page.records}" var="c" varStatus="vs">
    	<tr>
    		<td>${vs.index+1}</td>
            <td>${c.name}</td>
            <td>${c.sex}</td>
            <td>${c.race}</td>
            <td>${c.zjxy}</td>
            <td>${c.hjdz}</td>
            <td>${c.jydz}</td>
            <td>${c.hylb}</td>
            <td>${c.sfzh}</td>
            <td>${c.zzdz}</td>
            <td>${c.phone}</td>
            <td>${c.f5_qt}</td>
            <td><a href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=updateone&pid=${c.id}">修改</a> <a href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=deleteone&pid=${c.id}">删除</a></td>
        </tr>
        </c:forEach>
    </table>
    <p align="center"><%@include file="/statistics/form/page.jsp"%></p>
</body>
</html>
