<%-- 
    Document   : FormPage
    Created on : Feb 16, 2015, 2:27:20 PM
    Author     : RolfMoikjær
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form name="Form1" action="RecieveHTTPPostRequest" method="POST">
            <label>First name: </label> <input type='text' name='firstname'>
            <label>Age: </label> <input type='text' name='age'>
            <label>Countries: </label> <select name="selectDemo" size="5" multiple="multiple">
                <option>Danmark</option>
                <option>Norge</option>
                <option>Sverige</option>
                <option>Findland</option>
                <option>Tyskland</option>
            </select>
            <input type='submit' value='send'>
        </form>
    </body>
</html>
