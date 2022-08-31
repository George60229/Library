package com.example.library.userServlets;

import com.example.library.User;
import com.example.library.UserInfo;
import com.example.library.UserInfoRepository;
import com.example.library.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/viewUsersOrders")
public class ViewUsersOrdersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<UserInfo> list = UserInfoRepository.getAllUsersInfo();

        for (UserInfo myUserInfo : list) {

            out.println("<html><body>");
            out.println("<h1>" + myUserInfo + "</h1>");
            out.println("</body></html>");


        }
        out.close();
    }
}


