package com.thiunuwan.orderservice.service;


import com.thiunuwan.orderservice.dto.ShoppingCartItemsResponseDTO;
import com.thiunuwan.orderservice.dto.ShoppingCartItemsResquestDTO;
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

    @Autowired
    private ShoppingCartService shoppingCartService;

    public String saveShoppingCartItem(ShoppingCartItemsResquestDTO shoppingCartItemsResquestDTO, int userId) {
        ShoppingCart shoppingCart;



       if(shoppingCartRepo.findByUserId(userId)!=null) {
            shoppingCart = shoppingCartRepo.findByUserId(userId);
       }
       else {
            shoppingCart=new ShoppingCart();
           shoppingCart.setUserId(userId);
       }


        ShoppingCartItems newShoppingCartItem = new ShoppingCartItems();

        newShoppingCartItem.setShoppingCart(shoppingCart);
        newShoppingCartItem.setQty(shoppingCartItemsResquestDTO.getQty());
        newShoppingCartItem.setItem(shoppingCartItemsResquestDTO.getItem_id());
        newShoppingCartItem.setPrice(shoppingCartItemsResquestDTO.getPrice());

        newShoppingCartItem.setSubTotal(shoppingCartItemsResquestDTO.getPrice()*shoppingCartItemsResquestDTO.getQty());


        shoppingCartItemsRepo.save(newShoppingCartItem);
        shoppingCartService.updateTotal(shoppingCart.getId(), shoppingCartItemsResquestDTO.getPrice()*shoppingCartItemsResquestDTO.getQty());

        return "Sucessfully added shopping cart item";

    }

    public List<ShoppingCartItemsResponseDTO> getAllShoppingCartItems(){
        List<ShoppingCartItems> shoppingCartItemsList = shoppingCartItemsRepo.findAll();
        return modelMapper.map(shoppingCartItemsList, new TypeToken<ArrayList<ShoppingCartItemsResponseDTO>>(){
        }.getType());
    }

    public List<ShoppingCartItemsResponseDTO> getShoppingCartItemsByCartId(Long shopping_cart_id) {
        List<ShoppingCartItems> shoppingCartItemsList = shoppingCartItemsRepo.findByShopping_cart_id(shopping_cart_id);
        return modelMapper.map(shoppingCartItemsList, new TypeToken<ArrayList<ShoppingCartItemsResponseDTO>>(){
        }.getType());
    }


}
