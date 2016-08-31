<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
<title>黄石港区民主党派成员登记表</title>
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
		<h1 align="center">黄石港区民主党派成员登记表</h1>
	    <table id="tableColor"  cellpadding="10" cellspacing="0" border=2px align="center">
	    	<thead>
	    		<th>选择</th>
	        	<th>党派名称</th>
	            <th>姓名</th>
	            <th>性别</th>
	            <th>出生年月</th>
	            <th>籍贯</th>
	            <th>名族</th>
	            <th>加入党派时间</th>
	            <th>文化程度</th>
	            <th>工作单位</th>
	            <th>工作职务</th>
	            <th>社会职务</th>
	            <th>联系电话</th>
	            <th>所属社区</th>
	            <th>所属网络</th>
	        </thead>
	        <c:forEach items="${page.records}" var="c">
	    	<tr>
	    	<%--private String f1 = "dpmc,name,sex,birth,origin,race,rdsj,
	    	education,gzdw,dwzw,shzw,phone,community,grid,ward,f1"; --%>
	    		<td><input name="selectid" type="checkbox" value=${ c.id } /></td>
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
	        </tr>
	        </c:forEach>
	    </table>
	    <br/>
	    &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="删除所选" />
	  </form>
    <p align="center"><%@include file="/statistics/selectform/page.jsp"%></p>
</body>
</html>
