<%@ page import="com.loubth.DAO.TeacherManageDao" %>
<%@ page import="com.loubth.Bean.TeacherManage" %><%--
  Created by IntelliJ IDEA.
  User: St
  Date: 2018/6/12
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改教师管理信息</title>
    <%--引入必要样式与js--%>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        <%--基本样式--%>
        body{
            background-image: url("/UI/images/demo-1-bg.jpg");
            color: white;
            background-size: 100% 100%;
        }
        .center-vertical{
            position: relative;
            top: 50%;
            transform: translateY(-50%);
        }
    </style>
</head>
<body>
<%
    String id=request.getParameter("id");
    TeacherManageDao sd=new TeacherManageDao();
    TeacherManage teacherManage=sd.findById(Integer.parseInt(id));
    request.setAttribute("teacherManage",teacherManage);
%>
<!--修改老师管理信息-->
<form action="/ModifyTeacherManageServlet" method="post">
    <div class="container" align="center" style="margin-top: 10%">
        <div  align="center" class="">
            <h2>修改教师 ${teacherManage.id} 的管理班级信息</h2>
        </div>
        <table class="table table-bordered table-info">
            <tbody>
            <tr>
                <td>工号</td>
                <td><input type="text" name="id" value="${teacherManage.id}"></td>
            </tr>
            <tr>
                <td> 姓名</td>
                <td><input type="text" name="name" value="${teacherManage.name}"></td>
            </tr>
            <tr>
                <td>科目负责班级</td>
                <td><input type="text" name="subjectclass" value="${teacherManage.subjectClass}"></td>
            </tr>
            <tr>
                <td>主要管理班级</td>
                <td><input type="text" name="mainclass" value="${teacherManage.mainClass}"></td>
            </tr>
            <tr>
                <td>提交选项</td>
                <td><input type="submit" class="btn btn-warning" name="submit" value="确认修改"></td>
            </tr>
            </tbody>
        </table>
    </div>






    <input type="hidden" name="oldId" value="${teacherManage.id}">
</form>
</body>
</html>
