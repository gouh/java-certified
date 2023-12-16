package excercises.vars.interpolation;

import java.time.Year;

public class User {
    String name;
    int birthYear;

    User(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    /**
     * Prints the user's information.
     * This method calculates the user's age based on the current year and the year of birth,
     * and prints the user's name along with their age.
     * Example usage:
     * excercises.vars.interpolation.User myUser = new excercises.vars.interpolation.User("John", 1990);
     * myUser.printUserInfo();
     * This will output:
     * Hi John!, your age is : 31
     */
    public void printUserInfo() {
        int year = Year.now().getValue();
        System.out.println("Hi " + name + "!, your age is : " + (year - birthYear));
    }
}
