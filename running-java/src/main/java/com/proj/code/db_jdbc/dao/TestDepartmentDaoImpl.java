package com.proj.code.db_jdbc.dao;

import com.proj.code.bean.Department;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class TestDepartmentDaoImpl {

    @Test
    public void testAdd(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入部门名称");
        String name = scanner.nextLine();

        System.out.println("请输入部门详情");
        String desc = scanner.nextLine();

        Department department = new Department(10,name,desc);

        DepartmentDao departmentDao = new DepartmentDaoImpl();

        departmentDao.add(department);

        System.out.println("添加成功");

        scanner.close();
    }

    @Test
    public void testGetAll(){
        DepartmentDao departmentDao = new DepartmentDaoImpl();

        ArrayList<Department> departments = departmentDao.getAll();
        departments.forEach(System.out::println);
    }

    @Test
    public void testUpdate(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入修改的部门编号：");
        int id = scanner.nextInt();

        System.out.println("请输入部门名称：");
        String name = scanner.nextLine();

        System.out.println("请输入部门详情：");
        String desc = scanner.nextLine();

        Department department = new Department(id,name,desc);

        DepartmentDao departmentDao = new DepartmentDaoImpl();

        departmentDao.update(department);

        System.out.println("修改成功");

        scanner.close();
    }

    @Test
    public void testDelete(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入删除部门编号");
        int id = scanner.nextInt();

        DepartmentDao departmentDao = new DepartmentDaoImpl();

        departmentDao.delete(id);

        System.out.println("删除成功");

        scanner.close();
    }
}
