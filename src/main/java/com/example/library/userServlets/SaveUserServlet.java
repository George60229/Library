package com.example.library.userServlets;

import com.example.library.User;
import com.example.library.UserRepository;
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
import java.sql.SQLException;


@WebServlet("/saveUser")
public class SaveUserServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();
    public void init() {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Trying to sign up");
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        HttpSession session =request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");







        User myUser= new User();

        myUser.setLogin(login);
        myUser.setPassword(password);
        myUser.setRole("Reader");
        out.println(myUser);

        int status;


        try {
            status = UserRepository.save(myUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(status==-1){
            logger.error("User exist already");
            session.setAttribute("caused","index.jsp");
            session.setAttribute("error","User exist already");
            response.sendError(404);

        }
        if (status > 0) {
            logger.info("Sign up is successfully done");
            response.sendRedirect("index.jsp");
            out.close();

        } if(status==0) {
            logger.error("User is didn't saved in DB");
            session.setAttribute("caused","account.jsp");
            session.setAttribute("error","Registration is not passed, try it later");
            response.sendError(404);

        }


    }
}


