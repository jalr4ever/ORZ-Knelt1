package com.loubth.Util;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @program: Final-StudentGradeManageSystem
 * @description: 通过该类可获取与数据库的连接
 * <p>
 * Created by St on 2018/6/7.
 */
public class JDBC_Utils {
    private static String driver=null;//连接数据库的驱动
    private static String url=null;
    private static String user=null;
    private static String password=null;
    private static Connection conn=null;
    //静态代码块，载入就执行
    static
    {
        InputStream in=JDBC_Utils.class.getClassLoader().getResourceAsStream("db.properties");//读取资源文件流
        Properties prop=new Properties();//创建资源文件工具对象
        try {
            prop.load(in);//载入资源文件
            driver=prop.getProperty("driver");
            url=prop.getProperty("url");
            user=prop.getProperty("user");
            password=prop.getProperty("password");
            Class.forName(driver);//加载驱动
            conn=DriverManager.getConnection(url,user,password);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("取得数据库连接时的-IO异常");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("取得数据库连接时-Class找不到异常");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取数据库连接时错误");
        }
    }
    public static Connection getConnection() throws SQLException {//得到数据库连接对象
            return conn;
    }
    public static void release(Connection conn, Statement st, ResultSet rs) throws SQLException {//释放资源
            if(conn!=null) {
                conn.close();
            }
            if (st!=null){
                st.close();
            }
            if(rs!=null){
                rs.close();
            }
    }
}
