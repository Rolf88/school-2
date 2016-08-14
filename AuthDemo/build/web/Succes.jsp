<%-- 
    Document   : Succes
    Created on : Feb 17, 2015, 11:08:37 AM
    Author     : RolfMoikjær
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Succes Page</title>
    </head>
    <body>
        <h1> Succes! </h1>
        <h2> Hello <%=session.getAttribute("name") %> You are now logged in!</h2>
    </body>
</html>
