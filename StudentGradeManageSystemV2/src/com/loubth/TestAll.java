package com.loubth;


import com.loubth.Util.JDBC_Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: Final-StudentGradeManageSystem
 * @description: Temporary testing module
 * <p>
 * Created by St on 2018/6/7.
 */
public class TestAll {
    public static void main(String[] args) throws SQLException {
        testConnectDB();
    }
    public static void testConnectDB() throws SQLException {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        try{
            conn= JDBC_Utils.getConnection();
            st=conn.createStatement();
            String sql="select * from Test;";
            rs= st.executeQuery(sql);
            if (rs.next()) {

                System.out.println(rs.getString("id"));
                System.out.println("查询测试成功！");
            }
            else{
                System.out.println("查询测试失败！");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBC_Utils.release(conn,st,rs);}
    }
}
