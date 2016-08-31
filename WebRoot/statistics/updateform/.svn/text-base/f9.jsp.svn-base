<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>黄石港区出国和归国留学人员修改表</title>
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
<h1 align="center">黄石港区出国和归国留学人员</h1>
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
            <div class="field-label">留学国家名称：</div>
            <div class="field-widget"><input type="text" name="lxgj" value="${people.lxgj}"/></div>
        </div>

        <div class="form-row">
            <div class="field-label">攻读学位及专业：</div>
            <div class="field-widget"><input type="text" name="xwjzy" value="${people.xwjzy}"/></div>
        </div>

        <div class="form-row">
            <div class="field-label">归国时间：</div>
            <div class="field-widget"><input type="text" name="ggsj" value="${people.ggsj}"/></div>
        </div>

		<div class="form-row">
            <div class="field-label">归国工作单位：</div>
            <div class="field-widget"><input type="text" name="gggzdw" value="${people.gggzdw}"/></div>
        </div>

        <div class="form-row">
            <div class="field-label">社会职务：</div>
            <div class="field-widget"><input type="text" name="shzw" value="${people.shzw}"/></div>
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