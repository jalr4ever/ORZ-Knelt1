package com.loubth.BLL;

import com.loubth.DAO.TeacherManageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteTeacherManageServlet")
public class DeleteTeacherManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherManageDao sd=new TeacherManageDao();
        String id=request.getParameter("id");
        sd.delete(Integer.parseInt(id));
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        out.println("<h1>删除成功！</h1>");
        out.print("<script language=javascript>window.close();");
        out.print("</script>");
    }
}
