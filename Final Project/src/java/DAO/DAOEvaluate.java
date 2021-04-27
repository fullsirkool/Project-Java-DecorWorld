/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Evaluate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minh La Anhihi
 */
public class DAOEvaluate {

    Connection connection;
    PreparedStatement pre;
    ResultSet rs;

    public List<Evaluate> getEvaluatesByPID(int pid) {
        DAOAccount daoAccount = new DAOAccount();
        List<Evaluate> list = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("Select * from Evaluate where productID = ?");
            pre.setInt(1, pid);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Evaluate(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), daoAccount.getAccountById(rs.getInt(5) + ""), rs.getInt(6)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public int getAvgRateByID(int pid) {
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select AVG(rate) from Evaluate where productID = ?");
            pre.setInt(1, pid);
            rs = pre.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void insert(String content, String rate, String userID, String pid) {
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("insert into Evaluate values(?,?,GETDATE(),?,?)");
            pre.setString(1, content);
            pre.setString(2, rate);
            pre.setString(3, userID);
            pre.setString(4, pid);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
