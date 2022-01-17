package com.proj.code.db_jdbc.preparedstatement;

import com.proj.code.db_jdbc.jdbcutils.JdbcUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Snippet {
    @Test
    public void test() throws Exception {
        FileInputStream fis = new FileInputStream("C:/Users/Administration/Desktop/hzw.jpg");

        Connection conn = JdbcUtils.getConnection();

        String sql = "UPDATE t_user SET photo = ? WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setObject(1, fis);
        statement.setObject(2, 1);

        int len = statement.executeUpdate();

        System.out.println(len > 0 ? "更新成功" : "更新失败");

        statement.close();
        conn.close();
        fis.close();

    }
}
