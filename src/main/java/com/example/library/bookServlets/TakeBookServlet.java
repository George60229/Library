package com.example.library.bookServlets;

import com.example.library.*;

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
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;

@WebServlet("/takeBook")
public class TakeBookServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        logger.info("User is taking book...");
        HttpSession session=request.getSession();
        String login= (String) session.getAttribute("login");
        String name = request.getParameter("name");
        try {
            if(PenaltyRepository.checkPenalty(login)){
                logger.info("Wrong User try");
                session.setAttribute("error","You can't take books, you should pay penalty, please contact our admin");
                session.setAttribute("caused","account.jsp");
                response.sendError(404);
                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Book myBook = new Book();

        myBook.setName(name);


        int status = BookRepository.update(myBook);

        if (status > 0) {
            UserInfo myInfo=new UserInfo();
            myInfo.setLogin(login);
            myInfo.setBook(myBook.getName());

            Date date = Date.valueOf(LocalDate.now());

            myInfo.setDays(date);

            logger.info("Book is exist...");
            try {
                UserInfoRepository.save(myInfo);
                logger.info("All is done...");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("account.jsp");
        } else {
            logger.info("This book isn't exist");
            session.setAttribute("error","This book didn't exist");
            session.setAttribute("caused","account.jsp");
            response.sendError(404);
        }
        out.close();
    }
}
