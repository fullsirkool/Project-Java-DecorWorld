<%-- 
    Document   : Header
    Created on : Sep 20, 2020, 11:35:50 PM
    Author     : Minh La Anhihi
--%>

<%@page import="Entity.Account"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:set var="aid" value=""/>
<c:forEach items="${pageContext.request.cookies}" var="a">
    <c:if test="${a.name eq 'aID'}">
        <c:set var="aid" value="${a.value}"/>
    </c:if>
    <c:if test="${a.name eq 'email'}">
        <c:set var = "email" value = "${a.value}"/>
        <c:set var="check" value="${1}"/>
    </c:if>
    <c:if test="${a.name eq 'username'}">
        <c:set var = "username" value = "${a.value}"/>
    </c:if>
    <c:if test="${a.name eq 'password'}">
        <c:set var = "password" value = "${a.value}"/>
    </c:if>
    <c:if test="${a.name eq 'name'}">
        <c:set var = "name" value = "${a.value}"/>
    </c:if>
    <c:if test="${a.name eq 'role'}">
        <c:set var = "role" value = "${a.value}"/>
    </c:if>
    <c:if test="${a.name eq 'address'}">
        <c:set var = "address" value = "${a.value}"/>
    </c:if>
    <c:if test="${a.name eq 'phoneNumber'}">
        <c:set var = "phoneNumber" value = "${a.value}"/>
    </c:if>
</c:forEach>
<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="header__top__left">
                        <ul>
                            <li><i class="fa fa-envelope"></i> decorworld@gmail.com</li>
                            <li>Brightening Up Your Home is Our Mission</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="header__top__right">
                        <div class="header__top__right__language">
                            <img src="img/language.png" alt="">
                            <div>English</div>
                        </div>
                        <div class="header__top__right__auth">
                            <c:if test="${check != 1}">
                                <a href="Login.jsp"><i class="fa fa-sign-in"></i>Login</a>
                            </c:if>
                            <c:if test="${check == 1}">
                                <div style="display: flex">
                                    <a href="Account.jsp"><i class="fa fa-user"></i>Account</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a href="Logout"><i class="fa fa-sign-out"></i>Logout</a>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href="HomeServer"><img src="img/logo/NewDecorLogoFull.png" alt=""></a>
                </div>
            </div>
            <div style="text-align: center" class="col-lg-9">
                <nav class="header__menu">
                    <ul>
                        <li><a href="HomeServer" class="active">Home</a></li>
                        <li ><a href="LoadProduct">Product</a></li>
                        <li><a href="CartControl">Cart</a></li>
                        <li ><a href="ContactServer">Contact</a></li>
                    </ul>
                </nav>
            </div>
        </div>
        <div class="humberger__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
    <a href="CartControl">
        <div id="cart">
            <i class="fa fa-shopping-bag"></i>
        </div>
    </a>
    <div id="contact">
        <a href="#"><i class="fa fa-facebook"></i></a><br>
        <a href="#"><i class="fa fa-twitter"></i></a><br>
        <a href="#"><i class="fa fa-instagram"></i></a><br>
    </div>

    <style>
        #cart{
            cursor: pointer;
            text-align: center;
            color: white;
            position: fixed;
            float: left;
            width: 45px;
            height: 50px;
            background-color: #7FAD39;
            top: 232px;
            bottom: 0;
            left: px;
            right: 0;
        }
        #cart p{
            padding-top: 10px;
            margin-bottom: 0px;
            font-weight: bold;
            font-size: 17px;
            color: white;
        }
        #cart i{
            padding-top: 12px;
            font-size: 20px;
        }

        #contact{
            cursor: pointer;
            text-align: center;
            color: white;
            position: fixed;
            float: left;
            width: 45px;
            height: 140px;
            background-color: #464646;
            top: 295px;
            bottom: 0;
            left: px;
            right: 0;
            display: block;
        }

        #contact i{
            color: white;
            font-size: 26px;
            padding: 10px 0px 10px 0px;
        }
    </style>
</header>
<!-- Header Section End -->
