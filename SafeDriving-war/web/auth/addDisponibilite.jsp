<%-- 
    Document   : addDisponibilite
    Created on : 18 juin 2011, 21:43:21
    Author     : Grm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" href="../css/style.css" rel="stylesheet" />
        <link type="text/css" href="../css/smoothness/jquery-ui-1.8.13.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="../js/jquery-1.5.1.min.js"></script>
        <script type="text/javascript" src="../js/jquery-ui-1.8.13.custom.min.js"></script>
        <script>
            $(function() {
                $("#dateDebut").datepicker();
                $("#dateFin").datepicker();
            });
        </script>
    </head>
    <body>
        <%@include file="../template/header.jsp" %>

        <%@include file="../template/menu.jsp" %>
        <section>
            <h2>Hello World!</h2>
            <form action="/SafeDriving-war/auth/AddDisponibilite" method="POST">
                <label for="dateDebut">Date du début de la disponibilité</label>
                <input type="text" id="dateDebut" name="dateDebut" /><br/>
                <label for="heureDebut">Heure du début de la disponibilité</label>
                <input type="text" id="heureDebut" name="heureDebut" /><br/>
                <label for="dateFin">Date de la fin de la disponibilité</label>
                <input type="text" id="dateFin" name="dateFin" /><br/>
                <label for="heureFin">Heure de la fin de la disponibilité</label>
                <input type="text" id="heureFin" name="heureFin" /><br/>
                <input type="submit" value="Valider" />
            </form>
        </section>
    </body>
</html>
