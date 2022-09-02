<%@ page import="com.example.library.userServlets.AuthorizationUserServlet" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/22/2022
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My account</title>
    <link rel="stylesheet" href="styles/styles.less">
</head>
<div class="topnav">
    <a href="viewMyBook">View my book</a>
    <% if (AuthorizationUserServlet.role.equals("Admin")) { %>
    <a  href="viewUsersOrders">View users orders</a>
    <a  href="viewUsers">View Users</a>
    <a href="save_book.jsp">Save book</a>
    <a href="sign_up.jsp">Create User</a>
    <% }
    %>


</div>
<table border="1" bgcolor=#bfa798 width=100%>
    <tr align=center>
        <td colspan=2 style="color:#950000; font-size:14pt">
            My account</td></tr>
    <tr align=left>

        <td bgcolor=#ebebeb>
            <a href="index.jsp">Sign out</a>
            <% if (AuthorizationUserServlet.role.equals("Admin")) { %>

            <br><br>

            <form method="post" action="blockUser">
                <br><br>


                <br><br>
                <button name="button">Block user</button>
                Login user:<input type="text" name="login">
                <div>
                    <input type="radio" id="1"
                           name="isblocked" value="1"checked>
                    <label for="1">Block</label>

                    <input type="radio" id="2"
                           name="isblocked" value="2">
                    <label for="2">Unblock</label>

                </div>
            </form>

            <form method="post" action="deleteUser">
                <br><br>


                <button name="button">Delete user</button>

                <br><br>
                Login user:<input type="text" name="login">
            </form>


            <form class="form" action="viewUsersOrders">
                <p class="form__title">View all users orders</p>
                <div>
                    <button type="submit">View</button>

                </div>
            </form>

            <% }
            %>


            <br>
            <br>



            <br>
            <br>

            <br>
            <br>
            <form method="post" action="returnBook">
                <br><br>
                Enter name returned book :<input type="text" name="name">

                <br><br>
                <button name="button">Return book</button>

            </form>


            <form method="post" action="takeBook">
                <br><br>
                Take book
                Name:<input type="text" name="name">
                <br><br>
                <button name="button">Enter</button>

            </form>

        </td>


        <td style="width:20%">
            <p>Name: <%=AuthorizationUserServlet.login%></p>
            <p>Role: <%= AuthorizationUserServlet.role %></p>
            <a href="http://localhost:8888/Library_war_exploded/change_password.jsp">Change password</a>

        </td></tr>
    <tr align=center><td colspan=2>Подвал сайта</td></tr>
</table>


<br><br>
</body>
</html>
