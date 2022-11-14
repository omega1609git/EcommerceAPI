package com.example.Ecommerce.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY )
    @Column ( name = "c_id" )
    private int cId ;
    @Column
    private int customerPin;
    @Column
    private String customerName;

    @OneToMany( cascade = CascadeType.ALL  )
    @JoinColumn ( name = "fk_c_id" , referencedColumnName = "c_id"  )
    private List<Product> products ;



    public Cart( ){  }

    public Cart(int customerPin, String customerName, List<Product> products) {
        this.customerPin = customerPin;
        this.customerName = customerName;
        this.products = products;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getCustomerPin() {
        return customerPin;
    }

    public void setCustomerPin(int customerPin) {
        this.customerPin = customerPin;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName( String customerName) {
        this.customerName = customerName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
