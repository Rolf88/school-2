<%-- 
    Document   : Registration
    Created on : Feb 18, 2015, 12:56:46 PM
    Author     : RolfMoikjær
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <h1>Please register a user.</h1>
        <form name="register" action="Control" method="POST">
            <input type="hidden" name="origin" value="Registration"/>
            <label>Name: </label><br>
            <input type="text" name="name" value="" /><br>
            <label>Id: </label><br>
            <input type="text" name="id" value="" /><br>
            <label>Password: </label><br>
            <input type="password" name="pwd" value="" /><br>
            <label>Age: </label><br>
            <input type="text" name="age" value="" /><br>
            <label>Gender: </label><br>
            <select name="gender">
                <option>Male</option>
                <option>Female</option>
            </select><br>
            <label>Country: </label><br>    
            <select name="country">
                <option>Danmark</option>
                <option>Tyskland</option>
                <option>England</option>
                <option>Sverige</option>
                <option>Norge</option>
            </select><br>
            <input type="submit" value="Submit" name="Submit" /><br>
            <a href="Control?origin=ListUsers">List all users</a><br>
            <a href="Control?origin=ShowUsers">Show all users</a>
        </form>
    </body>
</html>
