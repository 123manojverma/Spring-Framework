package com.example.filterdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        long startTime=System.currentTimeMillis();

        HttpServletRequest httpRequest=(HttpServletRequest) request;

        HttpServletResponse httpResponse=(HttpServletResponse) response;

        String requestId= UUID.randomUUID().toString();

        httpResponse.setHeader("X-Request-ID",requestId);

//        Request Log
        System.out.println("Incoming Request : "+httpRequest.getMethod()+" "+ httpRequest.getRequestURI());

        chain.doFilter(request,response);

        long duration=System.currentTimeMillis()-startTime;

//        Response Log
        System.out.println("Response status : "+httpResponse.getStatus());

        System.out.println("API response time : "+duration);

    }
}
