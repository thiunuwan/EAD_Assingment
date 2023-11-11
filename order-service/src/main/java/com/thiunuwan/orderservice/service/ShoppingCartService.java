package com.thiunuwan.orderservice.service;


import com.thiunuwan.orderservice.dto.DeductItemsResponseDTO;
import com.thiunuwan.orderservice.dto.ShoppingCartDTO;
import com.thiunuwan.orderservice.entity.ShoppingCart;
import com.thiunuwan.orderservice.entity.ShoppingCartItems;
import com.thiunuwan.orderservice.repository.ShoppingCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;

    public String saveShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        return "Saved shopping Cart";
    }

    public void updateTotal(Long shoppingCartId,double subTotal){
        ShoppingCart shoppingCart=shoppingCartRepo.findById(shoppingCartId).get();
        Double total=shoppingCart.getTotal();
        total=total+subTotal;
        shoppingCart.setTotal(total);
        shoppingCartRepo.save(shoppingCart);
    }

    public void deleteShoppingCartByUserId(int userId){
        ShoppingCart shoppingCart=shoppingCartRepo.findByUserId(userId);

        shoppingCartRepo.deleteById(shoppingCart.getId());


    }


    public List<DeductItemsResponseDTO> getDeductItemListByUserId(int userId) {
           ShoppingCart shoppingCart= shoppingCartRepo.findByUserId(userId);
        List<DeductItemsResponseDTO> deductItemsResponseDTOList=new ArrayList<>();
           List<ShoppingCartItems> shoppingCartItemsList=shoppingCart.getShoppingCartItems();

        for (ShoppingCartItems s: shoppingCartItemsList) {
            DeductItemsResponseDTO deductItemsResponseDTO=DeductItemsResponseDTO.builder()
                    .itemId(s.getItem())
                    .purchaseQty(s.getQty())
                    .build();
            deductItemsResponseDTOList.add(deductItemsResponseDTO);
        }

        return deductItemsResponseDTOList;

    }
}
