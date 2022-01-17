package com.proj.code.db_jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {

    @Test
    public void method02() throws Exception {

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        Connection conn = DriverManager.getConnection(url, user, password);

        String sql = "insert into t_department values(null,'xx','xx')";
        Statement statement = conn.createStatement();
        int i = statement.executeUpdate(sql);

        System.out.println(i > 0 ? "插入成功" : "插入失败");

        statement.close();
        conn.close();


    }


    @Test
    public void method01() throws Exception {

        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        Connection conn = DriverManager.getConnection(url, user, password);

        String sql = "select * from t_department;";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Object id = resultSet.getObject(1);
            Object name = resultSet.getObject(2);
            Object desc = resultSet.getObject(3);
            System.out.println(id + "\t" + name + "\t" + desc);
        }

        resultSet.close();
        statement.close();
        conn.close();
    }
}
