<%@ page import="com.loubth.DAO.StudentDao" %>
<%@ page import="com.loubth.Bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: St
  Date: 2018/6/11
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
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
        StudentDao sd=new StudentDao();
        Student student=sd.findById(Integer.parseInt(id));
        request.setAttribute("student",student);
    %>
    <!--修改学生信息-->
    <form action="/ModifyStudentServlet" method="post">
            照片<img src="../${student.imagePath}" alt="该学生没有上传照片">
            学号<input type="text" name="id" value="${student.id}">
            密码<input type="text" name="password" value="${student.password}">
            班级<input type="text" name="class" value="${student.clazz}">
            姓名<input type="text" name="name" value="${student.name}">
            性别<input type="text" name="sex" value="${student.sex}">
            年龄<input type="text" name="age" value="${student.age}">
            手机号<input type="text" name="phoneNum" value="${student.phoneNum}">
            班主任<input type="text" name="chargeTeacher" value="${student.chargeTeacher}">
            家庭住址<input type="text" name="address" value="${student.address}">
            <input type="submit" name="submit" value="确认修改">

        <input type="hidden" name="oldId" value="${student.id}">
        <input type="hidden" name="imagePath" value="${student.imagePath}">
    </form>
</body>
</html>
