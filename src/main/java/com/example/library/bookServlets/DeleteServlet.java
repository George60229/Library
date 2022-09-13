package com.example.library.bookServlets;

import com.example.library.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteBook")
public class DeleteServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Book is ready to delete...");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        if(id<0){
            logger.error("Book is not deleted");
            response.sendError(404, "Wrong id !!!");
            return;
        }
        BookRepository.delete(id);
        logger.info("Book is successfully deleted");
        response.sendRedirect("viewServlet");
    }
}


