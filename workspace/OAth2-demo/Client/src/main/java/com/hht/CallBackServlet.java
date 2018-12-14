package com.hht;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class CallBackServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        // 授权成功, 进行回调. 此时拿到授权码, 向服务器换取token
        String getTokenUrl = "http://localhost:8080/server/getToken?code=" + req.getParameter("code");
        // 发送http请求, 获取token
        String token = sendHttpRequest(getTokenUrl);

        // 继续发送请求, 获取数据
        String getInfoUrl = "http://localhost:8080/server/getUserInfo?token=" + token;
        String userInfo = sendHttpRequest(getInfoUrl);
        // 转为json对象
        JSONObject jsonObject = JSON.parseObject(userInfo);

        // 将获取到的数据返回给前台
        String helloUrl = "hello";
        resp.sendRedirect(helloUrl + "?name=" + jsonObject.getString("name")
                + "&age=" + jsonObject.getString("age")
                + "&sex=" + jsonObject.getString("sex")
                + "&errorMsg=" + jsonObject.getString("errorMsg"));
    }

    private String sendHttpRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        // 读取数据
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder(500);
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        connection.disconnect();

        return sb.toString();
    }
}
