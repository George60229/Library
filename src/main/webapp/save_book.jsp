<!--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/22/2022
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head><title>Title</title>
        <link rel="shortcut icon" href="https://img.captain-droid.com/wp-content/uploads/2014/03/ckazki-dlya-detey-icon.png.webp" type="image/x-icon"></head>
    <body>
    <form method="post" action="saveBook">

        Name: <input name="name" required/>

        Country: <input name="country"  required/>

        Amount: <input name="amount" min="1" required type="number"/>

        Author: <input name="author"  required/>

        Year: <input name="year"  max="2022" required/>




        <input type="submit" value="Submit" />
    </form>
    </body>

    </html>

