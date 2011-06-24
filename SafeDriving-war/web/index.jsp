<%-- 
    Document   : index
    Created on : 16 mai 2011, 22:28:52
    Author     : Ehres
--%>

<%@page import="com.safedriving.model.InscritForum"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%-- <%@page import="javax.servlet.http.HttpSession"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Safe-Driving</title>
        <link type="text/css" href="css/style.css" rel="stylesheet" />
        <link type="text/css" href="css/smoothness/jquery-ui-1.8.13.custom.css" rel="stylesheet"/>

        <script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.13.custom.min.js"></script>
        <script>
            $(function() {
                $( ".home").button();
                $( "a", ".demo" ).click(function() { return false; });
            });
        </script>
        <script type="text/javascript">
            function confirmation() {
                return confirm("Confirmez-vous la suppression de l'article")  
            }
            
        </script>
    </head>
    <body>
        <%@include file="template/header.jsp" %>
        <div id="content">
            <%@include file="template/menu.jsp" %>
            <section>
                <fmt:setLocale value="fr_FR" />
                <c:forEach items="${articles}" var="article">
                    <article>
                        <header>
                            <h2><c:out value="${article.titre}"/></h2>
                            <fmt:formatDate type="both" value="${article.datePublication}" />
                        </header>
                        ${article.text}
                        <aside>
                            <div id="categories" >
                                Publié dans : 
                                <c:forEach items="${article.categories}" var="categorie">
                                    <c:out value="${categorie.name}"/>
                                </c:forEach>
                            </div>
                            <div id="tags">
                                Tags :
                                <c:forEach items="${article.tags}" var="tag">
                                    <c:out value="${tag.name}"/>
                                </c:forEach>
                            </div>
                            <br/>
                        </aside>
                        <hr/>
                        <footer>
                            <a class="home" href="/SafeDriving-war/ArticleDetail?id=${article.id}">Lire la suite</a> 
                            <c:if test="${user != null}">
                                <c:set var="roleName" value="${user.getRole().roleName}"/>
                                <c:if test="${'DIRECTION' == roleName || 'REDACTION' == roleName}">
                                    <a class="home" href="/SafeDriving-war/auth/Article?method=edit&id=${article.id}">Edit</a>
                                    <a class="home" href="/SafeDriving-war/auth/Article?method=delete&id=${article.id}" onclick="return confirmation()">Delete</a>
                                </c:if>
                            </c:if>
                        </footer>
                            <hr/>
                    </article>
                </c:forEach>
            </section>
        </div>
        <%@include file="template/footer.jsp" %>
    </body>
</html>
