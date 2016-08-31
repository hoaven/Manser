<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
<title>网格基本情况</title>
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
    <style type="text/css">
		body{
            font-family: 宋体;
        }
         table  thead{
            color: #f8f8f8;
            background-color: rgba(51, 122, 183, 1);
            font-family:宋体;
            font-size:18px;
        }
        table tr {
            font-family:宋体;
            font-size:18px;
        }
        th,td {
        	text-align:center;
        }
        h2 {
            color: #5E5E5E;
            text-align:center
        }
        a:link{
            color: darkblue;
            text-decoration: none;
            font-family:宋体;
            font-size:18px;
        }
        a:visited{
            color: darkblue;
        }
        a:hover{
            color: #49FF1C;
        }
        a:active{
            color: goldenrod;
        }
    	#clude {
            vertical-align: middle; 
    	}
    	#clude table {
    		margin-left: auto; 
			margin-right: auto; 
    	}
    </style>
</head>
<body onload="initEvent()">
	<a href="${pageContext.request.contextPath}/statistics/main.jsp">返回</a>
	<h1 align="center">网格分布基本情况</h1>
    <table id="tableColor"  cellpadding="10" cellspacing="0" border=2px align="center">
    	<thead>
    		<th>序号</th>
        	<th>所属域区</th>
            <th>所属社区</th>
            <th>所在网格</th>
            <th>网格管理员</th>
            <th>所管辖的范围</th>
            <th>手机号码</th>
        </thead>
        <c:forEach items="${grids}" var="c" varStatus="vs">
    	<tr>
    		<td>${vs.index+1}</td>
            <td>${c.ssyq}</td>
        	<td>${c.sssq}</td>
            <td>${c.szwg}</td>
            <td>${c.wgyxm}</td>
            <td>${c.fw}</td>
            <td>${c.phone}</td>
        </tr>
        </c:forEach>
    </table>
  </body>
</html>