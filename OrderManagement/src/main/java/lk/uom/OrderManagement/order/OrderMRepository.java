package lk.uom.OrderManagement.order;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderMRepository extends CrudRepository<OrderM, Long> {
    List<OrderM> findByCustomerId(String customerId);

    Optional<OrderM> findByuniqId(String uniqId);


}
