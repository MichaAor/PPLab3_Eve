package Model;

public class PayMethod {
    private String name;
    private double surcharge;

    public PayMethod() {}

    public PayMethod(String name, double surcharge) {
        this.name = name;
        this.surcharge = surcharge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(double surcharge) {
        this.surcharge = surcharge;
    }


    @Override
    public String toString() {
        String alignment = "\t\t\t\t\t\t\t\t\t\t";
        String lineColor = "\u001B[33m";
        String bodyColor = "\u001B[31m";
        String endColor = "\u001B[0m";
        return  alignment +
                lineColor + "«««««««««« PAY METHOD «««««««««" + endColor +
                bodyColor +
                "\n" + alignment + "  Name: " + this.name +
                "\n" + alignment + "  Surcharge: " + this.surcharge + "\n" + alignment +
                endColor +
                lineColor + "»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»" + endColor;
    }
}
