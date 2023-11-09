package com.thiunuwan.orderservice.service;


import com.thiunuwan.orderservice.dto.ShoppingCartDTO;
import com.thiunuwan.orderservice.repository.ShoppingCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;

    public String saveShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        return "Saved shopping Cart";
    }
}
