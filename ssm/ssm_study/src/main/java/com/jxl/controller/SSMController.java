package com.jxl.controller;

import com.jxl.entity.Employee;
import com.jxl.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName : SSMController
 * @Author : ljx
 * @Date: 2021/4/11 10:32
 * @Description :
 */
@Controller
public class SSMController {

//    private final EmployeeDao employeeDao;
//
//    @Autowired
//    public SSMController(EmployeeDao employeeDao) {
//        this.employeeDao = employeeDao;
//    }
    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/test")
    public String test(Model model){
        System.out.println("test");
        Employee employee = employeeDao.findEmployeeById(101);
        System.out.println(employee);
        model.addAttribute("employee",employee.getFirstName());
        return "hello";
    }
}
