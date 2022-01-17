package com.proj.code.db_jdbc.dao.apache;

import com.proj.code.db_jdbc.jdbcutils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class BasicDao2 {
    private QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDs());

    public int update(String sql, Object... args) throws Exception {
        return queryRunner.update(sql, args);
    }

    public int update(Connection conn, String sql, Object... args) throws Exception {
        return queryRunner.update(conn, sql, args);
    }


    public <T> List<T> getAll(Class<T> clazz, String sql, Object... args) throws Exception {
        return queryRunner.query(sql, new BeanListHandler<T>(clazz), args);
    }

    public <T> T getById(Class<T> clazz, String sql, Object... args) throws Exception {
        return queryRunner.query(sql, new BeanHandler<>(clazz), args);
    }

    /**
     * 单个值，查询总记录数，最高工资，最低值，平均值
     */
    public Object queryObject(String sql, Object... args) throws Exception {
        return queryRunner.query(sql, new ScalarHandler<>(), args);
    }

    /**
     * 按部门查询平均工资
     */
    public List<Map<String, Object>> queryMap(String sql, Object... args) throws Exception {
        return queryRunner.query(sql, new MapListHandler(), args);
    }
}
