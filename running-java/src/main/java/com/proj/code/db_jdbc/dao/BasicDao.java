package com.proj.code.db_jdbc.dao;

import com.proj.code.db_jdbc.jdbcutils.JdbcUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class BasicDao {
    public int update(String sql, Object... args) throws Exception {
        Connection conn = JdbcUtils.getConnection();

        PreparedStatement statement = conn.prepareStatement(sql);

        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }
        }

        int len = statement.executeUpdate();
        statement.close();
        JdbcUtils.free();

        return len;
    }


    public <T> ArrayList<T> getAll(Class<T> clazz, String sql, Object... args) throws Exception {
        Connection conn = JdbcUtils.getConnection();

        PreparedStatement statement = conn.prepareStatement(sql);

        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, i);
            }
        }

        ResultSet resultSet = statement.executeQuery();

        ResultSetMetaData rsm = resultSet.getMetaData();
        int count = rsm.getColumnCount();
        ArrayList<T> arrayList = new ArrayList<>();

        while (resultSet.next()){
            T instance = clazz.newInstance();
            for (int i = 1; i <= count; i++) {
                String columnName = rsm.getColumnLabel(i);
                Field field = clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(instance,resultSet.getObject(i));
            }
            arrayList.add(instance);
        }

        return arrayList;
    }
}
