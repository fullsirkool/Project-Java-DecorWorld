/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Bill;
import Entity.CartItem;
import Entity.TotalBill;
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
public class DAOBill {
    
    Connection connection;
    PreparedStatement pre;
    ResultSet rs;
    
    public int getCurrentBillNumber() {
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select count(distinct BillID) from Bill");
            rs = pre.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public List<Bill> getBillByBillID(String BillID) {
        List<Bill> list = new ArrayList<>();
        DAOAccount daoAccount = new DAOAccount();
        DAOProduct daoProduct = new DAOProduct();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from Bill where BillID = ?");
            pre.setString(1, BillID);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), daoAccount.getAccountById(rs.getString(7)), daoProduct.getProductByID(rs.getString(8)), rs.getInt(9), rs.getInt(10)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public Bill getDetailBill(String BillID, String productid) {
        DAOAccount daoAccount = new DAOAccount();
        DAOProduct daoProduct = new DAOProduct();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from Bill where BillID = ? and productid = ?");
            pre.setString(1, BillID);
            pre.setString(2, productid);
            rs = pre.executeQuery();
            while (rs.next()) {
                return new Bill(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), daoAccount.getAccountById(rs.getString(7)), daoProduct.getProductByID(rs.getString(8)), rs.getInt(9), rs.getInt(10));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<TotalBill> getTotalBillsByUserID(String userid) {
        List<TotalBill> list = new ArrayList<>();
        DAOBill daoBill = new DAOBill();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select distinct (BillID), userid from Bill where userid = ?");
            pre.setString(1, userid);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new TotalBill(daoBill.getBillByBillID(rs.getString(1)), rs.getString(1), rs.getInt(2)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public void updateStatus(String userid, List<Bill> list, int status) {
        for (Bill bill : list) {
            try {
                connection = new DBContext().getConnection();
                pre = connection.prepareStatement("update Bill set status = ? where BillID = ? and productid = ?");
                pre.setInt(1, status);
                pre.setString(2, bill.getBillid());
                pre.setInt(3, bill.getProduct().getpID());
                pre.executeUpdate();
            } catch (Exception e) {
            }
        }
    }
    
    public void insert(String billid, String name, String address, String phone, String email, String userid, List<CartItem> list) {
        for (CartItem item : list) {
            try {
                connection = new DBContext().getConnection();
                pre = connection.prepareStatement("insert into Bill values(?,?,?,?,?,GETDATE(),?,?,?,1)");
                pre.setString(1, billid);
                pre.setString(2, name);
                pre.setString(3, address);
                pre.setString(4, phone);
                pre.setString(5, email);
                pre.setString(6, userid);
                pre.setInt(7, item.getProduct().getpID());
                pre.setString(8, item.getQuantity());
                pre.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public List<Bill> getBillByBrandID(int BrandID) {
        DAOAccount daoAccount = new DAOAccount();
        DAOProduct daoProduct = new DAOProduct();
        List<Bill> list = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from Bill b, Product p"
                    + " where p.productID = b.productid and p.brandID = ?");
            pre.setInt(1, BrandID);
            rs = pre.executeQuery();
            while (rs.next()) {                
                list.add(new Bill(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), daoAccount.getAccountById(rs.getString(7)), daoProduct.getProductByID(rs.getString(8)), rs.getInt(9), rs.getInt(10)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Bill> getBillByBrandIDMonth(int BrandID) {
        DAOAccount daoAccount = new DAOAccount();
        DAOProduct daoProduct = new DAOProduct();
        List<Bill> list = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from Bill b, Product p"
                    + " where p.productID = b.productid and p.brandID = ? and date between GETDATE() - 30 and GETDATE()");
            pre.setInt(1, BrandID);
            rs = pre.executeQuery();
            while (rs.next()) {                
                list.add(new Bill(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), daoAccount.getAccountById(rs.getString(7)), daoProduct.getProductByID(rs.getString(8)), rs.getInt(9), rs.getInt(10)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        DAOProduct daoProduct = new DAOProduct();
        DAOBill daoBill = new DAOBill();
        List<TotalBill> list = daoBill.getTotalBillsByUserID("2");
        for (TotalBill bill : list) {
            System.out.println(bill);
        }
    }
}
