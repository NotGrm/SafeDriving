<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : registerToSession
    Created on : 16 juin 2011, 15:51:57
    Author     : Grm
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
        <form action="RegisterToSession" method="POST">
            <c:forEach var="session" items="${Lsession}">
                <input type="radio" name="session" value="${session.id}">${session.date} // ${session.id}</input><br/>
            </c:forEach>
            <input type="submit" value="Valider" />    
        </form>
    </body>
</html>