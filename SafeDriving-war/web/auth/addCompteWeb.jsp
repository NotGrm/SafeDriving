<%-- 
    Document   : addCompteWeb
    Created on : 1 juin 2011, 11:15:15
    Author     : Ehres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h2>Ajout d'un compte web</h2>
            <p>Est-ce qu'un compte Web Existe ?</p>
            <form name="addCompteWeb" action="/SafeDriving-war/auth/AddCompteWeb" method="POST"> 
                <input type="hidden" name="client" value="${client.id}" />
                <input type="hidden" name="employe" value="${employe.id}" />
                <input type="radio" name="bool" value="yes" checked="checked" />Oui<br/>
                Pseudo : <input type="text" name="pseudoSearch" value=""/><br/><br/>
                <input type="radio" name="bool" value="no" />Non<br/>
                Pseudo : <input type="text" name="pseudoAdd" value="" /><br/>
                Password : <input type="password" name="password" value="" /><br/>
                <input type="submit" value="Envoyer" />
            </form>
        </section>
    </body>
</html>
