<%-- 
    Document   : index
    Created on : 16 mai 2011, 22:28:52
    Author     : Ehres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@page import="javax.servlet.http.HttpSession"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>
            <ul>
                <li><a href="/SafeDriving-war/">Acceuil</a></li>
                <li><a href="/SafeDriving-war/auth/AddArticle">Ajout d'un Article</a></li>
                <li><a href="/SafeDriving-war/AddPersonnel">Ajout d'un employée</a></li>
                <li><a href="/SafeDriving-war/AddClient">Ajout d'un client</a></li>
                <li><a href="/SafeDriving-war/AddExamen">Ajout d'un examen</a></li>
                <li><a href="/SafeDriving-war/AddSessionPratique">Ajout d'une session pratique</a></li>
                <li><a href="/SafeDriving-war/AddSessionTheorique">Ajout d'une session theorique</a></li>
                <li><a href="/SafeDriving-war/AddVehicule">Ajout d'un véhicule</a></li>
                <li><a href="/SafeDriving-war/AddLieu">Ajout d'un lieu</a></li>
                <li><a href="/SafeDriving-war/AddTypeExamen">Ajout d'un type d'examen</a></li>
                <li><a href="/SafeDriving-war/Inscription">Inscription</a></li>
                <li><a href="/SafeDriving-war/Login">Login</a></li>
                <li><a href="/SafeDriving-war/Logout">Logout</a></li>
                
                <li> <%= session.getAttribute("username") %><br/></li>
       
            </ul>
        </div>
        <div>
            <c:forEach items="${articles}" var="article">
                <h2><c:out value="${article.titre}"/></h2>
                <c:out value="${article.text}"/>
                <a href="/SafeDriving-war/ArticleDetail?id=${article.id}">Lire la suite</a>
                <hr/>
        </c:forEach>
        </div>
    </body>
</html>
