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


@WebServlet(name="saveUser",value = "/save-user")
public class SaveUserServlet extends HttpServlet {
    public void init() {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();



        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        if(password.length()<5){
            response.sendError(404, "This password is weak!!!");
            return;
        }
        if(!role.equals("Admin")&&!role.equals("Reader")&&!role.equals("Librarian")){

            response.sendError(404, "Wrong role for user!!!");
            return;
        }
        if(login.length()<5){
            response.sendError(404, "This login is little!!!");
            return;
        }



        User myUser= new User();

        myUser.setLogin(login);
        myUser.setPassword(password);
        myUser.setRole(role);
        out.println(myUser);

        int status;


        try {
            status = UserRepository.save(myUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(status==-1){
            response.sendError(404,"User exist already");
            out.close();
            return;
        }
        if (status > 0) {
            response.sendRedirect("sign_in.jsp");
            out.close();

        } if(status==0) {
            out.println("Sorry! unable to save record");

        }


    }
}


