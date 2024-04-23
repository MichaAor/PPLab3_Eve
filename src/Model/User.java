package Model;

public class User {
    private int id;
    private String name;
    private String address;

    public User(int id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.address = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        String alignment = "\t\t\t\t\t\t\t\t\t\t";
        String lineColor = "\u001B[37m";
        String bodyColor = "\u001B[32m";
        String endColor = "\u001B[0m";
        return alignment +
                lineColor + "«««««««««««« USER «««««««««««««" + endColor +
                bodyColor +
                "\n" + alignment + "  ID: " + this.id +
                "\n" + alignment + "  Name: " + this.name +
                "\n" + alignment + "  Address: " + this.address + "\n" + alignment +
                endColor +
                lineColor + "»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»»" + endColor;
    }

    private String obtenerColor(){
        return "\033[3" + (int) (Math.random() * 7 - 3) + "m";
    }
}
