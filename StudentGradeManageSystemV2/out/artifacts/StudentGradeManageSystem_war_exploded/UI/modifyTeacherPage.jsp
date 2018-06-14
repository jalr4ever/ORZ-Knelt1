<%@ page import="com.loubth.DAO.TeacherDao" %>
<%@ page import="com.loubth.Bean.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/11
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改教师信息</title>
    <%--引入必要样式与js--%>
    <link rel="stylesheet" type="text/css" href="UI/css/bootstrap.min.css">
    <script src="UI/js/jquery.min.js"></script>
    <script src="UI/js/bootstrap.min.js"></script>
    <style>
        <%--基本样式--%>
        body{
            background-image: url("/UI/images/demo-1-bg.jpg");
            color: white;
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
    TeacherDao sd=new TeacherDao();
    Teacher teacher=sd.findById(Integer.parseInt(id));
    request.setAttribute("teacher",teacher);
%>
<!--修改老师信息-->
<form action="/ModifyTeacherServlet" method="post">
    照片<img src="../${teacher.imagePath}" alt="该老师没有上传照片">
    学号<input type="text" name="id" value="${teacher.id}">
    密码<input type="text" name="password" value="${teacher.password}">
    姓名<input type="text" name="name" value="${teacher.name}">
    性别<input type="text" name="sex" value="${teacher.sex}">
    年龄<input type="text" name="age" value="${teacher.age}">
    教授科目<input type="text" name="subject" value="${teacher.subject}">
    手机号<input type="text" name="phoneNum" value="${teacher.phoneNum}">
    家庭住址<input type="text" name="address" value="${teacher.address}">
    <input type="submit" name="submit" value="确认修改">

    <input type="hidden" name="oldId" value="${teacher.id}">
    <input type="hidden" name="imagePath" value="${teacher.imagePath}">
</form>
</body>
</html>
