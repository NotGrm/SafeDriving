<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
        <link type="text/css" href="../css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="../template/header.jsp" %>

        <%@include file="../template/menu.jsp" %>
        <section>
            <h2>Inscription à une session</h2>
            <form action="RegisterToSession" method="POST">
                <c:forEach var="session" items="${Lsession}">
                    <input type="radio" name="session" value="${session.id}" id="${session.id}"/>
                    <label for="${session.id}">
                        <c:out value="${session}"/> 
                        du : 
                        <fmt:formatDate type="date" value="${session.date}" />
                    </label>
                    <br/>
                </c:forEach>
                <input type="submit" value="Valider" />    
            </form>
        </section>
    </body>
</html>
