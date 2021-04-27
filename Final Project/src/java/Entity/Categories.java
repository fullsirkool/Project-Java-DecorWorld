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
public class Categories {
    private int cID;
    private String cName;
    private String cImg;

    public Categories() {
    }

    public Categories(int cID, String cName, String cImg) {
        this.cID = cID;
        this.cName = cName;
        this.cImg = cImg;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcImg() {
        return cImg;
    }

    public void setcImg(String cImg) {
        this.cImg = cImg;
    }

    @Override
    public String toString() {
        return "Categories{" + "cID=" + cID + ", cName=" + cName + ", cImg=" + cImg + '}';
    }

    
    
}
