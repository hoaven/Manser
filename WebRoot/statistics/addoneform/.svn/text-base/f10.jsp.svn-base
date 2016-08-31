<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>黄石港区香港同胞、澳门同胞（家属）胞属修改表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/statistics/addoneform/common.css">
<script
	src="${pageContext.request.contextPath}/statistics/addoneform/common.js"></script>
</head>
<body onload="getGrid()">
	<c:if test="${people==null}">
		<h1 align="center">黄石港区香港同胞、澳门同胞（家属）胞属</h1>
		<div class="form_content">
			<form
				action="${pageContext.request.contextPath}/servlet/AdminServlet?operation=realaddone&pid=${people.id}"
				method="post">
	</c:if>

	<c:if test="${people!=null}">
		<h1 align="center">黄石港区民主党派成员信息修改</h1>
		<div class="form_content">
			<form
				action="${pageContext.request.contextPath}/servlet/AdminServlet?operation=realupdateone&pid=${people.id}"
				method="post">
	</c:if>
	<fieldset>
		<div class="form-row">
			<div class="field-label">姓名：</div>
			<div class="field-widget">
				<input type="text" name="name" value="${people.name}" />
			</div>
		</div>

		<div class="form-row">
			<div class="field-label">性别：</div>
			<div class="field-widget">
				<c:if test="${people.sex eq '女'}">
					<input name="sex" type="radio" value="男" />男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="sex" type="radio" value="女" checked="checked" />女
					</c:if>

				<c:if
					test="${people.sex eq '男' ||people.sex eq '' ||people.sex==null}">
					<input name="sex" type="radio" value="男" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="sex" type="radio" value="女" />女
					</c:if>
			</div>
		</div>

		<div class="form-row">
			<div class="field-label">身份证号：</div>
			<div class="field-widget">
				<input type="text" name="sfzh" value="${people.sfzh}" />
			</div>
		</div>
		<%--
		<div class="form-row">
			<div class="field-label">性别：</div>
			<div class="field-widget">
				<label><input name="sex" type="radio" value="男" />男</label> 
				<label><input name="sex" type="radio" value="女" />女</label> 
        	</div>
        </div> 
--%>

		<div class="form-row">
			<div class="field-label">出生年月：</div>
			<div class="field-widget">
				<input type="text" name="birth" value="${people.birth}" />
			</div>
		</div>

		<div class="form-row">
			<div class="field-label">籍贯：</div>
			<div class="field-widget">
				<input type="text" name="origin" value="${people.origin}" />
			</div>
		</div>

		<div class="form-row">
			<div class="field-label">民族：</div>
			<div class="field-widget">
				<input type="text" name="race" value="${people.race}" />
			</div>
		</div>

		<div class="form-row">
			<div class="field-label">文化程度：</div>
			<div class="field-widget">
				<input type="text" name="education" value="${people.education}" />
			</div>
		</div>

		<div class="form-row">
			<div class="field-label">工作单位：</div>
			<div class="field-widget">
				<input type="text" name="gzdw" value="${people.gzdw}" />
			</div>
		</div>

		<div class="form-row">
			<div class="field-label">港或澳胞属：</div>
			<div class="field-widget">
				<select name="bs" id="bs"">
					<option value="香港同胞">香港同胞&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
					<option value="澳门同胞">澳门同胞</option>
					<option value="港胞家属">港胞家属</option>
					<option value="澳胞家属">澳胞家属</option>
				</select>
			</div>
		</div>

		<div class="form-row">
			<div class="field-label">家庭住址：</div>
			<div class="field-widget">
				<input type="text" name="jtdz" value="${people.jtdz}" />
			</div>
		</div>

		<div class="form-row">
			<div class="field-label">联系电话:</div>
			<div class="field-widget">
				<input type="text" name="phone" value="${people.phone}" />
			</div>
		</div>

		<div class="form-row">
			<div class="field-label">所属片区：</div>
			<div class="field-widget">
				<select name="ward" id="ward" onChange="getTwo()">
					<c:if test="${obj eq '中共黄石港区委统战部'}">
						<option value="">----请选择片区----</option>
						<option value="江北管理区">江北管理区</option>
						<option value="花湖街道办事处">花湖街道办事处</option>
						<option value="黄石港片区管理委员会">黄石港片区管理委员会</option>
						<option value="环磁湖片区管理委员会">环磁湖片区管理委员会</option>
						<option value="胜阳港片区管理委员会">胜阳港片区管理委员会</option>
					</c:if>

					<c:if test="${obj ne '中共黄石港区统战部'}">
						<option value="${ward}">${ward}</option>
					</c:if>
				</select>
			</div>
		</div>

		<div class="form-row">
			<div class="field-label">所属社区：</div>
			<div class="field-widget">

				<c:if test="${community!=null&&community ne ''}">
					<select name="community" id="community">
						<option value="${community}">${community}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
					</select>
				</c:if>

				<c:if test="${community==null||community eq ''}">
					<select name="community" id="community" onChange="getThere()">
						<option value="">----请选择社区----</option>
					</select>
				</c:if>

			</div>
		</div>

		<div class="form-row">
			<div class="field-label">所属网格：</div>
			<div class="field-widget">

				<c:if test="${grid!=null&&grid ne ''}">
					<select name="grid" id="grid">
						<option value="${grid}">${grid}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
					</select>
				</c:if>

				<c:if test="${grid==null||grid eq ''}">
					<select name="grid" id="grid">
						<option value="">----请选择网格----</option>
					</select>
				</c:if>

			</div>
		</div>

		<c:if test="${people==null}">
			<div class="form-row">
				<br /> <br />
				<p>
					<input type="submit" value="确定" />
				</p>
			</div>
		</c:if>

		<c:if test="${people!=null}">
			<div class="form-row">
				<br /> <br />
				<p>
					<input type="submit" value="确定" />
				</p>
			</div>
		</c:if>
	</fieldset>
	</form>
	</div>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
</body>
</html>