<%-- 
    Document   : Login
    Created on : Feb 17, 2015, 11:08:59 AM
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
    <center>
        <h1> Login Page </h1>
        <form name="Form1" action="Control" method="POST">
            <label> Username </label> <input type="text" name="id" value="" />
            <label> Password </label> <input type="password" name="pwd" value="" />
            <input type="submit" value="Ok" name="Ok" />
        </form>
    </center>
    </body>
</html>
