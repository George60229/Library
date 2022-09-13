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

@WebServlet("/saveBook")
public class SaveServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        logger.info("Creating book...");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String country = request.getParameter("country");
        int year= Integer.parseInt(request.getParameter("year"));
        int amount=Integer.parseInt(request.getParameter("amount"));


        Book myBook = new Book();

        myBook.setName(name);
        myBook.setAuthor(author);
        myBook.setCountry(country);
        myBook.setAmount(amount);
        myBook.setYear(year);

        out.println(myBook);
        int status = BookRepository.save(myBook);


        if (status > 0) {
            logger.info("Book is created");
            out.print("Book is created!");
        } else {
            logger.info("Book is not created");
            out.println("Sorry! unable to save record");
        }
        out.close();
    }
}

