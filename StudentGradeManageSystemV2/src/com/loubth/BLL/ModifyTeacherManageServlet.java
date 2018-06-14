package com.loubth.BLL;

import com.loubth.Bean.TeacherManage;
import com.loubth.DAO.TeacherManageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyTeacherManageManageServlet")
public class ModifyTeacherManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherManageDao sd=new TeacherManageDao();
        //post提交的参数要处理乱码
        sd.delete(Integer.parseInt(new String(request.getParameter("oldId").getBytes("iso-8859-1"), "utf-8")));
        TeacherManage teacherManage=new TeacherManage();
        teacherManage.setId(Integer.parseInt(new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8")));
        teacherManage.setName(new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8"));
        teacherManage.setSubjectClass(Integer.parseInt(new String(request.getParameter("subjectclass").getBytes("iso-8859-1"), "utf-8")));
        teacherManage.setMainClass(Integer.parseInt(new String(request.getParameter("mainclass").getBytes("iso-8859-1"), "utf-8")));


        sd.add(teacherManage);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().println("<h1>修改成功！</h1>");
    }
}
