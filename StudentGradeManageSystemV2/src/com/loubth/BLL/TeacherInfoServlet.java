package com.loubth.BLL;

import com.loubth.Bean.Student;
import com.loubth.Bean.Teacher;
import com.loubth.DAO.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TeacherInfoServlet")
public class TeacherInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Teacher> teacherList=new ArrayList<Teacher>();
        TeacherDao td=new TeacherDao();

        //post提交的参数要处理乱码
        if(request.getParameter("id")!=null){
            String id=new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8");
            if(id.equals("管理所有")){
                teacherList=td.findAll();
            }
            else{
                Teacher tc=td.findById(Integer.parseInt(id));
                teacherList.add(tc);
            }
        }

        request.setAttribute("teacherList",teacherList);
        request.getRequestDispatcher("/UI/adminSearchResultPage.jsp").forward(request,response);
    }
}
