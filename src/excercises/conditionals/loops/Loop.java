package excercises.conditionals.loops;

public class Loop {
    /**
     * Prints the times table for a given number.
     *
     * @param number the number for which the times table is printed
     */
    public void timesTable(int number){
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d * %d = %d%n", i, number, number * i);
        }
    }

    /**
     * Prints the times table for a given number by summing.
     *
     * @param number the number for which the times table by sum is printed
     */
    public void timesTableBySum(int number){
        int currentNumber = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d * %d = %d%n", i, number, currentNumber += number);
        }
    }

    /**
     * Calculates the factorial of a given number.
     *
     * @param n the number for which the factorial is calculated
     * @return the factorial of the given number
     */
    public long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
