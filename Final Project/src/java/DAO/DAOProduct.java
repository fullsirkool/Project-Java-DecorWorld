/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Bill;
import Entity.CartItem;
import Entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minh La Anhihi
 */
public class DAOProduct {

    Connection connection;
    PreparedStatement pre;
    ResultSet rs;

    public void insert(String title, String cID, String price, String description, String shortDescription, String image, String quantity, String bID) {
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("insert into Product values (?,?,?,?,?,?,?,?)");
            pre.setString(1, title);
            pre.setString(2, cID);
            pre.setString(3, price);
            pre.setString(4, description);
            pre.setString(5, shortDescription);
            pre.setString(6, image);
            pre.setString(7, quantity);
            pre.setString(8, bID);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        DAOEvaluate daoEvaluate = new DAOEvaluate();
        DAOCategories daoCategories = new DAOCategories();
        DAOBrand daoBrand = new DAOBrand();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from product");
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), daoCategories.getCategorieByPID(rs.getInt(1)), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), daoBrand.getBrandByID(rs.getInt(9)), daoEvaluate.getAvgRateByID(rs.getInt(1)), daoEvaluate.getEvaluatesByPID(rs.getInt(1))));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getTopNew(int size) {
        List<Product> list = new ArrayList<>();
        DAOEvaluate daoEvaluate = new DAOEvaluate();
        DAOCategories daoCategories = new DAOCategories();
        DAOBrand daoBrand = new DAOBrand();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select top(" + size + ") * from Product order by productID desc");
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), daoCategories.getCategorieByPID(rs.getInt(1)), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), daoBrand.getBrandByID(rs.getInt(9)), daoEvaluate.getAvgRateByID(rs.getInt(1)), daoEvaluate.getEvaluatesByPID(rs.getInt(1))));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getTopRate() {
        List<Product> list = new ArrayList<>();
        DAOEvaluate daoEvaluate = new DAOEvaluate();
        DAOCategories daoCategories = new DAOCategories();
        DAOBrand daoBrand = new DAOBrand();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select top(6) p.productID, p.title, p.categoriesID, p.price, p.[description], p.shortDescription, p.[image], p.quantity, p.brandID, AVG(rate) [avgRate] from Evaluate e, Product p"
                    + " where e.productID = p.productID"
                    + " group by p.productID, p.title, p.categoriesID, p.price, p.[description], p.shortDescription, p.[image], p.quantity, p.brandID"
                    + " order by avgRate desc");
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), daoCategories.getCategorieByPID(rs.getInt(1)), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), daoBrand.getBrandByID(rs.getInt(9)), daoEvaluate.getAvgRateByID(rs.getInt(1)), daoEvaluate.getEvaluatesByPID(rs.getInt(1))));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getProductsByCategory(String cid) {
        List<Product> list = new ArrayList<>();
        DAOEvaluate daoEvaluate = new DAOEvaluate();
        DAOCategories daoCategories = new DAOCategories();
        DAOBrand daoBrand = new DAOBrand();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from Product where categoriesID = ?");
            pre.setString(1, cid);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), daoCategories.getCategorieByPID(rs.getInt(1)), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), daoBrand.getBrandByID(rs.getInt(9)), daoEvaluate.getAvgRateByID(rs.getInt(1)), daoEvaluate.getEvaluatesByPID(rs.getInt(1))));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public Product getProductByID(String pid) {
        DAOEvaluate daoEvaluate = new DAOEvaluate();
        DAOCategories daoCategories = new DAOCategories();
        DAOBrand daoBrand = new DAOBrand();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from product where productID = ?");
            pre.setString(1, pid);
            rs = pre.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), daoCategories.getCategorieByPID(rs.getInt(1)), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), daoBrand.getBrandByID(rs.getInt(9)), daoEvaluate.getAvgRateByID(rs.getInt(1)), daoEvaluate.getEvaluatesByPID(rs.getInt(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Product> getProductsByQuery(String query) {
        List<Product> list = new ArrayList<>();
        DAOEvaluate daoEvaluate = new DAOEvaluate();
        DAOCategories daoCategories = new DAOCategories();
        DAOBrand daoBrand = new DAOBrand();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement(query);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), daoCategories.getCategorieByPID(rs.getInt(1)), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), daoBrand.getBrandByID(rs.getInt(9)), daoEvaluate.getAvgRateByID(rs.getInt(1)), daoEvaluate.getEvaluatesByPID(rs.getInt(1))));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void updateQuantity(List<Bill> list){
        for (Bill bill : list) {
            try {
                connection = new DBContext().getConnection();
                pre = connection.prepareStatement("update Product set	quantity = (quantity + ?) where productID = ?");
                pre.setInt(1, bill.getQuantity());
                pre.setInt(2, bill.getProduct().getpID());
                pre.executeUpdate();
            } catch (Exception e) {
            }
        }
    }
    
    public boolean isValidQuantitys(List<CartItem> listCart){
        List<Integer> list = new ArrayList<>();
        for (CartItem item : listCart) {
            try {
                connection = new DBContext().getConnection();
                pre = connection.prepareStatement("select quantity from Product where productID = ?");
                pre.setInt(1, item.getProduct().getpID());
                rs = pre.executeQuery();
                while (rs.next()) {                    
                    if (rs.getInt(1) > Integer.parseInt(item.getQuantity())) {
                        list.add(rs.getInt(1));
                    }
                }
            } catch (Exception e) {
            }
        }
        return list.size() == listCart.size();
    }

    public static void main(String[] args) {
        DAOProduct daoProduct = new DAOProduct();
        List<Product> list = daoProduct.getProductsByCategory("1");
        for (Product product : list) {
            System.out.println(product);
        }
    }
}
