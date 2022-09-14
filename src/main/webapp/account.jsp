<%@ page import="com.example.library.userServlets.AuthorizationUserServlet" %>
<%@ page import="com.example.library.Book" %>
<%@ page import="com.example.library.BookRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.library.UserInfoRepository" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/22/2022
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="shortcut icon" href="https://img.captain-droid.com/wp-content/uploads/2014/03/ckazki-dlya-detey-icon.png.webp" type="image/x-icon">
    <title>My account</title>
    <link rel="stylesheet" href="styles/styles.less">
</head>
<div class="topnav">



    <% if (session.getAttribute("role").equals("Admin")) { %>
    <a  href="show_users_orders.jsp">View users orders</a>
    <a  href="show_users.jsp">View Users</a>
    <a href="enter.jsp">Create User</a>
    <% }
    %>

    <% if (session.getAttribute("role").equals("Admin")||session.getAttribute("role").equals("Librarian")) { %>
        <a href="save_book.jsp">Save book</a>

    <% }
    %>

    <a href="search_book.jsp">Find book</a>
    <a href="change_password.jsp">Change password</a>
    <a href="index.jsp">Sign out</a>



</div>

<table border="1" bgcolor=#bfa798 width=100%>
    <tr align=center>
        <td colspan=2 style="color:#950000; font-size:14pt">
            <h1>Name:<%=session.getAttribute("login")%></h1>
            <br><br>
            <h1>Role:<%=session.getAttribute("role")%></h1>
            <br><br>

        </td></tr>
    <tr align=left>

        <td bgcolor=#ebebeb>

            <% if (session.getAttribute("role").equals("Admin")) { %>

            <br><br>

            <form method="post" action="blockUser">
                <br><br><br><br>





                Login user:<input type="text" name="login" required>

                <div>
                    <input type="radio" id="1"
                           name="isblocked" value="1"checked>
                    <label for="1">Block</label>

                    <input type="radio" id="2"
                           name="isblocked" value="2">
                    <label for="2">Unblock</label>

                </div>
                <br><br>
                <button name="button">Block user</button>
            </form>

            <form method="post" action="deleteUser">
                <br><br> <br><br><br><br>

                Login user:<input type="text" name="login" required>


                <br><br>
                <button name="button">Delete user</button>
            </form>
            <form method="post" action="removePenalty">
                <br><br> <br><br><br><br>
                Enter name user with penalty :<input type="text" name="login" required>

                <br><br>
                <button name="button">Remove Penalty</button>

            </form>
            <% }
            %>

                    <% if (session.getAttribute("role").equals("Admin")||session.getAttribute("role").equals("Librarian")) { %>

            <form method="get" action="deleteBook">
                <br><br> <br><br><br><br>

                Book name:<input type="text" name="name" required>


                <br><br>
                <button name="button">Delete Book</button>
            </form>
                    <% }%>

            <form method="post" action="returnBook">
                <br><br> <br><br><br><br>
                Enter name returned book :<input type="text" name="name" required>

                <br><br>
                <button name="button">Return book</button>

            </form>


            <form method="post" action="takeBook">
                <br><br> <br><br><br><br>
                Take book
                Name:<input type="text" name="name" required>
                <br><br>
                <button name="button">Enter</button>

            </form>

            <% if (session.getAttribute("role").equals("Reader")) { %>

            <a href="show_books.jsp">View all books</a>
            <% }%>
        </td>


        <td style="width:20%">

            <h1 class="enter">My books:</h1>
            <br><br>
        <%List<Book> list = UserInfoRepository.getMyBook((String) session.getAttribute("login"));
                        request.setAttribute("myList",list);%>
    <c:forEach items="${requestScope.myList}" var="book">
        <c:out value="${book.name}"/>
                <br><br>

    </c:forEach>
</table>

</html>
