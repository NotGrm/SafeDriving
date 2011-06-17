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
        <link type="text/css" href="../css/style.css" rel="stylesheet" />
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
        <%@include file="../template/header.jsp" %>
        
        <%@include file="../template/menu.jsp" %>
        <section>
            <h2>Ajout d'un client</h2>
            <form action="/SafeDriving-war/auth/AddClient" method="POST">
                Nom : <input type="text" name="name"/><br/>
                Prénom : <input type="text" name="firstname"/><br/>
                Adresse : <input type="text" name="address"/><br/>
                Code Postal : <input type="text" name="zipcode"/><br/>
                Ville : <input type="text" name="city"/>     <br/>       
                NumClient : <input type="text" name="clientNumber"/>  <br/>          
                Date Naissance :<input type="text" name ="date" id="datepicker"/><br/>

                <input type="submit" value="Valider"/>
            </form>
        </section>
    </body>
</html>
