<%--
  Created by IntelliJ IDEA.
  User: St
  Date: 2018/6/12
  Time: 8:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title>添加学生成绩信息</title>
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
            color:GrayText;
        }
    </style>

</head>
<body>
<!--添加学生成绩信息-->
<form action="/StudentGradeInfoAddServlet" method="post">
    <div class="container" align="center">
        <div  align="center" class="">
            <h2>添加新的学生成绩</h2>
        </div>
        <table class="table table-info table-bordered">
            <tbody>
            <tr>
                <td>学号</td>
                <td><input type="text" name="id" value=""></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td> <input type="text" name="name" value=""></td>
            </tr>
            <tr>
                <td>班级</td>
                <td><input type="text" name="class" value=""></td>
            </tr>
            <tr>
                <td>语文</td>
                <td> <input type="text" name="chinese" value=""></td>
            </tr>
            <tr>
                <td>数学</td>
                <td><input type="text" name="math" value=""></td>
            </tr>
            <tr>
                <td>英语</td>
                <td><input type="text" name="english" value=""></td>
            </tr>
            <tr>
                <td>物理</td>
                <td><input type="text" name="physics" value=""></td>
            </tr>
            <tr>
                <td>化学</td>
                <td><input type="text" name="chemistry" value=""></td>
            </tr>
            <tr>
                <td> 政治</td>
                <td><input type="text" name="politics" value=""></td>
            </tr>
            <tr>
                <td>地理</td>
                <td><input type="text" name="geography" value=""></td>
            </tr>
            <tr>
                <td> 体育</td>
                <td> <input type="text" name="pe" value=""></td>
            </tr>
            <tr>
                <td>总分</td>
                <td><input type="text" name="sum" value=""></td>
            </tr>
            <tr>
                <td> 平均分</td>
                <td><input type="text" name="avg" value=""></td>
            </tr>
            <tr>
                <td>排名</td>
                <td><input type="text" name="rank" value=""></td>
            </tr>
            <tr>
                <td>考试类型</td>
                <td><input type="text" name="property" value=""></td>
            </tr>
            <tr>
                <td>提交选项</td>
                <td><input type="submit"  class="btn btn-info btn-md" name="submit" value="确认添加"></td>
            </tr>
            </tbody>
        </table>
    </div>
</form>
</body>
</html>
