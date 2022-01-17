package com.proj.code.db_jdbc.dao.apache;

import com.proj.code.bean.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentDao2 {
//    void add(Department department);
//    ArrayList<Department> getAll();
//    void update(Department department);
//    void delete(int did);


    Department getById(int did);

    long count();

    List<Map<String, Object>> query();

}
