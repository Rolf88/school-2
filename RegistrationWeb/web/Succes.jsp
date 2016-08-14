<%-- 
    Document   : Succes
    Created on : Feb 18, 2015, 12:57:13 PM
    Author     : RolfMoikjær
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Succes</title>
    </head>
    <body>
        <h1>Succes!</h1>
        <h2> Hello <%=session.getAttribute("name") %> You are now logged in!</h2>
    </body>
</html>
