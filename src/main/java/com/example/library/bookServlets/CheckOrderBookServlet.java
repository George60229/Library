package com.example.library.bookServlets;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//old
@WebServlet("/checkOrderBook")
public class CheckOrderBookServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        HttpSession session= request.getSession();

        String sid =request.getParameter("contact");
        logger.info("Choose orderBy method...");
        switch (sid){
            case "author":
                response.sendRedirect("show_books.jsp");
                break;
            case "country":
                response.sendRedirect("show_books_1.jsp");
                break;
            case "name":
                response.sendRedirect("show_books_2.jsp");
                break;
            case "year":
                response.sendRedirect("show_books_3.jsp");
                break;

        }
        logger.info("Method is chosen successfully");

        //todo session dont work

    }
}

