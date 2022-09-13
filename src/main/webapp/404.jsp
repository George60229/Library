<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/2/2022
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <link rel="stylesheet" href="styles/mistake_styles.less">

</head>
<body>
<div class="mainbox">
    <div class="err">4</div>
    <div class="err1">0</div>
    <div class="err2">4</div>
    <div class="msg"><%=session.getAttribute("error")%><p>Let's go <a href=<%=session.getAttribute("caused") %>>home</a> and try from there.</p></div>
</div>
</body>
</html>
