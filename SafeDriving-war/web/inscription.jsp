<%-- 
    Document   : inscription
    Created on : 23 mai 2011, 10:33:42
    Author     : Grm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${InscriptionStatus == true}">
                <p>Inscription reussi!</p>
            </c:when>   
            <c:when test="${InscriptionStatus == false}">
                <p>Erreur lors de l'inscription</p>
            </c:when>   
            <c:otherwise>
                <h1>Inscription au forum de SafeDriving</h1>
                <form action="/SafeDriving-war/Inscription" method="POST">
                    <label for="username">Login :</label>
                    <input type="text" name="username" id="username" />
                    <label for="password">Password :</label>
                    <input type="password" name="password" id="password" />
                    <input type="submit" value="Valider"/>
                </form>
            </c:otherwise>
        </c:choose>

    </body>
</html>