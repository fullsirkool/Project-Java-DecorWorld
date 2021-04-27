<%-- 
    Document   : BillOut
    Created on : Nov 4, 2020, 8:43:52 PM
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
        <title>Order Success!</title>

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
                            <h2>ORDER DETAILS</h2>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->
        <div class="bill">
            <h5>Bill ID: ${billID}</h5>
            <table >
                <tr class="first">
                    <td style="padding: 5px 10px 5px 10px; font-size: 15px;">Product</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>Total</td>
                </tr>
                <c:set var="total" value="${0}"/>
                <c:forEach items="${listItem}" var="i">
                    <tr class="middle" style="background-color: #eeeeee;">
                        <c:set var="total" value="${total + i.product.price * i.quantity}"/>
                        <td>${i.product.title}</td>
                        <td>${i.product.price}</td>
                        <td>${i.quantity}</td>
                        <td>${i.quantity * i.product.price}</td>
                    </tr>
                </c:forEach>
                <tr class="last">
                    <td></td>
                    <td></td>
                    <td>Total order value</td>
                    <td>${total}</td>
                </tr>
            </table>
            <a href="HomeServer"><button class="site-btn"  id="bt"></button></a>
        </div>

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
            // Set the time we're counting down to
            var countDownTime = 60;
            // Update the count down every 1 second
            var x = setInterval(function () {

                // Display the result in the element with id="bt"
                document.getElementById("bt").innerHTML = "Redirect to Home in (" + countDownTime + ")";

                // Caculate count downtime
                countDownTime = countDownTime - 1;
                
                // If the count down is finished, write some text
                if (countDownTime < 0) {
                    clearInterval(x);
                    window.location = "/FinalProject/HomeServer";
                }
            }, 1000);
        </script>
    </body>
</html>