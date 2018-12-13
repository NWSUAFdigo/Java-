package com.hht;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取用户名和密码
        String account = req.getParameter("account");
        String pwd = req.getParameter("pwd");
        if ("wudi".equals(account) && "wudi27992".equals(pwd)) {
            // 登录成功, 调用回调函数并附带授权码
            String code = "1234";
            String callBackUrl = req.getParameter("callBackUrl");
            resp.sendRedirect(callBackUrl + "?code=" + code);
        } else {
            req.setAttribute("errorMsg", "用户名或密码错误, 请重新登录");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
