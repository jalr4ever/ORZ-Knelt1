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
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
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
        body input{
            color:GrayText;
            background-size: 100% 100%;
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
        <div class="container">
            <div  align="center" class="">
                <h2>修改学生 ${student.id} 的信息</h2>
            </div>
            <table class="table table-bordered">
                <tr>
                    <td>照片</td>
                    <td><img src="../${student.imagePath}" alt="该学生没有上传照片"></td>
                </tr>
                <tr>
                    <td>学号</td>
                    <td> <input type="text" name="id" value="${student.id}"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td> <input type="text" name="password" value="${student.password}"></td>
                </tr>
                <tr>
                    <td>班级</td>
                    <td><input type="text" name="class" value="${student.clazz}"></td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td><input type="text" name="name" value="${student.name}"></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td><input type="text" name="sex" value="${student.sex}"></td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td><input type="text" name="age" value="${student.age}"></td>
                </tr>
                <tr>
                    <td> 手机号</td>
                    <td>  <input type="text" name="phoneNum" value="${student.phoneNum}"></td>
                </tr>
                <tr>
                    <td>班主任</td>
                    <td><input type="text" name="chargeTeacher" value="${student.chargeTeacher}"></td>
                </tr>
                <tr>
                    <td>家庭住址</td>
                    <td> <input type="text" name="address" value="${student.address}"></td>
                </tr>
                <tr>
                    <td>修改选项</td>
                    <td> <input type="submit" class="btn btn-danger btn-md" name="submit" value="确认修改"></td>
                </tr>
            </table>
        </div>
        <input type="hidden" name="oldId" value="${student.id}">
        <input type="hidden" name="imagePath" value="${student.imagePath}">
    </form>
</body>
</html>
