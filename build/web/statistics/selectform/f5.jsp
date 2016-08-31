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
<form action="${pageContext.request.contextPath}/servlet/AdminServlet?operation=realdeletemany" method="post">
	<h1 align="center">黄石港区少数民族流动人口登记表</h1>
    <table id="tableColor"  cellpadding="10" cellspacing="0" border=2px align="center">
    	<thead>
    		<th>选择</th>
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
        <c:forEach items="${page.records}" var="c">
    	<tr>
    		<td><input name="selectid" type="checkbox" value=${ c.id } /></td>
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
            <td><a href="#">修改</a> <a href="#">删除</a></td>
        </tr>
        </c:forEach>
    </table>
    <br/>
	    &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="删除所选" />
	  </form>
    <p align="center"><%@include file="/statistics/selectform/page.jsp"%></p>
</body>
</html>
