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
public class Bill {
    private String billid;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String date;
    private Account account;
    private Product product;
    private int quantity;
    private int status;

    public Bill() {
    }

    public Bill(String billid, String name, String address, String phoneNumber, String email, String date, Account account, Product product, int quantity, int status) {
        this.billid = billid;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.date = date;
        this.account = account;
        this.product = product;
        this.quantity = quantity;
        this.status = status;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getStatusByWords() {
        if (status == 0) {
            return "Cancelled";
        } else {
            return "Done";
        }
    }

    @Override
    public String toString() {
        return "Bill{" + "billid=" + billid + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", date=" + date + ", account=" + account + ", product=" + product + ", quantity=" + quantity + ", status=" + status + '}';
    }

    
    
}
