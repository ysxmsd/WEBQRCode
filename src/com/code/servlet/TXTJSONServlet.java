package com.code.servlet;

import com.code.bean.CodeBean;
import com.code.service.TextProcess;
import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author conshu
 * @date 2018/8/29.
 */
public class TXTJSONServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setHeader("Access-Control-Allow-Origin", "*");

        PrintWriter out = resp.getWriter();
        resp.setCharacterEncoding("utf-8");
        TextProcess tp = new TextProcess();
        List addWorkTimeList = tp.readTEXT(req.getReader());

        Gson gson = new Gson();
        String json = gson.toJson(addWorkTimeList);
        out.write(json);

    }
}