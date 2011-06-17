<%-- 
    Document   : addCategorie
    Created on : 26 mai 2011, 20:58:09
    Author     : Grm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" href="../css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="../template/header.jsp" %>
        
        <%@include file="../template/menu.jsp" %>
        <section>
            <h2>Ajout d'une categorie</h2>
            <form action="/SafeDriving-war/AddCategorie" method="post">
                <input type="text" name="categorieName"/>

                <select name="parent">
                    <option value="0"></option>
                    <c:forEach var="cat" items="${categories}">
                        <option value="${cat.id}">${cat.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Valider"/>
            </form>
        </section>
    </body>
</html>
