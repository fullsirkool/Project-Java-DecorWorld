/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Minh La Anhihi
 */
public class DAOBrand {
    Connection connection;
    PreparedStatement pre;
    ResultSet rs;
    
    public Brand getBrandByAccountID(String aid){
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from Brand where userID = ?");
            pre.setString(1, aid);
            rs = pre.executeQuery();
            while (rs.next()) {                
                return new Brand(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Brand getBrandByID(int bid){
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from Brand where brandID = ?");
            pre.setInt(1, bid);
            rs = pre.executeQuery();
            while (rs.next()) {                
                return new Brand(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int getBrandIDByUserID(String userid){
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select brandID from Brand b, Account a where b.userID = a.userID and a.userID = ?");
            pre.setString(1, userid);
            rs = pre.executeQuery();
            while (rs.next()) {                
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public static void main(String[] args) {
        DAOBrand daoBrand = new DAOBrand();
        System.out.println(daoBrand.getBrandByAccountID("2"));
    }
}
