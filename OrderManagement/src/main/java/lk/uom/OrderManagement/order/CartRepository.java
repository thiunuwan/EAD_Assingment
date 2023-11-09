package lk.uom.OrderManagement.order;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Long> {
    public Iterable<Cart> getCartByCustomerid(String customerId);


    @Query(value = "SELECT * FROM cart WHERE customerid=:cid AND productid=:pid", nativeQuery = true)
    public Optional<Cart> findByCustomerIdProductid(@Param("cid") String customerid, @Param("pid") String productid);

    @Query(value = "DELETE FROM cart WHERE customerid=:cid AND productid=:pid", nativeQuery = true)
    public void deleteByCustomeridProductid(@Param("cid") String customerid, @Param("pid") String productid);
}
