/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.DAOBrand;
import DAO.DAOProduct;
import Entity.Account;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Minh La Anhihi
 */
@WebServlet("/upload")
@MultipartConfig
public class AddProductServer extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        DAOProduct daoProduct = new DAOProduct();
        DAOBrand daoBrand = new DAOBrand();
        String image = "";
        List<String> listData = new ArrayList<>();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            // Create a factory for disk-based file items
            FileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                int count = 0;
                List<FileItem> fileItems = upload.parseRequest(request);
                String pathFile = "";
                // loop for multi file
                for (FileItem item : fileItems) {
                    if (count != 3) {
                        listData.add(item.getString());
                    }
                    count++;
                    //item.getString lan luot la title, cate,price... cua em
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        image = fileName;
                        String root = getServletContext().getRealPath("/");
                        File path = new File(root + "../../web" + File.separator + "images");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }

                        File uploadedFile = new File(path + "/" + fileName);
                        System.out.println(uploadedFile.getAbsolutePath());
                        item.write(uploadedFile);
                    }
                }
            } catch (Exception e) {
            }
        }
        String title = listData.get(0);
        String categoryID = listData.get(1);
        String price = listData.get(2);
        String quantity = listData.get(3);
        String shortDes = listData.get(4);
        String description = listData.get(5);
        String userID = "";
        Cookie cookie[] = request.getCookies();
        for (Cookie c : cookie) {
            if (c.getName().equals("aID")) {
                userID = c.getValue();
            }
        }
        String brandID = daoBrand.getBrandByAccountID(userID).getBid() + "";
        daoProduct.insert(title, categoryID, price, description, shortDes, image, quantity, brandID);
        response.sendRedirect("LoadProduct?brandID=" + brandID.toUpperCase());
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
