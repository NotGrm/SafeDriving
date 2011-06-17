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
        <link type="text/css" href="../css/smoothness/jquery-ui-1.8.13.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="../js/jquery-1.5.1.min.js"></script>
        <script type="text/javascript" src="../js/jquery-ui-1.8.13.custom.min.js"></script>
        <script>
            $(function() {
                $("#datepicker").datepicker();
                
                $("#button").button();
            });
        </script>
    </head>
    <body>
        <%@include file="../template/header.jsp" %>
        <h1>Ajout d'un véhicule</h1>
        <%@include file="../template/menu.jsp" %>
        <section>
            <form action="/SafeDriving-war/auth/AddVehicule" method="POST">
                Numéro de série : <input type="text" name="serialNumber"/>
                Plaque d'immatriculation : <input type="text" name="plaque"/>
                Date d'achat : <input type="text" name="dateAchat" id="datepicker"/>
                <input type="submit" value="Valider"/>
            </form>
        </section>
    </body>
</html>
