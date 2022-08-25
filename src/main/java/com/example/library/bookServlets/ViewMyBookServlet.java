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

@WebServlet("/viewMyBook")
public class ViewMyBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = AuthorizationUserServlet.login;


        String myBook = UserInfoRepository.getMyBook(name);

        out.print(myBook);
        out.close();
    }
}
