package com.jxl.web.controller;

import com.jxl.web.listener.MyHttpSessionListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName : ThymeleafContoller
 * @Author : ljx
 * @Date: 2021/4/22 20:06
 * @Description :
 */
@RestController
public class ThymeleafController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        return "login";
    }

    @RequestMapping("online")
    @ResponseBody
    public String online(){
        return "当前在线人数："+ MyHttpSessionListener.online +"人";
    }

}
