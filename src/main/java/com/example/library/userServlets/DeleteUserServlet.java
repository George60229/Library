package com.example.library.userServlets;

import com.example.library.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String sid = request.getParameter("login");

        UserRepository.delete(sid);

        response.sendRedirect("http://localhost:8888/Library_war_exploded/account.jsp");
        out.close();
    }
}

