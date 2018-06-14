package com.loubth.BLL;

import com.loubth.Bean.Teacher;
import com.loubth.DAO.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyTeacherServlet")
public class ModifyTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherDao sd=new TeacherDao();
        //post提交的参数要处理乱码
        sd.delete(Integer.parseInt(new String(request.getParameter("oldId").getBytes("iso-8859-1"), "utf-8")));
        Teacher teacher=new Teacher();
        teacher.setId(Integer.parseInt(new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8")));
        teacher.setPassword(new String(request.getParameter("password").getBytes("iso-8859-1"), "utf-8"));
        teacher.setName(new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8"));
        teacher.setSex(new String(request.getParameter("sex").getBytes("iso-8859-1"), "utf-8"));
        teacher.setAge(Integer.parseInt(new String(request.getParameter("age").getBytes("iso-8859-1"), "utf-8")));
        teacher.setSubject(new String(request.getParameter("subject").getBytes("iso-8859-1"), "utf-8"));
        teacher.setPhoneNum(new String(request.getParameter("phoneNum").getBytes("iso-8859-1"), "utf-8"));
        teacher.setAddress(new String(request.getParameter("address").getBytes("iso-8859-1"), "utf-8"));
        teacher.setImagePath(new String(request.getParameter("imagePath").getBytes("iso-8859-1"), "utf-8"));
        sd.add(teacher);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().println("<h1>修改成功！</h1>");
    }
}
