<%-- 
    Document   : catalogue.jsp
    Created on : Dec 27, 2019, 2:42:23 PM
    Author     : mkreutner
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page import="com.directmedia.onlinestore.core.entity.Catalog"%>
<%@page import="com.directmedia.onlinestore.core.entity.Work"%>
<%@page import="com.directmedia.onlinestore.core.entity.Artist"%>
<c:forEach items="${requestScope.works}" var="work">
    <a href="work-details?id=${work.id}"
       class="list-group-item list-group-item-action">${work.title} (${work.release})</a></li>
</c:forEach>