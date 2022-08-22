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

@WebServlet("/blockUser")
public class BlockUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String block=request.getParameter("isblocked");

        User myUser = new User();

        myUser.setBlocked(Boolean.parseBoolean(block));
        myUser.setId(id);


        int status = UserRepository.update(myUser);

        if (status > 0) {
            response.sendRedirect("viewUsers");
        } else {
            out.println("Sorry! unable to update record");
        }
        out.close();
    }
}



