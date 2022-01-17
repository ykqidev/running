package com.proj.code.optional;

import com.proj.code.bean.Employee;

import java.util.ArrayList;
import java.util.Optional;

public class OptionalService {
    private ArrayList<Employee> arrayList = new ArrayList<>();

    {
        arrayList.add(new Employee(1, "刘一", 19));
        arrayList.add(new Employee(3, "孙七", 23));
    }

    public Optional<Employee> getById(int id) {
        for (Employee employee : arrayList) {
            if (employee.getId() == id) {
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }
}
