/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reference;

import DAO.DAOProduct;
import Entity.CartItem;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minh La Anhihi
 */
public class Reference {

    public String hashByMD5(String message) {
        String digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(message.getBytes("UTF-8"));

            //converting byte array to Hexadecimal String
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }

            digest = sb.toString();

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {

        }
        return digest;
    }

    public List<CartItem> decodeCartCookie(String cartCookie) {
        DAOProduct daoProduct = new DAOProduct();
        String cartItem[] = cartCookie.split(",");
        List<CartItem> listItem = new ArrayList<>();
        for (String ct : cartItem) {
            String[] items = ct.split("\\s+");
            listItem.add(new CartItem(daoProduct.getProductByID(items[0]), items[1]));
        }
        return listItem;
    }
}
