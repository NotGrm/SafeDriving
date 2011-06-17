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
        <link type="text/css" href="../css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="../template/header.jsp" %>
       
        <%@include file="../template/menu.jsp" %>
        <section>
             <h2>Ajout d'un service</h2>
            <form action="/SafeDriving-war/auth/AddService" method="post">
                <label  for="servicename">
                    Nom du service : </label>
                <input type="text" name="servicename" id="servicename"/>
                <input type="submit" value="Valider"/>
            </form>
        </section>
    </body>
</html>
