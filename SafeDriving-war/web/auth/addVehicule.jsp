<%-- 
    Document   : addVehicule
    Created on : 22 mai 2011, 12:03:19
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
        <h1>Ajout d'un véhicule</h1>
        <form action="/SafeDriving-war/AddVehicule" method="POST">
            Numéro de série : <input type="text" name="serialNumber"/>
            Plaque d'immatriculation : <input type="text" name="plaque"/>
            Date d'achat : <input type="text" name="dateAchat"/>
            <input type="submit" value="Valider"/>
        </form>
    </body>
</html>
