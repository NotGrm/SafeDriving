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
        <title>Liste des Employés</title>
    </head>
    <body>
        <h1>Liste des employés</h1>
        <c:forEach items="${employes}" var="employe">
            <a href="/SafeDriving-war/auth/EmployeDetail?id=${employe.id}">
                <c:out value="${employe.nom}"/>
                <c:out value="${employe.prenom}"/>
            </a>
            <hr/>
        </c:forEach>
    </body>
</html>
