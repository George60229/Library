<!--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/22/2022
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head><title>Title</title></head>
    <body>
    <form method="post" action="saveBook">

        Name: <input name="name" />

        Country: <input name="country"  />

        Amount: <input name="amount" min="1"/>

        Author: <input name="author"  />

        Year: <input name="year"  max="2022"/>




        <input type="submit" value="Submit" />
    </form>
    </body>

    </html>

