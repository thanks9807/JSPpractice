package com.example.jsptest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet("/login")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.printf("SomeBody Come");
        System.out.println(request.getMethod());
        System.out.println(request.getRequestURI());
        System.out.println(request.getHeaderNames());
        System.out.println(request.getParameter("uid"));
        System.out.println(request.getParameter("upw"));

        String id = request.getParameter("uid");
        String pw = request.getParameter("upw");
        JDBCTest jdbcTest = new JDBCTest();
        PrintWriter printWriter = response.getWriter();
        printWriter.write(jdbcTest.login(id,pw));

    }

    public void destroy() {
    }
}