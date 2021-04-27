<%-- 
    Document   : Detail
    Created on : Sep 23, 2020, 11:38:58 PM
    Author     : Minh La Anhihi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="beans" class="DAO.DAOCategories" scope="request"/>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Add New Product</title>

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
                            <h2>ADD NEW PRODUCT</h2>
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
                    <form action="AddProductServer" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-lg-12 col-md-12">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Title<span>*</span></p>
                                            <input name="title" type="text">
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Categories<span>*</span></p>
                                            <select name="categoryID">
                                                <c:forEach items="${beans.allCategories}" var="c">
                                                    <option value="${c.cID}">${c.cName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="checkout__input">
                                    <p>Price<span>*</span></p>
                                    <input name="price" type="number">
                                </div>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <div>
                                                <p>Image<span>*</span></p>
                                            </div>
                                        </div>
                                        <input type="file" name="file" value="">
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p>Quantity<span>*</span></p>
                                            <input name="quantity" type="number">
                                        </div>
                                    </div>
                                </div>
                                <div class="checkout__input">
                                    <p>Short Description<span>*</span></p>
                                    <input name="shortDes" type="text">
                                </div>
                                <div class="checkout__input">
                                    <p>Description<span>*</span></p>
                                    <textarea name="description" id="" rows="10"></textarea>
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
    </body>
</html>
