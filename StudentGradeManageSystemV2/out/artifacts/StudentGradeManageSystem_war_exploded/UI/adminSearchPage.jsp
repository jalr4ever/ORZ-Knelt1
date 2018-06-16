<%--
  Created by IntelliJ IDEA.
  User: St
  Date: 2018/6/10
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>adminSearchPage</title>

    <%--引入必要样式与js--%>
    <link rel="stylesheet" type="text/css" href="UI/css/bootstrap.min.css">
    <script src="UI/js/jquery.min.js"></script>
    <script src="UI/js/bootstrap.min.js"></script>
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
        input{
            width: 300px;
            color: Background;
        }

    </style>
</head>
<body>

 <div class="container" id="addStu" align="center">
        <h1 class="" style="font-family:宋体;font-weight:bold;font-size:50px">学生用户管理</h1><br>
        <table class="table table-bordered table-info">

            <tbody>
            <tr>
                <td>管理单个学生信息：</td>
                <td>
                    <form action="/StudentInfoServlet" method="post">
                        <input type="text" name="id"  placeholder="请输入待管理学生的学号">
                    </form>
                </td>
            </tr>
            <tr>
                <td>管理某班级的学生信息：&nbsp&nbsp&nbsp&nbsp &nbsp</td>
                <td>
                    <form action="/StudentInfoServlet" method="post">
                        <input type="text" name="classNum" value="" placeholder="请输入待管理班级的班级号">
                    </form>
                </td>
            </tr>
            <tr>
                <td>管理所有学生信息：</td>
                <td>
                    <form action="/StudentInfoServlet" method="post">
                    <input type="submit" name="id" class="btn btn-warning btn-md" value="管理所有">
                </form>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="container" id="addTea" align="center">
        <h1 class="" style="font-family:宋体;font-weight:bold;font-size:50px">教师用户管理</h1><br>
        <table class="table table-info table-bordered">
            <tbody>
            <tr>
                <td>添加教师信息：</td>
                <td><a  class="btn btn-info btn-md" style="width: 300px" href="/UI/teacherInfoAddPage.jsp">添加新的教师成员</a></td>
            </tr>
            <tr>
                <td>管理单个教师信息：&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp</td>
                <td>
                    <form action="/TeacherInfoServlet" method="post">
                        <input type="text" name="id" placeholder="请输入待管理教师的工号">
                    </form>
                </td>
            </tr>
            <tr>
                <td>管理所有教师信息：</td>
                <td>
                    <form action="/TeacherInfoServlet" method="post">
                        <input type="submit" name="id" class="btn btn-warning btn-md" value="管理所有">
                    </form>
                </td>
            </tr>
            </tbody>
        </table>
        <hr>
    </div>

    <div class="container" id="manageGrade">
        <table class="table table-info table-bordered">
            <tbody>
            <tr>
                <td>添加学生成绩信息：</td>
                <td>  <a class="btn btn-info btn-md" style="width: 300px" href="/UI/studentGradeInfoAddPage.jsp">添加新的学生成绩</a></td>
            </tr>
            <tr>
                <td> 管理学生成绩：</td>
                <td>
                    <form action="/StudentGradeServlet" method="post">
                        <input type="text" name="id" placeholder="请输入待管理学生的工号">
                    </form>
                </td>
            </tr>
            <tr>
                <td> 管理某班级的学生成绩信息：</td>
                <td>
                    <form action="/StudentGradeServlet" method="post">
                    <input type="text" name="classNum" value="" placeholder="请输入待管理班级的班级号">
                </form>
                </td>
            </tr>
            <tr>
                <td>管理所有学生成绩信息：</td>
                <td>
                    <form action="/StudentGradeServlet" method="post">
                        <input type="submit" class="btn btn-warning btn-md" name="id" value="管理所有">
                    </form>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <div class="container" id="manageTea">
        <table class="table table-info table-bordered">
            <tbody>
            <tr>
                <td>添加教师管理班级信息：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
                <td> <a class="btn btn-info btn-md"  style="width: 300px;" href="/UI/teacherManageAddPage.jsp">添加新的教师管理班级</a></td>
            </tr>
            <tr>
                <td>管理教师管理信息：</td>
                <td>
                    <form action="/TeacherManageServlet" method="post">
                        <input type="text" name="id" placeholder="请输入待管理教师的工号">
                    </form>
                </td>
            </tr>
            <tr>
                <td>管理所有教师管理信息：</td>
                <td>
                    <form action="/TeacherManageServlet" method="post">
                        <input type="submit" class="btn btn-warning btn-md"  name="id" value="管理所有">
                    </form>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

</body>
</html>
