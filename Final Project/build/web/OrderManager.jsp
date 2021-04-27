<%-- 
    Document   : OrderManager
    Created on : Nov 4, 2020, 10:25:57 PM
    Author     : Minh La Anhihi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Order Manager</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>
    <body>

        <!-- Header Section Begin -->
        <%@include file="Header.jsp" %>     
        <!-- Header Section End -->

        <!-- Checkout Section Begin -->
        <section class="checkout spad" style="background-color: #F5F5F5;">
            <div class="container">
                <c:forEach items="${listBill}" var="tb">
                    <div class="order__container">
                        <c:set var="total" value="1"/>
                        <c:set var="status" value="0"/>
                        <div class="order__top">
                            <c:forEach items="${tb.bills}" var="b">
                                <div class="order__wrapper">
                                    <div class="order__content">
                                        <div class="order__header">
                                            <strong style="color: #464646">Shop: </strong><a style="text-decoration: none; text-transform: none; color: #464646" href="LoadProduct?brandID=${b.product.brand.bid}">${b.product.brand.bname}</a>
                                        </div>
                                        <div class="order__content__item">
                                            <div class="order__item__detail">
                                                <div style="display: flex">
                                                    <img src="" alt=""/>
                                                    <div class="order__item__detail__img">
                                                        <img src="images/${b.product.image}" alt=""/>
                                                    </div>
                                                    <div class="order__item__detail__infor">
                                                        <a href="DetailServer?pid=${b.product.pID}"><h4>${b.product.title}</h4></a>
                                                        <p>Quantity: ${b.quantity}</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="order__item__total">
                                                <div class="order__item__total__text">
                                                    <h4>₫${b.product.shortPrice * b.quantity}</h4>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <a href="EvaluateServer?userid=${aid}&billID=${tb.billID}&pid=${b.product.pID}"><button class="site-btn order__button__evaluate">Evaluate</button></a>
                                </div>
                                <c:set var="total" value="${total + b.product.shortPrice * b.quantity}"/>
                                <c:set var="status" value="${b.status}"/>
                            </c:forEach>
                        </div>
                        <div class="order__buttons__wrapper">
                            <div class="order__total">
                                <span>Total:&nbsp</span><span style="color: #dd2222;"> ₫${total}</span> 
                            </div>
                            <c:if test="${status == 1}">
                                <div class="order__button">
                                    <a href="CancelOrder?billID=${tb.billID}"><button class="site-btn order__button__cacel">Cancel Order</button></a>
                                </div>
                            </c:if>
                            <c:if test="${status == 0}">
                                <div class="order__button">
                                    <h4><strong>Order Cancelled!</strong></h4>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
        <!-- Checkout Section End -->

        <!-- Footer Section Begin -->
        <%@include file="Footer.jsp" %>
        <!-- Footer Section End -->
        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
