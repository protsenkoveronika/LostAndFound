<%-- 
    Document   : login
    Created on : 13 трав. 2023 р., 14:45:46
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/styles.css">
        <title>Log in</title>
    </head>
    <body>
        <%@include file="header.jspf"%>
        <h2>Log in to see expensive items</h2>
        <p></p>
        <p></p>
        
        <div class="center-container" >
            <div class="column">
                <div class="signup">
                    <form name="login" action="login" method="POST">
                        <label for="input-login">login: </label>
                        <input type="text" name="login" value="" /><br>
                        <label for="input-login">password: </label>
                        <input type="text" name="password" value="" /><br>
                        <p></p>
                        <input type="submit" value="log in"/>
                    </form>
                </div>
            </div>
    
            <div class="column">
                <div class="signup">
                    <form name="signup" action="signup" method="POST">
                        <label for="input-signup">Name: </label>
                        <input type="text" name="name" value="" /><br>
                        <label for="input-signup">Surname: </label>
                        <input type="text" name="surname" value="" /><br>
                        <label for="input-signup">login: </label>
                        <input type="text" name="login" value="" /><br>
                        <label for="input-signup">password: </label>
                        <input type="text" name="password" value="" /><br>
                        <p></p>
                        <input type="submit" value="sign up"/>
                    </form>
                </div>
            </div>
        </div>
        
        <%@include file="footer.jspf"%>
    </body>
</html>
