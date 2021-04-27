<%-- 
    Document   : Cart
    Created on : Oct 12, 2020, 4:02:27 PM
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
        <title>Shopping Cart</title>

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

        <!-- Breadcrumb Section Begin -->
        <section class="breadcrumb-section">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <div  class="breadcrumb__text">
                            <h2>SHOPPING CART</h2>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Shoping Cart Section Begin -->
        <section class="shoping-cart spad">
            <div class="container">
                <form action="AddToCart" method="get">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="shoping__cart__table">
                                <table>
                                    <thead>
                                        <tr>
                                            <th class="shoping__product">Products</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>
                                    <c:if test="${isExist == true}">
                                        <c:set var="total" value="${0}"/>
                                        <tbody>
                                            <c:forEach items="${listItem}" var="i">
                                                <c:if test="${i.quantity != 0}">
                                                <input type="hidden" name="pid" value="${i.product.pID}"/>
                                                <tr>
                                                    <td class="shoping__cart__item">
                                                        <img style="width: 100px; height: auto;" src="images/${i.product.image}" alt="">
                                                        <h5>${i.product.title}</h5>
                                                    </td>
                                                    <td class="shoping__cart__price">
                                                        ${i.product.price} VND
                                                    </td>
                                                    <td class="shoping__cart__quantity">
                                                        <div class="quantity">
                                                            <div class="pro-qty">
                                                                <span class="dec qtybtn">-</span>
                                                                <input type="text" name="quantity" value="${i.quantity}">
                                                                <span class="inc qtybtn">+</span>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td class="shoping__cart__total">
                                                        ${i.quantity * i.product.price} VND
                                                    </td>
                                                </tr>
                                                <c:set var="total" value="${total + (i.quantity * i.product.price)}"/>
                                            </c:if>
                                        </c:forEach>
                                        </tbody>
                                    </c:if>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="shoping__cart__btns">
                                <input type="hidden" name="type" value="2">
                                <button type="submit" class="site-btn cart-btn-left">Upadate Cart</button>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="shoping__checkout">
                                <h5>Cart Total</h5>
                                <ul>
                                    <li>Subtotal <span>${total} VND</span></li>
                                    <li>Total <span>${total} VND</span></li>
                                </ul>
                                <a href="CheckOutServer" class="primary-btn">PROCEED TO CHECKOUT</a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
        <!-- Shoping Cart Section End -->

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
    </body>
</html>