package com.loubth.DAO;

import com.loubth.Bean.Student;
import com.loubth.Bean.TeacherManage;
import com.loubth.Bean.Teacher;
import com.loubth.Bean.TeacherManage;
import com.loubth.Util.JDBC_Utils;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherManageDao {
    public static void main(String[] args) {
        TeacherManageDao tmd=new TeacherManageDao();
        for(int i=0;i<100;i++){
            tmd.add(new TeacherManage(2016123400+i,"王社会"+i,1234,1234));
        }
//        tmd.update(new TeacherManage(2016123404,"王社会",199,199));
//
//
//        tmd.delete(2016123404);

    }
    public void add(TeacherManage teacherManage){
        if(teacherManage==null){
            System.out.println("待添加教师管理对象为空");
            return;
        }
        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="INSERT INTO teacherManage(tmid,tmname,tmsubjectclass,tmmainclass) VALUES(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,teacherManage.getId()+"");
            ps.setString(2,teacherManage.getName());
            ps.setString(3,teacherManage.getSubjectClass()+"");
            ps.setString(4,teacherManage.getMainClass()+"");
            ps.executeUpdate();
            System.out.println("添加成功！");
        }
        catch(SQLServerException e){
            System.out.println("该班级已经有班主任了");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){

        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="DELETE FROM teacherManage WHERE tmid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,id+"");
            ps.executeUpdate();
            System.out.println("删除成功 或 使用该工号的对象不存在！");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(TeacherManage teacherManage){
        if(teacherManage==null){
            System.out.println("待修改教师管理对象为空");
            return;
        }

        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="UPDATE teacherManage SET tmid=?,tmname=?,tmsubjectclass=?,tmmainclass=? WHERE tmid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,teacherManage.getId()+"");
            ps.setString(2,teacherManage.getName());
            ps.setString(3,teacherManage.getSubjectClass()+"");
            ps.setString(4,teacherManage.getMainClass()+"");
            ps.setString(5,teacherManage.getId()+"");
            ps.executeUpdate();
            System.out.println("修改成功！");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public TeacherManage findById(int id){
        if(id==0){
            System.out.println("该id不存在！");
            return null;
        }
        ArrayList<TeacherManage> teacherManageList=findBySQL("SELECT * FROM teacherManage WHERE tmid="+id);
        TeacherManage teacherManage=null;
        if(teacherManageList.size()>0){
            teacherManage =teacherManageList.get(0);
        }

        return teacherManage;
    }
    public ArrayList<TeacherManage> findByClass(int classNum){
        if(classNum==0){
            System.out.println("该班级不存在！");
            return null;
        }
        return findBySQL("SELECT * FROM teachermanage WHERE tmclass="+classNum);
    }
    public ArrayList<TeacherManage> findAll(){
        return findBySQL("SELECT * FROM teachermanage ORDER BY tmid ASC");
    }
    public ArrayList<TeacherManage> findBySQL(String sql){
        ArrayList<TeacherManage> teacherManageList=new ArrayList<TeacherManage>();
        try {
            Connection conn = JDBC_Utils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next() == true) {
                TeacherManage teacherManage=new TeacherManage();
                teacherManage.setId(Integer.parseInt(rs.getString("tmid")));
                teacherManage.setName(rs.getString("tmname"));
                teacherManage.setSubjectClass(Integer.parseInt(rs.getString("tmsubjectclass")));
                teacherManage.setMainClass(Integer.parseInt(rs.getString("tmmainclass")));

                teacherManageList.add(teacherManage);
            }
            System.out.println("查询成功！");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacherManageList;
    }
}
