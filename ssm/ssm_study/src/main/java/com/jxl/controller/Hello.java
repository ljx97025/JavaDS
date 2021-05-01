package com.jxl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName : Hello
 * @Author : ljx
 * @Date: 2021/5/1 17:41
 * @Description :
 */
@Controller
public class Hello {
    @GetMapping("/hello")
    public String show(){
        System.out.println("hello");
        return "hello";
    }
}
