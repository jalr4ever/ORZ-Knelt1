package com.loubth.DAO;

import com.loubth.Bean.Student;
import com.loubth.Bean.StudentGrade;
import com.loubth.Bean.Teacher;
import com.loubth.Util.JDBC_Utils;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentGradeDao {
    public static void main(String[] args) {
        StudentGradeDao sd=new StudentGradeDao();
        for(int i=0;i<100;i++){
            sd.add(new StudentGrade(2016123400+i,"王社会"+i,1234,100,100,100,100,100,100,100,100,100,100,1,"2016-2017 期末考试"));
        }
//        sd.update(new StudentGrade(2016123402,"王社会",1234,100,99,100,100,100,100,100,100,100,100,1,"2016-2017 期末考试"));
//
//        StudentGrade studentGrade=sd.findById(2016123402);
//        System.out.println(studentGrade.getId()+" : "+studentGrade.getAve());
//
//        sd.delete(2016123402);

    }
    public void add(StudentGrade studentGrade){
        if(studentGrade==null){
            System.out.println("待添加学生成绩对象为空");
            return;
        }
        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="INSERT INTO studentGrade(sgid,sgname,sgclass,sgchinese,sgmath,sgenglish,sgphysics,sgchemistry,sgpolitics,sggeography,sgpe,sgsum,sgavg,sgrank,sgproperty) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,studentGrade.getId()+"");
            ps.setString(2,studentGrade.getName());
            ps.setString(3,studentGrade.getClazz()+"");
            ps.setString(4,studentGrade.getChinese()+"");
            ps.setString(5,studentGrade.getMath()+"");
            ps.setString(6,studentGrade.getEnglish()+"");
            ps.setString(7,studentGrade.getPhysics()+"");
            ps.setString(8,studentGrade.getChemistry()+"");
            ps.setString(9,studentGrade.getPolitics()+"");
            ps.setString(10,studentGrade.getGeograry()+"");
            ps.setString(11,studentGrade.getPe()+"");
            ps.setString(12,studentGrade.getSum()+"");
            ps.setString(13,studentGrade.getAve()+"");
            ps.setString(14,studentGrade.getRank()+"");
            ps.setString(15,studentGrade.getProperties());


            ps.executeUpdate();
            System.out.println("添加成功！");
        }
        catch(SQLServerException e){
            System.out.println("待插入数据可能已经存在 或 系统中并不存在你插入的学生");

        }
        catch (SQLException e) {

        }
    }
    public void delete(int id){

        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="DELETE FROM studentGrade WHERE sgid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,id+"");
            ps.executeUpdate();
            System.out.println("删除成功 或 使用该工号的对象不存在！");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(StudentGrade studentGrade){
        if(studentGrade==null){
            System.out.println("待修改学生成绩对象为空");
            return;
        }

        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="UPDATE studentGrade SET sgid=?,sgname=?,sgclass=?,sgchinese=?,sgmath=?,sgenglish=?,sgphysics=?,sgchemistry=?,sgpolitics=?,sggeography=?,sgpe=?,sgsum=?,sgavg=?,sgrank=?,sgproperty=? WHERE sgid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,studentGrade.getId()+"");
            ps.setString(2,studentGrade.getName());
            ps.setString(3,studentGrade.getClazz()+"");
            ps.setString(4,studentGrade.getChinese()+"");
            ps.setString(5,studentGrade.getMath()+"");
            ps.setString(6,studentGrade.getEnglish()+"");
            ps.setString(7,studentGrade.getPhysics()+"");
            ps.setString(8,studentGrade.getChemistry()+"");
            ps.setString(9,studentGrade.getPolitics()+"");
            ps.setString(10,studentGrade.getGeograry()+"");
            ps.setString(11,studentGrade.getPe()+"");
            ps.setString(12,studentGrade.getSum()+"");
            ps.setString(13,studentGrade.getAve()+"");
            ps.setString(14,studentGrade.getRank()+"");
            ps.setString(15,studentGrade.getProperties());
            ps.setString(16,studentGrade.getId()+"");
            ps.executeUpdate();
            System.out.println("修改成功！");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public StudentGrade findById(int id){
        if(id==0){
            System.out.println("该id不存在！");
            return null;
        }
        ArrayList<StudentGrade> studentGradeList=findBySQL("SELECT * FROM studentGrade WHERE sgid="+id);
        StudentGrade studentGrade=null;
        if(studentGradeList.size()>0){
            studentGrade =studentGradeList.get(0);
        }

        return studentGrade;
    }
    public ArrayList<StudentGrade> findAll(){
        return findBySQL("SELECT * FROM studentgrade ORDER BY sgid ASC");
    }
    public ArrayList<StudentGrade> findByClass(int classNum){
        if(classNum==0){
            System.out.println("该班级不存在！");
            return null;
        }
        return findBySQL("SELECT * FROM studentgrade WHERE sgclass="+classNum);
    }
    public ArrayList<StudentGrade> findBySQL(String sql){
        ArrayList<StudentGrade> studentGradeList=new ArrayList<StudentGrade>();
        try {
            Connection conn = JDBC_Utils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next() == true) {
                StudentGrade studentGrade=new StudentGrade();
                studentGrade.setId(Integer.parseInt(rs.getString("sgid")));
                studentGrade.setName(rs.getString("sgname"));
                studentGrade.setClazz(Integer.parseInt(rs.getString("sgclass")));
                studentGrade.setChinese(Integer.parseInt(rs.getString("sgchinese")));
                studentGrade.setMath(Integer.parseInt(rs.getString("sgmath")));
                studentGrade.setEnglish(Integer.parseInt(rs.getString("sgenglish")));
                studentGrade.setPhysics(Integer.parseInt(rs.getString("sgphysics")));
                studentGrade.setChemistry(Integer.parseInt(rs.getString("sgchemistry")));
                studentGrade.setPolitics(Integer.parseInt(rs.getString("sgpolitics")));
                studentGrade.setGeograry(Integer.parseInt(rs.getString("sggeography")));
                studentGrade.setPe(Integer.parseInt(rs.getString("sgpe")));
                studentGrade.setSum(Integer.parseInt(rs.getString("sgsum")));
                studentGrade.setAve(Integer.parseInt(rs.getString("sgavg")));
                studentGrade.setRank(Integer.parseInt(rs.getString("sgrank")));
                studentGrade.setProperties(rs.getString("sgproperty"));

                studentGradeList.add(studentGrade);
            }
            System.out.println("查询成功！");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentGradeList;
    }


}
