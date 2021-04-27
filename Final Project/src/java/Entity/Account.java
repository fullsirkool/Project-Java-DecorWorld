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
public class Account {
    private int aID;
    private String email;
    private String password;
    private String userName;
    private String name;
    private int role;
    private String address;
    private String phoneNumber;

    public Account() {
    }

    public Account(int aID, String email, String password, String userName, String name, int role, String address, String phoneNumber) {
        this.aID = aID;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.name = name;
        this.role = role;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getaID() {
        return aID;
    }

    public void setaID(int aID) {
        this.aID = aID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "Account{" + "aID=" + aID + ", email=" + email + ", password=" + password + ", userName=" + userName + ", name=" + name + ", role=" + role + ", address=" + address + ", phoneNumber=" + phoneNumber + '}';
    }
    
}
