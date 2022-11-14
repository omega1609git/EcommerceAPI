package com.example.Ecommerce.Dto;

public class CartBill {
    private int totalPrice;
    private int totalWeight;
    private int totalShipping;

    public CartBill(int totalPrice, int totalWeight,int totalShipping) {
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
        this.totalShipping = totalShipping;
    }

    public int getTotalShipping() {
        return totalShipping;
    }

    public void setTotalShipping(int totalShipping) {
        this.totalShipping = totalShipping;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    @Override
    public String toString() {
        return "CartBill{" +
                "totalPrice=" + totalPrice +
                ", totalWeight=" + totalWeight +
                ", totalShipping=" + totalShipping +
                '}';
    }
}
