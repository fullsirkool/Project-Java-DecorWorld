<%-- 
    Document   : Shop
    Created on : Sep 27, 2020, 6:27:20 PM
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
        <title>Product</title>

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
        <jsp:useBean id="beanCategory" class="DAO.DAOCategories" scope="request"/>

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
                            <h2>PRODUCT</h2>
                            <c:if test="${aidFromServer == aid}">
                                <div class="breadcrumb__option">
                                    <a href="AddNewProduct.jsp">Add New Product</a>
                                    <a href="SellOrderServer">Sales Order Management</a>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Breadcrumb Section End -->

        <!-- Product Section Begin -->
        <section class="product spad">
            <div class="container">
                <div class="row">
                    <!-- Hero Section Begin -->
                    <%@include file="Left.jsp" %>
                    <!-- Hero Section End -->
                    <div class="col-lg-9 col-md-7">
                        <div class="hero__search">
                            <div class="hero__search__form">
                                <form action="#">
                                    <input type="text" id="search-text" placeholder="What do yo u need?">
                                    <button type="submit" class="site-btn">SEARCH</button>
                                </form>
                            </div>
                        </div>
                        <div class="filter__item">
                            <div class="row">
                                <div class="col-lg-6 col-md-5">
                                    <form action="LoadProduct" method="get">
                                        <div class="filter__sort">
                                            <span>Sort By</span>

                                            <select onchange="this.form.submit()" name="selectSort">
                                                <option value="0">Default</option>
                                                <option value="1">Rate</option>
                                                <option value="2">Price(low to high)</option>
                                                <option value="3">Price(high to low)</option>
                                            </select>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="row" id="list">
                            <c:forEach items="${listP}" var="p">
                                <div class="col-lg-4 col-md-6 col-sm-6 in" id="root_item">
                                    <div class="product__item">
                                        <div class="product__item__pic set-bg" data-setbg="images/${p.image}">
                                            <ul class="product__item__pic__hover">
                                                <li><a href="DetailServer?pid=${p.pID}"><i class="fa fa-eye"></i></a></li>
                                                <li><a onclick="clickBuy(${p.pID})"><i class="fa fa-shopping-cart"></i></a></li>
                                            </ul>
                                        </div>
                                        <div class="product__item__text">
                                            <h6><a class="title" href="DetailServer?pid=${p.pID}">${p.title}</a></h6>
                                            <h5>${p.price} VND</h5>
                                            <h6>${p.shortDescription}</h6>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Section End -->

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
        <script src="js/Script.js" type="text/javascript"></script>
        <script>
                                                    function clickBuy(pid) {
                                                        axios.get('/FinalProject/AddToCart', {
                                                            params: {
                                                                pid: pid,
                                                                type: 1,
                                                                quantity: 1
                                                            }
                                                        }).then(response => {
//                                                            this.users = response.data;
                                                            console.log(response);
                                                        }).catch(error => {
                                                            console.log(error);
                                                        });
                                                        alert("Added To Cart!");
                                                    }
        </script>
    </body>
</html>
