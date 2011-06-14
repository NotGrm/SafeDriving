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
        <h1>Planning</h1>
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
            <div id="heures">20h</div>
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
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
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
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
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
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
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
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
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
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
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
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
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
            </tbody>
        </table>

    </body>
</html>
