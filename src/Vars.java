public class Vars {
    byte byteVar;
    short shortVar;
    int intVar;
    long longVar;
    float floatVar;
    double doubleVar;
    char charVar;
    String stringVar;
    boolean booleanVar;

    Vars() {
        this.byteVar = 1;
        this.shortVar = 10;
        this.intVar = 100;
        this.longVar = 1000;
        this.floatVar = 10.1F;
        this.doubleVar = 20.10;
        this.charVar = 64;
        this.stringVar = "string";
        this.booleanVar = false;
    }

    /**
     * Prints the values of the instance variables.
     * This method prints the values of the following instance variables:
     * - byteVar
     * - shortVar
     * - intVar
     * - longVar
     * - floatVar
     * - doubleVar
     * - charVar
     * - stringVar
     * Example usage:
     * MyClass obj = new MyClass();
     * obj.printVars();
     * Output:
     * The value of byteVar is: 10
     * The value of shortVar is: 20
     * The value of intVar is: 30
     * The value of longVar is: 40
     * The value of floatVar is: 50.5
     * The value of doubleVar is: 60.6
     * The value of charVar is: A
     * The value of stringVar is: Hello
     */
    public void printVars() {
        System.out.println("The value of byteVar is: " + this.byteVar);
        System.out.println("The value of shortVar is: " + this.shortVar);
        System.out.println("The value of intVar is: " + this.intVar);
        System.out.println("The value of longVar is: " + this.longVar);
        System.out.println("The value of floatVar is: " + this.floatVar);
        System.out.println("The value of doubleVar is: " + this.doubleVar);
        System.out.println("The value of charVar is: " + this.charVar);
        System.out.println("The value of stringVar is: " + this.stringVar);
    }
}
