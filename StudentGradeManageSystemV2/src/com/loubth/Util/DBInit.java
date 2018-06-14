package com.loubth.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBInit {
    private static void Init(){
        try {
            Connection conn=JDBC_Utils.getConnection();
            String sql="SELECT sid FROM student WHERE sid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,"2015020001");
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {

                System.out.println(rs.getString("sid"));
                System.out.println("查询测试成功！");
            }
            else{
                System.out.println("查询测试失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DBInit.Init();
    }
}
