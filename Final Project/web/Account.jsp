<%-- 
    Document   : Detail
    Created on : Sep 23, 2020, 11:38:58 PM
    Author     : Minh La Anhihi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>My Account</title>

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
        <!--text area-->
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
        <script>tinymce.init({selector: 'textarea'});</script>
        <style>
            .tox-notifications-container{
                display: none;
            }
            .tox-statusbar__branding {
                display: none;

            }
        </style>
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
                            <h2>ACCOUNT INFORMATION</h2>
                            <div class="breadcrumb__option">
                                <c:if test="${role == 2}">
                                    <a href="LoadProduct?aid=${aid}">My Shop</a>
                                </c:if>
                                <c:if test="${role == 1}">
                                    <a href="ManagerServer">Manager</a>
                                </c:if>
                                <c:if test="${role != 1 && role != 0}">
                                    <a href="OrderManager">Order Management</a>
                                </c:if>
                            </div>
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
                    <h4>Product Information</h4>
                    <form action="ChangeInforServer" method="get" name="ChangeInfor" onsubmit="return checkInput()" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-lg-12 col-md-12">
                                <div class="checkout__input">
                                    <p>Email<span>*</span></p>
                                    <input name="email" type="email" value="${email}">
                                </div>
                                <div class="checkout__input">
                                    <p>Name<span>*</span></p>
                                    <input name="name" type="text" value="${name}">
                                </div>
                                <div class="checkout__input">
                                    <p>Phone Number<span>*</span></p>
                                    <input name="phoneNumber" type="text" value="${phoneNumber}">
                                </div>
                                <div class="checkout__input">
                                    <p>Address<span>*</span></p>
                                    <input name="address" type="text" value="${address}">
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Password<span>*</span></p>
                                            <input name="password" type="password" value="">
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Re Password<span>*</span></p>
                                            <input name="rePassword" type="password">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button style="margin-top: 30px; font-size: 14px; color: #ffffff; font-weight: 800; text-transform: uppercase; display: inline-block; padding: 15px 50px 15px 50px; background: #7fad39; border: none;" type="submit">Submit</button>
                    </form>
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

        <script>
                        function checkInput() {
                            var email = document.ChangeInfor.email.value;
                            var name = document.ChangeInfor.name.value;
                            var address = document.ChangeInfor.address.value;
                            var phoneNumber = document.ChangeInfor.phoneNumber.value;
                            var firstpassword = document.ChangeInfor.password.value;
                            var secondpassword = document.ChangeInfor.rePassword.value;
                            if (email == "" || address == "" || phoneNumber == "" || firstpassword == "" || secondpassword == "" || name == "") {
                                alert("Please fill all input!");
                                return false;
                            }
                            if (firstpassword == secondpassword) {
                                return true;
                            } else {
                                alert("Password must be same!");
                                return false;
                            }
                        }
        </script>
    </body>
</html>
