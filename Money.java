import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter an amount");

        double amount;
        String amountString = scanner.nextLine();
//  Establishing a double variable to call and inputting a string that allows you to use non integer values

        if (amountString.contains("$")) {
            amountString = amountString.replace("$", "").trim();
        }
        amount = Double.parseDouble(amountString);
//  Checking to see if the string contains a $, and if so deleting it, then converting the string back to a double

        int cent = (int) (amount * 100);
//  Converting double to an integer by multiplying it by 100, that is if the user inputs a value XX.00

        int quarters = cent / 25;
        int dimes = (cent - (quarters * 25)) / 10;
        int nickles = (cent - (quarters* 25) - (dimes * 10)) / 5;
        int pennies = cent - (quarters * 25) - (dimes * 10) - (nickles * 5);
//  Establishing what each cent's value is

        if (cent == 0) {
            System.out.println("Your change is 0 quarters, 0 dimes, 0 nickles, and 0 pennies");
//  Base case, if you enter 0.00, then the line above will print out

        } else {
            System.out.println("Your change is");
//  This is for when you enter an amount, it will run through the following statements

            if (quarters > 1) {
                System.out.println(quarters + " quarters");
            } else if (quarters == 1) {
                System.out.println(quarters + " quarter");
            }
//  If it can be divided by 25 more than once, then it will print out the if statement, if not the else statement

            if (dimes > 1) {
                System.out.println(dimes + " dimes");
            } else if (dimes == 1) {
                System.out.println(dimes + " dime");
            }
//  If it can be divided by 10 more than once, then it will print out the if statement, if not the else statement

            if (nickles > 1) {
                System.out.println(nickles + " nickles");
            } else if (nickles == 1) {
                System.out.println(nickles + " nickle");
            }
//  If it can be divided by 5 more than once, then it will print out the if statement, if not the else statement

            if (pennies > 1) {
                System.out.println(pennies + " pennies");
            } else if (pennies == 1) {
                System.out.println(pennies + " penny");
            }
//  If there is 4 cents left, then it will print out the if statement, if there is 1 the else statement
        }

        double pence = (double) (amount * 0.92);
//  Here the pence currency is established its value is 1.08 times the dollar
        String new_pence = String.format("%.2f", pence);
//  When multiplying the value, to keep it from being messy, we cap the double at two decimal places
        System.out.println("converted to " + new_pence + " euros");

//  For the rest of the code its almost identical to the cents, with the exception of the difference in value of the
//  currency, and the strings display different text to support the euro
        int pence2 = (int) (pence * 100);

        int fiftyp = pence2 / 50;
        int twentyp = (pence2 - (fiftyp * 50)) / 20;
        int tenp = (pence2 - (fiftyp * 50) - (twentyp * 20)) / 10;
        int fivep = (pence2 - (fiftyp * 50) - (twentyp * 20) - (tenp * 10)) / 5;
        int twop = (pence2 - (fiftyp * 50) - (twentyp * 20) - (tenp * 10) - (fivep * 5)) / 2;
        int onep = (pence2 - (fiftyp * 50) - (twentyp * 20) - (tenp * 10) - (fivep * 5) - (twop * 2));

        if (pence2 == 0) {
            System.out.println("Your change is 0 pence");
        } else {
            System.out.println("Your change is");

            if (fiftyp > 1) {
                System.out.println(fiftyp + " fifty pence");
            } else if (fiftyp == 1) {
                System.out.println(fiftyp + " fifty penny");
            }

            if (twentyp > 1) {
                System.out.println(twentyp + " twenty pence");
            } else if (twentyp == 1) {
                System.out.println(twentyp + " twenty penny");
            }

            if (tenp > 1) {
                System.out.println(tenp + " ten pence");
            } else if (tenp == 1) {
                System.out.println(tenp + " ten penny");
            }

            if (fivep > 1) {
                System.out.println(fivep + " five pence");
            } else if (fivep == 1) {
                System.out.println(fivep + " five penny");
            }

            if (twop > 1) {
                System.out.println(twop + " two pence");
            } else if (twop == 1) {
                System.out.println(twop + " two penny");
            }

            if (onep > 1) {
                System.out.println(onep + " one pence");
            } else if (onep == 1) {
                System.out.println(onep + " one penny");
            }
        }
        scanner.close();
    }
}