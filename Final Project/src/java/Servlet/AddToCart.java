/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {

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
        int type = Integer.parseInt(request.getParameter("type"));
        if (type == 1) {
            String pid = request.getParameter("pid");
            String quantity = request.getParameter("quantity");
            Cookie cookie[] = request.getCookies();
            boolean flag = false;
            for (Cookie c : cookie) {
                if (c.getName().equals("cart")) {
                    String currentCart = c.getValue();
                    String[] cartItems = currentCart.split(",");
                    String newValue = "";
                    boolean check = false;
                    for (int i = 0; i < cartItems.length; i++) {
                        String[] itemDetail = cartItems[i].split("\\s+");
                        if (itemDetail[0].equals(pid)) {
                            if (i == 0) {
                                newValue += itemDetail[0] + " " + (Integer.parseInt(itemDetail[1]) + Integer.parseInt(quantity));
                            } else {
                                newValue += "," + itemDetail[0] + " " + (Integer.parseInt(itemDetail[1]) + Integer.parseInt(quantity));
                            }
                            check = true;
                        } else {
                            if (i == 0) {
                                newValue += cartItems[i];
                            } else {
                                newValue += "," + cartItems[i];
                            }
                        }
                    }
                    if (!check) {
                        newValue = newValue + "," + pid + " " + quantity;
                    }
                    c.setValue(newValue);
                    c.setMaxAge(Integer.MAX_VALUE);
                    response.addCookie(c);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                Cookie cart = new Cookie("cart", pid + " " + quantity);
                cart.setMaxAge(Integer.MAX_VALUE);
                response.addCookie(cart);
            }
            System.out.println("PID: " + pid);
            System.out.println("QUANTITY: " + quantity);
        } else {
            String[] pid = request.getParameterValues("pid");
            String[] quantity = request.getParameterValues("quantity");

            Cookie cookie[] = request.getCookies();
            for (Cookie c : cookie) {
                if (c.getName().equals("cart")) {
                    String newValue = "";
                    boolean check = false;
                    for (int i = 0; i < pid.length; i++) {
                        if (!quantity[i].equals("0")) {
                            if (!check) {
                                newValue += pid[i] + " " + quantity[i];
                                check = true;
                            } else {
                                newValue += "," + pid[i] + " " + quantity[i];
                            }
                        }
                    }
                    if (check) {
                        c.setValue(newValue);
                        c.setMaxAge(Integer.MAX_VALUE);
                        response.addCookie(c);
                        break;
                    } else {
                        c.setValue(newValue);
                        c.setMaxAge(0);
                        response.addCookie(c);
                        break;
                    }

                }
            }
            request.getRequestDispatcher("CartControl").forward(request, response);
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
