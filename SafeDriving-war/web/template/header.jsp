<%-- 
    Document   : header
    Created on : 17 juin 2011, 09:42:58
    Author     : Grm
--%>

<%@page import="com.safedriving.model.InscritForum"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<header class="pageheader">
    <div>
        <h1>Safe-Driving</h1>
    </div>
    <nav class="header">
        <ul>
            <li><a href="/SafeDriving-war/Home"> Accueil</a></li>
        <c:choose>
            <c:when test="${user != null}">
                <li><a href="/SafeDriving-war/Logout">Logout</a></li>  
                <li> Log as : ${user.getUsername()}</li>                          
                </c:when>
                <c:otherwise>
                <li><a href="/SafeDriving-war/Inscription">Inscription</a></li>
                <li><a href="/SafeDriving-war/Login">Login</a></li> 
            </c:otherwise>
        </c:choose>
        </ul>
    </nav>
    
</header>
