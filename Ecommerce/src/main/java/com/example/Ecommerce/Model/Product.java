package com.example.Ecommerce.Model;

import javax.persistence.*;


@Entity
@Table( name = "Product" )
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  int pId;
    @Column
    private  String pName ;
    @Column
    private  int pPrice ;
    @Column
    private int pWeight ;
    @Column
    private  int pPin;



    public Product () {

    }
    public Product( String pName, int pPrice, int pWeight, int pPin) {
        this.pName = pName;
        this.pPrice = pPrice;
        this.pWeight = pWeight;
        this.pPin=pPin;
    }

    public int getpId() {
        return pId;
    }

    public String getpName() {
        return this.pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getpWeight() {
        return pWeight;
    }

    public void setpWeight(int pWeight) {
        this.pWeight = pWeight;
    }

    public int getpPin() {
        return pPin;
    }

    public void setpPin(int pPin) {
        this.pPin = pPin;
    }
    //    public Cart getCart() {
//        return cart;
//    }
//
//    public void setCart(Cart cart) {
//        this.cart = cart;
//    }



}
