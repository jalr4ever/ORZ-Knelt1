package com.loubth.BLL;

import com.loubth.Bean.Admin;
import com.loubth.Bean.Student;
import com.loubth.Bean.Teacher;
import com.loubth.DAO.AdminDao;
import com.loubth.DAO.StudentDao;
import com.loubth.DAO.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type=request.getParameter("option");
        int id=0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        }
        catch(Exception e){
        }
        String password=request.getParameter("password");
        if(type.equals("student")){
            StudentDao sd=new StudentDao();
            Student student=sd.findById(id);
            if(student!=null){
                if(student.getPassword().equals(password)){
                    System.out.println(student.getPassword()+":"+password);
                    request.getRequestDispatcher("/UI/studentSearchPage.jsp").forward(request,response);
                }
            }
        }
        else if(type.equals("teacher")){
            TeacherDao sd=new TeacherDao();
            Teacher teacher=sd.findById(id);
            if(teacher!=null){
                if(teacher.getPassword().equals(password)){
                    System.out.println(teacher.getPassword()+":"+password);
                    request.getRequestDispatcher("/UI/teacherSearchPage.jsp").forward(request,response);
                }
            }
        }
        else if(type.equals("admin")){
            AdminDao sd=new AdminDao();
            Admin admin=sd.findById(id);
            if(admin!=null){
                if(admin.getPassword().equals(password)){
                    System.out.println(admin.getPassword()+":"+password);
                    request.getRequestDispatcher("/UI/adminSearchPage.jsp").forward(request,response);
                }
            }
        }
//        InputWrongNew(request,response);
        InputWrong(request,response);
    }


    private void InputWrong(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
//        response.getWriter().println("<h1>无法正确登录，请检查您的帐号、密码、登录类型是否输入正确！</h1>");
//        response.getWriter().println("<br><a href='/'><h2>返回</h2></a>");
        response.getWriter().println("Log In False");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
