<%-- 
    Document   : addPersonnel
    Created on : 18 mai 2011, 10:41:15
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
            <h2>Ajout d'un employé</h2>
            <form action="/SafeDriving-war/auth/AddPersonnel" method="POST">
                Code Personnel : <input type="text" name="code"/>
                Nom : <input type="text" name="name"/>
                Prénom : <input type="text" name="firstname"/><br/>
                Adresse : <input type="text" name="address"/><br/>
                Code Postal : <input type="text" name="zipcode"/>
                Ville : <input type="text" name="city"/>
                <input type="submit" value="Valider"/>
            </form>
        </section>
    </body>
</html>
