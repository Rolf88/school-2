<%-- 
    Document   : ListUsers
    Created on : Feb 19, 2015, 8:42:39 AM
    Author     : RolfMoikjær
--%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListUsers Page</title>
    </head>
    <body>
        <c:forEach var="user" items="${sessionScope.users}">
            <c:out value="${user.name}"/>
        </c:forEach>
    </body>
</html>
