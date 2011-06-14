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
    </head>
    <body>
        <h1>Ajout d'un compte web</h1>
        
        <p>Est-ce qu'un compte Web Existe ?</p>
        <form name="addCompteWeb" action="/SafeDriving-war/auth/AddCompteWeb" method="POST"> 
            <input type="hidden" name="client" value="${client.id}" />
            <input type="radio" name="bool" value="yes" checked="checked" /><br/> Oui<br/>
            pseudo : <input type="text" name="pseudoSearch" value="" <br/>
            <input type="radio" name="bool" value="no" /><br/> Non<br/>
            pseudo : <input type="text" name="pseudoAdd" value="" /><br/>
            password : <input type="password" name="password" value="" /><br/>
            <input type="submit" value="Envoyer" />
        </form>
    </body>
</html>
