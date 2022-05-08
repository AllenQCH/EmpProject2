package com.qf.jsp;

import com.qf.entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ShowAllEmpJSP",value = "/manager/safe/showAllEmpJSP")
public class ShowAllEmpJSP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取集合数据
        List<Emp> emps = (List<Emp>)request.getAttribute("emps");

        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='utf-8'>");
        printWriter.println("<title>查询所有员工页面</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<table border='1'>");
        printWriter.println("<tr>");
        printWriter.println("<td>编号</td>");
        printWriter.println("<td>姓名</td>");
        printWriter.println("<td>工资</td>");
        printWriter.println("<td>年龄</td>");
        printWriter.println("<td>操作</td>");
        printWriter.println("</tr>");
        for (Emp emp:emps) {
            printWriter.println("<tr>");
            printWriter.println("<td>"+emp.getId()+"</td>");
            printWriter.println("<td>"+emp.getName()+"</td>");
            printWriter.println("<td>"+emp.getSalary()+"</td>");
            printWriter.println("<td>"+emp.getAge()+"</td>");
            printWriter.println("<td>删除</td>");
            printWriter.println("<td>修改</td>");
            printWriter.println("</tr>");
        }


        printWriter.println("</body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
