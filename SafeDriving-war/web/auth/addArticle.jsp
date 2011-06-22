<%-- 
    Document   : addArticle
    Created on : 18 mai 2011, 11:16:12
    Author     : Grm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" href="../css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="../template/header.jsp" %>

        <%@include file="../template/menu.jsp" %>
        <section>
            <h2>Ajouter un article</h2>
            <form action="/SafeDriving-war/auth/AddArticle" method="post">
                <label for="title">
                    <h3>Titre</h3>
                </label>
                <input type="text" name="title" id="title"/>
                <br/>
                <textarea rows="10" cols="50" name="text" id="editor1"> </textarea><br/>
                <div>
                    <h3>Catégorie</h3>
                    <%@include file="../template/categories.jsp" %>
                </div>
                <div>
                    <c:forEach items="${tags}" var="tag">
                        <a href="#"><c:out value="${tag.name}"/></a>
                    </c:forEach>
                    Tags : <input type="text" name="tags"/><br>
                    <input type="submit" value="Valider"/>
                </div>
            </form>
        </section>
        <ckeditor:replace replace="editor1" basePath="../ckeditor/" />
    </body>
</html>
