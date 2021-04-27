/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.DAOAccount;
import DAO.DAOCart;
import Entity.Account;
import Entity.CartItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Minh La Anhihi
 */
public class LoginServer extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //load account to session
        DAOAccount daoAccount = new DAOAccount();
        DAOCart daoCart = new DAOCart();
        //login control
        String userName = request.getParameter("username");
        String pass = request.getParameter("pass");
        Account account = daoAccount.isCorect(userName, pass);
        if (account == null || account.getRole() == 0) {
            request.setAttribute("isCorrect", false);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            List<CartItem> listCartItems = daoCart.getCartItemsByAID(account.getaID() + "");
            //check is exsist cart
            if (!listCartItems.isEmpty()) {
                Cookie cookie[] = request.getCookies();
                String newValue = "";
                for (CartItem item : listCartItems) {
                    newValue += "," + item.getProduct().getpID() + " " + item.getQuantity();
                }
                boolean isExist = false;
                for (Cookie c : cookie) {
                    if (c.getName().equals("cart")) {
                        //get current cart cookie value
                        c.setValue(c.getValue() + newValue);
                        c.setMaxAge(Integer.MAX_VALUE);
                        response.addCookie(c);
                        isExist = true;
                    }
                }
                if (!isExist) {
                    Cookie cart = new Cookie("cart", newValue.replaceFirst(",", ""));
                    cart.setMaxAge(Integer.MAX_VALUE);
                    response.addCookie(cart);
                }
            }

            //add account infor to cookie
            Cookie aID = new Cookie("aID", account.getaID() + "");
            Cookie email = new Cookie("email", account.getEmail());
            Cookie password = new Cookie("password", account.getPassword());
            Cookie username = new Cookie("username", account.getUserName());
            Cookie name = new Cookie("name", account.getName());
            Cookie role = new Cookie("role", account.getRole() + "");
            Cookie address = new Cookie("address", account.getAddress());
            Cookie phoneNumber = new Cookie("phoneNumber", account.getPhoneNumber());
            aID.setMaxAge(Integer.MAX_VALUE);
            email.setMaxAge(Integer.MAX_VALUE);
            password.setMaxAge(Integer.MAX_VALUE);
            username.setMaxAge(Integer.MAX_VALUE);
            name.setMaxAge(Integer.MAX_VALUE);
            role.setMaxAge(Integer.MAX_VALUE);
            address.setMaxAge(Integer.MAX_VALUE);
            phoneNumber.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(aID);
            response.addCookie(email);
            response.addCookie(password);
            response.addCookie(username);
            response.addCookie(name);
            response.addCookie(role);
            response.addCookie(address);
            response.addCookie(phoneNumber);

            if (account.getRole() == 1) {
                response.sendRedirect("ManagerServer");
            } else {
                response.sendRedirect("HomeServer");
            }
        }
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
