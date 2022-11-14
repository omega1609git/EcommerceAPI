package com.example.Ecommerce.Service;

import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Repository.CartDAO;
import com.example.Ecommerce.Repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO ;
    @Autowired
    private CartDAO cartDAO ;
    public Product addProduct ( Product product){
         productDAO.save(product) ;
         return productDAO.findById(product.getpId() ).get() ;
    }

    public Product getProductById ( int pId ){
        return productDAO.findById(pId ).get()   ;
    }

    public List<Product> getAllProduct( ){
        List<Product> allProduct=  new ArrayList<Product>() ;
        productDAO.findAll().forEach(allProduct:: add);
        return allProduct ;
    }


//    public Product addProductToCart(int pId, int cId) {
//        Cart cart = cartDAO.findById(cId).get() ;
//        Product product=productDAO.findById(pId).get() ;
//        product.setCart(cart);
//        productDAO.save(product);
//        return productDAO.findById(pId).get()  ;
//    }


}
