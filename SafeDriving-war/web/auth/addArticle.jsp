<%-- 
    Document   : addArticle
    Created on : 18 mai 2011, 11:16:12
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
        <%@include file="../template/header.jsp" %>
        <h1>Ajouter un article</h1>
        <%@include file="../template/menu.jsp" %>
        <section>
            <form action="/SafeDriving-war/auth/AddArticle" method="post">
                <h2>Titre</h2>
                <input type="text" name="title"/>
                <br/> 
                <textarea rows="10" cols="50" name="text"> </textarea><br/>
                <br/>
                Auteur : <input type="text" name="author"/>
                Categorie : <input type="text" name="categorie"/><br/>
                Tags : <input type="text" name="tags"/><br>
                <input type="submit" value="Valider"/>
            </form>
        </section>
    </body>
</html>
