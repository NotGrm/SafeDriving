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
<<<<<<< HEAD
        <link type="text/css" href="css/smoothness/jquery-ui-1.8.13.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.13.custom.min.js"></script>
        <script>
            $(function() {
                $("#datepicker").datepicker();
                
                $("#button").button();
            });
        </script>
=======
>>>>>>> a96bc9fd5b497f624e1bf51bf364d9da2ed580f1
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
<<<<<<< HEAD
            
            Date Naissance :
            <input type="text" name ="date" id="datepicker"/><br/>
            
            <input type="submit" value="Valider"/>
=======
            <input type="submit" value="Valider"/>
            
>>>>>>> a96bc9fd5b497f624e1bf51bf364d9da2ed580f1
        </form>
    </body>
</html>
