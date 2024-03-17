import java.util.Arrays;
public class Pizza {
//    creates toppings string array and price
    private final String[] toppings;
    double price;

//    initializes constructor pizza and deals with array toppings
    public Pizza(String[] toppings, int numToppings) {
        this.toppings = Arrays.copyOf(toppings, numToppings);
        this.price = 14.0 + (2.0 * numToppings);
    }

//    initializes constructor toString for pizza and returns a toppinglist and price
    public String toString() {
        String toppingsList = String.join(", ", toppings);
        return "Pizza with toppings: " + toppingsList + "\nPrice: $" + price;
    }

//    initializes constructor getPrice
    protected double getPrice() {
        return price;
    }
}