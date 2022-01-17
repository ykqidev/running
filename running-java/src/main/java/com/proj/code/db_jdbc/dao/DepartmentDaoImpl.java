package com.proj.code.db_jdbc.dao;

import com.proj.code.bean.Department;

import java.util.ArrayList;

public class DepartmentDaoImpl extends BasicDao implements DepartmentDao {
    @Override
    public void add(Department department) {
        String sql = "insert into t_department values(null,?,?)";
        try {
            update(sql, department.getDname(), department.getDescription());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Department> getAll() {
        String sql = "select * from t_department";
        try {
            return getAll(Department.class, sql);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Department department) {
        String sql = "update t_department set dname = ? ,description =? where did = ?";
        try {
            update(sql, department.getDname(), department.getDescription(), department.getDid());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {
        String sql = "delete from t_department where did = ?";
        try {
            update(sql, id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
