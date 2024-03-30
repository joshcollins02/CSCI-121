import java.util.Scanner;

public class TestBloodData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//creating two objects, one that you input your own values and two that takes the default values
        try {
            BloodData one = new BloodData();
            System.out.println("Enter a BloodType: ");
            String bg = sc.nextLine();
            System.out.println("Enter a RH Factor: ");
            String rh = sc.nextLine();
            BloodData two = new BloodData(bg, rh);

            System.out.println("Blood type " + one.getBg() + one.getRh());
            System.out.println("Blood type " + two.getBg() + two.getRh());
        } catch (Exception e) {
//            if the input is mismatched the exception will catch it
            System.out.println("Error: It shouldn't be what you put, FIX IT!");
        }
        sc.close();
    }
}
