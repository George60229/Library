package com.example.library.bookServlets;



import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//old
@WebServlet("/checkOrderBook")
public class CheckOrderBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");


        String sid =request.getParameter("contact");
        switch (sid){
            case "1":response.sendRedirect("viewBooksOrderByAuthor");
            break;
            case "2":response.sendRedirect("viewBooksOrderByCountry");
                break;
            case "3":response.sendRedirect("viewBooksOrderByName");
                break;
            case "4":response.sendRedirect("viewBooksOrderByYear");
                break;
        }




    }
}

