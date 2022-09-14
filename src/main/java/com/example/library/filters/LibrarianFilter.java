package com.example.library.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/jsp")
public class LibrarianFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log(">>> AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        this.context.log("Requested Resource::http://localhost:8889" + uri);

        HttpSession session = req.getSession();

        if ((!session.getAttribute("role").equals("admin")||!session.getAttribute("role").equals("librarian") )&& (uri.endsWith("save_book.jsp"))) {
            this.context.log("<<< Unauthorized access request");
            ((HttpServletResponse) response).sendRedirect("404.jsp");


        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        //close any resources here
    }
}

