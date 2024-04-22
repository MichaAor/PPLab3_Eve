public class Food {
    private String name;
    private float price;
    private FoodCategory foodCategory;

    public Food(){}

    public Food(String name, float price, FoodCategory foodCategory) {
        this.name = name;
        this.price = price;
        this.foodCategory = foodCategory;
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

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }
}
