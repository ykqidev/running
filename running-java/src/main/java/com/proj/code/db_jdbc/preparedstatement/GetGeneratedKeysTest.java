package com.proj.code.db_jdbc.preparedstatement;

import java.sql.*;
import java.util.Scanner;

public class GetGeneratedKeysTest {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入部门名称");
        String name = scanner.nextLine();

        System.out.println("请输入部门详情");
        String desc = scanner.nextLine();

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");

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
        conn.close();

    }
}
