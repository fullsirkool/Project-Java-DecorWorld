/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.DAOBill;
import DAO.DAOCart;
import DAO.DAOProduct;
import Entity.CartItem;
import Reference.Reference;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Minh La Anhihi
 */
@WebServlet(name = "BillServer", urlPatterns = {"/BillServer"})
public class BillServer extends HttpServlet {

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
        DAOBill daoBill = new DAOBill();
        DAOCart daoCart = new DAOCart();
        DAOProduct daoProduct = new DAOProduct();
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Reference referance = new Reference();
        Cookie cookie[] = request.getCookies();
        String cart = "";
        String aid = "";

        for (Cookie c : cookie) {
            if (c.getName().equals("cart")) {
                //get current cart cookie value
                cart = c.getValue();
            }
            if (c.getName().equals("aID")) {
                aid = c.getValue();
            }
            if (request.getParameter("type") != null) {
                if (c.getName().equals("name")) {
                    name = c.getValue();
                }
                if (c.getName().equals("address")) {
                    address = c.getValue();
                }
                if (c.getName().equals("phoneNumber")) {
                    phone = c.getValue();
                }
                if (c.getName().equals("email")) {
                    email = c.getValue();
                }
            }
        }

        if (aid == "") {
            aid = null;
        }
        String billID = referance.hashByMD5((daoBill.getCurrentBillNumber() + 1) + "");
        //decode cart from cookie to list item
        List<CartItem> listItem = referance.decodeCartCookie(cart);
        if (daoProduct.isValidQuantitys(listItem)) {
            daoBill.insert(billID, name, address, phone, email, aid, listItem);
            if (aid != null) {
                daoCart.delete(aid);
            }
            for (Cookie c : cookie) {
                if (c.getName().equals("cart")) {
                    //get current cart cookie value
                    c.setMaxAge(0);
                    response.addCookie(c);
                    break;
                }
            }
            request.setAttribute("listItem", listItem);
            request.setAttribute("billID", billID);
            request.getRequestDispatcher("BillOut.jsp").forward(request, response);
        } else {
            request.setAttribute("isInvalid", "invalid");
            request.getRequestDispatcher("CheckOutServer").forward(request, response);
        }
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
