<%-- 
    Document   : categories
    Created on : 20 juin 2011, 15:48:18
    Author     : Grm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${categories}" var="categorie">
    <ul style="list-style: none">
        <li>
            <input type="checkbox" name="selectedCategories" id="${categorie.id}" value="${categorie.id}"/>
            <label for="${categorie.id}">
                <c:out value="${categorie.name}"/>
            </label>
        </li>
        <c:if test="${!categorie.children.isEmpty()}">
            <li>
                <c:set var="categories" value="${categorie.children}" scope="request"/>
                <jsp:include page="../template/categories.jsp"/>
            </li>
        </c:if>
    </ul>
</c:forEach>