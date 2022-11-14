package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDAO extends JpaRepository <Cart, Integer> {



}
