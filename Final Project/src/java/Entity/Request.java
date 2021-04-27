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
public class Request {
    private Account account;
    private String content;
    private String date;

    public Request() {
    }

    public Request(Account account, String content, String date) {
        this.account = account;
        this.content = content;
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Request{" + "account=" + account + ", content=" + content + ", date=" + date + '}';
    }
    
    
    
}
