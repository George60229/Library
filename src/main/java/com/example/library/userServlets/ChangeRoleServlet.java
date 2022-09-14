package com.example.library.userServlets;

import com.example.library.User;
import com.example.library.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/changeRole")
public class ChangeRoleServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();


        String login = request.getParameter("login");
        String role = request.getParameter("role");





        User myUser = new User();


        myUser.setLogin(login);
        myUser.setRole(role);


        int status = UserRepository.updateRole(myUser);

        if (status > 0) {
            out.println("Role is changed successfully");
        } else {
            session.setAttribute("error","Role is not changed");
            session.setAttribute("caused","account.jsp");

            response.sendError(404);
        }
        out.close();
    }
}