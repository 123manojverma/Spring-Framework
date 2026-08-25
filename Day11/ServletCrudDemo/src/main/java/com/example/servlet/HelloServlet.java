package com.example.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet extends HttpServlet {

    public HelloServlet(){
        System.out.println("HelloServlet Constructor called");
    }

    @Override
    public void init(){
        System.out.println("init() method called");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setStatus(200);
        res.setContentType("text/plain");
        res.getWriter().write("Hello");
    }

    @Override
    public void destroy(){
        System.out.println("Destroy method called");
    }
}
