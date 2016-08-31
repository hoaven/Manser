<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
</style>
<script
	src="${pageContext.request.contextPath}/statistics/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	function initEvent(){

		//表格换成bootstrap样式
		$("#tableColor").addClass("table table-condensed");

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