package com.loubth.BLL;

import com.loubth.Bean.Student;
import com.loubth.DAO.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> studentList=new ArrayList<Student>();
        StudentDao sd=new StudentDao();
        //post提交的参数要处理乱码
        if(request.getParameter("id")!=null){
            String id=new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8");
            if(id.equals("管理所有")){
                studentList=sd.findAll();
            }
            else{
                Student std=sd.findById(Integer.parseInt(id));
                studentList.add(std);
            }
        }
        if(request.getParameter("classNum")!=null) {
            String classNum = new String(request.getParameter("classNum").getBytes("iso-8859-1"), "utf-8");
            System.out.println("classNum: " + classNum);
            if(!classNum.equals("")){
                studentList=sd.findByClass(Integer.parseInt(classNum));
            }
        }


        request.setAttribute("studentList",studentList);
        try{
            if(request.getParameter("isStudent").equals("true")){
                request.setAttribute("isStudent",true);
            }
        }
        catch (Exception e){
        }
        request.getRequestDispatcher("/UI/adminSearchResultPage.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
