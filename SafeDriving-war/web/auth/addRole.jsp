<%-- 
    Document   : addRole
    Created on : 18 juin 2011, 00:24:23
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
            <form action="/SafeDriving-war/auth/AddRole" method="POST">
                <h2>Ajout d'un role</h2>
                Nom du role :
                <input type="text" name="roleName"/>
                <input type="submit" value="Valider"/>
            </form>
    </body>
</html>
