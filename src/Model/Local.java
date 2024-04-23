package Model;

import java.util.ArrayList;
import java.util.List;

public class Local implements DeliveryMethod{
    private String name;
    private List<Food> menu;
    private List<PayMethod> payMethods;
    private List<Order> orders;

    public Local(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
        this.payMethods = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public Local(String name, List<Food> menu, List<PayMethod> payMethods) {
        this.name = name;
        this.menu = menu;
        this.payMethods = payMethods;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getMenu() {
        return menu;
    }

    public void setMenu(List<Food> menu) {
        this.menu = menu;
    }

    public List<PayMethod> getPayMethods() {
        return payMethods;
    }

    public void setPayMethods(List<PayMethod> payMethods) {
        this.payMethods = payMethods;
    }

    public void addFood(Food food) {
        this.menu.add(food);
    }

    public void addpayMethod(PayMethod method) {
        this.payMethods.add(method);
    }

    @Override
    public String toString() {
        return "\nName: " + this.name +
               "\nMenu: " + this.menu.toString();
    }

    @Override
    public void homeDelivery(Order order) {
        int lucky = (int) (Math.random() * 3 - 1);
        if(order.getDelivery().compareTo("Home Delivery") == 0
                && order.getAddress().compareTo(order.getUser().getAddress()) == 0){
            if(lucky == 1) {
                System.out.println("Entrega Realizada con exito");
                order.validateDelivered();
                this.orders.add(order);
            }else{
                System.err.println("\033[31m" + "El Delivery sufrio un accidente, enviaremos otro a la brevedad" + "\u001B[0m");
            }
        }else{
            System.err.println("\033[31m" + "OCURRIO UN ERROR, DISCREPANCIA DE DIRECCIONES" + "\u001B[0m");
        }
    }

    @Override
    public void takeAway(Order order) {
        if(order.getDelivery().compareTo("Take Away") == 0 && !order.isDelivered()){
            if(order.isPaid()){
                System.out.println("Pedido retirado");
                order.validateDelivered();
                this.orders.add(order);

            }else{
                int lucky = (int) (Math.random() * 3 - 1);
                System.out.println("Su orden de compra");
                System.out.println(order.toString());

                System.out.println("\033[36m" + "PROCESANDO PAGO" + "\u001B[0m");
                if(lucky == 2){
                    System.out.println("\033[32m" + "PAGO VERIFICADO" + "\u001B[0m");
                    System.out.println("Pedido Retirado");
                    order.validateDelivered();

                    this.orders.add(order);
                }else{
                    System.err.println("\033[31m" + "OCURRIO UN ERROR" + "\u001B[0m");
                }
            }
        }
    }
}
