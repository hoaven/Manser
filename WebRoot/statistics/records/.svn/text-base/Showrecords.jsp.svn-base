<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>操作记录</title>
<script
	src="${pageContext.request.contextPath}/statistics/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	function initEvent() {

		//表格换成bootstrap样式
		$("#tableColor").toggleClass("table table-condensed");

		//表格隔行换色
		var tableCol = document.getElementById("tableColor");
		var trs = tableCol.getElementsByTagName("tr");
		for ( var i = 1; i <= trs.length; i++) {
			var tr = trs[i];
			if (i % 2 == 0) {
				tr.style.background = "#d3d3d3";
			} else {
				tr.style.background = "white";
			}
		}
	};
</script>
<style type="text/css">
table  thead {
	color: #f8f8f8;
	background-color: rgba(27, 106, 170, 0.8);
}

table tr {
	
}

th,td {
	text-align: center;
}
.yonghu {
	width:100px;
}
.duixiang {
	width:80px;
}
.fanwei {
	width:150px;
}
.leixing {
	width:80px;
}
.shijian {
	width:100px;
}
</style>
</head>
<body onload="initEvent()">
	<div class="container">
		<h1 align="left">操作记录</h1>
		<form action="" method="post">
			<table border="1px dashed" align="center">
				<thead>
					<tr class="info">
						<th class="yonghu">用户</th>
						<th class="duixiang">操作对象</th>
						<th class="fanwei">操作范围</th>
						<th class="leixing">操作类型</th>
						<th class="shijian">操作时间</th>
						<th>操作内容</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.records}" var="c">
						<tr>
							<td>${c.username}</td>
							<td>${c.obj}</td>
							<td>${c.scope}</td>
							<td>${c.operate}</td>
							<td>${c.operatetime}</td>
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