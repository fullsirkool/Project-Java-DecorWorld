<%-- 
    Document   : Header
    Created on : Sep 20, 2020, 11:35:50 PM
    Author     : Minh La Anhihi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-lg-3">
    <div class="hero__categories">
        <div class="hero__categories__all">
            <i class="fa fa-bars"></i>
            <span>All departments</span>
        </div>
        <ul>
            <c:forEach items="${beanCategory.allCategories}" var="c">
                <li><a href="LoadProduct?cid=${c.cID}">${c.cName}</a></li>
                </c:forEach>
        </ul>
    </div>
</div>