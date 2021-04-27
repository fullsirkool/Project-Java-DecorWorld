/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Account;
import Reference.Reference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minh La Anhihi
 */
public class DAOAccount {

    Connection connection;
    PreparedStatement pre;
    ResultSet rs;
    Reference md5Convert = new Reference();

    public void insert(String email, String password, String userName, String name, String address, String phoneNumber) {
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("insert into Account values(?,?,?,?,0,?,?)");
            pre.setString(1, email);
            pre.setString(2, md5Convert.hashByMD5(password));
            pre.setString(3, userName);
            pre.setString(4, name);
            pre.setString(5, address);
            pre.setString(6, phoneNumber);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account isCorect(String userName, String pass) {
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from Account where userName = ? and password = ?");
            pre.setString(1, userName);
            pre.setString(2, md5Convert.hashByMD5(pass));
            rs = pre.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateInfor(String aID, String email, String password, String name, String address, String phoneNumber) {
        String query = "update Account set email = ?, password = ?, name = ?, address = ?, phoneNumber = ? where userID = ?";
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement(query);
            pre.setString(1, email);
            pre.setString(2, md5Convert.hashByMD5(password));
            pre.setString(3, name);
            pre.setString(4, address);
            pre.setString(5, phoneNumber);
            pre.setString(6, aID);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account getAccountById(String id) {
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement(" select * from Account where userID = ?");
            pre.setString(1, id);
            rs = pre.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8));

            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Account> unAcceptedAccounts(String query) {
        List<Account> list = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement(query);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;

    }

    public boolean isExsist(String userName) {
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from Account where userName = ? ");
            pre.setString(1, userName);
            rs = pre.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void updatePermission(String id, int role) {
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("update Account set role = ? where userID = ?");
            pre.setInt(1, role);
            pre.setString(2, id);
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertBrand(String brandName, String userID) {
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("insert into Brand values(?,?)");
            pre.setString(1, brandName);
            pre.setString(2, userID);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DAOAccount dao = new DAOAccount();
//        dao.insert("admin@gmail.com", "admin", "admin", "admin", "Hoa Lac Hi-Tech Park", "0964112357");
//        dao.updateInfor(1012, "testaccount@test.hihi", "123456", "cay qua huhu", "test", "012394345");
//        System.out.println(dao.getAccountById(3));
        dao.insertBrand("3", "TestBrand");
    }
}
