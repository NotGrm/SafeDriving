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
        <link type="text/css" href="../css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="../template/header.jsp" %>
        <%@include file="../template/menu.jsp" %>
        <section>
            <h2>Liste des clients</h2>

            <c:forEach items="${clients}" var="client">
                <a href="/SafeDriving-war/auth/ClientDetail?id=${client.id}">
                    <c:out value="${client.nom}"/>
                    <c:out value="${client.prenom}"/>
                </a>
                <hr/>
            </c:forEach>
        </section>
    </body>
</html>
