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
public class Evaluate {
    private int eid;
    private String econtent;
    private int rate;
    private String date;
    private Account account;
    private int pid;

    public Evaluate() {
    }

    public Evaluate(int eid, String econtent, int rate, String date, Account account, int pid) {
        this.eid = eid;
        this.econtent = econtent;
        this.rate = rate;
        this.date = date;
        this.account = account;
        this.pid = pid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEcontent() {
        return econtent;
    }

    public void setEcontent(String econtent) {
        this.econtent = econtent;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Evaluate{" + "eid=" + eid + ", econtent=" + econtent + ", rate=" + rate + ", date=" + date + ", account=" + account + ", pid=" + pid + '}';
    }

    

    
    
}
