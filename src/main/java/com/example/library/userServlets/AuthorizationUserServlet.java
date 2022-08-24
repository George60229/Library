package com.example.library.userServlets;

import com.example.library.User;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String myPass = request.getParameter("password");

        String myLog=request.getParameter("login");


        boolean res;
        try {
            res = UserRepository.checkPass(myPass,myLog);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (res) {
            response.sendRedirect("account.jsp");
        } else {
            response.sendRedirect("sign_in.jsp");
        }
        out.close();
    }
}