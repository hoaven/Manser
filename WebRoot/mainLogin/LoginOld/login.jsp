<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="${pageContext.request.contextPath}/mainLogin/login.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/mainLogin/login.js" charset="gbk"></script>
   <%--  <script type="text/javascript">
         function check(form) {
          if(form.one.value==''||form.one.value==null||form.one.value==0) {
                alert("请输入登录名一!");
                form.userId.focus();
                return false;
           }
           if(form.one.value!="中共黄石港区统战部") {
	           if(form.two.value==''||form.two.value==null||form.two.value==0) {
	                alert("请输入登录名二!");
	                form.userId.focus();
	                return false;
	           }  
	        }
         }
</script>  --%>
</head>
<body>
	${message}
	<div class="div1"></div>
  
    <div class="Main">
   <form id="form1" action="${pageContext.request.contextPath}/servlet/LoginServlet" method="post" >
                <ul class="login">
                    <li><span class="left">登录名：</span>
                    <!-- onChange="getTwo() -->
                        <select name="one" id="one" onChange="getTwo()">
                            <option value="中共黄石港区统战部">黄石港区委统战部</option> 
                            <option value="江北管理区">江北管理区</option>
                            <option value="花湖街道办事处">花湖街道办事处</option>
                            <option value="黄石港片区管理委员会">黄石港片区管理委员会</option>
                            <option value="环磁湖片区管理委员会">环磁湖片区管理委员会</option>
                            <option value="胜阳港片区管理委员会">胜阳港片区管理委员会</option>
                        </select>
                    </li>
                    <li><span class="left">登录名：</span>
                        <select id="two" name="two">
                          <option value="中共黄石港区统战部">黄石港区委统战部</option>
                        </select>
                    </li>
                     <li><span class="left">密 &nbsp;码：</span>
                          <input type="password" name="password"/>
                    </li>
                    <li>
                </ul>
            </li>

            <li class="middle_C">
            <span class="btn">
                <input type="image" src="${pageContext.request.contextPath}/mainLogin/images/login/btnlogin.gif" />
            </span>
            </li>
   </form>
    </div>
 
</body>
</html>
