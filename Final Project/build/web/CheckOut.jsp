<%-- 
    Document   : CheckOut
    Created on : Nov 2, 2020, 9:18:40 PM
    Author     : Minh La Anhihi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Check Out</title>

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

        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-section">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div  class="breadcrumb__text">
                            <h2>CHECKOUT</h2>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Checkout Section Begin -->
        <section class="checkout spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h6><span class="icon_tag_alt"></span> Have a account? <a href="BillServer?type=1">Click here</a> to use your account information
                        </h6>
                    </div>
                </div>
                <div class="checkout__form">
                    <h4>Billing Details</h4>
                    <form action="BillServer" method="post" name="checkOutForm">
                        <div class="row">
                            <div class="col-lg-8 col-md-6">
                                <div class="checkout__input">
                                    <p>Name<span>*</span></p>
                                    <input type="text" name="name" id="name" required="">
                                </div>
                                <div class="checkout__input">
                                    <p>Address<span>*</span></p>
                                    <input type="text" name="address" id="address" class="checkout__input__add" required="">
                                </div>
                                <div class="checkout__input">
                                    <p>Email<span>*</span></p>
                                    <input type="email" name="email" id="email" class="checkout__input__add" required="">
                                </div>
                                <div class="checkout__input">
                                    <p>Phone<span>*</span></p>
                                    <input type="text" name="phone" id="phone" class="checkout__input__add" required="">
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <c:if test="${isInvalid eq 'invalid'}">
                                    <div class="alert alert-danger fade show" role="alert">
                                        <span>Invalid Product Quantity</span>
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                </c:if>
                                <div class="checkout__order">
                                    <h4>Your Order</h4>
                                    <div class="checkout__order__products">Products <span>Total</span></div>
                                    <ul>
                                        <c:if test="${isExist == true}">
                                            <c:set var="total" value="${0}"/>
                                            <c:forEach items="${listItem}" var="i">
                                                <li>${i.product.title} <span>${i.quantity * i.product.price} VND</span></li>
                                                    <c:set var="total" value="${total + (i.quantity * i.product.price)}"/>
                                                </c:forEach>
                                            </c:if>
                                    </ul>
                                    <div class="checkout__order__subtotal">Subtotal <span>${total} VND</span></div>
                                    <div class="checkout__order__total">Total <span>${total} VND</span></div>
                                    <c:if test="${isExist == true}">
                                        <button type="submit" class="site-btn">PLACE ORDER</button>
                                    </c:if>
                                    <c:if test="${isExist != true}">
                                        <button disabled type="submit" class="site-btn">PLACE ORDER</button>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <!-- Checkout Section End -->

        <!-- Footer Section Begin -->
        <jsp:include flush="true" page="Footer.jsp"/>
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
