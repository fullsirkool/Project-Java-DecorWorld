<%-- 
    Document   : Home
    Created on : Sep 23, 2020, 10:00:11 PM
    Author     : Minh La Anhihi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Decor World</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;600;900&display=swap" rel="stylesheet">

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
    <body

        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>

        <!-- Header Section Begin -->
        <%@include file="Header.jsp" %>     
        <!-- Header Section End -->

        <!-- Hero Section Begin -->
        <section class="hero">
            <div class="container">
                <div class="row">
                    <jsp:include page="Left.jsp" flush="true"/>
                    <div class="col-lg-9">
                        <div class="hero__item set-bg" data-setbg="img/hero/NewBanner.png">
                            <div class="hero__text">
                                <span style="font-weight: lighter">Decor </span><span style="font-weight: 700">World</span>
                                <h2>BEAUTY <br />of THE DELICACY</h2>
                                <a href="LoadProduct" class="primary-btn">SHOP NOW</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

        <!-- Categories Section Begin -->
        <section class="categories">
            <div class="container">
                <div class="row">
                    <div class="categories__slider owl-carousel">
                        <c:forEach items="${beanCategory.allCategories}" var="c">
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="img/categories/${c.cImg}">
                                    <h5><a href="LoadProduct?cid=${c.cID}">${c.cName}</a></h5>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>
        <!-- Categories Section End -->

        <!-- Featured Section Begin -->
        <section class="featured spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Featured Product</h2>
                        </div>
                        <div class="featured__controls">
                            <form>
                                <ul style="width: 70%; margin: 0 auto;">
                                    <li class="active" data-filter="*">All</li>
                                        <c:forEach items="${beanCategory.allCategories}" var="c">
                                        <li data-filter=".${c.cName}">${c.cName}</li>
                                        </c:forEach>
                                </ul>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="row featured__filter">
                    <c:forEach items="${listFilter}" var="p">
                        <div class="col-lg-3 col-md-4 col-sm-6 mix ${p.categorie.cName}">
                            <div class="featured__item">
                                <div class="featured__item__pic set-bg" data-setbg="images/${p.image}">
                                    <ul class="featured__item__pic__hover">
                                        <li><a href="DetailServer?pid=${p.pID}"><i class="fa fa-eye"></i></a></li>
                                        <li><a class="" onclick="clickBuy(${p.pID})"><i class="fa fa-shopping-cart"></i></a></li>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="DetailServer?pid=${p.pID}">${p.title}</a></h6>
                                    <h5>${p.price} VND</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Featured Section End -->

        <!-- Banner Begin -->
        <div class="banner">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="banner__pic">
                            <img style="width: 570px; height: auto;" src="img/banner/647565.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="banner__pic">
                            <img style="width: 570px; height: auto;" src="img/banner/647570.jpg" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Banner End -->

        <!-- Latest Product Section Begin -->
        <section class="latest-product spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="latest-product__text">
                            <h4>Top Rate</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                    <c:forEach items="${listRate}" begin="0" end="2" var="p">
                                        <a href="DetailServer?pid=${p.pID}" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img style="height: 110px; width: auto;" src="images/${p.image}" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${p.title}</h6>
                                                <span>${p.price} VND</span>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                                <div class="latest-prdouct__slider__item">
                                    <c:forEach items="${listRate}" begin="3" end="5" var="p">
                                        <a href="DetailServer?pid=${p.pID}" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img style="height: 110px; width: auto;" src="images/${p.image}" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${p.title}</h6>
                                                <span>${p.price} VND</span>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="latest-product__text">
                            <h4>Latest Products</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                    <c:forEach items="${listNew}" begin="0" end="2" var="p">
                                        <a href="DetailServer?pid=${p.pID}" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img style="height: 110px; width: auto;" src="images/${p.image}" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${p.title}</h6>
                                                <span>${p.price} VND</span>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                                <div class="latest-prdouct__slider__item">
                                    <c:forEach items="${listNew}" begin="3" end="5" var="p">
                                        <a href="DetailServer?pid=${p.pID}" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img style="height: 110px; width: auto;" src="images/${p.image}" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${p.title}</h6>
                                                <span>${p.price} VND</span>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Latest Product Section End -->

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

        <script>
            function clickBuy(pid) {
                axios.get('/FinalProject/AddToCart', {
                    params: {
                        pid: pid,
                        type: 1,
                        quantity: 1
                    }
                }).then(response => {
                    this.users = response.data;
                    console.log(response);
                }).catch(error => {
                    console.log(error);
                });
                alert("Added To Cart!");
            }
        </script>

    </body>
</html>
