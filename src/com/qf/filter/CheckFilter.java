package com.qf.filter;

import com.qf.entity.EmpManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CheckFilter",value = "/manager/safe/*")
public class CheckFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest  request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        HttpSession session = request.getSession();
        EmpManager empManager= (EmpManager)session.getAttribute("empManager");
        if(empManager!=null){//表示已经登陆
            chain.doFilter(req, resp);
        }else {
            response.sendRedirect(request.getContextPath()+"/login.html");
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
