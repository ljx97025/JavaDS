package com.jxl.service;

import com.jxl.entity.Employee;
import com.jxl.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName : Service
 * @Author : ljx
 * @Date: 2021/4/30 16:31
 * @Description : 服务
 */
@Service
public class ServiceImp {

    // 自动注入问题 三种
    /**
     * field constructor  setter
     * 推荐使用 constructor
     *
     *
     *
     */
//    @Autowired
//    EmployeeDao employeeDao;
    final EmployeeDao employeeDao;
    @Autowired
    public ServiceImp(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void find(){
        Employee employee = employeeDao.findEmployeeById(101);
        System.out.println(employee);
    }

}
