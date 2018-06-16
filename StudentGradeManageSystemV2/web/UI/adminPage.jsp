<%--
  Created by IntelliJ IDEA.
  User: St
  Date: 2018/6/9
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>学生成绩管理系统</title>

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
<%--系统的管理员面板--%>
<form action="">
    <div class="container" align="center" style="margin-top: 5%">
        <table class="table table-bordered table-info">
            <tbody>
            <c:forEach items="${studentList}" var="student">
                <tr>
                    <td>学号</td>
                    <td>${student.id}</td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td>${student.password}</td>
                </tr>
                <tr>
                    <td>班级</td>
                    <td>${student.clazz}</td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td>${student.name}</td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td>${student.sex}</td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td>${student.age}</td>
                </tr>
                <tr>
                    <td>手机号</td>
                    <td>${student.phoneNum}</td>
                </tr>
                <tr>
                    <td>班主任</td>
                    <td>${student.chargeTeacher}</td>
                </tr>
                <tr>
                    <td>照片</td>
                    <td>${student.imagePath}</td>
                </tr>
                <tr>
                    <td>家庭住址</td>
                    <td>${student.address}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</form>
</body>
</html>
