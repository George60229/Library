package com.example.library.bookServlets;

import com.example.library.Book;
import com.example.library.BookRepository;
import com.example.library.UserInfoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/returnBook")
public class ReturnBookServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Book is returned...");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession();

        String login= (String) session.getAttribute("login");
        String book=request.getParameter("name");

        Book myBook=new Book();

        myBook.setName(book);
        int status= UserInfoRepository.updateAmount(myBook,login);
        if(status>0){
            BookRepository.updateAmount(myBook);
            response.sendRedirect("account.jsp");
        }
        else {
            session.setAttribute("caused","account.jsp");
            session.setAttribute("error","You don't have this book");
            response.sendError(404);
        }

        out.close();
    }
}

