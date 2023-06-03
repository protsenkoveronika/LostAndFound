<%-- 
    Document   : expensive
    Created on : 12 трав. 2023 р., 08:22:51
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/styles.css">
        <title>Expensive items</title>
    </head>
    <body>
        <%@include file="header.jspf"%>
        
        <div class="split-container">
            <div class="left-half">
                <section>
                <h2>Expensive Lost</h2>
                <div class="el">
                    <c:forEach items="${explostItems}" var="expitem">
                    <p><a href="expitem.jsp?id=${expitem.id}&amp;type=explost">${expitem.name}</a></p>
                    </c:forEach>
                </div>
                </section>
                <form name="addExpLost" action="addpage?type=explost" method="POST">
                    <input type="submit" value="+" name="addExpLost" />
                </form>
                <form name="searchExpLost" action="search" method="GET">
                    <input type="hidden" name="type" value="explost" />
                    <input type="text" name="info" value="" />
                    <input type="submit" value="Search" name="Search" />
                </form>
            </div>
            
            <div class="right-half">
                <section>
                <h2>Expensive Found</h2>
                <div class="el">
                    <c:forEach items="${expfoundItems}" var="expitem">
                    <p><a href="expitem.jsp?id=${expitem.id}&amp;type=expfound">${expitem.name}</a></p>
                    </c:forEach>
                </div>
                </section>
                <form name="addExpFound" action="addpage?type=expfound" method="POST">
                    <input type="submit" value="+" name="addExpFound" />
                </form>
                <form name="searchExpFound" action="search" method="GET">
                    <input type="hidden" name="type" value="expfound" />
                    <input type="text" name="info" value="" />
                    <input type="submit" value="Search" name="Search" />
                </form>
            </div>
        </div>
        
        <%@include file="footer.jspf"%>
    </body>
</html>
