<%-- 
    Document   : add
    Created on : 28 трав. 2023 р., 21:57:41
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/styles.css">
        <title>Add Item</title>
    </head>
    <body>
        <%@include file="header.jspf"%>
        
        <h1>Fill the form to add item</h1>
        <div class="signup">
        <form name="add" action="add" method="POST">
            <input type="hidden" name="type" value="${param.type}" />
            <label for="input-name">Name:</label>
            <input type="text" name="name" value="" /><br>
            <p></p>
            <label for="input-description">Description:</label>
            <input type="text" name="description" value="" /><br>
            <p></p>
            <label for="input-contact">Contact number:</label>
            <input type="text" name="contact" value="" /><br>
            <p></p>
            <input type="submit" value="Done" />
        </form>
        </div>
    </body>
</html>
