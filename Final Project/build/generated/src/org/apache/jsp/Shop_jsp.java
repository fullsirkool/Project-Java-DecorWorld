package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entity.Account;
import Entity.Account;

public final class Shop_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/Header.jsp");
    _jspx_dependants.add("/Left.jsp");
    _jspx_dependants.add("/Footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_set_var_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"description\" content=\"Ogani Template\">\n");
      out.write("        <meta name=\"keywords\" content=\"Ogani, unica, creative, html\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <title>");
      out.print(request.getParameter("shopName"));
      out.write(" Shop</title>\n");
      out.write("\n");
      out.write("        <!-- Google Font -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Css Styles -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/elegant-icons.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/nice-select.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery-ui.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/slicknav.min.css\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\">\n");
      out.write("        ");
      DAO.DAOCategories beans = null;
      synchronized (request) {
        beans = (DAO.DAOCategories) _jspx_page_context.getAttribute("beans", PageContext.REQUEST_SCOPE);
        if (beans == null){
          beans = new DAO.DAOCategories();
          _jspx_page_context.setAttribute("beans", beans, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- Page Preloder -->\n");
      out.write("        <div id=\"preloder\">\n");
      out.write("            <div class=\"loader\"></div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Header Section Begin -->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<!-- Header Section Begin -->\n");
      out.write("<header class=\"header\">\n");
      out.write("    <div class=\"header__top\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-6\">\n");
      out.write("                    <div class=\"header__top__left\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li><i class=\"fa fa-envelope\"></i> decorworld@gmail.com</li>\n");
      out.write("                            <li>Free Shipping for all Order of $99</li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-6\">\n");
      out.write("                    <div class=\"header__top__right\">\n");
      out.write("                        <div class=\"header__top__right__language\">\n");
      out.write("                            <img src=\"img/language.png\" alt=\"\">\n");
      out.write("                            <div>English</div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"header__top__right__auth\">\n");
      out.write("                            ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-3\">\n");
      out.write("                <div class=\"header__logo\">\n");
      out.write("                    <a href=\"Home.jsp\"><img src=\"img/logo/NewDecorLogoFull.png\" alt=\"\"></a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div style=\"text-align: center\" class=\"col-lg-9\">\n");
      out.write("                <nav class=\"header__menu\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"Home.jsp\" class=\"active\">Home</a></li>\n");
      out.write("                        <li ><a href=\"Product.jsp\">Product</a></li>\n");
      out.write("                        <li><a href=\"#\">Cart</a></li>\n");
      out.write("                        <li ><a href=\"index.html\">Contact</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"humberger__open\">\n");
      out.write("            <i class=\"fa fa-bars\"></i>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <a href=\"index.html\">\n");
      out.write("        <div id=\"cart\">\n");
      out.write("            <p>5</p>\n");
      out.write("            <i class=\"fa fa-shopping-bag\"></i>\n");
      out.write("        </div>\n");
      out.write("    </a>\n");
      out.write("    <div id=\"contact\">\n");
      out.write("        <a href=\"#\"><i class=\"fa fa-facebook\"></i></a><br>\n");
      out.write("        <a href=\"#\"><i class=\"fa fa-twitter\"></i></a><br>\n");
      out.write("        <a href=\"#\"><i class=\"fa fa-instagram\"></i></a><br>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("        #cart{\n");
      out.write("            cursor: pointer;\n");
      out.write("            text-align: center;\n");
      out.write("            color: white;\n");
      out.write("            position: fixed;\n");
      out.write("            float: left;\n");
      out.write("            width: 45px;\n");
      out.write("            height: 75px;\n");
      out.write("            background-color: #7FAD39;\n");
      out.write("            top: 232px;\n");
      out.write("            bottom: 0;\n");
      out.write("            left: px;\n");
      out.write("            right: 0;\n");
      out.write("        }\n");
      out.write("        #cart p{\n");
      out.write("            padding-top: 10px;\n");
      out.write("            margin-bottom: 0px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            font-size: 17px;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("        #cart i{\n");
      out.write("            font-size: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #contact{\n");
      out.write("            cursor: pointer;\n");
      out.write("            text-align: center;\n");
      out.write("            color: white;\n");
      out.write("            position: fixed;\n");
      out.write("            float: left;\n");
      out.write("            width: 45px;\n");
      out.write("            height: 140px;\n");
      out.write("            background-color: #464646;\n");
      out.write("            top: 320px;\n");
      out.write("            bottom: 0;\n");
      out.write("            left: px;\n");
      out.write("            right: 0;\n");
      out.write("            display: block;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #contact i{\n");
      out.write("            color: white;\n");
      out.write("            font-size: 26px;\n");
      out.write("            padding: 10px 0px 10px 0px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</header>\n");
      out.write("<!-- Header Section End -->\n");
      out.write("     \n");
      out.write("        <!-- Header Section End -->\n");
      out.write("\n");
      out.write("        <!-- Breadcrumb Section Begin -->\n");
      out.write("        <section class=\"breadcrumb-section\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-12 text-center\">\n");
      out.write("                        <div  class=\"breadcrumb__text\">\n");
      out.write("                            <h2>");
      out.print(request.getParameter("shopName").toUpperCase());
      out.write("</h2>\n");
      out.write("                            <div class=\"breadcrumb__option\">\n");
      out.write("                                <a href=\"AddNewProduct.jsp\">Add New Product</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Breadcrumb Section End -->\n");
      out.write("\n");
      out.write("        <!-- Product Section Begin -->\n");
      out.write("        <section class=\"product spad\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <!-- Hero Section Begin -->\n");
      out.write("                    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"col-lg-3\">\n");
      out.write("    <div class=\"hero__categories\">\n");
      out.write("        <div class=\"hero__categories__all\">\n");
      out.write("            <i class=\"fa fa-bars\"></i>\n");
      out.write("            <span>All departments</span>\n");
      out.write("        </div>\n");
      out.write("        <ul>\n");
      out.write("            ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\n");
      out.write("                    <!-- Hero Section End -->\n");
      out.write("                    <div class=\"col-lg-9 col-md-7\">\n");
      out.write("                        <div class=\"hero__search\">\n");
      out.write("                            <div class=\"hero__search__form\">\n");
      out.write("                                <form action=\"#\">\n");
      out.write("                                    <input type=\"text\" placeholder=\"What do yo u need?\">\n");
      out.write("                                    <button type=\"submit\" class=\"site-btn\">SEARCH</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"product__discount\">\n");
      out.write("                            <div class=\"section-title product__discount__title\">\n");
      out.write("                                <h2>Sale Off</h2>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"product__discount__slider owl-carousel\">\n");
      out.write("                                    <div class=\"col-lg-4\">\n");
      out.write("                                        <div class=\"product__discount__item\">\n");
      out.write("                                            <div class=\"product__discount__item__pic set-bg\"\n");
      out.write("                                                 data-setbg=\"img/product/discount/pd-1.jpg\">\n");
      out.write("                                                <div class=\"product__discount__percent\">-20%</div>\n");
      out.write("                                                <ul class=\"product__item__pic__hover\">\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                                </ul>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"product__discount__item__text\">\n");
      out.write("                                                <span>Dried Fruit</span>\n");
      out.write("                                                <h5><a href=\"#\">Raisin’n’nuts</a></h5>\n");
      out.write("                                                <div class=\"product__item__price\">$30.00 <span>$36.00</span></div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-lg-4\">\n");
      out.write("                                        <div class=\"product__discount__item\">\n");
      out.write("                                            <div class=\"product__discount__item__pic set-bg\"\n");
      out.write("                                                 data-setbg=\"img/product/discount/pd-2.jpg\">\n");
      out.write("                                                <div class=\"product__discount__percent\">-20%</div>\n");
      out.write("                                                <ul class=\"product__item__pic__hover\">\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                                </ul>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"product__discount__item__text\">\n");
      out.write("                                                <span>Vegetables</span>\n");
      out.write("                                                <h5><a href=\"#\">Vegetables’package</a></h5>\n");
      out.write("                                                <div class=\"product__item__price\">$30.00 <span>$36.00</span></div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-lg-4\">\n");
      out.write("                                        <div class=\"product__discount__item\">\n");
      out.write("                                            <div class=\"product__discount__item__pic set-bg\"\n");
      out.write("                                                 data-setbg=\"img/product/discount/pd-3.jpg\">\n");
      out.write("                                                <div class=\"product__discount__percent\">-20%</div>\n");
      out.write("                                                <ul class=\"product__item__pic__hover\">\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                                </ul>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"product__discount__item__text\">\n");
      out.write("                                                <span>Dried Fruit</span>\n");
      out.write("                                                <h5><a href=\"#\">Mixed Fruitss</a></h5>\n");
      out.write("                                                <div class=\"product__item__price\">$30.00 <span>$36.00</span></div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-lg-4\">\n");
      out.write("                                        <div class=\"product__discount__item\">\n");
      out.write("                                            <div class=\"product__discount__item__pic set-bg\"\n");
      out.write("                                                 data-setbg=\"img/product/discount/pd-4.jpg\">\n");
      out.write("                                                <div class=\"product__discount__percent\">-20%</div>\n");
      out.write("                                                <ul class=\"product__item__pic__hover\">\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                                </ul>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"product__discount__item__text\">\n");
      out.write("                                                <span>Dried Fruit</span>\n");
      out.write("                                                <h5><a href=\"#\">Raisin’n’nuts</a></h5>\n");
      out.write("                                                <div class=\"product__item__price\">$30.00 <span>$36.00</span></div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-lg-4\">\n");
      out.write("                                        <div class=\"product__discount__item\">\n");
      out.write("                                            <div class=\"product__discount__item__pic set-bg\"\n");
      out.write("                                                 data-setbg=\"img/product/discount/pd-5.jpg\">\n");
      out.write("                                                <div class=\"product__discount__percent\">-20%</div>\n");
      out.write("                                                <ul class=\"product__item__pic__hover\">\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                                </ul>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"product__discount__item__text\">\n");
      out.write("                                                <span>Dried Fruit</span>\n");
      out.write("                                                <h5><a href=\"#\">Raisin’n’nuts</a></h5>\n");
      out.write("                                                <div class=\"product__item__price\">$30.00 <span>$36.00</span></div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-lg-4\">\n");
      out.write("                                        <div class=\"product__discount__item\">\n");
      out.write("                                            <div class=\"product__discount__item__pic set-bg\"\n");
      out.write("                                                 data-setbg=\"img/product/discount/pd-6.jpg\">\n");
      out.write("                                                <div class=\"product__discount__percent\">-20%</div>\n");
      out.write("                                                <ul class=\"product__item__pic__hover\">\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                                    <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                                </ul>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"product__discount__item__text\">\n");
      out.write("                                                <span>Dried Fruit</span>\n");
      out.write("                                                <h5><a href=\"#\">Raisin’n’nuts</a></h5>\n");
      out.write("                                                <div class=\"product__item__price\">$30.00 <span>$36.00</span></div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"filter__item\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-lg-4 col-md-5\">\n");
      out.write("                                    <div class=\"filter__sort\">\n");
      out.write("                                        <span>Sort By</span>\n");
      out.write("                                        <select>\n");
      out.write("                                            <option value=\"0\">Default</option>\n");
      out.write("                                            <option value=\"0\">Default</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-4 col-md-4\">\n");
      out.write("                                    <div class=\"filter__found\">\n");
      out.write("                                        <h6><span>16</span> Products found</h6>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-4 col-md-3\">\n");
      out.write("                                    <div class=\"filter__option\">\n");
      out.write("                                        <span class=\"icon_grid-2x2\"></span>\n");
      out.write("                                        <span class=\"icon_ul\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-lg-4 col-md-6 col-sm-6\">\n");
      out.write("                                <div class=\"product__item\">\n");
      out.write("                                    <div class=\"product__item__pic set-bg\" data-setbg=\"img/product/product-1.jpg\">\n");
      out.write("                                        <ul class=\"product__item__pic__hover\">\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"product__item__text\">\n");
      out.write("                                        <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                        <h5>$30.00</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-4 col-md-6 col-sm-6\">\n");
      out.write("                                <div class=\"product__item\">\n");
      out.write("                                    <div class=\"product__item__pic set-bg\" data-setbg=\"img/product/product-2.jpg\">\n");
      out.write("                                        <ul class=\"product__item__pic__hover\">\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"product__item__text\">\n");
      out.write("                                        <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                        <h5>$30.00</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-4 col-md-6 col-sm-6\">\n");
      out.write("                                <div class=\"product__item\">\n");
      out.write("                                    <div class=\"product__item__pic set-bg\" data-setbg=\"img/product/product-3.jpg\">\n");
      out.write("                                        <ul class=\"product__item__pic__hover\">\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"product__item__text\">\n");
      out.write("                                        <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                        <h5>$30.00</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-4 col-md-6 col-sm-6\">\n");
      out.write("                                <div class=\"product__item\">\n");
      out.write("                                    <div class=\"product__item__pic set-bg\" data-setbg=\"img/product/product-4.jpg\">\n");
      out.write("                                        <ul class=\"product__item__pic__hover\">\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"product__item__text\">\n");
      out.write("                                        <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                        <h5>$30.00</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-4 col-md-6 col-sm-6\">\n");
      out.write("                                <div class=\"product__item\">\n");
      out.write("                                    <div class=\"product__item__pic set-bg\" data-setbg=\"img/product/product-5.jpg\">\n");
      out.write("                                        <ul class=\"product__item__pic__hover\">\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"product__item__text\">\n");
      out.write("                                        <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                        <h5>$30.00</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-4 col-md-6 col-sm-6\">\n");
      out.write("                                <div class=\"product__item\">\n");
      out.write("                                    <div class=\"product__item__pic set-bg\" data-setbg=\"img/product/product-6.jpg\">\n");
      out.write("                                        <ul class=\"product__item__pic__hover\">\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"product__item__text\">\n");
      out.write("                                        <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                        <h5>$30.00</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-4 col-md-6 col-sm-6\">\n");
      out.write("                                <div class=\"product__item\">\n");
      out.write("                                    <div class=\"product__item__pic set-bg\" data-setbg=\"img/product/product-7.jpg\">\n");
      out.write("                                        <ul class=\"product__item__pic__hover\">\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"product__item__text\">\n");
      out.write("                                        <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                        <h5>$30.00</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-4 col-md-6 col-sm-6\">\n");
      out.write("                                <div class=\"product__item\">\n");
      out.write("                                    <div class=\"product__item__pic set-bg\" data-setbg=\"img/product/product-8.jpg\">\n");
      out.write("                                        <ul class=\"product__item__pic__hover\">\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"product__item__text\">\n");
      out.write("                                        <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                        <h5>$30.00</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-4 col-md-6 col-sm-6\">\n");
      out.write("                                <div class=\"product__item\">\n");
      out.write("                                    <div class=\"product__item__pic set-bg\" data-setbg=\"img/product/product-9.jpg\">\n");
      out.write("                                        <ul class=\"product__item__pic__hover\">\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"product__item__text\">\n");
      out.write("                                        <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                        <h5>$30.00</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-4 col-md-6 col-sm-6\">\n");
      out.write("                                <div class=\"product__item\">\n");
      out.write("                                    <div class=\"product__item__pic set-bg\" data-setbg=\"img/product/product-10.jpg\">\n");
      out.write("                                        <ul class=\"product__item__pic__hover\">\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"product__item__text\">\n");
      out.write("                                        <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                        <h5>$30.00</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-4 col-md-6 col-sm-6\">\n");
      out.write("                                <div class=\"product__item\">\n");
      out.write("                                    <div class=\"product__item__pic set-bg\" data-setbg=\"img/product/product-11.jpg\">\n");
      out.write("                                        <ul class=\"product__item__pic__hover\">\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"product__item__text\">\n");
      out.write("                                        <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                        <h5>$30.00</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-lg-4 col-md-6 col-sm-6\">\n");
      out.write("                                <div class=\"product__item\">\n");
      out.write("                                    <div class=\"product__item__pic set-bg\" data-setbg=\"img/product/product-12.jpg\">\n");
      out.write("                                        <ul class=\"product__item__pic__hover\">\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-heart\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-retweet\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fa fa-shopping-cart\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"product__item__text\">\n");
      out.write("                                        <h6><a href=\"#\">Crab Pool Security</a></h6>\n");
      out.write("                                        <h5>$30.00</h5>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"product__pagination\">\n");
      out.write("                            <a href=\"#\">1</a>\n");
      out.write("                            <a href=\"#\">2</a>\n");
      out.write("                            <a href=\"#\">3</a>\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-long-arrow-right\"></i></a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <!-- Product Section End -->\n");
      out.write("\n");
      out.write("        <!-- Footer Section End -->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Footer Section Begin -->\n");
      out.write("<footer class=\"footer spad\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-3 col-md-6 col-sm-6\">\n");
      out.write("                <div class=\"footer__about\">\n");
      out.write("                    <div class=\"footer__about__logo\">\n");
      out.write("                        <a href=\"./index.html\"><img src=\"img/logo/DecoLogo.png\" alt=\"\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <ul>\n");
      out.write("                        <li>Address: Hoa Lac Hi-Tech Park - Thach Hoa, Thach That, Ha Noi</li>\n");
      out.write("                        <li>Phone: +84 96.188.888</li>\n");
      out.write("                        <li>Email: decorworld@gmail.com</li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-4 col-md-6 col-sm-6 offset-lg-1\">\n");
      out.write("                <div class=\"footer__widget\">\n");
      out.write("                    <h6>Useful Links</h6>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">About Us</a></li>\n");
      out.write("                        <li><a href=\"#\">About Our Shop</a></li>\n");
      out.write("                        <li><a href=\"#\">Secure Shopping</a></li>\n");
      out.write("                        <li><a href=\"#\">Delivery infomation</a></li>\n");
      out.write("                        <li><a href=\"#\">Privacy Policy</a></li>\n");
      out.write("                        <li><a href=\"#\">Our Sitemap</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">Who We Are</a></li>\n");
      out.write("                        <li><a href=\"#\">Our Services</a></li>\n");
      out.write("                        <li><a href=\"#\">Projects</a></li>\n");
      out.write("                        <li><a href=\"#\">Contact</a></li>\n");
      out.write("                        <li><a href=\"#\">Innovation</a></li>\n");
      out.write("                        <li><a href=\"#\">Testimonials</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-4 col-md-12\">\n");
      out.write("                <div class=\"footer__widget\">\n");
      out.write("                    <h6>Join Our Newsletter Now</h6>\n");
      out.write("                    <p>Get E-mail updates about our latest shop and special offers.</p>\n");
      out.write("                    <form action=\"#\">\n");
      out.write("                        <input type=\"text\" placeholder=\"Enter your mail\">\n");
      out.write("                        <button type=\"submit\" class=\"site-btn\">Subscribe</button>\n");
      out.write("                    </form>\n");
      out.write("                    <div class=\"footer__widget__social\">\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-instagram\"></i></a>\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-pinterest\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("<!-- Footer Section End -->\n");
      out.write("\n");
      out.write("        <!-- Footer Section End -->\n");
      out.write("\n");
      out.write("        <!-- Js Plugins -->\n");
      out.write("        <script src=\"js/jquery-3.3.1.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.nice-select.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery-ui.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.slicknav.js\"></script>\n");
      out.write("        <script src=\"js/mixitup.min.js\"></script>\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.cookies}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("c");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("    ");
          if (_jspx_meth_c_if_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write('\n');
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.name eq 'email'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("        ");
        if (_jspx_meth_c_set_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_set_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_set_0.setVar("check");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${1}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${check != 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                <a href=\"Login.jsp\"><i class=\"fa fa-sign-in\"></i>Login</a>\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${check == 1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                <div style=\"display: flex\">\n");
        out.write("                                    <a href=\"Account.jsp\"><i class=\"fa fa-user\"></i>Account</a>\n");
        out.write("                                    &nbsp;&nbsp;&nbsp;&nbsp;\n");
        out.write("                                    <a href=\"Logout\"><i class=\"fa fa-sign-out\"></i>Logout</a>\n");
        out.write("                                </div>\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${beans.allCategories}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("c");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                <li><a href=\"#\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.cName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></li>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}
