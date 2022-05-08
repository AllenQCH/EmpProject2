package com.qf.controller;

import com.qf.entity.EmpManager;
import com.qf.service.EmpManagerService;
import com.qf.service.impl.EmpManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EmpManagerLoginController", value = "/manager/EmpManagerLoginController")
public class EmpManagerLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、收参
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String inputVcode = request.getParameter("inputVcode");

        //2、获取验证码
        String codes = (String) request.getSession().getAttribute("codes");
        if (!inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes)) {
            //3、调用业务方法实现登录
            EmpManagerService empManagerService = new EmpManagerServiceImpl();
            EmpManager empManager = empManagerService.login(username, password);
            //4、处理结果，流程跳转
            if (empManager != null) {
                //登陆成功
                //存放到session里面
                HttpSession session = request.getSession();
                session.setAttribute("empManager", empManager);
                //跳转到查询所有的controller
                response.sendRedirect(request.getContextPath() + "/manager/safe/showAllEmpController");
            } else {
                //登陆失败，跳转到登陆页面
                response.sendRedirect(request.getContextPath() + "/login.html");
            }
        } else {
            //验证码输入失败，跳转到登陆页面
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
