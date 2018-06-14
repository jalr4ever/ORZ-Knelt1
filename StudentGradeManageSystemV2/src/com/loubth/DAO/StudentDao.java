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

public class StudentDao {
    public static void main(String[] args) {
        StudentDao sd=new StudentDao();
        for(int i=0;i<100;i++){
            sd.add(new Student(2016123400+i,2016123400+i+"",1234,"王社会"+i,"女",15,"13333333333","今夜全是社会人迪厅","UI/images/photos/2015020001.png",2000001001));
//            sd.delete(2016123400+i);
        }
//        sd.update(new Student(2016123402,"2016123402",1234,"张社会","女",15,"13333333333","今夜全是社会人迪厅","C:\\social.jpg",2000001001));
//
//        Student student=sd.findById(2016123402);
//        System.out.println(student.getId()+" : "+student.getPassword());
//
//        sd.delete(2016123402);

    }
    public boolean add(Student student){
        if(student==null){
            System.out.println("待添加学生对象为空");
            return false;
        }
        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="INSERT INTO student(sid,spassword,sclass,sname,ssex,sage,sphone,saddress,simage,sleader) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,student.getId()+"");
            ps.setString(2,student.getPassword());
            ps.setString(3,student.getClazz()+"");
            ps.setString(4,student.getName());
            ps.setString(5,student.getSex());
            ps.setString(6,student.getAge()+"");
            ps.setString(7,student.getPhoneNum());
            ps.setString(8,student.getAddress());
            ps.setString(9,student.getImagePath());
            ps.setString(10,student.getChargeTeacher()+"");

            ps.executeUpdate();
            System.out.println("添加成功！");
            return true;
        }
        catch(SQLServerException e){
            e.printStackTrace();
            System.out.println("待插入数据可能已经存在！");
        }
        catch (SQLException e) {

        }
        return false;
    }
    public void delete(int id){

        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="DELETE FROM student WHERE sid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,id+"");
            ps.executeUpdate();
            System.out.println("删除成功 或 使用该工号的对象不存在！");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Student student){
        if(student==null){
            System.out.println("待修改学生对象为空");
            return;
        }

        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="UPDATE student SET sid=?,spassword=?,sclass=?,sname=?,ssex=?,sage=?,sphone=?,saddress=?,simage=?,sleader=? WHERE sid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,student.getId()+"");
            ps.setString(2,student.getPassword());
            ps.setString(3,student.getClazz()+"");
            ps.setString(4,student.getName());
            ps.setString(5,student.getSex());
            ps.setString(6,student.getAge()+"");
            ps.setString(7,student.getPhoneNum());
            ps.setString(8,student.getAddress());
            ps.setString(9,student.getImagePath());
            ps.setString(10,student.getChargeTeacher()+"");
            ps.setString(11,student.getId()+"");
            ps.executeUpdate();
            System.out.println("修改成功！");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Student findById(int id){
        if(id==0){
            System.out.println("该id不存在！");
            return null;
        }
        ArrayList<Student> studentList=findBySQL("SELECT * FROM student WHERE sid="+id);
        Student student=null;
        if(studentList.size()>0){
            student =studentList.get(0);
        }

        return student;
    }
    public ArrayList<Student> findByClass(int classNum){
        if(classNum==0){
            System.out.println("该班级不存在！");
            return null;
        }
        return findBySQL("SELECT * FROM student WHERE sclass="+classNum);
    }
    public ArrayList<Student> findAll(){
        return findBySQL("SELECT * FROM student ORDER BY sid ASC");
    }
    public ArrayList<Student> findBySQL(String sql){
        ArrayList<Student> studentList=new ArrayList<Student>();
        try {
            Connection conn = JDBC_Utils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next() == true) {
                Student student = new Student();
                student.setId(Integer.parseInt(rs.getString("sid")));
                student.setPassword(rs.getString("spassword"));
                student.setClazz(Integer.parseInt(rs.getString("sclass")));
                student.setName(rs.getString("sname"));
                student.setSex(rs.getString("ssex"));
                student.setAge(Integer.parseInt(rs.getString("sage")));
                student.setPhoneNum(rs.getString("sphone"));
                student.setAddress(rs.getString("saddress"));
                student.setImagePath(rs.getString("simage"));
                student.setChargeTeacher(Integer.parseInt(rs.getString("sleader")));

                studentList.add(student);
            }
            System.out.println("查询成功！");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
