import java.util.Arrays;

public class DeliveryPizza extends Pizza {
//    creates deliveryfee
    private double deliveryFee;

//    initializes DeliveryPizza with deliveryFee and deliveryAdress array
    public DeliveryPizza(String[] toppings, int numToppings, double deliveryFee, String[] deliveryAddress) {
        super(toppings, numToppings);
        this.deliveryFee = deliveryFee;
        String deliveryAdress = Arrays.toString(deliveryAddress);
        calcDeliveryFee();
    }

//    call getprice from superclass in pizza
    public double getPrice() {
        return super.getPrice() + deliveryFee;
    }

//    calculates delivery fee $3 if over 18, $5 if under
    private void calcDeliveryFee() {
        if (getPrice() > 18.00) {
            this.deliveryFee = 3.00;
        } else {
            this.deliveryFee = 5.00;
        }
    }

//    returns superclass while incorporating deliveryFee
    public String toString() {
        return super.toString() + "\nDelivery Fee: $" + deliveryFee;
    }
}
