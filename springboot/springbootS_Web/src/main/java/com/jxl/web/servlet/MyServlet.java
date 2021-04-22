package com.jxl.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : MyServlet
 * @Author : ljx
 * @Date: 2021/4/22 18:42
 * @Description :
 */
//@WebServlet(name = "myServlet",urlPatterns = {"/srv"})
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("第一个servlet");
        super.doGet(req, resp);
    }
}
