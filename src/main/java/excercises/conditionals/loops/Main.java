package excercises.conditionals.loops;

import java.util.Scanner;

public class Main {
    Loop loop;

    Main(Loop loop) {
        this.loop = loop;
    }

    /**
     * Runs a loop that takes input from the user and performs certain actions based on the input.
     * The loop will continue until the user chooses to stop.
     */
    public void scannerLoop() {
        Scanner lector = new Scanner(System.in);
        boolean breakLoop = false;
        while (!breakLoop) {
            System.out.println("Enter first number");
            int num1 = lector.nextInt();

            System.out.println("Enter second number");
            int num2 = lector.nextInt();

            System.out.println("Enter third number");
            int num3 = lector.nextInt();

            if (num1 == num2 && num2 != num3) {
                System.out.println("No 1 is equal to 2 but different to 3");
            }

            this.loop.timesTable(num1);
            System.out.println("\n");
            this.loop.timesTable(num2);
            System.out.println("\n");
            this.loop.timesTable(num3);

            System.out.println("Do you want try again?");
            breakLoop = !lector.nextBoolean();
        }
    }

    /**
     * The main method of the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main obj = new Main(new Loop());

        // obj.scannerLoop();

        // System.out.println("Times table of 3:");
        // obj.loop.timesTable(3);

        // System.out.println("Times table by sum of 4:");
        // obj.loop.timesTableBySum(4);

        System.out.printf("Factorial of 5: %d", obj.loop.factorial(5));
    }
}
