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
        body input{
            color: GrayText;
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
    <div class="container">
        <div  align="center" class="">
            <h2>修改教师 ${teacher.id} 的个人信息</h2>
        </div>
        <table class="table table-bordered">
            <tbody>
            <tr>
                <td>照片</td>
                <td><img src="../${teacher.imagePath}" alt="该老师没有上传照片"></td>
            </tr>
            <tr>
                <td>工号</td>
                <td><input type="text" name="id" value="${teacher.id}"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td> <input type="text" name="password" value="${teacher.password}"></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name" value="${teacher.name}"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" name="sex" value="${teacher.sex}"></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age" value="${teacher.age}"></td>
            </tr>
            <tr>
                <td>教授科目</td>
                <td><input type="text" name="subject" value="${teacher.subject}"></td>
            </tr>
            <tr>
                <td> 手机号</td>
                <td> <input type="text" name="phoneNum" value="${teacher.phoneNum}"></td>
            </tr>
            <tr>
                <td>家庭住址</td>
                <td><input type="text" name="address" value="${teacher.address}"></td>
            </tr>
            <tr>
                <td>修改选项</td>
                <td>    <input type="submit"  class="btn btn-md btn-danger" name="submit"  value="确认修改"></td>
            </tr>
            </tbody>
        </table>
    </div>
    <input type="hidden" name="oldId" value="${teacher.id}">
    <input type="hidden" name="imagePath" value="${teacher.imagePath}">
</form>
</body>
</html>
