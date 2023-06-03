<%-- 
    Document   : index
    Created on : 11 трав. 2023 р., 20:58:16
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <title>Lost and Found</title>
    <style>
    .intro{
        display: flex;
        justify-content: center;
        align-items: center;
        height: 15vh;
        text-align: center;
    }
    </style>
</head>
<body>
    <%@include file="WEB-INF/jsp/header.jspf"%>
    
    <div class="split-container">
        <div class="left-half-i">
            <h1>Lost</h1>
        </div>
        <div class="right-half-i">
            <h1>Found</h1>
        </div>
    </div>
    
    <p class="intro">
        Welcome to the lost and found application! <br>
        This is a useful and versatile application for finding lost things and providing information about finds. <br>
        Fill free to use it.
    </p>
    
    <%@include file="WEB-INF/jsp/footer.jspf"%>
</body>
</html>