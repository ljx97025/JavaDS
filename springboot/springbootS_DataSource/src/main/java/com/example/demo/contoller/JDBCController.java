package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName : JDBCController
 * @Author : ljx
 * @Date: 2021/4/21 9:46
 * @Description : springboot jdbc使用
 */
@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/emplist")
    public List<Map<String, Object>> empList(){
        String sql = "Select * from employees";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        return mapList;
    }

    @GetMapping("/addEmp")
    public String addEmp(){
        String sql = "insert into employees(first_name,last_name) values('ll','ll')";
        jdbcTemplate.update(sql);
        return "success";
    }

    @GetMapping("/findEmp/{firstName}")
    public List<Map<String, Object>> findEmp(@PathVariable("firstName") String firstName){
        //通过 @PathVariable 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
        // 需要保证 url参数的值与@PathVariable()内值value相同，不一定要与处理器方法形参相同
        String sql = "Select * from employees where first_name=?";
        List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql, firstName);
        return queryForList;
    }

    @GetMapping("/deleteEmp/{firstname}")
    public String deleteEmp(@PathVariable("firstname") String firstName){
        String sql = "delete from employees where first_name=?";
        jdbcTemplate.update(sql, firstName);
        return "success";
    }

}
