<%@page import="com.safedriving.model.InscritForum"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : planning
    Created on : 9 juin 2011, 17:09:39
    Author     : Ehres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
        <link type="text/css" href="../css/style.css" rel="stylesheet" />
        <style type="text/css">
            .planning{
                width: 900px;
                height: 400px;
                border: 1px solid black;
            }
            .semaine{
                border: 1px solid black;
            }
            #jour{
                border : 1px solid black;
                width: 126px;
                float : left;
            }
            td{
                height : 40px;
            }
            .horaire{
                width: 25px;
                height: 580px;
                float : left;
                margin-top: 40px;
            }
            .tablePlanning{
                width : 850px;
            }
            .tablePlanning.th{
                margin-bottom: 15px;
            }
            #heures{
                margin-bottom: 26px;
            }
            .infoTemp{
                width: 850px;
            }
        </style>
    </head>
    <body>
        <%@include file="../template/header.jsp" %>
        
        <%@include file="../template/menu.jsp" %>
        <section>
            <h2>Planning</h2>
            <c:choose>
                <c:when test="${user != null}">
                    <c:set var="roleName" value="${user.getRole().roleName}"/>
                    <c:choose>
                        <c:when test="${'DIRECTION' == roleName || 'SERVICE_FORMATION' == roleName}">
                            <a href="/SafeDriving-war/auth/AddSessionPratique">Ajouter une session pratique à cette semaine</a>    <a href="/SafeDriving-war/auth/AddSessionTheorique">Ajouter une session Théorique à cette semaine</a>
                        </c:when>
                    </c:choose>
                </c:when>
            </c:choose>
            <div class="infoTemp">
                <p>                
                    <a href="/SafeDriving-war/auth/Planning?week=${weekOfYear-1}"><< Semaine précédente</a> ${month} ${year} Semaine numero ${weekOfYear} <a href="/SafeDriving-war/auth/Planning?week=${weekOfYear+1}">Semaine suivante >></a>
                </p>

            </div>
            <div class="horaire">
                <div id="heures">8h</div>
                <div id="heures">9h</div>
                <div id="heures">10h</div>
                <div id="heures">11h</div>
                <div id="heures">12h</div>
                <div id="heures">13h</div>
                <div id="heures">14h</div>
                <div id="heures">15h</div>
                <div id="heures">16h</div>
                <div id="heures">17h</div>
                <div id="heures">18h</div>
                <div id="heures">19h</div>
            </div>
            <table class="tablePlanning" border="2">
                <thead>
                    <tr>
                        <th>
                            Lundi <br/>
                            ${monday}
                        </th>
                        <th>
                            Mardi <br/>
                            ${tuesday}
                        </th>
                        <th>
                            Mercredi <br/>
                            ${wednesday}
                        </th>
                        <th>
                            Jeudi <br/>
                            ${thursday}
                        </th>
                        <th>
                            Vendredi <br/>
                            ${friday}
                        </th>
                        <th>
                            Samedi <br/>
                            ${saturday}
                        </th>
                        <th>
                            Dimanche <br/>
                            ${sunday}
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${monday89}</td>
                        <td>${tuesday89}</td>
                        <td>${wednesday89}</td>
                        <td>${thursday89}</td>
                        <td>${friday89}</td>
                        <td>${saturday89}</td>
                        <td>${sunday89}</td>
                    </tr>
                    <tr>
                        <td>${monday910}</td>
                        <td>${tuesday910}</td>
                        <td>${wednesday910}</td>
                        <td>${thursday910}</td>
                        <td>${friday910}</td>
                        <td>${saturday910}</td>
                        <td>${sunday910}</td>
                    </tr>
                    <tr>
                        <td>${monday1011}</td>
                        <td>${tuesday1011}</td>
                        <td>${wednesday1011}</td>
                        <td>${thursday1011}</td>
                        <td>${friday1011}</td>
                        <td>${saturday1011}</td>
                        <td>${sunday1112}</td>
                    </tr>
                    <tr>
                        <td>${monday1112}</td>
                        <td>${tuesday1112}</td>
                        <td>${wednesday1112}</td>
                        <td>${thursday1112}</td>
                        <td>${friday1112}</td>
                        <td>${saturday1112}</td>
                        <td>${sunday1112}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>${monday1314}</td>
                        <td>${tuesday1314}</td>
                        <td>${wednesday1314}</td>
                        <td>${thursday1314}</td>
                        <td>${friday1314}</td>
                        <td>${saturday1314}</td>
                        <td>${sunday1314}</td>
                    </tr>
                    <tr>
                        <td>${monday1415}</td>
                        <td>${tuesday1415}</td>
                        <td>${wednesday1415}</td>
                        <td>${thursday1415}</td>
                        <td>${friday1415}</td>
                        <td>${saturday1415}</td>
                        <td>${sunday1415}</td>
                    </tr>
                    <tr>
                        <td>${monday1516}</td>
                        <td>${tuesday1516}</td>
                        <td>${wednesday1516}</td>
                        <td>${thursday1516}</td>
                        <td>${friday1516}</td>
                        <td>${saturday1516}</td>
                        <td>${sunday1516}</td>
                    </tr>
                    <tr>
                        <td>${monday1617}</td>
                        <td>${tuesday1617}</td>
                        <td>${wednesday1617}</td>
                        <td>${thursday1617}</td>
                        <td>${friday1617}</td>
                        <td>${saturday1617}</td>
                        <td>${sunday1617}</td>
                    </tr>
                    <tr>
                        <td>${monday1718}</td>
                        <td>${tuesday1718}</td>
                        <td>${wednesday1718}</td>
                        <td>${thursday1718}</td>
                        <td>${friday1718}</td>
                        <td>${saturday1718}</td>
                        <td>${sunday1718}</td>
                    </tr>
                    <tr>
                        <td>${monday1819}</td>
                        <td>${tuesday1819}</td>
                        <td>${wednesday1819}</td>
                        <td>${thursday1819}</td>
                        <td>${friday1819}</td>
                        <td>${saturday1819}</td>
                        <td>${sunday1819}</td>
                    </tr>
                </tbody>
            </table>
        </section>
    </body>
</html>
