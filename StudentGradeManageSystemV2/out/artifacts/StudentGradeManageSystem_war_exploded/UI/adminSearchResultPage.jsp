<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/10
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>adminSearchResultPage</title>

    <%--引入必要样式与js--%>
    <link rel="stylesheet" type="text/css" href="UI/css/bootstrap.min.css">
    <script src="UI/js/jquery.min.js"></script>
    <script src="UI/js/bootstrap.min.js"></script>

    <!--删除指定教师元素JavaScript-->
    <script language="javascript" type="text/javascript">
        function removeTeacherInfo(teacherId) {
            var teacherInfo=document.getElementById("teacherInfo");
            var teacher=document.getElementById(teacherId);
            teacherInfo.removeChild(teacher);
            alert("删除成功！")
        }
    </script>

    <!--删除指定学生成绩元素JavaScript-->
    <script language="javascript" type="text/javascript">
        function removeStudentGradeInfo(studentGrade) {
            var studentGradeInfo=document.getElementById("studentGradeInfo");
            var studentGrade=document.getElementById(studentGrade);
            studentGradeInfo.removeChild(studentGrade);
            alert("删除成功！")
        }
    </script>

    <!--删除指定教师管理元素JavaScript-->
    <script language="javascript" type="text/javascript">
        function removeTeacherManageInfo(teacherManage) {
            var teacherManageInfo=document.getElementById("teacherManageInfo");
            var teacherManage=document.getElementById(teacherManage);
            teacherManageInfo.removeChild(teacherManage);
            alert("删除成功！")
        }
    </script>

    <!--删除指定学生元素JavaScript-->
    <script language="javascript" type="text/javascript">
        function removeStudentInfo(studentId) {
            var studentInfo=document.getElementById("studentInfo");
            var student=document.getElementById(studentId);
            studentInfo.removeChild(student);
            alert("删除成功！")
        }
    </script>

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
    </style>

</head>
<body>

    <!--管理学生个人信息-->
    <div class="container center-vertical" align="center">
    <c:if test="${studentList!=null}">
        <div  align="center" class="center-vertical">
            <h2>学生个人信息</h2>
        </div>
        <table id="stuInfoPanel" class="table table-info  table-bordered">
        <tbody>
        <c:forEach items="${studentList}" var="student">
        <tr id="${student.id}">
            <td>照片</td>
            <td><img src="${student.imagePath}" alt="该学生没有上传照片"></td>
        </tr>
        <tr id="${student.id}">
            <td>学号</td>
            <td>${student.id}</td>
        </tr>
        <tr id="${student.id}">
            <td>密码</td>
            <td>${student.password}</td>
        </tr>
        <tr id="${student.id}">
            <td>班级</td>
            <td>${student.clazz}</td>
        </tr>
        <tr id="${student.id}">
            <td>姓名</td>
            <td>${student.name}</td>
        </tr>
        <tr id="${student.id}">
            <td>性别</td>
            <td>${student.sex}</td>
        </tr>
        <tr id="${student.id}">
            <td>年龄</td>
            <td>${student.age}</td>
        </tr>
        <tr id="${student.id}">
            <td>手机号</td>
            <td>${student.phoneNum}</td>
        </tr>
        <tr id="${student.id}">
            <td>班主任</td>
            <td>${student.chargeTeacher}</td>
        </tr>
        <tr id="${student.id}">
            <td>家庭住址</td>
            <td>${student.address}</td>
        </tr>
        <tr id="${student.id}">
            <c:if test="${isStudent!=true}">
                <tr>
                    <td>修改</td>
                    <td><a href="/UI/modifyStudentPage.jsp?id=${student.id}" target="_blank">修改</a></td>
                </tr>
                <tr>
                    <td>删除</td>
                    <td> <a href="/DeleteStudentServlet?id=${student.id}" target="_blank" onclick=removeStudentInfo("${student.id}")>删除</a></td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
        </table>
    </c:if>
</div>


    <!--管理教师个人信息-->
    <div calss="container center-vertical" align="center" style="width:auto;height:auto">
        <c:if test="${teacherList!=null}">
            <div  align="center" class="center-vertical">
                <h2>教师个人信息</h2>
            </div>
            <table id="teaInfoPanel" class="table table-info table-bordered">
                <tr>
                    <td>照片</td>
                    <td>工号</td>
                    <td>密码</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>教学科目</td>
                    <td>手机号</td>
                    <td>家庭住址</td>
                    <c:if test="${isStudent!=true}">
                        <td>修改</td>
                        <td>删除</td>
                    </c:if>
                </tr>
                <tbody id="teacherInfo">
                <c:forEach items="${teacherList}" var="teacher">
                    <tr id="${teacher.id}">
                        <td>
                            <img src="${teacher.imagePath}" alt="该教师没有上传照片">
                        </td>
                        <td>
                                ${teacher.id}
                        </td>
                        <td>
                                ${teacher.password}
                        </td>
                        <td>
                                ${teacher.name}
                        </td>
                        <td>
                                ${teacher.sex}
                        </td>
                        <td>
                                ${teacher.age}
                        </td>
                        <td>
                                ${teacher.subject}
                        </td>
                        <td>
                                ${teacher.phoneNum}
                        </td>
                        <td>
                                ${teacher.address}
                        </td>
                        <c:if test="${isStudent!=true}">
                            <td>
                                <a href="/UI/modifyTeacherPage.jsp?id=${teacher.id}" target="_blank">修改</a>
                            </td>
                            <td>

                                <a href="/DeleteTeacherServlet?id=${teacher.id}" target="_blank" onclick=removeTeacherInfo("${teacher.id}")>删除</a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>


    <!--管理学生成绩-->
    <div class="container center-vertical" align="center" style="width:auto;height:auto">
        <c:if test="${studentGradeList!=null}">
        <table id="manageStuPanel" class="table table-info table-bordered">
            <div  align="center">
                <h2>学生成绩信息</h2>
            </div>

            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>班级</td>
                <td>语文</td>
                <td>数学</td>
                <td>英语</td>
                <td>物理</td>
                <td>化学</td>
                <td>政治</td>
                <td>地理</td>
                <td>体育</td>
                <td>平均分</td>
                <td>总分</td>
                <td>排名</td>
                <td>考试类型</td>
                <c:if test="${isStudent!=true}">
                    <td>修改</td>
                    <td>删除</td>
                </c:if>
            </tr>
            <tbody id="studentGradeInfo">
            <c:forEach items="${studentGradeList}" var="studentGrade">
                <tr id="${studentGrade.id}">
                    <td>
                            ${studentGrade.id}
                    </td>
                    <td>
                            ${studentGrade.name}
                    </td>
                    <td>
                            ${studentGrade.clazz}
                    </td>
                    <td>
                            ${studentGrade.chinese}
                    </td>
                    <td>
                            ${studentGrade.math}
                    </td>
                    <td>
                            ${studentGrade.english}
                    </td>
                    <td>
                            ${studentGrade.physics}
                    </td>
                    <td>
                            ${studentGrade.chemistry}
                    </td>
                    <td>
                            ${studentGrade.politics}
                    </td>
                    <td>
                            ${studentGrade.geograry}
                    </td>
                    <td>
                            ${studentGrade.pe}
                    </td>
                    <td>
                            ${studentGrade.ave}
                    </td>
                    <td>
                            ${studentGrade.sum}
                    </td>
                    <td>
                            ${studentGrade.rank}
                    </td>
                    <td>
                            ${studentGrade.properties}
                    </td>
                    <c:if test="${isStudent!=true}">
                        <td>
                            <a href="/UI/modifyStudentGradePage.jsp?id=${studentGrade.id}" target="_blank">修改</a>
                        </td>
                        <td>
                            <a href="/DeleteStudentGradeServlet?id=${studentGrade.id}" target="_blank" onclick=removeStudentGradeInfo("${studentGrade.id}")>删除</a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    </div>



    <!--管理教师管理信息-->
    <div class="container center-vertical" align="center">
        <c:if test="${teacherManageList!=null}">
            <div  align="center">
                <h2>教室信息管理</h2>
            </div>
            <table id="manageTeaPanel" class="table table-info table-bordered">
                <tr>
                    <td>工号</td>
                    <td>姓名</td>
                    <td>科目负责班级</td>
                    <td>主要管理班级</td>
                    <c:if test="${isStudent!=true}">
                        <td>修改</td>
                        <td>删除</td>
                    </c:if>
                </tr>
                <tbody id="teacherManageInfo">
                <c:forEach items="${teacherManageList}" var="teacherManage">
                    <tr id="${teacherManage.id}">
                        <td>
                                ${teacherManage.id}
                        </td>
                        <td>
                                ${teacherManage.name}
                        </td>
                        <td>
                                ${teacherManage.subjectClass}
                        </td>
                        <td>
                                ${teacherManage.mainClass}
                        </td>
                        <c:if test="${isStudent!=true}">
                            <td>
                                <a href="/UI/modifyTeacherManagePage.jsp?id=${teacherManage.id}" target="_blank">修改</a>
                            </td>
                            <td>

                                <a href="/DeleteTeacherManageServlet?id=${teacherManage.id}" target="_blank" onclick=removeTeacherManageInfo("${teacherManage.id}")>删除</a>
                            </td>
                        </c:if>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>


</body>
</html>
