import java.util.ArrayList;
import java.util.List;

public class FoodCategory {
    private String name;
    private List<Food> foodList;

    public FoodCategory() {
        foodList = new ArrayList<Food>();
    }

    public FoodCategory(String name) {
        this.name = name;
        this.foodList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
