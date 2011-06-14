<%-- 
    Document   : addService
    Created on : 23 mai 2011, 17:48:16
    Author     : Grm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ajout d'un service</h1>
        <form action="/SafeDriving-war/auth/AddService" method="post">
            <label  for="servicename">
                Nom du service : </label>
            <input type="text" name="servicename" id="servicename"/>
            <input type="submit" value="Valider"/>
        </form>
    </body>
</html>
