package com.hht;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class GetUserInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        String token = req.getParameter("token");
        // 校验token
        Map<String, String> userInfo = new HashMap<>();
        if ("abcdef".equals(token)) {
            // 校验通过, 发送json数据
            userInfo.put("name", "wudi");
            userInfo.put("age", "18");
            userInfo.put("sex", "man");
        } else {
            userInfo.put("errorMsg", "token失效, 请求数据失败");
        }
        // 转为json
        String userInfoStr = JSON.toJSONString(userInfo);
        // 返回
        PrintWriter writer = resp.getWriter();
        writer.write(userInfoStr);
    }
}
