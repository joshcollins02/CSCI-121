import java.util.Scanner;

public class DemoPizza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        initializing variables for toppings and toppings count
        String[] toppings = new String[10];
        int numToppings = 0;
//        loop for number of toppings, once it hits 10 it auto exits
        while (numToppings < 10) {
            System.out.print("Enter a topping or type 'done': ");
            String topping = null;
            try {
                topping = scanner.nextLine().trim();
                if (topping.equalsIgnoreCase("done")) {
                    break;
                }
                Integer.parseInt(topping);
                System.out.println("Invalid input. Topping must be a string.");
//                exception catch because I want the user to input a string
            } catch (NumberFormatException e) {
                toppings[numToppings] = topping;
                numToppings++;
            }
        }

//        delivery choice yes/no
        System.out.print("Do you want the pizza to be delivered? (yes/no): ");
        String deliveryChoice = scanner.nextLine().trim();
        if (deliveryChoice.equalsIgnoreCase("yes")) {
//            just for fun but it doesnt do anything
            System.out.print("Enter the delivery address: ");
            String deliveryAddress = scanner.nextLine().trim();
//            intializing a delivery fee
            double deliveryFee = 0;
            double discountPercentage = 0;
//            10% discount for addresses ending in "street"
            if (deliveryAddress.toLowerCase().endsWith("street")) {
                discountPercentage = 0.10;
//                12% discount for addresses ending in "avenue"
            } else if (deliveryAddress.toLowerCase().endsWith("avenue")) {
                discountPercentage = 0.12;
//                8% discount for addresses ending in "circle"
            } else if (deliveryAddress.toLowerCase().endsWith("circle")) {
                discountPercentage = 0.08;
            }
//            intializes pizza
            Pizza pizza = new Pizza(toppings, numToppings);
            double originalPrice = pizza.getPrice();

//            handles calculation and return
            double discountedPrice = originalPrice - (originalPrice * discountPercentage);
            System.out.println("Original Price: $" + originalPrice);
            System.out.println("Discount Percentage: " + (discountPercentage * 100) + "%");
            System.out.println("Discounted Price: $" + discountedPrice);
        } else {
//            just intializes for no delivery for pizza
            Pizza pizza = new Pizza(toppings, numToppings);
            System.out.println(pizza);
        }
        scanner.close();
    }
}
// didnt think we needed a GUI everything is easily accesible in scanner interface