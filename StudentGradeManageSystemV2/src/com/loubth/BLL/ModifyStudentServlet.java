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

@WebServlet(name = "ModifyStudentServlet")
public class ModifyStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao sd=new StudentDao();
        //post提交的参数要处理乱码
        sd.delete(Integer.parseInt(new String(request.getParameter("oldId").getBytes("iso-8859-1"), "utf-8")));
        Student student=new Student();
        student.setId(Integer.parseInt(new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8")));
        student.setPassword(new String(request.getParameter("password").getBytes("iso-8859-1"), "utf-8"));
        student.setClazz(Integer.parseInt(new String(request.getParameter("class").getBytes("iso-8859-1"), "utf-8")));
        student.setName(new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8"));
        student.setSex(new String(request.getParameter("sex").getBytes("iso-8859-1"), "utf-8"));
        student.setAge(Integer.parseInt(new String(request.getParameter("age").getBytes("iso-8859-1"), "utf-8")));
        student.setPhoneNum(new String(request.getParameter("phoneNum").getBytes("iso-8859-1"), "utf-8"));
        student.setAddress(new String(request.getParameter("address").getBytes("iso-8859-1"), "utf-8"));
        student.setImagePath(new String(request.getParameter("imagePath").getBytes("iso-8859-1"), "utf-8"));
        student.setChargeTeacher(Integer.parseInt(new String(request.getParameter("chargeTeacher").getBytes("iso-8859-1"), "utf-8")));

        sd.add(student);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().println("<h1>修改成功！</h1>");
    }
}
