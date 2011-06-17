<%-- 
    Document   : clientDetail
    Created on : 16 juin 2011, 16:45:11
    Author     : Ehres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail du client</title>
    </head>
    <body>
        <%@include file="../template/header.jsp" %>
        <h1>Detail du client</h1>
        <%@include file="../template/menu.jsp" %>
        <section>
            <p><c:out value="${client.nom} ${client.prenom}"/></p>
        </section>
    </body>
</html>
