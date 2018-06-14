package com.loubth.BLL;

import com.loubth.Bean.StudentGrade;
import com.loubth.DAO.StudentGradeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentGradeInfoAddServlet")
public class StudentGradeInfoAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=new String(request.getParameter("id").getBytes("iso-8859-1"),"utf-8");
        String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
        String clazz=new String(request.getParameter("class").getBytes("iso-8859-1"),"utf-8");
        String chinese=new String(request.getParameter("chinese").getBytes("iso-8859-1"),"utf-8");
        String math=new String(request.getParameter("math").getBytes("iso-8859-1"),"utf-8");
        String english=new String(request.getParameter("english").getBytes("iso-8859-1"),"utf-8");
        String physics=new String(request.getParameter("physics").getBytes("iso-8859-1"),"utf-8");
        String chemistry=new String(request.getParameter("chemistry").getBytes("iso-8859-1"),"utf-8");
        String politics=new String(request.getParameter("politics").getBytes("iso-8859-1"),"utf-8");
        String geography=new String(request.getParameter("geography").getBytes("iso-8859-1"),"utf-8");
        String pe=new String(request.getParameter("pe").getBytes("iso-8859-1"),"utf-8");
        String sum=new String(request.getParameter("sum").getBytes("iso-8859-1"),"utf-8");
        String avg=new String(request.getParameter("avg").getBytes("iso-8859-1"),"utf-8");
        String rank=new String(request.getParameter("rank").getBytes("iso-8859-1"),"utf-8");
        String property=new String(request.getParameter("property").getBytes("iso-8859-1"),"utf-8");

        StudentGrade studentGrade=new StudentGrade();
        studentGrade.setId(Integer.parseInt(id));
        studentGrade.setName(name);
        studentGrade.setClazz(Integer.parseInt(clazz));
        studentGrade.setChinese(Integer.parseInt(chinese));
        studentGrade.setMath(Integer.parseInt(math));
        studentGrade.setEnglish(Integer.parseInt(english));
        studentGrade.setPhysics(Integer.parseInt(physics));
        studentGrade.setChemistry(Integer.parseInt(chemistry));
        studentGrade.setPolitics(Integer.parseInt(politics));
        studentGrade.setGeograry(Integer.parseInt(geography));
        studentGrade.setPe(Integer.parseInt(pe));
        studentGrade.setSum(Integer.parseInt(sum));
        studentGrade.setAve(Integer.parseInt(avg));
        studentGrade.setRank(Integer.parseInt(rank));
        studentGrade.setProperties(property);

        StudentGradeDao sd=new StudentGradeDao();
        sd.add(studentGrade);

        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        out.println("<h1>添加成功！</h1>");

    }
}
