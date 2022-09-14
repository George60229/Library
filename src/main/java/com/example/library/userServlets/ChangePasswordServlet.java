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

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();



        String newPassword = request.getParameter("new_password");
        String newPasswordRepeated = request.getParameter("repeated_password");

       if(!newPassword.equals(newPasswordRepeated)){
           response.sendError(404,"Password is not repeated correctly ");
       }



        User myUser = new User();

        HttpSession session=request.getSession();
        String login= (String) session.getAttribute("login");
        myUser.setLogin(login);
        myUser.setPassword(newPassword);


        int status = UserRepository.updatePass(myUser);

        if (status > 0) {
            response.sendRedirect("account.jsp");
        } else {
            session.setAttribute("error","Password is not changed");
            session.setAttribute("caused","change_password.jsp");

            response.sendError(404);
        }
        out.close();
    }
}
