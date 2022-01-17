package com.proj.code.enumtype;

import com.proj.code.bean.Employee;

public class StatusEnumTest {
    public static void main(String[] args) {
        Employee[] arr = new Employee[5];
        arr[0] = new Employee(1,"张三", Status.BUSY);
        arr[1] = new Employee(2,"李四",Status.BUSY);
        arr[2] = new Employee(3,"王五",Status.FREE);
        arr[3] = new Employee(4,"赵六",Status.VOCATION);
        arr[4] = new Employee(5,"钱七",Status.LEFT);

        for (Employee employee : arr) {
            System.out.println(employee);
        }
    }
}
