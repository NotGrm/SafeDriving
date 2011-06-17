<%-- 
    Document   : clientDetail
    Created on : 16 juin 2011, 16:45:11
    Author     : Ehres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail de l'employé</title>
    </head>
    <body>
        <%@include file="../template/header.jsp" %>
        <h1>Detail de l'employé</h1>
        <%@include file="../template/menu.jsp" %>
        <section>
            <p>nom : <c:out value="${employe.nom}  "/></p>
            <p>Prénom : <c:out value="${employe.prenom}  "/></p>
            <p>Adresse : <c:out value="${employe.adresse} "/></p>
            <p>Code Postal : <c:out value="${employe.codePostal}"/></p>
            <p>Date de Naissance : <c:out value="${employe.dateNaissance}"/></p>
            <p>Ville : <c:out value="${employe.ville}"/></p>
            <p>UserName : <c:out value="${compteWeb.username}"/></p>
            <br/>
            <c:if test="${compteWeb == null}">
                <a href="/SafeDriving-war/auth/EmployeDetail?id=${employe.id}&changeCompteWeb=${true}">Ajouter un Compte Web</a>
            </c:if>
        </section>
    </body>

</html>
