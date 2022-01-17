package com.proj.code.db_jdbc.jdbcutils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcUtilsTest {

    @Test
    public void test() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入部门名称");
        String name = scanner.nextLine();

        System.out.println("请输入部门详情");
        String desc = scanner.nextLine();

        Connection conn = JdbcUtils.getConnection();

        String sql = "insert into t_department values (null,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setObject(1, name);
        preparedStatement.setObject(2, desc);

        int i = preparedStatement.executeUpdate();
        System.out.println(i > 0 ? "添加成功" : "添加失败");
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            System.out.println(generatedKeys.getObject(1));

        }

        preparedStatement.close();
        JdbcUtils.free();

    }
}
