<%-- 
    Document   : inscription
    Created on : 23 mai 2011, 10:33:42
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
        <h1>Inscription au forum de SafeDriving</h1>
        <form action="/SafeDriving-war/Inscription" method="POST">
            <label for="username">Login :</label>
            <input type="text" name="username" id="username" />
            <label for="password">Password :</label>
                <input type="password" name="password" id="password" />
            <input type="submit" value="Valider"/>
        </form>
    </body>
</html>
