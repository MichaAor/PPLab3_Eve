package Model;

import java.util.List;

public class Order {
    private int id;
    private User user;
    private String address;
    private List<Food> foods;
    private PayMethod method;
    private String delivery;
    private boolean paid;
    private boolean delivered;
    private float subtotal;
    private float total;

    public Order() {}

    public Order(User user, List<Food> foods, PayMethod method, String delivery) {
        this.id = (int) (Math.random() * 10000 - 1);
        this.user = user;
        this.address = this.user.getAddress();
        this.foods = foods;
        this.method = method;
        this.delivery = delivery;
        this.validatePaid();
        this.delivered = false;
        this.calculateSubtotal();
        this.calculateTotal();
    }

    public Order(int id, User user, String address, List<Food> foods, PayMethod method, String delivery) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.foods = foods;
        this.method = method;
        this.delivery = delivery;
        this.validatePaid();
        this.delivered = false;
        this.calculateSubtotal();
        this.calculateTotal();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public PayMethod getMethod() {
        return method;
    }

    public void setMethod(PayMethod method) {
        this.method = method;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }


//! Metodos Suport

    public void validatePaid(){
        int lucky = (int) (Math.random() * 3 - 1);
        if(this.method.getName().compareTo("Card Pay") ==0 && (lucky == 3)) {
            this.paid = true;
        }else{
            this.paid = false;
        }
    }

    public void validateDelivered(){
        if(this.isPaid()){
            this.delivered = true;
        }
    }

    private void calculateSubtotal(){
        for(Food food : this.foods){
            this.setSubtotal(this.subtotal += food.getPrice());
        }
    }

    private void calculateTotal(){
        this.setTotal((float) (this.subtotal * this.method.getSurcharge()));
    }


    @Override
    public String toString() {
        String alignment = "\t\t\t\t\t\t\t\t\t\t";
        String lineColor = "\u001B[35m";
        String bodyColor = "\u001B[34m";
        String endColor = "\u001B[0m";
        return "\n" + alignment +
                lineColor +  "══════════════ ORDER ═════════════════" + endColor +
                bodyColor +
                "\n" + alignment + "  ID: " + this.id +
                "\n" + alignment + "  Address: " + this.address +
                "\n" + alignment + "  it's paid?: " + this.paid +
                "\n" + alignment + "  is it delivered?: " + this.delivered +
                "\n" + alignment + "  Subtotal: " + this.subtotal +
                "\n" + alignment + "  Total: " + this.total +

                "\n" + this.method +
                "\n" + this.user+

                "\n" + alignment +
                "\u001B[31m" + "▓▓▓▓▓▓▓▓▓▓▓▓▓ FOODS ▓▓▓▓▓▓▓▓▓▓▓" + endColor +
                "\u001B[36m" +
                "\n" + alignment + this.foods.toString() + "\n" + alignment +
                endColor +
                "\u001B[31m" + "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓" + endColor + "\n" + alignment +
                lineColor + "════════════════════════════════════════════" + endColor;
    }
}
