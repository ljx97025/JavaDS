package com.jxl.study.entity;

import java.util.List;

/**
 * @ClassName : Department
 * @Author : ljx
 * @Date: 2021/4/6 9:10
 * @Description : 部门
 */
public class Department {
    private Integer departmentID;
    private String departmentName;
    private Integer managerID;
    private Integer locationID;

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department(Integer departmentID, String departmentName, Integer managerID, Integer locationID) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.managerID = managerID;
        this.locationID = locationID;
    }

    public Department() {
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getManagerID() {
        return managerID;
    }

    public void setManagerID(Integer managerID) {
        this.managerID = managerID;
    }

    public Integer getLocationID() {
        return locationID;
    }

    public void setLocationID(Integer locationID) {
        this.locationID = locationID;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", departmentName='" + departmentName + '\'' +
                ", managerID=" + managerID +
                ", locationID=" + locationID +
                ", employees=" + employees +
                '}';
    }
}
