package lk.uom.OrderManagement.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderMService {

    @Autowired
    private OrderMRepository orderMRepository;

    public OrderM createOrder(String customerId){
        OrderM newOrderM = new OrderM(customerId);
        orderMRepository.save(newOrderM);
        return newOrderM;
    }


    public Iterable<OrderM> getAll(){
        return orderMRepository.findAll();
    }

    public Optional<OrderM> getOrderById(String uniqId){
        return orderMRepository.findByuniqId(uniqId);
    }

    public Iterable<OrderM> findCustomerOrders(String customerId){
        return orderMRepository.findByCustomerId(customerId);
    }

    public OrderM updateStatus(String uniqId, String status){
        Optional<OrderM> order = orderMRepository.findByuniqId(uniqId);
        if(order.isPresent()){
            OrderM modOrder = order.get();
            modOrder.setStatus(status);

            orderMRepository.save(modOrder);
            return modOrder;
        }
        else{
            throw new OrderNotFoundException("Order not Found");
        }
    }

}
