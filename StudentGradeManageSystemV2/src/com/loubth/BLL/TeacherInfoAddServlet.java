package com.loubth.BLL;

import com.loubth.Bean.Teacher;
import com.loubth.DAO.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TeacherInfoAddServlet")
public class TeacherInfoAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=new String(request.getParameter("id").getBytes("iso-8859-1"),"utf-8");
        String password=new String(request.getParameter("password").getBytes("iso-8859-1"),"utf-8");
        String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
        String sex=new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
        String subject=new String(request.getParameter("subject").getBytes("iso-8859-1"),"utf-8");
        String age=new String(request.getParameter("age").getBytes("iso-8859-1"),"utf-8");
        String phoneNum=new String(request.getParameter("phoneNum").getBytes("iso-8859-1"),"utf-8");
        String address=new String(request.getParameter("address").getBytes("iso-8859-1"),"utf-8");

        Teacher teacher=new Teacher();
        teacher.setId(Integer.parseInt(id));
        teacher.setPassword(password);
        teacher.setName(name);
        teacher.setSex(sex);
        teacher.setSubject(subject);
        teacher.setAge(Integer.parseInt(age));
        teacher.setPhoneNum(phoneNum);
        teacher.setAddress(address);

        TeacherDao td=new TeacherDao();
        boolean isAddSuccess=td.add(teacher);

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
            out.println("<h1>添加失败！工号已经存在，请更换工号！</h1>");
        }
    }
}
