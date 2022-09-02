package com.example.library.userServlets;


import com.example.library.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/authorizationUser")
public class AuthorizationUserServlet extends HttpServlet {


    public static String login;
    public static String role;
    //todo httpSession

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String myPass = request.getParameter("password");
        String myLog = request.getParameter("login");


        login=myLog;

        boolean res;
        try {
            res = UserRepository.checkPass(myLog,String.valueOf(myPass.hashCode()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (res) {
            try {
                UserRepository.checkRole(myLog,String.valueOf(myPass.hashCode()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("account.jsp");

        } else {
            response.sendError(404, "Error, Something is wrong");
        }

        out.close();
    }

}