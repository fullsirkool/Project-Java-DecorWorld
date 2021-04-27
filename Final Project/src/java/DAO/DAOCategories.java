/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Categories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minh La Anhihi
 */
public class DAOCategories {

    Connection connection;
    PreparedStatement pre;
    ResultSet rs;

    public List<Categories> getAllCategories() {
        List<Categories> list = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from Categories");
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Categories(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public Categories getCategorieByPID(int pid) {
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select c.categoriesID, c.categoriesName, c.categoriesImg from Categories c, Product p"
                    + " where c.categoriesID = p.categoriesID and p.productID = ?");
            pre.setInt(1, pid);
            rs = pre.executeQuery();
            while (rs.next()) {
                return new Categories(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        DAOCategories dao = new DAOCategories();
//        List<Categories> list = dao.getAllCategories();
//        for (Categories categories : list) {
//            System.out.println(categories);
//        }
        System.out.println(dao.getCategorieByPID(1));
    }
}
