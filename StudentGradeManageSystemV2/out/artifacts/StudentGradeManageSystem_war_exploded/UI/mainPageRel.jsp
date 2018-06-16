<%--
  Created by IntelliJ IDEA.
  User: St
  Date: 2018/6/10
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>学生成绩管理系统</title>
    <link rel="stylesheet" type="text/css" href="UI/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="UI/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="UI/css/component.css" />
    <link rel="stylesheet" type="text/css" href="UI/css/bootstrap.min.css">
    <!--[if IE]>
    <script src="UI/js/html5.js"></script>
    <![endif]-->
    <script src="UI/js/jquery.min.js"></script>
    <script src="UI/js/bootstrap.min.js"></script>


    <style>
        #mainPanel{
            width: 800px;
            height: 640px;
        }
        body{
            background-size: 100% 100%;
        }

    </style>
    <script>
       <%--验证用户名--%>
       $(document).ready(function () {
           $("#mainForm").submit(function (e) {
               //验证逻辑-获取数据
               var idval=$("input[name=id]").val();
               var passwordval=$("input[name=password]").val();
               var typeVal=$("input[name=option]:checked").val();
               //ajax-post提交验证
               $.post(
                   "/LoginServlet",
                   {option:typeVal,id:idval,password:passwordval},
                   function (data) {
                       if(data.trim()=="Log In False"){
//                           alert(idval+"  "+passwordval+"  "+typeVal);
                           alert("密码输入错误!请重新输入!");
                       }
                       else{
                           document.getElementById("mainForm") .submit();
                       }
                   });
                        e.preventDefault();
           });
       });

        <%--title动画--%>
        $(document).ready(function(){
//        $(".main-title").fadeIn(2000);
            $(".main-title").animate({
                    top:'180px',
                    fontSize:'+=15px',
                    opacity:'0.98'
                },
                1500
            );
        });

        <%--mainPanel动画--%>
        $(document).ready(function () {
            $("#mainPanel").animate({
                top:'550px',
                opacity:'0.98'
            });
        });
    </script>

</head>
<body >

<form action="/LoginServlet" method="post" id="mainForm">
    <div class="demo-1">
        <div class="content ">
            <div id="large-header" class="large-header">
                <div id="titlemsg">
                    <p class="main-title">学生成绩管理系统 <span class="thin">V1.0</span></p >
                    <div class="container main-title" id="mainPanel">
                        <div class="row">
                            <div class="col-md-3 col-md-offset-2" style="font-size: 25px;text-align: left">
                                <label>工号：</label>
                            </div>
                            <div class="col-md-1 ">
                                <input type="text" name="id" style="width: 200px" class="form-control" placeholder="工号">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3 col-md-offset-2" style="font-size: 25px;text-align: left">
                                <label>密码：</label>
                            </div>
                            <div class="col-md-1">
                                <input type="password" name="password" style="width: 200px" class="form-control" placeholder="密码">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-8 col-md-offset-2" style="font-size: 25px;text-align: left">
                                <div class="radio">
                                    用户类型：
                                    <label >
                                        <input type="radio"  name="option" checked="checked" value="student">学生
                                    </label>
                                    <label >
                                        <input type="radio"  name="option" value="teacher">老师
                                    </label>
                                    <label >
                                        <input type="radio"  name="option" value="admin">管理员
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 col-md-offset-5" style="text-align: left">
                                <div class="btn-group" >
                                    <button type="submit" class="btn btn-default btn-lg">登录</button>
                                </div>
                            </div>
                        </div>


                    </div>
                    <canvas id="demo-canvas"></canvas>
                </div>
            </div>
        </div>

    </div>
</form>


<script src="UI/js/TweenLite.min.js"></script>
<script src="UI/js/EasePack.min.js"></script>
<script src="UI/js/rAF.js"></script>
<script src="UI/js/demo-1.js"></script>
</body>
</html>
