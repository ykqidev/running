package com.proj.code.optional;

import com.proj.code.bean.Employee;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void method02(){
        OptionalService service = new OptionalService();
        Optional<Employee> employeeOptional = service.getById(1).filter(t -> t.getAge()>20);
        employeeOptional.ifPresent(System.out::println);
        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.orElseThrow(() -> new RuntimeException("传入参数错误"));
            System.out.println(employee);
        }
    }

    @Test
    public void method01(){
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
        System.out.println(empty.hashCode());

    }
}
