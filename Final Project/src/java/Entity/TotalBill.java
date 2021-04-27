/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;

/**
 *
 * @author Minh La Anhihi
 */
public class TotalBill {

    private List<Bill> bills;
    private String billID;
    private int userid;

    public TotalBill() {
    }

    public TotalBill(List<Bill> bills, String billID, int userid) {
        this.bills = bills;
        this.billID = billID;
        this.userid = userid;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "TotalBill{" + "bills=" + bills + ", billID=" + billID + ", userid=" + userid + '}';
    }

    
    
    
}
