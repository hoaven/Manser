<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head lang="en">
        <meta charset="UTF-8">
        <title>中共黄石港区委统战服务对象管理系统</title>
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/statistics/bootstrap.min.css">
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/statistics/dashboard.css">
        <link rel="stylesheet" type="text/css"
              href="${pageContext.request.contextPath}/statistics/community.css">
        <script
        src="${pageContext.request.contextPath}/statistics/jquery-2.1.4.min.js"></script>
        <script
        src="${pageContext.request.contextPath}/statistics/bootstrap.min.js"></script>
        <script type="text/javascript">
            function displaySubMenu(li) {
                var subMenu = li.getElementsByTagName("ul")[0];
                subMenu.style.display = "block";
            }
            function hideSubMenu(li) {
                var subMenu = li.getElementsByTagName("ul")[0];
                subMenu.style.display = "none";
            }
        </script>


    </head>
    <body>
        ${message}

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div id="navbar" class="navbar-collapse collapse">
                    <label style="margin-top: 15px;margin-bottom: 15px;">用户：${user}</label>
                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <label style="font-weight: normal;">服务对象范围： <c:if
                            test="${obj ne '中共黄石港区委统战部'}">
                            <c:if test="${ward!=null}">
                                ${ward}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </c:if>
                            <c:if test="${community!=null}">
                                ${community}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </c:if> ${grid}
                        </c:if> <c:if test="${obj eq '中共黄石港区委统战部'}">
                            ${obj}
                        </c:if> </label>
                    <ul class="nav navbar-nav navbar-right">
                        <c:if test="${user eq '中共黄石港区委统战部'}">
                            <!--  <li><a
                                    href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=showrecords">操作记录</a>
                            </li>-->
                        </c:if>
                        <li><a style="color: #ffffff;"
                               href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=showgrid">网格分布情况</a>
                        </li>
                        <li><a style="color: #ffffff;"
                               href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=removeSession">退出</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a
                        href="${pageContext.request.contextPath}/servlet/DetailServlet?form=f1">民主党派成员</a>
                </li>
                <li><a
                        href="${pageContext.request.contextPath}/servlet/DetailServlet?form=f2">无党派人士</a>
                </li>
                <li><a
                        href="${pageContext.request.contextPath}/servlet/DetailServlet?form=f3">党外知识分子</a>
                </li>
                <li><a
                        href="${pageContext.request.contextPath}/servlet/DetailServlet?form=f4">宗教人士</a>
                </li>
                <li><a
                        href="${pageContext.request.contextPath}/servlet/DetailServlet?form=f5">少数民族流动人士</a>
                </li>
                <li><a
                        href="${pageContext.request.contextPath}/servlet/DetailServlet?form=f6">少数民族常住人士</a>
                </li>
                <li><a
                        href="${pageContext.request.contextPath}/servlet/DetailServlet?form=f7">非公有制经济人士</a>
                </li>
                <li><a
                        href="${pageContext.request.contextPath}/servlet/DetailServlet?form=f8">新的社会阶层人士</a>
                </li>
                <li><a
                        href="${pageContext.request.contextPath}/servlet/DetailServlet?form=f9">出国和归国留学人士</a>
                </li>
                <li><a
                        href="${pageContext.request.contextPath}/servlet/DetailServlet?form=f10">港澳同胞（家属）</a>
                </li>
                <li><a
                        href="${pageContext.request.contextPath}/servlet/DetailServlet?form=f11">台湾同胞及其在大陆亲属</a>
                </li>
                <li><a
                        href="${pageContext.request.contextPath}/servlet/DetailServlet?form=f12">华侨、归侨及侨眷</a>
                </li>
                <li><a
                        href="${pageContext.request.contextPath}/servlet/DetailServlet?form=f13">其他联系对象</a>
                </li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="container">
                <%-- 
<div id="carousel1" class="carousel slide">        <!--图片轮播-->
<ol class="carousel-indicators">
    <li data-toggle="#carousel1" data-slide-to="0" class="active"></li>
    <li data-toggle="#carousel1" data-slide-to="1"></li>
    <li data-toggle="#carousel1" data-slide-to="2"></li>
</ol>
<div class="carousel-inner">
    <div class="item active">
        <img src="${pageContext.request.contextPath}/statistics/ch5.jpg" style="width: 1140px;height: 380px">
    </div>
    <div class="item ">
        <img src="${pageContext.request.contextPath}/statistics/ch4.jpg" style="width: 1140px;height: 380px">
    </div>
    <div class="item">
        <img src="${pageContext.request.contextPath}/statistics/ch3.jpg" style="width: 1140px;height: 380px">
    </div>
</div>
<a class="left carousel-control" href="#carousel1" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
</a>
<a class="right carousel-control" href="#carousel1" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
</a>
</div>
                --%>

                <div class="nav">
                    <ul id="navigation">
                        <li id="allgrid" onmouseover="displaySubMenu(this)"
                            onmouseout="hideSubMenu(this)"><a
                                href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=backuser">全区</a>
                        </li>

                        <li onmouseover="displaySubMenu(this)"
                            onmouseout="hideSubMenu(this)"><a
                                href="${pageContext.request.contextPath}/servlet/LimitServlet?obj=黄石港片区管理委员会">黄石港片区</a>
                            <ul>
                                <c:forEach items="${areagrid['黄石港片区管理委员会']}" var="sq">
                                    <li onmouseover="displaySubMenu(this)"
                                        onmouseout="hideSubMenu(this)"><a
                                            href="${pageContext.request.contextPath}/servlet/LimitServlet?obj=${sq.key}">${sq.key}</a>
                                        <ul>
                                            <c:if test="${sq.value!=null}">
                                                <c:forEach items="${sq.value}" var="wg">
                                                    <li><a
                                                            href="${pageContext.request.contextPath}/servlet/LimitServlet?value1=黄石港片区管理委员会&value2=${sq.key}&obj=${wg}">${wg}</a>
                                                    </li>
                                                </c:forEach>
                                            </c:if>
                                        </ul>
                                    </li>
                                </c:forEach>
                            </ul></li>
                        <li onmouseover="displaySubMenu(this)"
                            onmouseout="hideSubMenu(this)"><a
                                href="${pageContext.request.contextPath}/servlet/LimitServlet?obj=胜阳港片区管理委员会">胜阳港片区</a>
                            <ul>
                                <c:forEach items="${areagrid['胜阳港片区管理委员会']}" var="sq">
                                    <li onmouseover="displaySubMenu(this)"
                                        onmouseout="hideSubMenu(this)"><a
                                            href="${pageContext.request.contextPath}/servlet/LimitServlet?obj=胜阳港片区管理委员会">${sq.key}</a>
                                        <ul>
                                            <c:if test="${sq.value!=null}">
                                                <c:forEach items="${sq.value}" var="wg">
                                                    <li><a
                                                            href="${pageContext.request.contextPath}/servlet/LimitServlet?value1=${pq.key}&value2=${sq.key}&obj=${wg}">${wg}</a>
                                                    </li>
                                                </c:forEach>
                                            </c:if>
                                        </ul>
                                    </li>
                                </c:forEach>
                            </ul></li>
                        <li onmouseover="displaySubMenu(this)"
                            onmouseout="hideSubMenu(this)"><a
                                href="${pageContext.request.contextPath}/servlet/LimitServlet?obj=环磁湖片区管理委员会">环磁湖片区</a>
                            <ul>
                                <c:forEach items="${areagrid['环磁湖片区管理委员会']}" var="sq">
                                    <li onmouseover="displaySubMenu(this)"
                                        onmouseout="hideSubMenu(this)"><a
                                            href="${pageContext.request.contextPath}/servlet/LimitServlet?obj=${sq.key}">${sq.key}</a>
                                        <ul>
                                            <c:if test="${sq.value!=null}">
                                                <c:forEach items="${sq.value}" var="wg">
                                                    <li><a
                                                            href="${pageContext.request.contextPath}/servlet/LimitServlet?value1=环磁湖片区管理委员会&value2=${sq.key}&obj=${wg}">${wg}</a>
                                                    </li>
                                                </c:forEach>
                                            </c:if>
                                        </ul>
                                    </li>
                                </c:forEach>
                            </ul></li>
                        <li onmouseover="displaySubMenu(this)"
                            onmouseout="hideSubMenu(this)"><a
                                href="${pageContext.request.contextPath}/servlet/LimitServlet?obj=花湖街道办事处">花湖街道</a>
                            <ul>
                                <c:forEach items="${areagrid['花湖街道办事处']}" var="sq">
                                    <li onmouseover="displaySubMenu(this)"
                                        onmouseout="hideSubMenu(this)"><a
                                            href="${pageContext.request.contextPath}/servlet/LimitServlet?obj=${sq.key}">${sq.key}</a>
                                        <ul>
                                            <c:if test="${sq.value!=null}">
                                                <c:forEach items="${sq.value}" var="wg">
                                                    <li><a
                                                            href="${pageContext.request.contextPath}/servlet/LimitServlet?value1=花湖街道办事处&value2=${sq.key}&obj=${wg}">${wg}</a>
                                                    </li>
                                                </c:forEach>
                                            </c:if>
                                        </ul>
                                    </li>
                                </c:forEach>
                            </ul></li>
                        <li onmouseover="displaySubMenu(this)"
                            onmouseout="hideSubMenu(this)"><a
                                href="${pageContext.request.contextPath}/servlet/LimitServlet?obj=江北管理区">江北管理区</a>
                            <ul>
                                <c:forEach items="${areagrid['江北管理区']}" var="sq">
                                    <li onmouseover="displaySubMenu(this)"
                                        onmouseout="hideSubMenu(this)"><a
                                            href="${pageContext.request.contextPath}/servlet/LimitServlet?obj=${sq.key}">${sq.key}</a>
                                        <ul>
                                            <c:if test="${sq.value!=null}">
                                                <c:forEach items="${sq.value}" var="wg">
                                                    <li><a
                                                            href="${pageContext.request.contextPath}/servlet/LimitServlet?value1=江北管理区&value2=${sq.key}&obj=${wg}">${wg}</a>
                                                    </li>
                                                </c:forEach>
                                            </c:if>
                                        </ul>
                                    </li>
                                </c:forEach>
                            </ul></li>


                    </ul>
                </div>


                <br /> <br /> <br />
                <c:if test="${isDisplay ne 'yes'}">
                    <h2>
                        <c:if test="${obj ne '中共黄石港区委统战部'}">
                            <c:if test="${ward!=null}">
                                ${ward}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </c:if>
                            <c:if test="${community!=null}">
                                ${community}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </c:if> ${grid}
                        </c:if>

                        <c:if test="${obj eq '中共黄石港区委统战部'}">
                            ${obj}
                        </c:if>
                    </h2>
                    <br />

                    <div class="count">
                        <table id="tableC" class="table table-condensed">
                            <tr>
                                <td width="500px">民主党派成员：</td>
                                <td><span style="text-decoration:underline">${f1}人</span>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;其中：民革：</td>
                                <td><span style="text-decoration:underline">${f1_1}人</span>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;民盟：</td>
                                <td><span style="text-decoration:underline">${f1_2}人</span>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;民建：</td>
                                <td><span style="text-decoration:underline">${f1_3}人</span>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;民进：</td>
                                <td><span style="text-decoration:underline">${f1_4}人</span>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;农工党：</td>
                                <td><span style="text-decoration:underline">${f1_5}人</span>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;致公党：</td>
                                <td><span style="text-decoration:underline">${f1_6}人</span>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;九三：</td>
                                <td><span style="text-decoration:underline">${f1_7}人</span>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;台盟：</td>
                                <td><span style="text-decoration:underline">${f1_8}人</span>
                                </td>
                            </tr>


                            <tr>
                                <td>无党派人士：</td>
                                <td><span style="text-decoration:underline">${f2}人</span></td>
                            </tr>
                            <tr>
                                <td>党外知识分子：</td>
                                <td><span style="text-decoration:underline">${f3}人</span></td>
                            </tr>
                            <tr>
                                <td>宗教人士：</td>
                                <td><span style="text-decoration:underline">${f4}人</span></td>
                            </tr>
                            <tr>
                                <td>少数民族流动：</td>
                                <td><span style="text-decoration:underline">${f5}人</span></td>
                            </tr>
                            <tr>
                                <td>少数民族常住：</td>
                                <td><span style="text-decoration:underline">${f6}人</span></td>
                            </tr>
                            <tr>
                                <td>非公有制经济人士：</td>
                                <td><span style="text-decoration:underline">${f7}人</span></td>
                            </tr>
                            <tr>
                                <td>新的社会阶层人士：</td>
                                <td><span style="text-decoration:underline">${f8}人</span></td>
                            </tr>
                            <tr>
                                <td>出国和归国留学人士：</td>
                                <td><span style="text-decoration:underline">${f9}人</span></td>
                            </tr>
                            <tr>
                                <td>港澳同胞（家属）：</td>
                                <td><span style="text-decoration:underline">${f10}人</span></td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;其中：香港同胞人数：</td>

                                <td><span style="text-decoration:underline">${f10_1}人</span>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;澳门同胞人数：</td>

                                <td><span style="text-decoration:underline">${f10_2}人</span>
                            </tr>
                            <tr>
                                <td>台湾同胞及其在大陆亲属：</td>
                                <td><span style="text-decoration:underline">${f11}人</span>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;其中：台胞人数：</td>
                                <td><span style="text-decoration:underline">${f11_1}人</span>
                                </td>
                            </tr>

                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;台属人数：</td>

                                <td><span style="text-decoration:underline">${f11_2}人</span>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;台企数：</td>

                                <td><span style="text-decoration:underline">${f11_3}人</span>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;台商人数：</td>
                                <td><span style="text-decoration:underline">${f11_4}人</span>
                            </tr>
                            <tr>
                                <td>华侨、归侨及侨眷：</td>
                                <td><span style="text-decoration:underline">${f12}人</span></td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;其中：华侨人数：</td>
                                <td><span style="text-decoration:underline">${f12_1}人</span>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;归侨人数：</td>
                                <td><span style="text-decoration:underline">${f12_2}人</span>
                                </td>
                            </tr>
                            <tr>
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;侨眷人数：</td>
                                <td><span style="text-decoration:underline">${f12_3}人</span>
                                </td>
                            </tr>
                            <tr>
                                <td>其他联系对象：</td>
                                <td><span style="text-decoration:underline">${f13}人</span>
                                </td>
                            </tr>
                        </table>
                    </div>


                    <%--
                    <div class="count">
                            <div class="row">
                                    <div class="col-md-3">
                                            民主党派成员：<span style="text-decoration:underline">${f1}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            无党派人士：<span style="text-decoration:underline">${f2}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            党外知识分子：<span style="text-decoration:underline">${f3}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            宗教人士：<span style="text-decoration:underline">${f4}人</span>
                                    </div>
                            </div>
                            <div class="row">
                                    <div class="col-md-3">
                                            少数民族流动：<span style="text-decoration:underline">${f5}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            少数民族常住：<span style="text-decoration:underline">${f6}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            非公有制经济人士：<span style="text-decoration:underline">${f7}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            新的社会阶层人士：<span style="text-decoration:underline">${f8}人</span>
                                    </div>
                            </div>
                            <div class="row">
                                    <div class="col-md-3">
                                            出国和归国留学人士：<span style="text-decoration:underline">${f9}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            港澳同胞（家属）：<span style="text-decoration:underline">${f10}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            台湾同胞及其在大陆亲属：<span style="text-decoration:underline">${f11}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            华侨、归侨及侨眷：<span style="text-decoration:underline">${f12}人</span>
                                    </div>
                            </div>
                            <div class="row">
                                    <div class="col-md-3">
                                            其他联系对象：<span style="text-decoration:underline">${f13}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            民革：<span style="text-decoration:underline">${f1_1}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            民盟：<span style="text-decoration:underline">${f1_2}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            民建：<span style="text-decoration:underline">${f1_3}人</span>
                                    </div>
                            </div>
                            <div class="row">
                                    <div class="col-md-3">
                                            民进：<span style="text-decoration:underline">${f1_4}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            农工党：<span style="text-decoration:underline">${f1_5}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            致公党：<span style="text-decoration:underline">${f1_6}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            九三：<span style="text-decoration:underline">${f1_7}人</span>
                                    </div>
                            </div>
                            <div class="row">
                                    <div class="col-md-3">
                                            台盟：<span style="text-decoration:underline">${f1_8}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            香港同胞人数：<span style="text-decoration:underline">${f10_1}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            澳门同胞人数：<span style="text-decoration:underline">${f10_2}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            台胞人数：<span style="text-decoration:underline">${f11_1}人</span>
                                    </div>
                            </div>
                            <div class="row">
                                    <div class="col-md-3">
                                            台属人数：<span style="text-decoration:underline">${f11_2}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            台企数：<span style="text-decoration:underline">${f11_3}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            台商人数：<span style="text-decoration:underline">${f11_4}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            华侨人数：<span style="text-decoration:underline">${f12_1}人</span>
                                    </div>
                            </div>
                            <div class="row">
                                    <div class="col-md-3">
                                            归侨人数：<span style="text-decoration:underline">${f12_2}人</span>
                                    </div>
                                    <div class="col-md-3">
                                            侨眷人数：<span style="text-decoration:underline">${f12_3}人</span>
                                    </div>
                            </div>
                    </div>
                    --%>
                </c:if>
                <br /> <br />
            </div>
            <c:if test="${isDisplay eq 'yes'}">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <form class="form-inline"
                                  action="${pageContext.request.contextPath}/servlet/AdminServlet?operation=findpeoplebykey"
                                  method="post">
                                <div class="form-group">
                                    <label><span>关键字查询:</span> </label> 
                                    <select name="selectkey" class="form-control">
                                        <option value="身份证号">身份证号</option>
                                        <option value="姓名">姓名</option>
                                        <option value="工作单位">工作单位</option>
                                        <option value="党派名称">党派名称</option>
                                    </select> 
                                    <input type="text" name="search" class="form-control"  placeholder="搜索"> &nbsp;&nbsp;&nbsp;&nbsp;
                                    <button type="submit" class="btn"
                                            style="background-color:rgba(27,106,170,0.6)" value="查询">查询</button>
                                </div>
                            </form>
                        </div>
                        <div class="col-md-6">
                            <ul id="mytab">
                                <li><a
                                        href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=deletemany&type=${type}">批量删除</a>
                                </li>
                                <li><a
                                        href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=addone&type=${type}">单条增加</a>
                                </li>
                                <li><a
                                        href="${pageContext.request.contextPath}/servlet/AdminServlet?operation=addmany&type=${type}">批量增加</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <br />
                <br />

                <div id="clude" class="col-md-12" style="">
                    <jsp:include flush="true" page='${c}'></jsp:include>
                    </div>

            </c:if>
            <br /> <br /> <br /> <br /> <br />
        </div>
        <%--
<footer>
    
            <p>公司简介|广告服务|联系我们|招聘信息|网站律师|产品答疑</p>
            <span>Copyrihht @1994-2015 XX Corporation, All Rigths Reserved </span>
    
</footer>
        --%>
        <script
        src="${pageContext.request.contextPath}/statistics/jquery-2.1.4.min.js"></script>
        <script
        src="${pageContext.request.contextPath}/statistics/bootstrap.min.js"></script>
        <script>
                                            $("#carousel1").carousel({
                                                interval: 4000
                                                        /*不能加分号*/
                                            })
        </script>
    </body>
</html>
