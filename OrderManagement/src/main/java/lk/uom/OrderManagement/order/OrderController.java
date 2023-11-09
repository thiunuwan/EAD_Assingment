package lk.uom.OrderManagement.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="api/orders")
public class OrderController {

    @Autowired
    private OrderMService orderMService;
    @Autowired
    private OrderProductService orderProductService;
    @Autowired
    private CartService cartService;
@GetMapping
Iterable<OrderM> all() {
    return orderMService.getAll();
}

// Only For testing. Customer cannot create an order directly. First he has to add them to the cart. After clicking checkout, all items in the cart would be converted to a confirmed order.
@PostMapping
OrderM newOrder(@RequestBody OrderM orderM) {
    return orderMService.createOrder(orderM.getCustomerId());
}

@GetMapping(path="/{uniqId}")
Optional<OrderM> getOrderDetails(@PathVariable String uniqId){
    Optional<OrderM> order = orderMService.getOrderById(uniqId);


    if(order.isPresent()){
        return order;
    }
    else{
        throw new OrderNotFoundException("Order Not Found");
    }
    }


@GetMapping(path="/{orderId}/items")
Iterable<OrderProduct> getOrderItems(@PathVariable  String orderId){
    return orderProductService.getOrderItemsByOrderId(orderId);
}


@GetMapping(path="/cart/{customerId}")
Iterable<Cart> getCartItems(@PathVariable  String customerId){
    return cartService.getCartItemsByCustomerId(customerId);
}


@PostMapping(path="/cart")
Cart addItemstoCart(@RequestBody Cart cart) {
        return cartService.createCartItem(cart.getCustomerid(), cart.getProductid());
}

@GetMapping(path="/user/{customerId}")
    Iterable<OrderM> getCustomerOrders(@PathVariable String customerId){
    return orderMService.findCustomerOrders(customerId);
}

@PutMapping(path="/{orderId}/{status}")
    OrderM updateOrderStatus(@PathVariable String orderId, @PathVariable String status){
        return orderMService.updateStatus(orderId, status);
}

@DeleteMapping(path="/{customerId}/cart/{productId}")
    Cart deleteCartItem(@PathVariable String customerId, @PathVariable String productId){
        return cartService.deleteCartItem(customerId, productId);
}



//checkout: Transfer all cart items to OrderProduct(this table containe all individual items of each order). Then create a new order entry in the orderm(order is a reserved word in sql) table
    @GetMapping(path="/checkout/{customerId}")
    OrderM confirmOrder(@PathVariable String customerId){
        //Create new Order Entry
        OrderM orderConfirmed = orderMService.createOrder(customerId);
        //transfer cart items to orderProduct table
        Iterable<Cart> cartItems = cartService.getCartItemsByCustomerId(customerId);
        for(Cart item: cartItems){
            orderProductService.createOrderItem(orderConfirmed.getUniqId(), item.getProductid());
            cartService.deleteCartItem(item.getCustomerid(), item.getProductid());
        }

        return orderConfirmed;
    }
}
