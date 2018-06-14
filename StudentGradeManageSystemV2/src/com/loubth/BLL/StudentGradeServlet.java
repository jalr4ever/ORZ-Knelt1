package com.loubth.BLL;

import com.loubth.Bean.StudentGrade;
import com.loubth.DAO.StudentGradeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentGradeServlet")
public class StudentGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<StudentGrade> studentGradeList=new ArrayList<StudentGrade>();
        StudentGradeDao sg=new StudentGradeDao();

        //post提交的参数要处理乱码
        if(request.getParameter("id")!=null){
            String id=new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8");
            if(id.equals("管理所有")){
                studentGradeList=sg.findAll();
            }
            else{
                StudentGrade tc=sg.findById(Integer.parseInt(id));
                studentGradeList.add(tc);
            }
        }

        if(request.getParameter("classNum")!=null) {
            String classNum = new String(request.getParameter("classNum").getBytes("iso-8859-1"), "utf-8");
            System.out.println("classNum: " + classNum);
            if(!classNum.equals("")){
                studentGradeList=sg.findByClass(Integer.parseInt(classNum));
            }
        }

        request.setAttribute("studentGradeList",studentGradeList);
        try{
            if(request.getParameter("isStudent").equals("true")){
                request.setAttribute("isStudent",true);
            }
        }
        catch (Exception e){
        }
        request.getRequestDispatcher("/UI/adminSearchResultPage.jsp").forward(request,response);
    }
}
