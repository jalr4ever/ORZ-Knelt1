package com.loubth.BLL;

import com.loubth.Bean.StudentGrade;
import com.loubth.DAO.StudentGradeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyStudentGradeGradeServlet")
public class ModifyStudentGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentGradeDao sd=new StudentGradeDao();
        //post提交的参数要处理乱码
        sd.delete(Integer.parseInt(new String(request.getParameter("oldId").getBytes("iso-8859-1"), "utf-8")));
        StudentGrade studentGrade=new StudentGrade();
        studentGrade.setId(Integer.parseInt(new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8")));
        studentGrade.setName(new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8"));
        studentGrade.setClazz(Integer.parseInt(new String(request.getParameter("class").getBytes("iso-8859-1"), "utf-8")));
        studentGrade.setChinese(Integer.parseInt(new String(request.getParameter("chinese").getBytes("iso-8859-1"), "utf-8")));
        studentGrade.setMath(Integer.parseInt(new String(request.getParameter("math").getBytes("iso-8859-1"), "utf-8")));
        studentGrade.setEnglish(Integer.parseInt(new String(request.getParameter("english").getBytes("iso-8859-1"), "utf-8")));
        studentGrade.setPhysics(Integer.parseInt(new String(request.getParameter("physics").getBytes("iso-8859-1"), "utf-8")));
        studentGrade.setChemistry(Integer.parseInt(new String(request.getParameter("chemistry").getBytes("iso-8859-1"), "utf-8")));
        studentGrade.setPolitics(Integer.parseInt(new String(request.getParameter("politics").getBytes("iso-8859-1"), "utf-8")));
        studentGrade.setGeograry(Integer.parseInt(new String(request.getParameter("geography").getBytes("iso-8859-1"), "utf-8")));
        studentGrade.setPe(Integer.parseInt(new String(request.getParameter("pe").getBytes("iso-8859-1"), "utf-8")));
        studentGrade.setClazz(Integer.parseInt(new String(request.getParameter("avg").getBytes("iso-8859-1"), "utf-8")));
        studentGrade.setSum(Integer.parseInt(new String(request.getParameter("sum").getBytes("iso-8859-1"), "utf-8")));
        studentGrade.setRank(Integer.parseInt(new String(request.getParameter("rank").getBytes("iso-8859-1"), "utf-8")));
        studentGrade.setProperties(new String(request.getParameter("property").getBytes("iso-8859-1"), "utf-8"));

        sd.add(studentGrade);
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().println("<h1>修改成功！</h1>");
    }
}
