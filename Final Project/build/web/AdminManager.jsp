<%-- 
    Document   : AdminManager
    Created on : Sep 30, 2020, 9:29:41 PM
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
        <title>Admin Manager</title>

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
                            <h2>ADMIN MANAGER</h2>
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
                    <h4>New Account Information</h4>
                    <table style="border: 1px solid lightgray" class="table">
                        <thead>
                            <tr>
                                <th>User ID</th>
                                <th>Email</th>
                                <th>Password</th>
                                <th>User Name</th>
                                <th>Login Permission</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listLogin}" var="l">
                                <tr>
                                    <td>${l.aID}</td>
                                    <td>${l.email}</td>
                                    <td>${l.password}</td>
                                    <td>${l.userName}</td>
                                    <td><a href="AcceptServer?aID=${l.aID}&type=Login"><button style="float: right; padding: 8px 15px 8px 15px;" class="site-btn">Accept</button></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="checkout__form">
                    <h4>Accept Sell Request</h4>
                    <table style="border: 1px solid lightgray" class="table">
                        <thead>
                            <tr>
                                <th>User ID</th>
                                <th>Email</th>
                                <th>Password</th>
                                <th>User Name</th>
                                <th>Sell Permission</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listSell}" var="s">
                                <tr>
                                    <td>${s.aID}</td>
                                    <td>${s.email}</td>
                                    <td>${s.password}</td>
                                    <td>${s.userName}</td>
                                    <td><a href="AcceptServer?aID=${s.aID}&type=Sell"><button style="float: right; padding: 8px 15px 8px 15px;" class="site-btn">Accept</button></a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="checkout__form">
                    <h4>Request</h4>
                    <table style="border: 1px solid lightgray" class="table">
                        <thead>
                            <tr>
                                <th>User ID</th>
                                <th>User Name</th>
                                <th>Content</th>
                                <th>Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listRequest}" var="r">
                                <tr>
                                    <td>${r.account.aID}</td>
                                    <td>${r.account.name}</td>
                                    <td>${r.content}</td>
                                    <td>${r.date}</td>
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
