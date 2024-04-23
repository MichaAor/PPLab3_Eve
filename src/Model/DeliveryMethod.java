package Model;

public interface DeliveryMethod {
    void homeDelivery(Order order);
    void takeAway(Order order);
}
