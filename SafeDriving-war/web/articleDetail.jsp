<%-- 
    Document   : articleDetail
    Created on : 22 mai 2011, 14:39:06
    Author     : Grm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="css/style.css" rel="stylesheet" />
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="template/header.jsp" %>
        <div id="content">
            <%@include file="template/menu.jsp" %>
            <section>
                <h2><c:out value="${article.titre}"/> </h2>
                <c:out value="${article.text}"/>
            </section>
        </div>
    </body>
</html>
