package com.loubth.BLL;

import com.loubth.Bean.TeacherManage;
import com.loubth.Bean.TeacherManage;
import com.loubth.DAO.TeacherManageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TeacherManageAddServlet")
public class TeacherManageAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=new String(request.getParameter("id").getBytes("iso-8859-1"),"utf-8");
        String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
        String subjectclass=new String(request.getParameter("subjectclass").getBytes("iso-8859-1"),"utf-8");
        String mainclass=new String(request.getParameter("mainclass").getBytes("iso-8859-1"),"utf-8");

        TeacherManage teacherManage=new TeacherManage();
        teacherManage.setId(Integer.parseInt(id));
        teacherManage.setName(name);
        teacherManage.setSubjectClass(Integer.parseInt(subjectclass));
        teacherManage.setMainClass(Integer.parseInt(mainclass));

        TeacherManageDao sd=new TeacherManageDao();
        sd.add(teacherManage);

        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        out.println("<h1>添加成功！</h1>");

    }
}
