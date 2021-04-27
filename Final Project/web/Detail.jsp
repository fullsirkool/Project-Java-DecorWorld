<%-- 
    Document   : Detail
    Created on : Oct 21, 2020, 4:20:01 PM
    Author     : Minh La Anhihi
--%>

<%@page import="Entity.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>${requestScope.product.title}</title>

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

        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Header Section Begin -->
        <%@include file="Header.jsp" %>     
        <!-- Header Section End -->

        <!-- Product Details Section Begin -->
        <section class="product-details spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="product__details__pic">
                            <div class="product__details__pic__item">
                                <img style="width: 100%;" class="product__details__pic__item"
                                     src="images/${product.image}" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="product__details__text">
                            <h3>${product.title}</h3>
                            <div class="product__details__rating">
                                <div class="rate">
                                    <c:if test="${product.avgRate == 0}">
                                        <c:forEach begin="0" end="4" var="s">
                                            <div data-score="${s}" class="star"></div>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${product.avgRate != 0}">
                                        <c:forEach begin="0" end="${product.avgRate - 1}" var="s">
                                            <div style="color: gold" data-score="${s}" class="star"></div>
                                        </c:forEach>
                                        <c:forEach begin="${product.avgRate}" end="4" var="s">
                                            <div data-score="${s}" class="star"></div>
                                        </c:forEach>
                                    </c:if>
                                </div>
                            </div>
                            <div class="product__details__price">${product.shortPrice} VND</div>
                            <p>${product.shortDescription}</p>
                            <div class="product__details__quantity">
                                <div class="quantity">
                                    <div class="pro-qty">
                                        <span class="dec qtybtn">-</span>
                                        <input name="quantity" id="quantity" type="text" value="1">
                                        <span class="inc qtybtn">+</span>
                                    </div>
                                </div>
                            </div>
                            <a onclick="clickAddToCart(${product.pID})" style="color: #FFFFFF;" class="primary-btn">ADD TO CARD</a>
                            <ul>
                                <c:if test="${product.quantity == 0}">
                                    <li><b>Availability</b> <span>Sold Out</span></li>
                                    </c:if>
                                    <c:if test="${product.quantity != 0}">
                                    <li><b>Availability</b> <span>In Stock</span></li>
                                    <input type="hidden" id="currentQuantity" value="${product.quantity}">
                                </c:if>
                                <li><b>Brand</b> <a style="color: #464646" href="LoadProduct?brandID=${product.brand.bid}"><span>${product.brand.bname}</span></a></li>
                                <li><b>Sold by</b>
                                    <div class="share">
                                        <a href="#"><i class="fa fa-facebook"></i></a>
                                        <a href="#"><i class="fa fa-twitter"></i></a>
                                        <a href="#"><i class="fa fa-instagram"></i></a>
                                        <a href="#"><i class="fa fa-pinterest"></i></a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="product__details__tab">
                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                                       aria-selected="true">Description</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                       aria-selected="false">Reviews</a>
                                </li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                    <div class="product__details__tab__desc">
                                        <p>${product.description}</p>
                                    </div>
                                </div>
                                <div class="tab-pane" id="tabs-3" role="tabpanel">
                                    <div class="product__details__tab__desc">
                                        <c:forEach items="${product.evaluates}" var="e">
                                            <div>
                                                <p>${e.account.name}<br><small>${e.date}</small></p>
                                                <small>
                                                    <div class="rate">
                                                        <c:forEach begin="0" end="${e.rate - 1}" var="s">
                                                            <div style="color: gold" data-score="${s}" class="star"></div>
                                                        </c:forEach>
                                                        <c:forEach begin="${e.rate}" end="4" var="s">
                                                            <div data-score="${s}" class="star"></div>
                                                        </c:forEach>
                                                    </div>
                                                </small>
                                                <p>${e.econtent}</p>
                                                <hr>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Details Section End -->

        <!-- Footer Section End -->
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
        <script>
                                function clickAddToCart(pid) {
                                    if (document.getElementById('quantity').value > document.getElementById('currentQuantity').value) {
                                        alert("Add Failed!");
                                    } else {
                                        axios.get('/FinalProject/AddToCart', {
                                            params: {
                                                pid: pid,
                                                type: 1,
                                                quantity: document.getElementById('quantity').value
                                            }
                                        }).then(response => {
                                            this.users = response.data;
                                            console.log(response);
                                        }).catch(error => {
                                            console.log(error);
                                        });
                                        alert("Added To Cart!");
                                    }
                                }
        </script>
    </body>
</html>
