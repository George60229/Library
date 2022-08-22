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
import java.util.List;


@WebServlet(name="viewUsers",value = "/view-users")
public class ViewUsersServlet extends HttpServlet {
    public void init() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<User> list = UserRepository.getAllUsers();

        for (User myUser : list) {

            out.println("<html><body>");
            out.println("<h1>" + myUser + "</h1>");
            out.println("</body></html>");


        }
        out.close();
    }
}

