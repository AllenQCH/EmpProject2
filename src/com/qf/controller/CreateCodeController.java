package com.qf.controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateCodeController",value = "/createCode")
public class CreateCodeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、创建验证码图片
        ValidateCode code =new ValidateCode(200,30,4,10);
        String codes = code.getCode();
        HttpSession session = request.getSession();
        session.setAttribute("codes",codes);
        //2、验证图片响应给客户端
        code.write(response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
