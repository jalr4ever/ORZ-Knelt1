package com.loubth.DAO;

import com.loubth.Bean.Admin;
import com.loubth.Util.JDBC_Utils;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    public static void main(String[] args) {
        AdminDao ad=new AdminDao();
        ad.add(new Admin(2016123402,"2016123402"));
        ad.update(new Admin(2016123402,"2017123402"));

        Admin admin=ad.findById(2016123402);
        System.out.println(admin.getId()+" : "+admin.getPassword());

        ad.delete(2016123402);

    }
    public void add(Admin admin){
        if(admin==null){
            System.out.println("待添加管理员对象为空");
            return;
        }
        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="INSERT INTO admin(aid,apassword) VALUES(?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,admin.getId()+"");
            ps.setString(2,admin.getPassword());
            ps.executeUpdate();
            System.out.println("添加成功！");
        }
        catch(SQLServerException e){
            System.out.println("待插入数据可能已经存在！");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){

        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="DELETE FROM admin WHERE aid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,id+"");
            ps.executeUpdate();
            System.out.println("删除成功 或 使用该工号的对象不存在！");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Admin admin){
        if(admin==null){
            System.out.println("待修改管理员对象为空");
            return;
        }

        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="UPDATE admin SET aid=?,apassword=? WHERE aid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,admin.getId()+"");
            ps.setString(2,admin.getPassword());
            ps.setString(3,admin.getId()+"");
            ps.executeUpdate();
            System.out.println("修改成功！");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Admin findById(int id){
        Admin admin=null;
        if(id==0){
            System.out.println("该id不存在！");
            return null;
        }

        try {
            Connection conn= JDBC_Utils.getConnection();
            String sql="SELECT * FROM admin WHERE aid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,id+"");

            ResultSet rs=ps.executeQuery();
            if(rs.next()==true){
                admin=new Admin();
                admin.setId(Integer.parseInt(rs.getString("aid")));
                admin.setPassword(rs.getString("apassword"));
            }
            System.out.println("查询成功！");
        }
        catch (SQLException e) {
            System.out.println("所查询的id不存在！");
            e.printStackTrace();
            return null;
        }
        return admin;
    }
}
