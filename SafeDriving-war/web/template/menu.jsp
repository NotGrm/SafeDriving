<%-- 
    Document   : menu
    Created on : 17 juin 2011, 09:43:11
    Author     : Grm
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.safedriving.model.InscritForum"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
    ArrayList<String[]> redactionLinks = new ArrayList<String[]>();
    redactionLinks.add(new String[]{"/SafeDriving-war/auth/AddArticle", "Ajout Article"});
    redactionLinks.add(new String[]{"/SafeDriving-war/auth/AddCategorie", "Ajout Categorie"});
    redactionLinks.add(new String[]{"/SafeDriving-war/auth/AddTag", "Ajout d'un Tag"});
    pageContext.setAttribute("redactionLinks", redactionLinks);

    ArrayList<String[]> clientLinks = new ArrayList<String[]>();
    clientLinks.add(new String[]{"/SafeDriving-war/auth/Planning", "Voir Planning"});
    clientLinks.add(new String[]{"/SafeDriving-war/auth/RegisterToSession", "Inscription à une session"});
    pageContext.setAttribute("clientLinks", clientLinks);

    ArrayList<String[]> agenceLinks = new ArrayList<String[]>();

    agenceLinks.add(new String[]{"/SafeDriving-war/auth/AddClient", "Ajout Client"});
    agenceLinks.add(new String[]{"/SafeDriving-war/auth/AddSessionPratique", "Ajout Session Pratique"});
    agenceLinks.add(new String[]{"/SafeDriving-war/auth/AddSessionTheorique", "Ajout Session Theorique"});
    agenceLinks.add(new String[]{"/SafeDriving-war/auth/ShowClients", "Liste Clients"});
    pageContext.setAttribute("agenceLinks", agenceLinks);

    ArrayList<String[]> formationLinks = new ArrayList<String[]>();
    formationLinks.add(new String[]{"/SafeDriving-war/auth/Planning", "Voir Planning"});
    formationLinks.add(new String[]{"/SafeDriving-war/auth/AddNote", "Ajout Note"});
    formationLinks.add(new String[]{"/SafeDriving-war/auth/accessDenied.jsp", "Indiqué Disponibilités"});
    pageContext.setAttribute("formationLinks", formationLinks);

    ArrayList<String[]> directionLinks = new ArrayList<String[]>();
    directionLinks.add(new String[]{"/SafeDriving-war/auth/AddPersonnel", "Ajout Employé"});
    directionLinks.add(new String[]{"/SafeDriving-war/auth/ShowEmployes", "Liste Employés"});
    directionLinks.add(new String[]{"/SafeDriving-war/auth/AddExamen", "Ajout Examen"});
    directionLinks.add(new String[]{"/SafeDriving-war/auth/AddTypeExamen", "Ajout Type Examen"});
    directionLinks.add(new String[]{"/SafeDriving-war/auth/AddVehicule", "Ajout Véhicule"});
    directionLinks.add(new String[]{"/SafeDriving-war/auth/AddLieu", "Ajout Lieu"});
    directionLinks.add(new String[]{"/SafeDriving-war/auth/AddTypePratique", "Ajout Type Pratique"});
    directionLinks.add(new String[]{"/SafeDriving-war/auth/AddRole", "Ajout Role"});

    pageContext.setAttribute("directionLinks", directionLinks);
%>



<c:if test="${user != null}">
    <nav >
        <!--<ul>-->
        <c:set var="roleName" value="${user.getRole().roleName}"/>
        <c:choose>
            <c:when test="${'DIRECTION' == roleName}">
                <!--<li><a href="/SafeDriving-war/auth/AddArticle">Ajout Article</a></li>
                <li><a href="/SafeDriving-war/auth/AddArticle">Ajout Tag</a></li>
                <li><a href="/SafeDriving-war/auth/AddArticle">Ajout Categorie</a></li>-->
                <ul> <h3>Rédaction</h3>
                    <c:forEach items="${redactionLinks}" var="link">
                        <li><a href="${link[0]}">${link[1]}</a></li>
                    </c:forEach>
                </ul>
                <ul> <h3>Agence</h3>
                    <c:forEach items="${agenceLinks}" var="link">
                        <li><a href="${link[0]}">${link[1]}</a></li>
                    </c:forEach>
                </ul>
                <ul> <h3>Formation</h3>
                    <c:forEach items="${formationLinks}" var="link">
                        <li><a href="${link[0]}">${link[1]}</a></li>
                    </c:forEach>
                </ul>
                <ul> <h3>Direction</h3>
                    <c:forEach items="${directionLinks}" var="link">
                        <li><a href="${link[0]}">${link[1]}</a></li>
                    </c:forEach>
                </ul>
                <!--<ul>
                    <li><a href="/SafeDriving-war/auth/AddExamen">Ajout Examen</a></li>
                    <li><a href="/SafeDriving-war/auth/AddVehicule">Ajout Véhicule</a></li>
                    <li><a href="/SafeDriving-war/auth/AddLieu">Ajout Lieu</a></li>
                    <li><a href="/SafeDriving-war/auth/AddTypeExamen">Ajout Type Examen</a></li>
                    <li><a href="/SafeDriving-war/auth/AddTypePratique">Ajout Type Pratique</a></li>-->
                </c:when>                    
                <c:when test="${'REDACTION' == roleName}">
                    <!--<li><a href="/SafeDriving-war/auth/AddArticle">Ajout d'un Article</a></li>
                    <li><a href="/SafeDriving-war/auth/AddArticle">Ajout d'un Tag</a></li>
                    <li><a href="/SafeDriving-war/auth/AddArticle">Ajout d'une Categorie</a></li>-->
                    <ul> <h3>Rédaction</h3>
                        <c:forEach items="${redactionLinks}" var="link">
                            <li><a href="${link[0]}">${link[1]}</a></li>
                        </c:forEach>
                    </ul>
                </c:when>                   
                <c:when test="${'GESTION_AGENCE' == roleName}">
                    <!--<li><a href="/SafeDriving-war/auth/AddPersonnel">Ajout d'un employée</a></li>
                    <li><a href="/SafeDriving-war/auth/AddClient">Ajout d'un client</a></li>
                    <li><a href="/SafeDriving-war/auth/AddExamen">Ajout d'un examen</a></li>
                    <li><a href="/SafeDriving-war/auth/AddSessionPratique">Ajout d'une session pratique</a></li>
                    <li><a href="/SafeDriving-war/auth/AddSessionTheorique">Ajout d'une session theorique</a></li>
                    <li><a href="/SafeDriving-war/auth/AddVehicule">Ajout d'un véhicule</a></li>
                    <li><a href="/SafeDriving-war/auth/AddLieu">Ajout d'un lieu</a></li>
                    <li><a href="/SafeDriving-war/auth/AddTypeExamen">Ajout d'un type d'examen</a></li>
                    <li><a href="/SafeDriving-war/auth/Planning">Planning</a></li>
                    <li><a href="/SafeDriving-war/auth/ShowClients">Listee des clients</a></li>
                    <li><a href="/SafeDriving-war/auth/ShowEmployes">Listee des employes</a></li>-->
                    <ul> <h3>Agence</h3>
                        <c:forEach items="${agenceLinks}" var="link">
                            <li><a href="${link[0]}">${link[1]}</a></li>
                        </c:forEach>
                    </ul>
                </c:when>                
                <c:when test="${'SERVICE_FORMATION' == roleName}">
                    <!--<li><a href="/SafeDriving-war/auth/Planning">Planning</a></li>
                    <li><a href="/SafeDriving-war/auth/AddNote">Ajout Note</a></li>
                    <li>Indiqué Disponibilités</li>-->
                    <ul> <h3>Formation</h3>
                        <c:forEach items="${formationLinks}" var="link">
                            <li><a href="${link[0]}">${link[1]}</a></li>
                        </c:forEach>
                    </ul>

                </c:when>      
                <c:when test="${'CLIENT' == roleName}">
                    <!--<li><a href="/SafeDriving-war/auth/Planning">Planning</a></li>
                    <li><a href="/SafeDriving-war/auth/RegisterToSession">S'inscrire à une session</a></li>-->
                    <ul> <h3>Client</h3>
                        <c:forEach items="${clientLinks}" var="link">
                            <li><a href="${link[0]}">${link[1]}</a></li>
                        </c:forEach>
                    </ul>
                </c:when>    
            </c:choose>   

        <!--</ul>-->
    </nav>
</c:if>
