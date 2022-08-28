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
    <title>Title</title>
</head>

<table border="1" bgcolor=#bfa798 width=100%>
    <tr align=center>
        <td colspan=2 style="color:#950000; font-size:14pt">
            My account</td></tr>
    <tr align=left>

        <td bgcolor=#ebebeb>

            <% if (AuthorizationUserServlet.role.equals("Admin")) { %>
            <a href="http://localhost:8888/Library_war_exploded/save_book.jsp">Save book</a>
            <% }
            %>


            <br>
            <br>



            <br>
            <br>
            <a href="viewMyBook">View my Books</a>
            <br>
            <br>
            <form method="post" action="returnBook">
                <br><br>


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
        </td></tr>
    <tr align=center><td colspan=2>Подвал сайта</td></tr>
</table>


<br><br>







</body>
</html>
