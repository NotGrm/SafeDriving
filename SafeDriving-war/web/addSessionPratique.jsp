<%-- 
    Document   : addSessionPersonnel
    Created on : 22 mai 2011, 10:52:59
    Author     : Grm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" href="css/smoothness/jquery-ui-1.8.13.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.13.custom.min.js"></script>
        <script>
            $(function() {
                $("#datepicker").datepicker();
                
                $("#button").button();
            });
        </script>
    </head>
    <body>
        <h1>Ajout d'une session pratique</h1>
        <form action="/SafeDriving-war/AddSessionPratique" method="POST">
            Nb Places : <input type="text" name="nbPlaces"/>
            Date : 
            <input type="text" name ="date" id="datepicker"/><br/>
            Lieu : <input type="text" name="place"/>
            Intervenant : <input type="text" name="intervenant"/>
            Véhicule : <input type="text" name="vehiculeName"/>
            Type : <input type="text" name="type"/>
            <input type="submit" value="Valider"/>
        </form>
    </body>
</html>
