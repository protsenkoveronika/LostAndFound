<%-- 
    Document   : error
    Created on : 13 трав. 2023 р., 15:38:27
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lost and Found</title>
        <link rel="stylesheet" type="text/css" href="../css/styles.css">
    </head>
    <body>
        <%@include file="header.jspf"%>
        <section>
            <h1>${message}</h1>
            <a href="/LostAndFound/do/loginpage">Log in</a>
        </section>  
        <br>
    </body>
</html>
