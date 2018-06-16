<%@ page import="com.loubth.DAO.StudentDao" %>
<%@ page import="com.loubth.Bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: St
  Date: 2018/6/12
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>studentSearchPage</title>

    <%--引入必要样式与js--%>
    <link rel="stylesheet" type="text/css" href="UI/css/bootstrap.min.css">
    <script src="UI/js/jquery.min.js"></script>
    <script src="UI/js/bootstrap.min.js"></script>

    <%--按钮选择事件--%>
    <script>
        $(document).ready(function(){
            $("input").mouseenter(function(){
                $("input").animate(
                    {
                        width:'+=20px',
                        height:'+=20px',
                        fontSize:'+=5px'
                    },
                    100
                );
            });
            $("input").mouseleave(function(){
                $("input").animate(
                    {
                        width:'-=20px',
                        height:'-=20px',
                        fontSize:'-=5px'
                    },
                    100
                );
            });
        });
    </script>


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
    StudentDao sd=new StudentDao();
    Student student=sd.findById(Integer.parseInt(request.getParameter("id")));
    request.setAttribute("student",student);
%>


    <div class="center-block center-vertical" style="width: 100%">
        <div class="container" align="center">
            <h1 class="" style="font-family:宋体;font-weight:bold;font-size:50px">欢迎登陆!</h1><br>
            <label style="font-family:宋体;font-weight: lighter;font-size: 30px">你好, ${param.id}, 请选择接下来的操作:  </label><br><br>
            <div class="row">
                <div class="col-md-4">
                    <form action="/StudentInfoServlet" method="post" target="_blank">
                        <input type="hidden" name="id" value="${param.id}">
                        <input type="hidden" name="isStudent" value="true">
                        <input type="submit" class="btn btn-info btn-lg" value="我的信息">
                    </form>
                    <%--<a href="/StudentInfoServlet" class="btn btn-info btn-lg">我的信息</a>--%>
                </div>
                <div class="col-md-4">
                    <form action="/StudentGradeServlet" method="post" target="_blank">
                        <input type="hidden" name="id" value="${param.id}">
                        <input type="hidden" name="isStudent" value="true">
                        <input type="submit" class="btn btn-info btn-lg" value="我的成绩">
                    </form>
                    <%--<a href="/StudentGradeServlet" class="btn btn-info btn-lg">我的成绩</a>--%>
                </div>
                <div class="col-md-4">
                    <form action="/StudentGradeServlet" method="post" target="_blank">
                        <input type="hidden" name="classNum" value="${student.clazz}">
                        <input type="hidden" name="isStudent" value="true">
                        <input type="submit" class="btn btn-info btn-lg" value="本班成绩">
                    </form>
                    <%--<a href="/StudentGradeServlet" class="btn btn-info btn-lg">本班成绩</a>--%>
                </div>
            </div>
            <br><br>
            <div class="col-md-12">
                <a href="../index.jsp" class="btn btn-info">返回登录页</a>
            </div>
            <br>
        </div>
    </div>
</body>
</html>
