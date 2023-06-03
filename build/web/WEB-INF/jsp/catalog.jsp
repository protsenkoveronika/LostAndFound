<%-- 
    Document   : catalog
    Created on : 12 трав. 2023 р., 09:20:09
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/styles.css">
        <title>Catalog</title>
    </head>
    <body>
        <%@include file="header.jspf"%>
        
        <div class="split-container">
            <div class="left-half">
                <section>
                <h2>Lost</h2>
                <div class="el">
                    <c:forEach items="${lostItems}" var="item">
                    <p><a href="item.jsp?id=${item.id}&amp;type=lost">${item.name}</a></p>
                    </c:forEach>
                </div>
                </section>
                <form name="addLost" action="addpage?type=lost" method="POST">
                    <input type="submit" value="+" name="addLost" />
                </form>
                <form name="searchLost" action="search" method="GET">
                    <input type="hidden" name="type" value="lost" />
                    <input type="text" name="info" value="" />
                    <input type="submit" value="Search" name="Search" />
                </form>
            </div>
            
            <div class="right-half">
                <section>
                <h2>Found</h2>
                <div class="el">
                    <c:forEach items="${foundItems}" var="item">
                    <p><a href="item.jsp?id=${item.id}&amp;type=found">${item.name}</a></p>
                    </c:forEach>
                </div>
                </section>
                <form name="addFound" action="addpage?type=found" method="POST">
                    <input type="submit" value="+" name="addFound" />
                </form>
                <form name="searchFound" action="search" method="GET">
                    <input type="hidden" name="type" value="found" />
                    <input type="text" name="info" value="" />
                    <input type="submit" value="Search" name="Search" />
                </form>
            </div>
        </div>
        
        <%@include file="footer.jspf"%>
    </body>
</html>

