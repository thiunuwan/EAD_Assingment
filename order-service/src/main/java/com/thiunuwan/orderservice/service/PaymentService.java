package com.thiunuwan.orderservice.service;


import com.thiunuwan.orderservice.client.InventoryClient;
import com.thiunuwan.orderservice.dto.*;
import com.thiunuwan.orderservice.repository.ShopOrderRepository;
import com.thiunuwan.orderservice.repository.ShoppingCartItemsRepo;
import com.thiunuwan.orderservice.repository.ShoppingCartRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ShoppingCartRepo shoppingCartRepo;

    @Autowired
    private ShopOrderServiceImpl shopOrderServiceImpl;

    @Autowired
    private ShopOrderRepository shopOrderRepository;

    @Autowired
    private ShoppingCartItemsService shoppingCartItemsService;

    @Autowired
    private OrderLineService orderLineService;




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

    public int isPaymentSuccessful(int code,int userId,String shippingAddress){
        if(code==200){

            //create order
            ShopOrderRequestDTO orderRequestDTO=new ShopOrderRequestDTO();
            orderRequestDTO.setUserId(userId);
            orderRequestDTO.setOrderDateTime(LocalDateTime.now());
            orderRequestDTO.setShippingAddress(shippingAddress);
            orderRequestDTO.setOrderStatus("processing");
            orderRequestDTO.setOrderTotal(shoppingCartRepo.findByUserId(userId).getTotal());

            Long orderId=shopOrderServiceImpl.createOrder(orderRequestDTO);

            //create order-lines
            Long cartId = shoppingCartRepo.findByUserId(userId).getId();

            List<ShoppingCartItemsResponseDTO> shoppingCartItemsList =shoppingCartItemsService.getShoppingCartItemsByCartId(cartId);

            for (ShoppingCartItemsResponseDTO item: shoppingCartItemsList) {
                OrderLineRequestDTO requestDTO = new OrderLineRequestDTO();
                requestDTO.setInventoryItemId(item.getItem());
                requestDTO.setQuantity(item.getQty());
                requestDTO.setOrderId(orderId);
                requestDTO.setSubTotal(item.getPrice()* item.getQty());
                orderLineService.addOrderLine(requestDTO);
            }

            //deduct the item qts from inventory micro service
            List<DeductItemsResponseDTO> deductItemList=shoppingCartService.getDeductItemListByUserId(userId);
            System.out.println(inventoryClient.updateItemQuantitiesByDeductItemList(deductItemList));


            shoppingCartService.deleteShoppingCartByUserId(userId);
            return code;
        }
        return -1;
    }

}