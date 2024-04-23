package Model;

public class Food {
    private String name;
    private float price;

    public Food(){}

    public Food(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String alignment = "\t\t\t\t\t\t\t\t\t\t";
    return  "\n" + alignment + "  Name: " + this.name +
            "\n" + alignment + "  Price: " + this.price;
    }
}
