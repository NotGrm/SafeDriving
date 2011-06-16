<%-- 
    Document   : showClient
    Created on : 16 juin 2011, 16:08:57
    Author     : Ehres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des clients</title>
    </head>
    <body>
        <h1>Liste des clients</h1>
        <c:forEach items="${clients}" var="client">
            <a href="/SafeDriving-war/auth/ClientDetail?id=${client.id}">
            <c:out value="${client.nom}"/>
            <c:out value="${client.prenom}"/>
            </a>
            <hr/>
        </c:forEach>
    </body>
</html>
