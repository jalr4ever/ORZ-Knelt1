<%--
  Created by IntelliJ IDEA.
  User: St
  Date: 2018/6/12
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>添加教师管理</title>

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
<!--添加教师管理信息-->
<form action="/TeacherManageAddServlet" method="post">
    <div class="container" align="center" style="margin-top: 10%">
    <table class="table table-info table-bordered">
        <div  align="center" class="">
            <h2>添加新的教师管理班级信息</h2>
        </div>
        <tbody>
        <tr>
            <td>工号</td>
            <td><input type="text" name="id" value=""></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value=""></td>
        </tr>
        <tr>
            <td>授课班级</td>
            <td><input type="text" name="subjectclass" value=""></td>
        </tr>
        <tr>
            <td>主管班级</td>
            <td><input type="text" name="mainclass" value=""></td>
        </tr>
        <tr>
            <td>提交选项</td>
            <td><input type="submit" name="submit"  class="btn btn-info" value="确认添加"></td>
        </tr>
        </tbody>
    </table>
    </div>





</form>

</body>
</html>
