package com.thiunuwan.orderservice.service;


import com.thiunuwan.orderservice.client.InventoryClient;
import com.thiunuwan.orderservice.dto.DeductItemsResponseDTO;
import com.thiunuwan.orderservice.dto.PaymentRequestDTO;
import com.thiunuwan.orderservice.dto.PaymentResponseDTO;
import com.thiunuwan.orderservice.repository.ShoppingCartRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ShoppingCartRepo shoppingCartRepo;




    private final InventoryClient inventoryClient;

    private final StripeService stripeService;

    public PaymentService(StripeService stripeService,InventoryClient inventoryClient) {
        this.stripeService = stripeService;
        this.inventoryClient=inventoryClient;
    }


    public PaymentResponseDTO initiatePayment(PaymentRequestDTO PaymentRequestDTO) {
        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        try {
            double amount=shoppingCartRepo.findById(PaymentRequestDTO.getCartId()).get().getTotal();
//            long amount = PaymentRequestDTO.getAmount();
            if (amount == 0 || isNull(amount)) {
                responseDTO.setMessage("Cart is empty");
                return responseDTO;
            }
            PaymentIntent paymentIntent = stripeService.createPaymentIntent(amount);
            responseDTO.setMessage("Payment initiated");
            responseDTO.setClientSecret(paymentIntent.getClientSecret());
        } catch (StripeException e) {
            e.printStackTrace();
            responseDTO.setMessage("Internal server error");
        }
        return responseDTO;

    }

    public int isPaymentSuccessful(int code,int userId){
        if(code==200){

            //deduct the item qts from inventory micro service
            List<DeductItemsResponseDTO> deductItemList=shoppingCartService.getDeductItemListByUserId(userId);
            System.out.println(inventoryClient.updateItemQuantitiesByDeductItemList(deductItemList));


            shoppingCartService.deleteShoppingCartByUserId(userId);
            return code;
        }
        return -1;
    }

}