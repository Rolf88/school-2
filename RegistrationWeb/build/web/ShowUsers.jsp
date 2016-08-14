<%-- 
    Document   : ShowUsers
    Created on : Feb 19, 2015, 11:51:44 AM
    Author     : RolfMoikjær
--%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="Style.css" type="text/css">
    </head>
    <body>
        <form name="showAllUsers" action="Control" method="POST">
            <input type="hidden" name="origin" value="ShowUsers"/>
            <c:forEach var="user" items="${sessionScope.List}">
                <c:if test="${user.gender.equals('Female')}">
                    <div class="rm_blackborder rm_red">
                        <c:out value="${user.name}, "/>
                        <c:out value="${user.id}, "/>
                        <c:out value="${user.age}, "/>
                        <c:out value="${user.gender}, "/><br>
                    </div>
                </c:if>
                <c:if test="${user.gender.equals('Male')}">
                    <div class="rm_blackborder rm_blue">
                        <c:out value="${user.name}, "/>
                        <c:out value="${user.id}, "/>
                        <c:out value="${user.age}, "/>
                        <c:out value="${user.gender}, "/><br>
                    </div>
                </c:if>
            </c:forEach>
        </form>
    </body>
</html>
