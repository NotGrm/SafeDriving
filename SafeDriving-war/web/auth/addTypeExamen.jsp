<%-- 
    Document   : addTypeExamen
    Created on : 22 mai 2011, 18:25:48
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
            <h2>Ajout d'un type d'examen</h2>
            <form action="/SafeDriving-war/auth/AddTypeExamen" method="POST">
                Type : <input type="text" name="type"/>
                <input type="submit" value="Valider"/>
            </form>
        </section>
    </body>
</html>
