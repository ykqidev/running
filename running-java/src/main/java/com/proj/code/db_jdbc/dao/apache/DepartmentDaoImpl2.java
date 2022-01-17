package com.proj.code.db_jdbc.dao.apache;

import com.proj.code.bean.Department;

import java.util.List;
import java.util.Map;

public class DepartmentDaoImpl2 extends BasicDao2 implements DepartmentDao2 {

    @Override
    public Department getById(int did) {
        String sql = "select * from t_department where did = ?";
        try {
            return getById(Department.class, sql, did);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public long count() {
        String sql = "select count(*) from t_department";
        try {
            return (long) queryObject(sql);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Map<String, Object>> query() {
        String sql = "select t1.*,avg(did) from t_department as t1 group by did";
        try {
            return queryMap(sql);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
