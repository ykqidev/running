package com.proj.code.db_jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务 同一个connection
 * 同一个事务的sql必须保证是同一个connection对象
 */
public class TransactionTest {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");

            conn.setAutoCommit(false);
            update(conn);
            insert(conn);
            conn.commit();
            System.out.println("操作成功");
        } catch (Exception e) {

            System.out.println("操作失败");
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static void update(Connection conn) throws Exception {
        String sql = "update t_department set dname = ? where dname = ?";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setObject(1, "IT部1");
        statement.setObject(2, "yy");

        int len = statement.executeUpdate();

        statement.close();

    }

    private static void insert(Connection conn) throws SQLException {
        String sql = "insert into t_department values(null,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setObject(1, "IT部");
        statement.setObject(2, "搬砖的");

        int len = statement.executeUpdate();

        statement.close();
    }
}
