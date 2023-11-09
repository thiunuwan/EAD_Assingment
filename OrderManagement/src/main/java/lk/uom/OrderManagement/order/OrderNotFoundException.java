package lk.uom.OrderManagement.order;

public class OrderNotFoundException  extends RuntimeException{
    public OrderNotFoundException(String message) {
        super(message);
    }
}
