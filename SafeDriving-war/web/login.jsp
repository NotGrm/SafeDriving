<%-- 
    Document   : login
    Created on : 24 mai 2011, 16:43:11
    Author     : Ehres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
    </head>
    <body>
        <h1>Log in</h1>
        <form name="login" action="/SafeDriving-war/Login" method="POST">
            <table border="0">
                    <tr>
                        <td>username : </td>
                        <td><input type="text" name="username" value="" /></td>
                    </tr>
                <tbody>
                    <tr>
                        <td>password : </td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="login" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        
    </body>
</html>
