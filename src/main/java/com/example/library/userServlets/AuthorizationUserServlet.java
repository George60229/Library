package com.example.library.userServlets;


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

@WebServlet("/authorizationUser")
public class AuthorizationUserServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String myPass = request.getParameter("password");
        String myLog = request.getParameter("login");
        HttpSession session=request.getSession();

        logger.info("Somebody try sign in...");




        boolean res;
        try {
            res = UserRepository.checkPass(myLog,String.valueOf(myPass.hashCode()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (res) {
            logger.info("Password is passed");
            try {
                String role=UserRepository.checkRole(myLog,String.valueOf(myPass.hashCode()));
                session.setAttribute("role",role);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            session.setAttribute("login",myLog);
            logger.info("role is set, sign in is successfully done");
            response.sendRedirect("account.jsp");

        } else {
            logger.error("Wrong login or password");
            session.setAttribute("error","Wrong login or password");
            session.setAttribute("caused","index.jsp");

            response.sendError(404);
        }

        out.close();
    }

}