/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Minh La Anhihi
 */
public class Brand {
    private int bid;
    private String bname;
    private int aid;

    public Brand() {
    }

    public Brand(int bid, String bname, int aid) {
        this.bid = bid;
        this.bname = bname;
        this.aid = aid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Brand{" + "bid=" + bid + ", bname=" + bname + ", aid=" + aid + '}';
    }
    
    
}
