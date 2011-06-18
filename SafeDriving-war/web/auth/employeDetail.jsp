<%-- 
    Document   : employeDetail
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
        <link type="text/css" href="../css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="../template/header.jsp" %>

        <%@include file="../template/menu.jsp" %>
        <section>
            <h2>Detail de l'employé</h2>
            <c:if test="${modif == true}">
                <form name="modif" action="/SafeDriving-war/auth/EmployeDetail" method="POST">
                    <p>id : <c:out value="${employe.id}"/><input type="hidden" name="id" value="<c:out value="${employe.id}"/>" /></p>
                    <p>Nom : <input type="text" name="nom" value="<c:out value="${employe.nom}"/>" /></p>
                    <p>Prénom : <input type="text" name="prenom" value="<c:out value="${employe.prenom}"/>" /></p>
                    <p>Date de naissance : <input type="text" name="DateNaissance" value="<c:out value="${employe.dateNaissance}"/>" /></p>
                    <p>Adresse : <input type="text" name="adresse" value="<c:out value="${employe.adresse}"/>" /></p>
                    <p>Code Postal : <input type="text" name="codePostal" value="<c:out value="${employe.codePostal}"/>" /></p>
                    <p>Ville : <input type="text" name="ville" value="<c:out value="${employe.ville}"/>" /></p>
                    <input type="submit" value="Enregistrer" />
                    <c:choose>
                        <c:when test="${compte.username != null}">
                            <p>Pseudo compte web : <c:out value="${compte.username}"/></p>
                        </c:when>
                        <c:when test="${compte == null}">
                            <a href="/SafeDriving-war/auth/EmployeDetail?id=${employe.id}&addcompteweb=${true}">Ajouter un compte web</a>
                        </c:when>
                    </c:choose>
                </form>
            </c:if>
            <c:if test="${modif != true}">
                <a href="/SafeDriving-war/auth/EmployeDetail?id=${employe.id}&modif=${true}">Modifier</a>
                <c:out value="${message}"/>
                <p>Nom : <c:out value="${employe.nom}"/></p>
                <p>Prénom : <c:out value="${employe.prenom}"/></p>
                <p>Date de naissance : <c:out value="${employe.dateNaissance}"/></p>
                <p>Adresse : <c:out value="${employe.adresse}"/></p>
                <p>Code Postal : <c:out value="${employe.codePostal}"/></p>
                <p>Ville : <c:out value="${employe.ville}"/></p>
                <c:choose>
                    <c:when test="${compte.username != null}">
                        <p>Pseudo compte web : <c:out value="${compte.username}"/></p>
                    </c:when>
                    <c:when test="${compte == null}">
                        <a href="/SafeDriving-war/auth/EmployeDetail?id=${employe.id}&addcompteweb=${true}">Ajouter un compte web</a>
                    </c:when>
                </c:choose>
            </c:if>
        </section>
    </body>

</html>
