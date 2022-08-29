package com.example.library.bookServlets;

import com.example.library.Book;
import com.example.library.BookRepository;
import com.example.library.UserInfo;
import com.example.library.UserInfoRepository;
import com.example.library.userServlets.AuthorizationUserServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/viewMyBook")
public class ViewMyBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = AuthorizationUserServlet.login;

        List<Book> result=UserInfoRepository.getMyBook(name);
        for (Book myBook : result) {

            out.println("<h1>" + myBook.getName() + "</h1>");


        }

        out.close();
    }
}
