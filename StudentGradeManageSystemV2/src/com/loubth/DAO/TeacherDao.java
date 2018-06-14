package com.loubth.DAO;

import com.loubth.Bean.Student;
import com.loubth.Bean.Teacher;
import com.loubth.Util.JDBC_Utils;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDao {
    public static void main(String[] args) {
        TeacherDao td=new TeacherDao();
        for(int i=0;i<100;i++){
            td.add(new Teacher(2016123400+i,2016123400+i+"","王社会"+i,"女",15,"语文","13333333333","今夜全是社会人迪厅","UI/images/photos/2015020001.png"));
//        td.delete(2016123400+i);
        }
//        td.update(new Teacher(2016123402,"2017123402","张社会","女",15,"语文","13333333333","今夜全是社会人迪厅","C:\\social.jpg"));

//        Teacher teacher=td.findById(2016123402);
//        System.out.println(teacher.getId()+" : "+teacher.getPassword());
//

    }
    public boolean add(Teacher teacher){
        if(teacher==null){
            System.out.println("待添加老师对象为空");
            return false;
        }
        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="INSERT INTO teacher(tid,tpassword,tsubject,tname,tsex,tage,tphone,taddress,timage) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,teacher.getId()+"");
            ps.setString(2,teacher.getPassword());
            ps.setString(3,teacher.getSubject());
            ps.setString(4,teacher.getName());
            ps.setString(5,teacher.getSex());
            ps.setString(6,teacher.getAge()+"");
            ps.setString(7,teacher.getPhoneNum());
            ps.setString(8,teacher.getAddress());
            ps.setString(9,teacher.getImagePath());

            ps.executeUpdate();
            System.out.println("添加成功！");
            return true;
        }
        catch(SQLServerException e){
            System.out.println("待插入数据可能已经存在！");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void delete(int id){

        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="DELETE FROM teacher WHERE tid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,id+"");
            ps.executeUpdate();
            System.out.println("删除成功 或 使用该工号的对象不存在！");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Teacher teacher){
        if(teacher==null){
            System.out.println("待修改老师对象为空");
            return;
        }

        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="UPDATE teacher SET tid=?,tpassword=?,tsubject=?,tname=?,tsex=?,tage=?,tphone=?,taddress=?,timage=? WHERE tid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,teacher.getId()+"");
            ps.setString(2,teacher.getPassword());
            ps.setString(3,teacher.getSubject()+"");
            ps.setString(4,teacher.getName());
            ps.setString(5,teacher.getSex());
            ps.setString(6,teacher.getAge()+"");
            ps.setString(7,teacher.getPhoneNum());
            ps.setString(8,teacher.getAddress());
            ps.setString(9,teacher.getImagePath());
            ps.setString(10,teacher.getId()+"");
            ps.executeUpdate();
            System.out.println("修改成功！");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Teacher findById(int id){
        if(id==0){
            System.out.println("该id不存在！");
            return null;
        }
        ArrayList<Teacher> teacherList=findBySQL("SELECT * FROM teacher WHERE tid="+id);
        Teacher teacher=null;
        if(teacherList.size()>0){
            teacher =teacherList.get(0);
        }

        return teacher;
    }
    public ArrayList<Teacher> findAll(){
        return findBySQL("SELECT * FROM teacher ORDER BY tid ASC");
    }
    public ArrayList<Teacher> findBySQL(String sql){
        ArrayList<Teacher> teacherList=new ArrayList<Teacher>();
        try {
            Connection conn = JDBC_Utils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next() == true) {
                Teacher teacher=new Teacher();
                teacher.setId(Integer.parseInt(rs.getString("tid")));
                teacher.setPassword(rs.getString("tpassword"));
                teacher.setName(rs.getString("tname"));
                teacher.setSex(rs.getString("tsex"));
                teacher.setAge(Integer.parseInt(rs.getString("tage")));
                teacher.setSubject(rs.getString("tsubject"));
                teacher.setPhoneNum(rs.getString("tphone"));
                teacher.setAddress(rs.getString("taddress"));
                teacher.setImagePath(rs.getString("timage"));

                teacherList.add(teacher);
            }
            System.out.println("查询成功！");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacherList;
    }
}
