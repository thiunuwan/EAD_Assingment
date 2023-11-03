package lk.uom.OrderManagement.order;

import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {
    public Iterable<OrderProduct> findAllByOrderId(String orderId);
}
