<%-- 
    Document   : index
    Created on : 16 mai 2011, 22:28:52
    Author     : Ehres
--%>

<%@page import="com.safedriving.model.InscritForum"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@page import="javax.servlet.http.HttpSession"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Safe-Driving</title>
        <link type="text/css" href="css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="template/header.jsp" %>
        <div id="content">
            <%@include file="template/menu.jsp" %>
            <section>
                <c:forEach items="${articles}" var="article">
                    <article>
                        <header>
                            <h2><c:out value="${article.titre}"/></h2>
                            <c:out value="${article.datePublication}"/>
                        </header>
                        <c:out value="${article.text}"/>
                        <footer>
                            <a href="/SafeDriving-war/ArticleDetail?id=${article.id}">Lire la suite</a> 
                        </footer>
                        <hr/>
                    </article>
                </c:forEach>
            </section>
        </div>
        <%@include file="template/footer.jsp" %>
    </body>
</html>
