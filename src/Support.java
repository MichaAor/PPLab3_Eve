import Model.Food;
import Model.PayMethod;
import Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Support {
//? Metodos Encargados de generar el usuario
    public User generateUser() {
        int idUser = (int) (Math.random() * 100 - 1);
        User user = new User(idUser,genUserName(),genUserAddress());
    return user;
    }

    private String genUserName(){
        String[] names = {"Emma","Juan","Isabella","Santiago","Maria"};
        return names[(int) (Math.random() * names.length - 1)];
    }

    private String genUserAddress(){
        String[] addressName = {"Luro","Italia","Independencia","Libertad","Matheu"};
        int addressNum = (int) (Math.random() * addressName.length);
    return addressName[(int) (Math.random() * addressName.length - 1)] + addressNum;
    }

//? Metodos Encargados de generar comidas
    public List<Food> generateMenu(){
        List<Food> menu = new ArrayList<>();
        IntStream.range(0,5)
                .forEach(food -> menu.add(generateFood()));
    return menu;
    }


    public Food generateFood() {
        float price = (float) (Math.random() * 20000 - 500);
        Food food = new Food(genFoodName(),price);
    return food;
    }

    private String genFoodName(){
        String[] names = {"Pork and duck vindaloo",
                          "Lime and chocolate mousse",
                          "Cauliflower and tofu soup",
                          "Sweetcorn and chickpea korma",
                          "Courgette and pumpkin cupcakes",
                          "Nectarine and persimmon gyoza",
                          "Garam masala and cabbage gyoza",
                          "Pumpkin seed and mushroom lasagne",
                          "Squid and john dory salad",
                          "Caerphilly and jaggery salad"};
        return names[(int) (Math.random() * names.length - 1)];
    }

    //? Metodos Encargados de generar metodos de pago

    public PayMethod generateBasicMethod(){
        return new PayMethod("Efectivo",0.07);
    }

    public PayMethod generateCardMethod(){
        return new PayMethod("Credit Card", 0.15);
    }
}
