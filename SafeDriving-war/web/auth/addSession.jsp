<%-- 
    Document   : addSession
    Created on : 17 juin 2011, 21:59:56
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
                $("#datepicker").datepicker();
            });
        </script>
        <script type="text/javascript">
            function visibilite(thingId)
            {
                var targetElement;
                targetElement = document.getElementById(thingId);
                targetElement.style.display = "" ;
                
                var otherElement
                if(thingId == "div_pratique")
                {
                    otherElement = document.getElementById('div_theorique');
                } else 
                {
                    otherElement = document.getElementById('div_pratique');
                }
                otherElement.style.display = "none";
            }
        </script>

    </head>
    <body>
        <%@include file="../template/header.jsp" %>

        <%@include file="../template/menu.jsp" %>
        <section>

            <form action="/SafeDriving-war/auth/AddSessionTheorique" method="POST">
                <header>
                    <h2> Ajout d'une session </h2>
                </header>
                <div id="div_commun">

                    <label for="datepicker">Date :</label>
                    <input  type="text" name ="date" id="datepicker"/>
                    Heure : <input type="text" name="debut"/>
                    Durée : <input type="text" name="duree"/><br/>
                    Nb Places : <input type="text" name="nbPlaces"/>

                    <label for="lieu"> Lieu :</label>
                    <select id="lieu" name="place">
                        <c:forEach items="${lieux}" var="lieu">
                            <option value="${lieu.id}">${lieu.nom}</option>
                        </c:forEach>
                    </select>

                    <!--Lieu : <input type="text" name="place"/>-->
                    <h3> Choix d'un intervenant</h3>
                    <c:forEach items="${formateurs}" var="formateur">
                        <input id="${formateur.id}" type="radio" name="intervenant" value="${formateur.id}"/>
                        <label for="${formateur.id}">${formateur.nom} ${formateur.prenom}</label>
                    </c:forEach>
                    <!--Intervenant : <input type="text" name="intervenant"/>-->


                </div>

                <h3>Choisissez quel type de session à ajouter</h3>
                <input id="pratique_radio" type="radio" name="typesession" value="pratique" onclick="visibilite('div_pratique')"/>
                <label for="pratique_radio">Session Pratique</label>

                <input id="theorique_radio" type="radio" name="typesession" value="theorique" onclick="visibilite('div_theorique')"/>
                <label for="theorique_radio">Session Theorique</label>

                <div id="div_theorique" style="display:none">
                    Difficulté : <input type="text" name="difficult"/>
                </div>
                <div id="div_pratique" style="display:none">
                    Véhicule : <input type="text" name="vehiculeNumSerie"/>
                    Type : <input type="text" name="type"/>
                </div>
                <footer>
                    <input type="submit" value="Valider"/>
                </footer>
            </form>
        </section>
    </body>
</html>
