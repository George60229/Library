package com.example.library.bookServlets;

import com.example.library.Book;
import com.example.library.BookRepository;
import com.example.library.UserInfo;
import com.example.library.UserInfoRepository;
import com.example.library.userServlets.AuthorizationUserServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/returnBook")
public class ReturnBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();




        String book=request.getParameter("name");

        Book myBook=new Book();

        myBook.setName(book);
        BookRepository.updateAmount(myBook);
        UserInfoRepository.updateAmount(myBook);

        response.sendRedirect("http://localhost:8888/Library_war_exploded/account.jsp");

        out.close();
    }
}

