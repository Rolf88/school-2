<%-- 
    Document   : Login
    Created on : Feb 18, 2015, 12:57:01 PM
    Author     : RolfMoikjær
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Please Login.</h1>
        <form name="Login" action="Control" method="POST">
            <label> Username </label> <input type="text" name="id" value="" />
            <label> Password </label> <input type="password" name="pwd" value="" />
            <input type="submit" value="Ok" name="Ok" />
            <input type="hidden" name="origin" value="Login"/>
        </form>
    </body>
</html>
