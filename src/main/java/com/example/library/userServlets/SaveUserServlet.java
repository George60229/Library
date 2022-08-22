package com.example.library.userServlets;

import com.example.library.User;
import com.example.library.UserRepository;
import static java.lang.System.out;
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
        try {
            if(UserRepository.checkLogin(login)){
                response.sendError(404, "This user exist!!!");
                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        User myUser= new User();

        myUser.setLogin(login);
        myUser.setPassword(password);
        myUser.setRole(role);
        out.println(myUser);

        int status = 0;


        status = UserRepository.save(myUser);


        if (status > 0) {
            out.println("Record saved successfully!");
        } else {
            out.println("Sorry! unable to save record");
        }
        response.sendRedirect("sign_in.jsp");
        out.close();

    }
}


