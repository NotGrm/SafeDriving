<%-- 
    Document   : menu
    Created on : 17 juin 2011, 09:43:11
    Author     : Grm
--%>
<%@page import="com.safedriving.model.InscritForum"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:if test="${user != null}">
    <nav >
        <ul>
            <c:set var="roleName" value="${user.getRole().roleName}"/>
            <c:choose>
                <c:when test="${'DIRECTION' == roleName}">
                    <li><a href="/SafeDriving-war/auth/AddArticle">Ajout Article</a></li>
                    <li><a href="/SafeDriving-war/auth/AddPersonnel">Ajout Employée</a></li>
                    <li><a href="/SafeDriving-war/auth/AddClient">Ajout Client</a></li>
                    <li><a href="/SafeDriving-war/auth/AddExamen">Ajout Examen</a></li>
                    <li><a href="/SafeDriving-war/auth/AddSessionPratique">Ajout Session Pratique</a></li>
                    <li><a href="/SafeDriving-war/auth/AddSessionTheorique">Ajout Session Theorique</a></li>
                    <li><a href="/SafeDriving-war/auth/AddVehicule">Ajout Véhicule</a></li>
                    <li><a href="/SafeDriving-war/auth/AddLieu">Ajout Lieu</a></li>
                    <li><a href="/SafeDriving-war/auth/AddTypeExamen">Ajout Type Examen</a></li>
                    <li><a href="/SafeDriving-war/auth/Planning">Voir Planning</a></li>
                    <li><a href="/SafeDriving-war/auth/AddTypePratique">Ajout Type Pratique</a></li>
                    <li><a href="/SafeDriving-war/auth/AddNote">Ajout Note</a></li>
                    <li><a href="/SafeDriving-war/auth/RegisterToSession">Inscription à une session</a></li>
                    <li><a href="/SafeDriving-war/auth/ShowClients">Liste des clients</a></li>
                    <li><a href="/SafeDriving-war/auth/ShowEmployes">Liste des employes</a></li>
                </c:when>                    
                <c:when test="${'REDACTION' == roleName}">
                    <li><a href="/SafeDriving-war/auth/AddArticle">Ajout d'un Article</a></li>
                    <li><a href="/SafeDriving-war/auth/Planning">Planning</a></li>
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
                    <li><a href="/SafeDriving-war/auth/Planning">Planning</a></li>
                    <li><a href="/SafeDriving-war/auth/ShowClients">Listee des clients</a></li>
                    <li><a href="/SafeDriving-war/auth/ShowEmployes">Listee des employes</a></li>
                </c:when>                
                <c:when test="${'SERVICE_FORMATION' == roleName}">
                    <li><a href="/SafeDriving-war/auth/AddClient">Ajout d'un client</a></li>
                    <li><a href="/SafeDriving-war/auth/AddSessionPratique">Ajout d'une session pratique</a></li>
                    <li><a href="/SafeDriving-war/auth/AddSessionTheorique">Ajout d'une session theorique</a></li>
                    <li><a href="/SafeDriving-war/auth/AddVehicule">Ajout d'un véhicule</a></li>
                    <li><a href="/SafeDriving-war/auth/AddTypeExamen">Ajout d'un type d'examen</a></li>
                    <li><a href="/SafeDriving-war/auth/Planning">Planning</a></li>
                </c:when>      
                <c:when test="${'CLIENT' == roleName}">
                    <li><a href="/SafeDriving-war/auth/Planning">Planning</a></li>
                    <li><a href="/SafeDriving-war/auth/RegisterToSession">S'inscrire à une session</a></li>
                </c:when>     
                <c:when test="${'FORUM' == roleName}">
                    <li><a href="/SafeDriving-war/auth/Planning">Planning</a></li>
                </c:when>    
            </c:choose>   

        </ul>
    </nav>
</c:if>
