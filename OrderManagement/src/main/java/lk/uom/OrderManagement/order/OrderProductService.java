package lk.uom.OrderManagement.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    public Iterable<OrderProduct> getOrderItemsByOrderId(String orderId){
        return orderProductRepository.findAllByOrderId(orderId);
    }

    public OrderProduct createOrderItem(String orderId, String productId){
        OrderProduct orderProduct = new OrderProduct(orderId, productId);
        orderProductRepository.save(orderProduct);
        return orderProduct;
    }
}
