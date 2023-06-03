<%-- 
    Document   : item
    Created on : 13 ????. 2023 ?., 09:36:05
    Author     : user
--%>


<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/styles.css">
    <title>Item Details</title>
</head>
<body>
    <%@include file="header.jspf"%>
    <h1>Item Details</h1>
    <c:if test="${item != null}">
        <p>Name: ${item.name}</p>
        <p>Description: ${item.description}</p>
        <p>Contact: ${item.contact}</p>
        <p></p>
        <form action="delete" method="POST">
            <input type="hidden" name="itemId" value="${item.id}" />
            <input type="submit" value="Delete" />
        </form>
    </c:if>
    <c:if test="${item == null}">
        <p>Item not found.</p>
    </c:if>
</body>
</html>



