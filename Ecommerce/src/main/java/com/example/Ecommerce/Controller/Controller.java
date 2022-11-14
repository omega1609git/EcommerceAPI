package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Cart;
import com.example.Ecommerce.Model.Product;
import com.example.Ecommerce.Service.CartService;
import com.example.Ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/sastaAmzn")
public class Controller {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService ;

    @GetMapping("/hii")
    public String sayHello(  ) {
        return "Hello" ;
    }



    @PostMapping("/cart")
    public Cart addCart( @RequestBody Cart cart ){
        cartService.addCart(cart);
        return cartService.getCartById(cart.getcId() )  ;
    }
    @GetMapping("/cart/{cId}")
    public Cart getCart( @PathVariable int cId ){
        return cartService.getCartById(cId );
    }
    @GetMapping("/cart/{cId}/totalPrice")
    public String getTotalPrice( @PathVariable int cId ){
        return cartService.getTotalPrice(cId).toString();
    }
    @PostMapping("/addProductToCart/{cId}/{pId}")
    public void addProductToCart( @PathVariable(name = "pId") int pId, @PathVariable(name = "cId") int cId ){
        Product product=productService.getProductById(pId);
        Cart cart=cartService.getCartById(cId);
        cartService.addProductToCart(product,cart);
    }
    @DeleteMapping("deleteCart/{cId}")
    public void deleteCart( @PathVariable( name="cId") int cId ){
        cartService.deleteCart(cId);
    }
    @DeleteMapping("deleteProduct/{cId}/{pId}")
    public void deleteProduct( @PathVariable(name = "cId") int cId, @PathVariable(name="pId") int pId ){
        cartService.deleteProductFromCart(pId,cId);
    }




    @PostMapping("/product")
    public Product addProduct( @RequestBody Product product ){
        productService.addProduct( product );
        return  productService.getProductById(product.getpId()) ;
    }
    @GetMapping ( "/product/{pId}" )
    public Product getProduct ( @PathVariable int pId ){
        return productService.getProductById(pId);
    }
    @GetMapping("/getProducts")
    public List<Product> getAllProduct( ){
        return  productService.getAllProduct();
    }






}
