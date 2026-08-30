package com.example.filterdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest=(HttpServletRequest) request;

        HttpServletResponse httpResponse=(HttpServletResponse) response;

        String token=httpRequest.getHeader("token");
        String apikey=httpRequest.getHeader("x-api-key");

        if(token==null || !token.equals("12345")){
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if(apikey==null || !apikey.equals("secret123")){
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            httpResponse.setContentType("applicaiton/json");

            httpResponse.getWriter().write(
                    "{\n" +
                            "    \"message\":\"Invalid or missing Api key\"\n" +
                            "}"
            );

            return;
        }

        chain.doFilter(request,response);
    }
}
