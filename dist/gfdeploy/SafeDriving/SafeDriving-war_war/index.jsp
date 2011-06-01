<%-- 
    Document   : index
    Created on : 16 mai 2011, 22:28:52
    Author     : Ehres
--%>

<%@page import="com.safedriving.model.InscritForum"%>
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
                <%
                InscritForum user;
                
                try{
                    user = (InscritForum) session.getAttribute("user");
                 }catch(Exception e){
                     user = null;
                 }
                %>
                <li><a href="/SafeDriving-war/">Acceuil</a></li>
 
                <c:choose>
                    <c:when test="${user != null}">
                        <c:set var="roleName" value="${user.getRole().roleName}"/>
                        <c:choose>
                            <c:when test="${'DIRECTION' == roleName}">
                                <li><a href="/SafeDriving-war/auth/AddArticle">Ajout d'un Article</a></li>
                                <li><a href="/SafeDriving-war/auth/AddPersonnel">Ajout d'un employée</a></li>
                                <li><a href="/SafeDriving-war/auth/AddClient">Ajout d'un client</a></li>
                                <li><a href="/SafeDriving-war/auth/AddExamen">Ajout d'un examen</a></li>
                                <li><a href="/SafeDriving-war/auth/AddSessionPratique">Ajout d'une session pratique</a></li>
                                <li><a href="/SafeDriving-war/auth/AddSessionTheorique">Ajout d'une session theorique</a></li>
                                <li><a href="/SafeDriving-war/auth/AddVehicule">Ajout d'un véhicule</a></li>
                                <li><a href="/SafeDriving-war/auth/AddLieu">Ajout d'un lieu</a></li>
                                <li><a href="/SafeDriving-war/auth/AddTypeExamen">Ajout d'un type d'examen</a></li>
                            </c:when>                    
                            <c:when test="${'REDACTION' == roleName}">
                                <li><a href="/SafeDriving-war/auth/AddArticle">Ajout d'un Article</a></li>
                            </c:when>                   
                            <c:when test="${'GESTION_AGENCE' == roleName}">
                                <li><a href="/SafeDriving-war/auth/AddPersonnel">Ajout d'un employée</a></li>
                                <li><a href="/SafeDriving-war/auth/AddClient">Ajout d'un client</a></li>
                                <li><a href="/SafeDriving-war/auth/AddExamen">Ajout d'un examen</a></li>
                                <li><a href="/SafeDriving-war/auth/AddSessionPratique">Ajout d'une session pratique</a></li>
                                <li><a href="/SafeDriving-war/auth/AddSessionTheorique">Ajout d'une session theorique</a></li>
                                <li><a href="/SafeDriving-war/auth/AddVehicule">Ajout d'un véhicule</a></li>
                                <li><a href="/SafeDriving-war/auth/AddLieu">Ajout d'un lieu</a></li>
                                <li><a href="/SafeDriving-war/auth/AddTypeExamen">Ajout d'un type d'examen</a></li>
                            </c:when>                
                            <c:when test="${'SERVICE_FORMATION' == roleName}">
                                <li><a href="/SafeDriving-war/auth/AddClient">Ajout d'un client</a></li>
                                <li><a href="/SafeDriving-war/auth/AddSessionPratique">Ajout d'une session pratique</a></li>
                                <li><a href="/SafeDriving-war/auth/AddSessionTheorique">Ajout d'une session theorique</a></li>
                                <li><a href="/SafeDriving-war/auth/AddVehicule">Ajout d'un véhicule</a></li>
                                <li><a href="/SafeDriving-war/auth/AddTypeExamen">Ajout d'un type d'examen</a></li>
                            </c:when>    
                        </c:choose>
                        <li><a href="/SafeDriving-war/Logout">Logout</a></li>  
                        <li> <%= user.getUsername()%><br/></li>                          
                    </c:when> 
                    <c:when test="${user == null}">
                        <li><a href="/SafeDriving-war/Inscription">Inscription</a></li>
                        <li><a href="/SafeDriving-war/Login">Login</a></li>                          
                    </c:when> 
                </c:choose>
                

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
