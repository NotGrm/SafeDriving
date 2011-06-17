<%-- 
    Document   : addTypePratique
    Created on : 24 mai 2011, 15:56:31
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
            <h2>Ajout d'un type de pratique</h2>
            <form action="/SafeDriving-war/auth/AddTypePratique" method="post">
                Nom :<input type="text" name="name"/>
                Nombre maximum de participants :<input type="text" name="nb"/>            
                <input type="submit" value="Valider"/>
            </form>
        </section>
    </body>
</html>
