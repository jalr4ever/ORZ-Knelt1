<%@ page import="com.loubth.DAO.TeacherManageDao" %>
<%@ page import="com.loubth.Bean.TeacherManage" %>
<%--
  Created by IntelliJ IDEA.
  User: St
  Date: 2018/6/12
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>teacherSearchPage</title>

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
    TeacherManageDao tmd =new TeacherManageDao();
    TeacherManage teacherManage= tmd.findById(Integer.parseInt(request.getParameter("id")));
    request.setAttribute("teacherManage",teacherManage);
%>


    <div class="center-block center-vertical" style="width: 100%">
        <div class="container" align="center">
            <h1 class="" style="font-family:宋体;font-weight:bold;font-size:50px">欢迎登陆!</h1><br>
            <label style="font-family:宋体;font-weight: lighter;font-size: 30px">你好, ${param.id}, 请选择接下来的操作:  </label><br><br>
            <div class="row">
                <div class="col-md-6">
                    <form action="/TeacherInfoServlet" method="post" target="_blank">
                        <input type="hidden" name="id" value="${param.id}">
                        <input type="submit"  class="btn btn-info btn-lg" value="查看我的信息">
                    </form>
                </div>
                <div class="col-md-6">
                    <form action="/StudentGradeServlet" method="post" target="_blank">
                        <input type="hidden" name="classNum" value="${teacherManage.mainClass}">
                        <input type="submit"  class="btn btn-info btn-lg" value="管理本班成绩">
                    </form>
                </div>
            </div>
            <br><br>
            <div class="row">
                <div class="col-md-12">
                    <a href="../index.jsp" class="btn btn-info">返回登录页</a>
                </div>
            </div>
        </div>

    </div>
</body>
</html>
