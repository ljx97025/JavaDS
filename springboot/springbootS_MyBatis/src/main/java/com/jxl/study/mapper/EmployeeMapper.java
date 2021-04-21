package com.jxl.study.mapper;

import com.jxl.study.entity.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ClassName : EmployeeMapper
 * @Author : ljx
 * @Date: 2021/4/21 15:28
 * @Description :
 */
@Mapper
@Repository
public interface EmployeeMapper {
    public List<Employee> findAll();
    public Employee findEmployeeById(Integer department_id);

    /**
     * 将所有employee的数据转化为map key为列表名 value为列表名对应的值
     * @return 将所有转化为map 的employee 装在为list
     */
    public List<Map<String,Object>> findEmployeeMap();
    public Map<String,Object> findEmployeeMapById(Integer id);

    /**
     * 将所有结果以map形式返回，key为employee_id（数据库中列名） value Employee对象
     * @return
     */

    public Map<Integer,Employee> findEmployeeMapKV();

    public Employee findEmployeeByIDAndJob(@Param("id") Integer id);

    public List<Employee> findEmployByDepartmentID(@Param("id")Integer id,Integer manager_id);
}
