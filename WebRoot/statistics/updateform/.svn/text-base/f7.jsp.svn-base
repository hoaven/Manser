<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>黄石港区非公有制经济人士修改表</title>
    <style type="text/css">
        .form_content{
            width:575px;
            margin:30px auto;
            padding:10px;
            background:url(/Manser/statistics/updateform/images/center_bg3.gif) repeat top left;
        }
        .form-row {
            float:left;
            padding:5px 5px 5px 5px;
        }
        .field-label {
            width:150px;
            float:left;
            line-height:25px;
            font-family:宋体;
            font-size:18px;
            color: #000000;
        }
        .field-widget {
            float:left;
        }
    </style>
</head>
<body>
<h1 align="center">黄石港区非公有制经济人士</h1>
<div class="form_content">
    <form action="${pageContext.request.contextPath}/servlet/AdminServlet?operation=realupdateone&pid=${people.id}" method="post">
        <fieldset>
        <div class="form-row">
            <div class="field-label">姓名：</div>
            <div class="field-widget"><input type="text" name="name" value="${people.name}"/></div>
        </div>
		
        <div class="form-row">
            <div class="field-label">性别：</div>
            <div class="field-widget"><input type="text" name="sex" value="${people.sex}"/></div>
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
            <div class="field-widget"><input type="text" name="birth" value="${people.birth}"/></div>
        </div>
		
		<div class="form-row">
            <div class="field-label">籍贯：</div>
            <div class="field-widget"><input type="text" name="origin" value="${people.origin}"/></div>
        </div>

        <div class="form-row">
            <div class="field-label">民族：</div>
            <div class="field-widget"><input type="text" name="race" value="${people.race}"/></div>
        </div>
                   
       
        <div class="form-row">
            <div class="field-label">党派名称：</div>
            <div class="field-widget"><input type="text" name="dpmc" value="${people.dpmc}"/></div>
        </div>

        <div class="form-row">
            <div class="field-label">文化程度：</div>
            <div class="field-widget"><input type="text" name="education" value="${people.education}"/></div>
        </div>

        <div class="form-row">
            <div class="field-label">企业名称：</div>
            <div class="field-widget"><input type="text" name="qymc" value="${people.qymc}"/></div>
        </div>

        <div class="form-row">
            <div class="field-label">企业地址：</div>
            <div class="field-widget"><input type="text" name="qydz" value="${people.qydz}"/></div>
        </div>

		<div class="form-row">
            <div class="field-label">职务：</div>
            <div class="field-widget"><input type="text" name="dwzw" value="${people.dwzw}"/></div>
        </div>
        <div class="form-row">
            <div class="field-label">职称：</div>
            <div class="field-widget"><input type="text" name="zc" value="${people.zc}"/></div>
        </div>

		<div class="form-row">
            <div class="field-label">法定代表人：</div>
            <div class="field-widget"><input type="text" name="fddbr" value="${people.fddbr}"/></div>
        </div>

		<div class="form-row">
            <div class="field-label">企业创办时间：</div>
            <div class="field-widget"><input type="text" name="cbsj" value="${people.cbsj}"/></div>
        </div>
		<div class="form-row">
            <div class="field-label">企业所在行业及主导产品：</div>
            <div class="field-widget"><input type="text" name="hycp" value="${people.hycp}"/></div>
        </div>

        <div class="form-row">
            <div class="field-label">联系电话:</div>
            <div class="field-widget"><input type="text" name="phone" value="${people.phone}"/></div>
        </div>
       
       <div class="form-row">
            <div class="field-label">所属片区：</div>
            <div class="field-widget"><input type="text" name="ward" value="${people.ward}"/></div>
        </div>
        
        <div class="form-row">
            <div class="field-label">所属社区：</div>
            <div class="field-widget"><input type="text" name="community" value="${people.community}"/></div>
        </div>

        <div class="form-row">
            <div class="field-label">所属网格：</div>
            <div class="field-widget"><input type="text" name="grid" value="${people.grid}"/></div>
        </div>
            <div class="form-row">
                <br/><br/>
                <p><input type="submit" value="修改"/></p>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>