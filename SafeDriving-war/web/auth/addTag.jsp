<%-- 
    Document   : addTag
    Created on : 29 mai 2011, 22:20:30
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
        <h1>Hello World!</h1>
        <form action="/SafeDriving-war/AddTag" method="post">
            <label for="tagName">Tag :</label>
            <input type="text" name="tagName" id="tagName"/>
            <input type="submit" value="Valider"/>
        </form>
    </body>
</html>
