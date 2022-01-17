package com.proj.code.db_jdbc.jdbcutils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DataSource ds;

    private static ThreadLocal<Connection> local;

    static {
        Properties properties = new Properties();
        try {
            properties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);

            local = new ThreadLocal<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        Connection conn = local.get();
        if (conn == null) {
            conn = ds.getConnection();
            local.set(conn);
        }
        return conn;
    }


    public static void free() {
        Connection conn = local.get();
        if (conn != null) {
            local.remove();
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static DataSource getDs() {
        return ds;
    }
}
