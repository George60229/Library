package com.example.library.penaltyServlets;

import com.example.library.PenaltyRepository;
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

@WebServlet("/removePenalty")
public class RemovePenaltyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();


        String login = request.getParameter("login");







        int status = PenaltyRepository.removePenalty(login);

        if (status > 0) {
            response.sendRedirect("account.jsp");
        } else {
            session.setAttribute("error","Penalty is not removed");
            session.setAttribute("caused","account.jsp");

            response.sendError(404);
        }
        out.close();
    }
}
