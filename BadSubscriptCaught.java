import java.util.Scanner;
import java.util.InputMismatchException;
import java.sql.SQLOutput;
public class BadSubscriptCaught {
    public static void main(String[] args) {
        String[] names = {"James", "Sam", "Jake", "Amy", "Jack", "John", "Ryan", "Harry", "Tate", "Josh"};
        Scanner sc = new Scanner(System.in);
            try {
                System.out.println("Input an integer number 0-9");
                int index = sc.nextInt();
                System.out.println(names[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Found index exception: Array index out of bounds");
            } catch (ArithmeticException e) {
                System.out.println("Found arithmetic exception: incorrect calculation");
            } catch (InputMismatchException e) {
                System.out.println("Found invalid input exception: input is mismatched. Switch to integers");
            }
    }
}