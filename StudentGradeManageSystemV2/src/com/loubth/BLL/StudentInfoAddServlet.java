package com.loubth.BLL;

import com.loubth.Bean.Student;
import com.loubth.DAO.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentInfoAddServlet")
public class StudentInfoAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=new String(request.getParameter("id").getBytes("iso-8859-1"),"utf-8");
        String password=new String(request.getParameter("password").getBytes("iso-8859-1"),"utf-8");
        String clazz=new String(request.getParameter("class").getBytes("iso-8859-1"),"utf-8");
        String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
        String sex=new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
        String age=new String(request.getParameter("age").getBytes("iso-8859-1"),"utf-8");
        String phoneNum=new String(request.getParameter("phoneNum").getBytes("iso-8859-1"),"utf-8");
        String chargeTeacher=new String(request.getParameter("chargeTeacher").getBytes("iso-8859-1"),"utf-8");
        String address=new String(request.getParameter("address").getBytes("iso-8859-1"),"utf-8");

        Student student=new Student();
        student.setId(Integer.parseInt(id));
        student.setPassword(password);
        student.setClazz(Integer.parseInt(clazz));
        student.setName(name);
        student.setSex(sex);
        student.setAge(Integer.parseInt(age));
        student.setPhoneNum(phoneNum);
        student.setChargeTeacher(Integer.parseInt(chargeTeacher));
        student.setAddress(address);

        StudentDao sd=new StudentDao();
        boolean isAddSuccess=sd.add(student);
        if(isAddSuccess){
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out=response.getWriter();
            out.println("<h1>添加成功！</h1>");
        }
        else{
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            PrintWriter out=response.getWriter();
            out.println("<h1>添加失败！学号已经存在，请更换学号！</h1>");
        }


    }
}
