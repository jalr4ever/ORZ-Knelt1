package com.loubth.BLL;

import com.loubth.Bean.TeacherManage;
import com.loubth.DAO.TeacherManageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TeacherManageServlet")
public class TeacherManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<TeacherManage> teacherManageList=new ArrayList<TeacherManage>();
        TeacherManageDao tmd=new TeacherManageDao();

        //post提交的参数要处理乱码
        if(request.getParameter("id")!=null){
            String id=new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8");
            if(id.equals("管理所有")){
                teacherManageList=tmd.findAll();
            }
            else{
                TeacherManage tc=tmd.findById(Integer.parseInt(id));
                teacherManageList.add(tc);
            }
        }
        if(request.getParameter("classNum")!=null) {
            String classNum = new String(request.getParameter("classNum").getBytes("iso-8859-1"), "utf-8");
            System.out.println("classNum: " + classNum);
            if(!classNum.equals("")){
                teacherManageList=tmd.findByClass(Integer.parseInt(classNum));
            }
        }

        request.setAttribute("teacherManageList",teacherManageList);
        request.getRequestDispatcher("/UI/adminSearchResultPage.jsp").forward(request,response);
    }
}
