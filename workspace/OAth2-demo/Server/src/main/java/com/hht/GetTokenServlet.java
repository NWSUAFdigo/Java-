package com.hht;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetTokenServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 校验授权码是否在有效期内
        String code = req.getParameter("code");
        if ("1234".equals(code)) {
            // 发放令牌
            String token = "abcdefg";
            PrintWriter writer = resp.getWriter();
            writer.print(token);
        }
    }
}
