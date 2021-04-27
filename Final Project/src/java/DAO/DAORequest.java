/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Entity.Request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minh La Anhihi
 */
public class DAORequest {
    Connection connection;
    PreparedStatement pre;
    ResultSet rs;
    
    public void insert(String userid, String content){
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("insert into Request values(?,?, GETDATE())");
            pre.setString(1, userid);
            pre.setString(2, content);
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public List<Request> getAllRequest(){
        List<Request> list = new ArrayList<>();
        DAOAccount daoAccount = new DAOAccount();
        try {
            connection = new DBContext().getConnection();
            pre = connection.prepareStatement("select * from Request");
            rs = pre.executeQuery();
            while (rs.next()) {                
                list.add(new Request(daoAccount.getAccountById(rs.getString(1)), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
}
