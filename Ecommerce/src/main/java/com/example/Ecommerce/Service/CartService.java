package com.example.Ecommerce.Service;

import com.example.Ecommerce.Dto.CartBill;
import com.example.Ecommerce.Model.Cart;
import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Repository.CartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartDAO cartDAO ;


    public Cart addCart( Cart cart ) {
        cartDAO.save(cart);
        return cartDAO.findById(cart.getcId()).get() ;
    }

    public Cart getCartById(int cId) {
        return cartDAO.findById(cId).get() ;
    }



    public List<Cart> getAllCart(){
        List<Cart> allCart= new ArrayList<Cart>()  ;
        cartDAO.findAll().forEach(allCart::add) ;
        return allCart  ;
    }


    public CartBill getTotalPrice(int cId) {
        Cart cart= cartDAO.findById(cId).get()  ;
        List<Product> products = cart.getProducts() ;
        int sum=0;
        int weight=0;
        int totalShipping=0;
        for( int i=0; i<products.size(); i++ ){
            weight+=products.get(i).getpWeight();
            sum+=products.get(i).getpPrice() ;
            int distance= Math.abs(products.get(i).getpPin() - cart.getCustomerPin() ) ;
            totalShipping+=shippingCharge(products.get(i).getpWeight(),distance);
        }

        return new CartBill(sum,weight,totalShipping);

    }

    public void addProductToCart( Product product, Cart cart ){
        List<Product> products=cart.getProducts();
        products.add(product);
        cartDAO.save(cart);

    }

   public void deleteCart(int cid){
        cartDAO.deleteById(cid);
   }
   public void deleteProductFromCart(int pid,int cid){
        Cart cart =cartDAO.findById(cid).get();
        List<Product> products=cart.getProducts();
        for(Product product:products){
            if(product.getpId()==pid)
            {  products.remove(product);break; }
        }
       cartDAO.save(cart);
   }

    public static int shippingCharge(int weight, int distance) {
        if(weight <= 2) {
            if(distance <= 5)
                return 12;
            else if(distance <= 20)
                return 15;
            else if(distance <= 50)
                return 20;
            else if(distance <= 500)
                return 50;
            else if(distance <= 800)
                return 100;
            else
                return 220;
        }
        else if(weight <= 5) {
            if(distance <= 5)
                return 14;
            else if(distance <= 20)
                return 18;
            else if(distance <= 50)
                return 24;
            else if(distance <= 500)
                return 55;
            else if(distance <= 800)
                return 110;
            else
                return 250;
        }
        else if(weight <= 20) {
            if(distance <= 5)
                return 16;
            else if(distance <= 20)
                return 25;
            else if(distance <= 50)
                return 30;
            else if(distance <= 500)
                return 80;
            else if(distance <= 800)
                return 130;
            else
                return 270;
        }
        else {
            if(distance <= 5)
                return 21;
            else if(distance <= 20)
                return 35;
            else if(distance <= 50)
                return 50;
            else if(distance <= 500)
                return 90;
            else if(distance <= 800)
                return 150;
            else
                return 300;
        }
    }




}
