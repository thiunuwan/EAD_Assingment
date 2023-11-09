package lk.uom.OrderManagement.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;


    public Cart createCartItem(String customerId, String productId){
        Cart cartItem = new Cart(customerId, productId);
        cartRepository.save(cartItem);
        return cartItem;
    }

    public Iterable<Cart> getCartItemsByCustomerId(String customerId){
        return cartRepository.getCartByCustomerid(customerId);
    }

    public Cart deleteCartItem(String customerId, String productId){
        Optional<Cart> cartItem = cartRepository.findByCustomerIdProductid(customerId, productId);

        if(cartItem.isPresent()){
            Cart deletedCartItem = cartItem.get();
            cartRepository.deleteByCustomeridProductid(customerId, productId);
            return deletedCartItem;
        }
        else{
            throw new OrderNotFoundException("Item not found..");

        }

    }
}
