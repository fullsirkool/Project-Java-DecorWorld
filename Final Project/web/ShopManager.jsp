<%-- 
    Document   : ShopManager
    Created on : Nov 9, 2020, 11:18:51 PM
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
        <title>Selled Order</title>

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
                            <h2>SHOP MANAGER</h2>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->
        <!-- Checkout Section Begin -->
        <section class="checkout spad">
            <div class="container">
                <div class="checkout__form">

                    <h4>Recent 30 days Order</h4>
                    <table style="border: 1px solid lightgray" class="table">
                        <thead>
                            <tr>
                                <th>Bill ID</th>
                                <th>Product</th>
                                <th>Quantity</th>
                                <th>User Name</th>
                                <th>Address</th>
                                <th>Phone Number</th>
                                <th>Email</th>
                                <th>Date</th>
                                <th>Total Price</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="total" value="0"/>
                            <c:forEach items="${listBillM}" var="b">
                                <tr>
                                    <td>${b.billid}</td>
                                    <td>${b.product.title}</td>
                                    <td>${b.quantity}</td>
                                    <td>${b.name}</td>
                                    <td>${b.address}</td>
                                    <td>${b.phoneNumber}</td>
                                    <td>${b.email}</td>
                                    <td>${b.date}</td>
                                    <td>${b.product.price * b.quantity}</td>
                                    <td>${b.statusByWords}</td>
                                    <c:set var="total" value="${total + b.product.price * b.quantity}"/>
                                </tr>
                            </c:forEach>
                                <tr style="text-align: right">
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>Total income: </td>
                                    <td>${total}</td>
                                </tr>
                        </tbody>
                    </table>
                    <h4>All Order</h4>
                    <table style="border: 1px solid lightgray" class="table">
                        <thead>
                            <tr>
                                <th>Bill ID</th>
                                <th>Product</th>
                                <th>Quantity</th>
                                <th>User Name</th>
                                <th>Address</th>
                                <th>Phone Number</th>
                                <th>Email</th>
                                <th>Date</th>
                                <th>Total Price</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listBill}" var="b">
                                <tr>
                                    <td>${b.billid}</td>
                                    <td>${b.product.title}</td>
                                    <td>${b.quantity}</td>
                                    <td>${b.name}</td>
                                    <td>${b.address}</td>
                                    <td>${b.phoneNumber}</td>
                                    <td>${b.email}</td>
                                    <td>${b.date}</td>
                                    <td>${b.product.price * b.quantity}</td>
                                    <td>${b.statusByWords}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
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
    </body>
</html>
