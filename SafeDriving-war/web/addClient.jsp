<%-- 
    Document   : addClient
    Created on : 22 mai 2011, 10:11:57
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
        <h1>Ajout d'un client</h1>
        <form action="/SafeDriving-war/AddClient" method="POST">
            Nom : <input type="text" name="name"/>
            Prénom : <input type="text" name="firstname"/>
            Adresse : <input type="text" name="address"/>
            Code Postal : <input type="text" name="zipcode"/>
            Ville : <input type="text" name="city"/>
            
            NumClient : <input type="text" name="clientNumber"/>
            Compte forum : <input type="text" name="accountName"/>
            <input type="submit" value="Valider"/>
            
        </form>
    </body>
</html>
