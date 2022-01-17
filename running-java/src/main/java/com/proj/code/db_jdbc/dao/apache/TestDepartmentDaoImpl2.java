package com.proj.code.db_jdbc.dao.apache;

import com.proj.code.bean.Department;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TestDepartmentDaoImpl2 {

    @Test
    public void testGetById() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入删除部门编号");
        int id = scanner.nextInt();

        DepartmentDao2 departmentDao2 = new DepartmentDaoImpl2();

        Department department = departmentDao2.getById(id);

        System.out.println("查询成功");
        System.out.println(department);

        scanner.close();
    }

    @Test
    public void testCount() {
        DepartmentDao2 departmentDao2 = new DepartmentDaoImpl2();

        System.out.println("获取到的总数为：" + departmentDao2.count());
    }

    @Test
    public void testQueryMap() {
        DepartmentDao2 departmentDao2 = new DepartmentDaoImpl2();

        List<Map<String, Object>> mapList = departmentDao2.query();
        mapList.forEach(mapItem -> {
            Set<Map.Entry<String, Object>> entrySet = mapItem.entrySet();
            entrySet.forEach(System.out::println);
        });
    }


}
