public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Show vars
        Vars myObjectVars = new Vars();
        myObjectVars.printVars();

        // Show user info
        User myUser = new User("Hugo", 1996);
        myUser.printUserInfo();
    }
}