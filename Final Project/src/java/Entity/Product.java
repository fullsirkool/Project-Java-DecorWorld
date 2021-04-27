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
public class Product {

    private int pID;
    private String title;
    private Categories categorie;
    private double price;
    private String description;
    private String shortDescription;
    private String image;
    private int quantity;
    private Brand brand;
    private int avgRate;
    private List<Evaluate> evaluates;

    public Product() {
    }

    public Product(int pID, String title, Categories categorie, double price, String description, String shortDescription, String image, int quantity, Brand brand, int avgRate, List<Evaluate> evaluates) {
        this.pID = pID;
        this.title = title;
        this.categorie = categorie;
        this.price = price;
        this.description = description;
        this.shortDescription = shortDescription;
        this.image = image;
        this.quantity = quantity;
        this.brand = brand;
        this.avgRate = avgRate;
        this.evaluates = evaluates;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Categories getCategorie() {
        return categorie;
    }

    public void setCategorie(Categories categorie) {
        this.categorie = categorie;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(int avgRate) {
        this.avgRate = avgRate;
    }

    public List<Evaluate> getEvaluates() {
        return evaluates;
    }

    public void setEvaluates(List<Evaluate> evaluates) {
        this.evaluates = evaluates;
    }

    public String getShortPrice() {
        return (price + "").replace(".0", "");
    }

    @Override
    public String toString() {
        return "Product{" + "pID=" + pID + ", title=" + title + ", categorie=" + categorie + ", price=" + price + ", description=" + description + ", shortDescription=" + shortDescription + ", image=" + image + ", quantity=" + quantity + ", brand=" + brand + ", avgRate=" + avgRate + ", evaluates=" + evaluates + '}';
    }

}
