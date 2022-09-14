package com.example.library.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class JspFilter implements Filter {



    public void init(FilterConfig fConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();



        HttpSession session = req.getSession();

        if (session.getAttribute("role") == null && uri.endsWith("jsp")&&!uri.endsWith("show_books.jsp")&&!uri.endsWith("show_books_1.jsp")&&!uri.endsWith("show_books_2.jsp")&&!uri.endsWith("show_books_3.jsp")&&!uri.endsWith("index.jsp")) {

                PrintWriter out = res.getWriter();
                out.println("No access!!!");


        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        //close any resources here
    }
}
