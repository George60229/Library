package com.example.library.bookServlets;

import com.example.library.Book;
import com.example.library.BookRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/takeBook")
public class TakeBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();



        String name = request.getParameter("name");

        Book myBook = new Book();

        myBook.setName(name);


        int status = BookRepository.update(myBook);

        if (status > 0) {
            response.sendRedirect("http://localhost:8888/Library_war_exploded/test.jsp");
        } else {
            out.println("Sorry! You can't take this book");
        }
        out.close();
    }
}
