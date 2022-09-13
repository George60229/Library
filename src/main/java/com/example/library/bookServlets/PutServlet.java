package com.example.library.bookServlets;

import com.example.library.Book;
import com.example.library.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/putBook")
public class PutServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Book start changes...");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String country=request.getParameter("country");
        Book myBook = new Book();
        myBook.setId(id);
        myBook.setName(name);
        myBook.setAuthor(author);
        myBook.setCountry(country);

        int status = BookRepository.update(myBook);

        if (status > 0) {
            logger.info("Book is successfully changed ");
            response.sendRedirect("viewServlet");
        } else {
            logger.error("Book is not changed ");
            out.println("Sorry! unable to update record");
        }
        out.close();
    }
}
