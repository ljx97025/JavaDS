package com.jxl.dao;

import com.jxl.entity.Department;

import java.util.List;

/**
 * @ClassName : DepartmentDao
 * @Author : ljx
 * @Date: 2021/4/6 9:29
 * @Description :
 */
public interface DepartmentDao {
    public List<Department> findAll();
    public Department findDepartmentAllEmployeeByID(Integer id);
    public Department findDepartmentAllEmployeeByIDSimple(Integer id);
}
