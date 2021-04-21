package com.jxl.study.controller;

import com.jxl.study.entity.Employee;
import com.jxl.study.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName : EmployeeController
 * @Author : ljx
 * @Date: 2021/4/21 15:34
 * @Description :
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;
    @GetMapping("/selectmap")
    public String selectEmp(){
        List<Employee> emps = employeeMapper.findAll();
        for(Employee emp: emps){
            System.out.println(emp);
        }
        return "ok";
    }

}
