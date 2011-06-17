<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : addNote
    Created on : 16 juin 2011, 11:02:16
    Author     : Grm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            function visibilite(thingId)
            {
                var tabDiv = document.getElementsByTagName("div");
                var n = tabDiv.length;
                for (i=0; i<n; i++)
                {
                    tabDiv[i].style.display = "none";
                }
                
                var targetElement;
                targetElement = document.getElementById(thingId);
                targetElement.style.display = "" ;
                var otherElement;
                otherElement = document.getElementById('selectionSession');
                otherElement.style.display = "";
            }
        </script>

    </head>
    <body>
        <%@include file="../template/header.jsp" %>
        <h1>Ajout d'une note</h1>
        <%@include file="../template/menu.jsp" %>
        <section>
            <form action="/SafeDriving-war/auth/AddNote" method="POST">
                <input type="text" name="score" value="" /><br/>
                <div id="selectionSession">
                    <select name="sessionID" multiple>
                        <c:forEach var="session" items="${Lsession}">
                            <option onclick="visibilite('${session.id}')" value="${session.id}">Session du ${session.date}</option>
                        </c:forEach>
                    </select>
                </div>
                <c:forEach var="session" items="${Lsession}">
                    <div id="${session.id}" style="display:none">
                        <select name="clientID" multiple>
                            <c:forEach var="participant" items="${session.participants}">
                                <option value="${participant.id}">${participant.prenom} ${participant.nom}</option>
                            </c:forEach>
                        </select>
                    </div>
                </c:forEach>
                <input type="submit" value="Valider" />
            </form>
        </section>
    </body>
</html>
