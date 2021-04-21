package com.example.demo.contoller;

import com.example.demo.mult.DataSourceAnnotation;
import com.example.demo.mult.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName : EmpController
 * @Author : ljx
 * @Date: 2021/4/21 11:36
 * @Description :
 */
@RestController
public class EmpController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/local")
    @DataSourceAnnotation(value = DataSourceType.LOCAL)
    public List<Map<String, Object>> local(){
        System.out.println("-----------------local");
        String sql = "Select * from employees";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        return mapList;
    }

    @GetMapping("/remote")
    @DataSourceAnnotation(value = DataSourceType.REMOTE)
    public List<Map<String, Object>> remote(){
        System.out.println("-----------------remote");
        String sql = "Select * from employees";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        return mapList;
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
