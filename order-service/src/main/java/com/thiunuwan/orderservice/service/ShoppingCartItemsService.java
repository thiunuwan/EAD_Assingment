package com.thiunuwan.orderservice.service;


import com.thiunuwan.orderservice.dto.ShoppingCartItemsDTO;
import com.thiunuwan.orderservice.dto.UserPaymentMethodDTO;
import com.thiunuwan.orderservice.entity.ShoppingCart;
import com.thiunuwan.orderservice.entity.ShoppingCartItems;
import com.thiunuwan.orderservice.repository.ShoppingCartItemsRepo;
import com.thiunuwan.orderservice.repository.ShoppingCartRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ShoppingCartItemsService {

    @Autowired
    private ShoppingCartItemsRepo shoppingCartItemsRepo;

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveShoppingCartItem(ShoppingCartItemsDTO shoppingCartItemsDTO) {

        ShoppingCart mappedShoppingCart = shoppingCartRepo.findById(shoppingCartItemsDTO.getShopping_cart_id()).orElseThrow(()-> new RuntimeException("No matching SHopping Cart found."));

        ShoppingCartItems newShoppingCartItem = new ShoppingCartItems();

        newShoppingCartItem.setShoppingCart(mappedShoppingCart);
        newShoppingCartItem.setQty(shoppingCartItemsDTO.getQty());
        return "Sucessfully added shopping cart item";

    }

    public List<ShoppingCartItemsDTO> getAllShoppingCartItems(){
        List<ShoppingCartItems> shoppingCartItemsList = shoppingCartItemsRepo.findAll();
        return modelMapper.map(shoppingCartItemsList, new TypeToken<ArrayList<ShoppingCartItemsDTO>>(){
        }.getType());
    }
}
