package com.hht;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QQLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用QQ登录, 重定向到QQ授权页面, 并附带回调url
        String callBackUrl = "http://localhost:8080/client/callBack";
        String source = "douban";
        String redirectUrl = "http://localhost:8080/server/auth?callBackUrl=" + callBackUrl + "&source=" + source;

        resp.sendRedirect(redirectUrl);
    }
}
