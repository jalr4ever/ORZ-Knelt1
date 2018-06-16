<%@ page import="com.loubth.DAO.StudentGradeDao" %>
<%@ page import="com.loubth.Bean.StudentGrade" %><%--
  Created by IntelliJ IDEA.
  User: St
  Date: 2018/6/12
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title>修改学生成绩</title>
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
        body input{
            color: GrayText;
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
    StudentGradeDao sd=new StudentGradeDao();
    StudentGrade studentGrade=sd.findById(Integer.parseInt(id));
    request.setAttribute("studentGrade",studentGrade);
%>

<!--修改学生信息-->
<form action="/ModifyStudentGradeServlet" method="post">
    <div class="container">
        <div  align="center" class="">
            <h2>修改学生 ${studentGrade.id} 的分数</h2>
        </div>
        <table class="table table-info table-bordered">
            <tbody>
            <tr>
                <td>学号</td>
                <td> <input type="text" name="id" value="${studentGrade.id}"></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name" value="${studentGrade.name}"></td>
            </tr>
            <tr>
                <td>班级</td>
                <td> <input type="text" name="class" value="${studentGrade.clazz}"></td>
            </tr>
            <tr>
                <td>语文</td>
                <td> <input type="text" name="chinese" value="${studentGrade.chinese}"></td>
            </tr>
            <tr>
                <td>数学</td>
                <td><input type="text" name="math" value="${studentGrade.math}"></td>
            </tr>
            <tr>
                <td>英语</td>
                <td><input type="text" name="english" value="${studentGrade.english}"></td>
            </tr>
            <tr>
                <td>物理</td>
                <td><input type="text" name="physics" value="${studentGrade.physics}"></td>
            </tr>
            <tr>
                <td>化学</td>
                <td><input type="text" name="chemistry" value="${studentGrade.chemistry}"></td>
            </tr>
            <tr>
                <td> 政治</td>
                <td> <input type="text" name="politics" value="${studentGrade.politics}"></td>
            </tr>
            <tr>
                <td> 地理</td>
                <td> <input type="text" name="geography" value="${studentGrade.geograry}"></td>
            </tr>
            <tr>
                <td>体育</td>
                <td> <input type="text" name="pe" value="${studentGrade.pe}"></td>
            </tr>
            <tr>
                <td> 平均分</td>
                <td><input type="text" name="avg" value="${studentGrade.ave}"></td>
            </tr>
            <tr>
                <td>总分</td>
                <td><input type="text" name="sum" value="${studentGrade.sum}"></td>
            </tr>
            <tr>
                <td>排名</td>
                <td><input type="text" name="rank" value="${studentGrade.rank}"></td>
            </tr>
            <tr>
                <td>考试类型</td>
                <td> <input type="text" name="property" value="${studentGrade.properties}"></td>
            </tr>
            <tr>
                <td>修改选项</td>
                <td>  <input type="submit" class="btn btn-md btn-warning" style="width: 100px" name="submit" value="确认修改"></td>
            </tr>
            </tbody>
        </table>
        <input type="hidden" name="oldId" value="${studentGrade.id}">
    </div>

</form>
</body>
</html>
