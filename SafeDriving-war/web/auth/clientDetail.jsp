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
        <title>Detail du client</title>
        <link type="text/css" href="../css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="../template/header.jsp" %>

        <%@include file="../template/menu.jsp" %>
        <section>
            <h2>Détails du client</h2>
            <c:if test="${modif == true}">
                <form name="modif" action="/SafeDriving-war/auth/ClientDetail" method="POST">
                    <p>id : <c:out value="${client.id}"/><input type="hidden" name="id" value="<c:out value="${client.id}"/>" /></p>
                    <p>Nom : <input type="text" name="nom" value="<c:out value="${client.nom}"/>" /></p>
                    <p>Prénom : <input type="text" name="prenom" value="<c:out value="${client.prenom}"/>" /></p>
                    <p>Date de naissance : <input type="text" name="DateNaissance" value="<c:out value="${client.dateNaissance}"/>" /></p>
                    <p>Adresse : <input type="text" name="adresse" value="<c:out value="${client.adresse}"/>" /></p>
                    <p>Code Postal : <input type="text" name="codePostal" value="<c:out value="${client.codePostal}"/>" /></p>
                    <p>Ville : <input type="text" name="ville" value="<c:out value="${client.ville}"/>" /></p>
                    <input type="submit" value="Enregistrer" />
                    <c:choose>
                        <c:when test="${compte.username != null}">
                            <p>Pseudo compte web : <c:out value="${compte.username}"/></p>
                        </c:when>
                        <c:when test="${compte == null}">
                            <a href="/SafeDriving-war/auth/ClientDetail?id=${client.id}&addcompteweb=${true}">Ajouter un compte web</a>
                        </c:when>
                    </c:choose>
                </form>
            </c:if>
            <c:if test="${modif != true}">
                <a href="/SafeDriving-war/auth/ClientDetail?id=${client.id}&modif=${true}">Modifier</a>
                <c:out value="${message}"/>
                <p>Nom : <c:out value="${client.nom}"/></p>
                <p>Prénom : <c:out value="${client.prenom}"/></p>
                <p>Date de naissance : <c:out value="${client.dateNaissance}"/></p>
                <p>Adresse : <c:out value="${client.adresse}"/></p>
                <p>Code Postal : <c:out value="${client.codePostal}"/></p>
                <p>Ville : <c:out value="${client.ville}"/></p>
                <c:choose>
                    <c:when test="${compte.username != null}">
                        <p>Pseudo compte web : <c:out value="${compte.username}"/></p>
                    </c:when>
                    <c:when test="${compte == null}">
                        <a href="/SafeDriving-war/auth/ClientDetail?id=${client.id}&addcompteweb=${true}">Ajouter un compte web</a>
                    </c:when>
                </c:choose>
            </c:if>

        </section>
    </body>
</html>
