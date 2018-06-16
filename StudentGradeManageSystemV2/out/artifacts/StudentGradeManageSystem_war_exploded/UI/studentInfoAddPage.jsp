<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/11
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>

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
<!--添加学生信息-->
<form action="/StudentInfoAddServlet" method="post">
    <div class="container" align="center" style="margin-top: 5%">
        <div  align="center" class="">
            <h2>添加新的学生成员</h2>
        </div>
        <table class="table table-info table-bordered">
            <tbody>
            <tr>
                <td>照片（待完成）</td>
                <td><input type="button" name="image" value="上传" class="btn btn-info" disabled="disabled"></td>
            </tr>
            <tr>
                <td>学号</td>
                <td><input type="text" name="id" value=""></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" name="password" value=""></td>
            </tr>
            <tr>
                <td>班级</td>
                <td><input type="text" name="class" value=""></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name" value=""></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" name="sex" value=""></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age" value=""></td>
            </tr>
            <tr>
                <td>手机号</td>
                <td><input type="text" name="phoneNum" value=""></td>
            </tr>
            <tr>
                <td>班主任</td>
                <td><input type="text" name="chargeTeacher" value=""></td>
            </tr>
            <tr>
                <td>家庭住址</td>
                <td><input type="text" name="address" value=""></td>
            </tr>
            <tr>
                <td>提交选项</td>
                <td><input type="submit" name="submit" value="确认添加" class="btn btn-info"></td>
            </tr>
            </tbody>
        </table>
    </div>
</form>
</body>
</html>
