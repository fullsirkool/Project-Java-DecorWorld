<%-- 
    Document   : Evaluate
    Created on : Nov 7, 2020, 2:36:08 PM
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
        <title>Evaluate</title>

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
        <!-- Axios -->
        <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    </head>
    <body>

        <!-- Header Section Begin -->
        <%@include file="Header.jsp" %>     
        <!-- Header Section End -->

        <!-- Checkout Section Begin -->
        <section class="checkout spad" style="background-color: #F5F5F5;">
            <div class="container">
                <div class="order__container">
                    <div class="order__top">
                        <div class="order__wrapper">
                            <div class="order__content">
                                <div class="order__header">
                                    <strong style="color: #464646">Shop: </strong><a style="text-decoration: none; text-transform: none; color: #464646" href="#">${b.product.brand.bname}</a>
                                </div>
                                <div class="evaluate__item__total">
                                    <div class="order__item__detail">
                                        <div style="display: flex">
                                            <img src="" alt=""/>
                                            <div class="order__item__detail__img">
                                                <img src="images/${bill.product.image}" alt=""/>
                                            </div>
                                            <div class="order__item__detail__infor">
                                                <a href="DetailServer?pid=${bill.product.pID}"><h4>${bill.product.title}</h4></a>
                                                <p>Quantity: ${bill.quantity}</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="order__item__total">
                                        <div class="order__item__total__text">
                                            <h4>₫${bill.product.shortPrice * bill.quantity}</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <form action="EvaluateServer" method="post">
                                <input type="hidden" name="pid" value="${bill.product.pID}">
                                <div class="evaluate">
                                    <div class="evaluate__checkout__input">
                                        <textarea name="content" id="content" rows="6"></textarea>
                                    </div>
                                    <div class="evaluate__rate">
                                        <h3>Rate: </h3>
                                        <div>
                                            <div id="rate" class="rate">
                                                <div data-score="1" class="star"></div>
                                                <div data-score="2" class="star"></div>
                                                <div data-score="3" class="star"></div>
                                                <div data-score="4" class="star"></div>
                                                <div data-score="5" class="star"></div>
                                            </div>
                                        </div>
                                        <input type="hidden" id="result" name="rate">
                                        <h4 id="result_DP">Rank: </h4>
                                    </div>
                                </div>
                                <button class="site-btn" style="margin: 10px 0px 10px 20px;">Submit</button>
                            </form>
                        </div>
                        <div class="dotted">
                        </div>
                    </div>
                </div>
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
        <script src="js/Script.js" type="text/javascript"></script>
    </body>
</html>
