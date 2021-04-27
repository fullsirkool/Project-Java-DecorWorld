/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.CartItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minh La Anhihi
 */
public class DAOCart {

    Connection connection;
    PreparedStatement pre;
    ResultSet rs;

    public int getTotalNumber(String userid) {
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select count(userid) from Cart where userid = ?");
            pre.setString(1, userid);
            rs = pre.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void saveCurrentCart(String aid, List<CartItem> list) {
        for (CartItem item : list) {
            try {
                connection = new DBContext().getConnection();
                pre = connection.prepareStatement("insert into Cart values(?,?,?)");
                pre.setString(1, aid);
                pre.setInt(2, item.getProduct().getpID());
                pre.setString(3, item.getQuantity());
                pre.executeUpdate();
            } catch (Exception e) {
            }
        }
    }

    public List<CartItem> getCartItemsByAID(String aid) {
        DAOProduct daoProduct = new DAOProduct();
        List<CartItem> list = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from Cart where userid = ?");
            pre.setString(1, aid);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new CartItem(daoProduct.getProductByID(rs.getString(2)), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public void delete(String userid) {
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("delete from Cart where userid = ?");
            pre.setString(1, userid);
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        DAOCart daoCart = new DAOCart();
        List<CartItem> list = daoCart.getCartItemsByAID("2");
        for (CartItem cartItem : list) {
            System.out.println(cartItem);
        }
    }
}
