/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.DAOBrand;
import DAO.DAOProduct;
import Entity.Product;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Minh La Anhihi
 */
@WebServlet(name = "LoadProduct", urlPatterns = {"/LoadProduct"})
public class LoadProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOProduct daoProduct = new DAOProduct();
        DAOBrand daoBrand = new DAOBrand();
        List<Product> list;
        String cid = request.getParameter("cid");
        if (cid != null) {
            list = daoProduct.getProductsByCategory(cid);
        } else {
            String brandID = request.getParameter("brandID");
            String aid = request.getParameter("aid");
            if (aid == null && brandID == null) {
                String select = request.getParameter("selectSort");
                if (select == null) {
                    select = "0";
                }

                if (select.equals("0")) {
                    list = daoProduct.getAllProducts();
                } else if (select.equals("1")) {
                    list = daoProduct.getProductsByQuery("select p.productID, p.title, p.categoriesID, p.price, p.[description], p.shortDescription, p.[image], p.quantity, p.brandID, AVG(rate) [avgRate] from Evaluate e, Product p"
                            + " where e.productID = p.productID"
                            + " group by p.productID, p.title, p.categoriesID, p.price, p.[description], p.shortDescription, p.[image], p.quantity, p.brandID"
                            + " order by avgRate desc");
                } else if (select.equals("2")) {
                    list = daoProduct.getProductsByQuery("select * from Product order by price asc");
                } else {
                    list = daoProduct.getProductsByQuery("select * from Product order by price desc");
                }
            } else {
                if (brandID == null) {
                    brandID = daoBrand.getBrandIDByUserID(aid) + "";
                }
                String select = request.getParameter("selectSort");
                if (select == null) {
                    select = "0";
                }
                if (select.equals("0")) {
                    list = daoProduct.getProductsByQuery("select * from Product where brandID = " + brandID);
                } else if (select.equals("1")) {
                    list = daoProduct.getProductsByQuery("select p.productID, p.title, p.categoriesID, p.price, p.[description], p.shortDescription, p.[image], p.quantity, p.brandID, AVG(rate) [avgRate] from Evaluate e, Product p"
                            + " where e.productID = p.productID and p.brandID = " + brandID
                            + " group by p.productID, p.title, p.categoriesID, p.price, p.[description], p.shortDescription, p.[image], p.quantity, p.brandID"
                            + " order by avgRate desc");
                } else if (select.equals("2")) {
                    list = daoProduct.getProductsByQuery("select * from Product where brandID = " + brandID + " order by price asc");
                } else {
                    list = daoProduct.getProductsByQuery("select * from Product where brandID = " + brandID + " order by price desc");
                }
                request.setAttribute("aidFromServer", aid);
            }
        }
        request.setAttribute("listP", list);
        request.getRequestDispatcher("Product.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
