package Model;
//?                       ╔════════════╗
//?                       ║  DELIVERY  ║
//?                       ╚════════════╝
//? Agrupo las formas de entregar los pedidos.
public interface DeliveryMethod {
    void homeDelivery(Order order);
    void takeAway(Order order);
}
