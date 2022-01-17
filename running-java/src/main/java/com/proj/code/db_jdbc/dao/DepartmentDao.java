package com.proj.code.db_jdbc.dao;

import com.proj.code.bean.Department;

import java.util.ArrayList;

public interface DepartmentDao {
    void add(Department department);

    ArrayList<Department> getAll();

    void update(Department department);

    void delete(int did);

}
