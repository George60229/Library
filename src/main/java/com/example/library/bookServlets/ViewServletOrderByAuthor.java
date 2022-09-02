package com.example.library.bookServlets;

import com.example.library.Book;
import com.example.library.BookRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/viewBooksOrderByAuthor")

public class ViewServletOrderByAuthor extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        PrintWriter out = response.getWriter();

        response.sendRedirect("show_books.jsp");



        out.close();

    }
}
